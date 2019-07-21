/**
 * @author Leon Singleton
 */
package assignment2017;

import assignment2017.codeprovided.Connect4Displayable;
import assignment2017.codeprovided.Connect4GameState;

/**
 * A class that is used to output the current state of the game to the console
 * following a players move
 */
public class Connect4ConsoleDisplay implements Connect4Displayable {

    private final MyGameState gameState;

    /**
     * This is the constructor which allows the ganestate to be passed used
     * within this class
     * 
     * @param gamestate
     *            the current gamestate of the board
     */
    public Connect4ConsoleDisplay(Connect4GameState gameState) {
        // casts the connect4gamestate object to an object of type MyGameState
        this.gameState = (MyGameState) gameState;
    }

    /**
     * This method displays the board to the console in an appropriate format
     */
    public void displayBoard() {

        // loops through the gamearray board and prints all items in the array
        // that are not set as the EMPTY variable, depending on the value of the
        // position in the array the appropriate character (Y or R) is printed
        for (int j = Connect4GameState.NUM_ROWS - 1; j >= 0; j--) {
            System.out.print("| ");
            for (int i = 0; i < Connect4GameState.NUM_COLS; i++) {
                if (gameState.gameArray[j][i] == Connect4GameState.EMPTY) {
                    System.out.print("  ");
                    System.out.print(" ");
                } else if (gameState.gameArray[j][i] == Connect4GameState.RED) {
                    System.out.print(" R");
                    System.out.print(" ");
                } else if (gameState.gameArray[j][i] == Connect4GameState.YELLOW) {
                    System.out.print(" Y");
                    System.out.print(" ");
                }
            }

            System.out.print(" |");
            System.out.println();
        }
        System.out.println(" ----------------------- ");
        System.out.println("   0  1  2  3  4  5  6 ");
    }

}
