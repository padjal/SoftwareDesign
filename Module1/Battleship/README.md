# Battleships homework project
The classic battleships game with a small twist - only the computer gets to arrange their fleet.

## Intro
The Battleships homework project is a classic programming task, but this time it has been changed a little bit. The player now does not have the possibility to place ships - they can only guess where the computer's shipd are located. The main goal of this homework is to show good understanding of the OOP principles and the java technology.

## Instructions
The game is usually played in turns where each player gets a chance to guess a spot on their enemy's board and get an answer on whether they have hit a ship or not. Unlike the usual game, in our case only one player gets to guess ship locations. We refer to them as player and to their oponent as computer.

### The board
The gameboard at any given time of the game displays the current situation of all tiles of the ocean. A single tile in the ocean can be in one of three different states:
- \[ \] - hidden
- \[O] - fired but missed
- \[@] - fired and on target
- \[X] - one block of ship sunken
  
The program provides two ways of game initialization - command line parameters and a more user-frindly prompt-response based input system. Both work interchangeably but the user should stick to the system they have chosen until the end of the game after making the first step.

### Using the command line

### Usign the user-friednly prompt-response model

## Project structure
In order to prove a good understanding of OOP principles, I have created an UML class diagram for the project:

![Battleships UML Class diagram](/resources/Battleships_diagram.png "Battleships UML Class diagram")

