/**
 * @author Leon Singleton
 */
package assignment2017;

import assignment2017.codeprovided.Connect4Displayable;
import assignment2017.codeprovided.Connect4GameState;
import assignment2017.codeprovided.Connect4Player;

/**
 * A class that represents the process of Connect4 game bring carried out
 * between two players using the current gamestate of the board
 */
public class Connect4 {

    private final Connect4GameState gameState;
    private final Connect4Player red;
    private final Connect4Player yellow;
    private final Connect4Displayable display;

    /**
     * The constructor for the class used to set the instance variables needed
     * 
     * @param gameState
     *            The object representing the current gamestate of the connect4
     *            board
     * @param red
     *            The object representing the red player
     * @param yellow
     *            The object representing the yellow player
     * @param display
     *            The object representing the display output of the game
     */
    public Connect4(Connect4GameState gameState, Connect4Player red, Connect4Player yellow,
            Connect4Displayable display) {
        this.gameState = gameState;
        this.red = red;
        this.yellow = yellow;
        this.display = display;
    }

    /**
     * This method is used to go through the processes of playing a game between
     * two players by getting their respective moves and responding with the
     * correct outcome depending on the win state or draw state of a game
     */

    public void play() {

        gameState.startGame();

        // keeps getting the red and yellow players to make moves onto the board
        // until the gameover condition is true, the board is displayed after
        // each players move
        do {
            if (gameState.whoseTurn() == Connect4GameState.RED) {
                red.makeMove(gameState);
            }
            display.displayBoard();
            if (gameState.gameOver() == true) {
                break;
            }
            if (gameState.whoseTurn() == Connect4GameState.YELLOW) {
                yellow.makeMove(gameState);
            }
            display.displayBoard();
        } while (gameState.gameOver() != true);

        // checks if the board is full and there is no winner, in which case the
        // game is a tie
        if (gameState.isBoardFull() == true && gameState.getWinner() == -1) {
            System.out.println("Board is full, game tied");
        }

        // checks if the win condition has been met and determines which player
        // it is that has won
        if (gameState.getWinner() == 0) {
            System.out.println("R wins");
        } else if (gameState.getWinner() == 1) {
            System.out.println("Y wins");
        }

    }

}
