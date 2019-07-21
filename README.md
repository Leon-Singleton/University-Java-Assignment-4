# University-Java-Assignment-4
Connect Four game with Intelligent AI and console/graphical display variations

This program allows a game of connect 4 to be played between either two human players or a human player and an intelligent AI player that abides by all of the typical rules of standard game of connect4 . There are also two display variants which can be played, a console variant and a graphical display variant. The game makes use of absract classes, inheritance and polymorhpism to track the status of the game and allow for different types of player and display modes to be 'plugged in'. The graphical interface has been built using Java Swing elements.

When playing the game a user can select to play multiple types of game which are descirbed as follows:

* Two Player game: A game played between two human participants.
* Random Computer Game: A game played between a human participant and an AI that makes a move at random each time.
* Intelligent AI game: A game played between a human participant and an AI that makes a move based on knowledge of the game state. It looks ahead several moves in advance before choosing the move that delivers the highest chance of victory.

## Installation and execution

1. Outside of the assignment2017 folder compile its contents as package using the command 'javac assignment2017\PlayConnect4.java' from a command window.
2. Exucute the main Java file using the 'java' command using the command argument '-gui' or '-nogui' from a console window to specify the display variant e.g ('java assignment2017.PlayConnect4 -gui').
3. Follow the on screen Instructions to play a game of connect4 with either another human player or an AI player.


