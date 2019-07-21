/**
 * @author Leon Singleton
 */
package assignment2017;

import java.util.Scanner;

import assignment2017.codeprovided.ColumnFullException;
import assignment2017.codeprovided.Connect4GameState;
import assignment2017.codeprovided.Connect4Player;
import assignment2017.codeprovided.IllegalColumnException;

/**
 * This class extends the connect4player class so that a GUI player (human
 * player) object can be created which allows a GUI player to play the game and
 * their input be processed
 */
public class GuiPlayer extends Connect4Player {

    /**
     * This method is blank method so that the user can play the GUI game mode
     * without the game loop getting stuck waiting for the keyboard player
     * object to type a move in the console, hence this method is needed
     * 
     * @param gameState
     *            The object representing the current gamestate of the connect4
     *            board
     */
    public void makeMove(Connect4GameState gameState) {

    }

}
