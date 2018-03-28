package com.dungeon.game.entity.mind.impl;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.dungeon.game.Game;
import com.dungeon.game.entity.Direction;
import com.dungeon.game.entity.mind.EntityState;
import com.dungeon.game.entity.mind.Mind;
import com.dungeon.game.entity.ship.Ship;
import com.dungeon.game.entity.ship.impl.ShipPlayer;

import java.util.Random;

public class EntityStateWander extends EntityState {

    private Random wanderDestinationRandomizer = new Random();

    private Rectangle destination = new Rectangle();

    private Vector2 wanderRange;

    public EntityStateWander(Ship parentShip, Vector2 wanderRange) {
        super(parentShip);
        this.wanderRange = wanderRange;
        this.selectNewDesitination();
    }

    @Override
    public void perform() {
        float destX = (this.destination.x);
        float destY = (this.destination.y);

        float entityX = (this.getParentShip().getPosition().x);
        float entityY = (this.getParentShip().getPosition().y);

        double angle = Math.atan2(destY - entityY, destX - entityX);
        angle = angle * (180/Math.PI);

        if(angle < 0){
            angle = 360 - (-angle);
        }

        this.getParentShip().setRotation(-90f + (float) angle);

        if(!(this.getParentShip().getDirection() == Direction.FULL_STOP)) {
            this.getParentShip().adjustMovementTo(Direction.UP);

            this.getParentShip().moveAtCurrentVelocity();
        }

        Rectangle entityBody = new Rectangle(this.getParentShip().getPosition().x, this.getParentShip().getPosition().y, this.getParentShip().getSprite().getWidth(), this.getParentShip().getSprite().getHeight());

        if(entityBody.overlaps(this.destination) && !(this.getParentShip().getDirection() == Direction.FULL_STOP)) {
            this.selectNewDesitination();
        }
    }

    @Override
    public void checkTransitionConditions() {

    }

    private void selectNewDesitination() {
        float posX = (this.getParentShip().getPosition().x);
        float posY = (this.getParentShip().getPosition().y);

        int destinationChangeX = (this.wanderDestinationRandomizer.nextInt((int) this.wanderRange.x));
        int destinationChangeY = (this.wanderDestinationRandomizer.nextInt((int) this.wanderRange.y));

        if(destinationChangeX < this.wanderRange.x / 2) {
            destinationChangeX = (int) this.wanderRange.x / 2;
        }

        if(destinationChangeY < this.wanderRange.y / 2) {
            destinationChangeY = (int) this.wanderRange.y / 2;
        }

        boolean addX = (this.wanderDestinationRandomizer.nextBoolean());
        boolean addY = (this.wanderDestinationRandomizer.nextBoolean());

        Vector2 newDestination = new Vector2(addX ? posX + destinationChangeX : posX - destinationChangeX, addY ? posY + destinationChangeY : posY - destinationChangeY);

        DelayedCourseChanger courseChanger = new DelayedCourseChanger(this, 8000, newDestination);
        courseChanger.start();
    }

    public Rectangle getDestination() {
        return this.destination;
    }
}

class DelayedCourseChanger extends Thread {

    private EntityStateWander wanderState;

    private int delay;

    private Vector2 newCourse;

    public DelayedCourseChanger(EntityStateWander wanderState, int delay, Vector2 newCourse) {
        this.wanderState = wanderState;
        this.delay = delay;
        this.newCourse = newCourse;
        this.wanderState.getParentShip().adjustMovementTo(Direction.FULL_STOP);
    }

    @Override
    public void run() {
        try {
            Thread.sleep(new Random().nextInt(this.delay));

            this.wanderState.getDestination().set(this.newCourse.x, this.newCourse.y, 25, 25);
            this.wanderState.getParentShip().setDirection(Direction.UP);
        } catch(InterruptedException e) {
            e.printStackTrace();
        }
    }

    //TODO The delay should be somewhat random so it's not _exact_ and unnatural every time

    //TODO Instead of rotating instantly on a course change, it should "phase into" the new rotation over the period of around a second.

}