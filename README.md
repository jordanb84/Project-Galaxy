# Project Galaxy

Project Galaxy (temporarily named) is a space game project written in LibGDX.

This project is currently early in development.

![Screenshot](https://i.imgur.com/EARCToM.png)

## TODO

- When a ship has arrived at it's destination and shortly after decides a new course, it should
phase into the new heading rather than popping to it instantly to give a more natural feel.

- Shielding system for ships. Different ships will have different shield strengths and shield (re)generator
output. While a ship has shields up, a significant amount of the ship's energy will be used to power them.
when powered, shields will be rendered at around 40-60% opacity to give a visual indicator that they are on.
Opacity will go to 100% for about 1 second if the shields sustain a hit (from a weapon, asteroid, etc.) to give
visual feedback for the impact. There should be a sound effect to accompany this to further the feedback when
an important event such as this one occurs. When a player's shields are enabled, there should be a faint energy
sound in the background on loop.

- When one ship is actively attacking another, it should circle around the targeted vessel rather than
staying in place

## Known Bugs