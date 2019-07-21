/**
 * @author Leon Singleton
 */
package assignment2017;

import assignment2017.codeprovided.ColumnFullException;
import assignment2017.codeprovided.Connect4GameState;
import assignment2017.codeprovided.Connect4Player;
import assignment2017.codeprovided.IllegalColumnException;

/**
 * This class extends the connect4player class so that a randomplayer (AI) can
 * make a move on the board
 */
public class RandomPlayer extends Connect4Player {

    /**
     * This method allows a random number between 0-6 to be generated to
     * represent a computer (AI) player entering its chosen move on the board
     * 
     * @param gameState
     *            The object representing the current gamestate of the connect4
     *            board
     */
    public void makeMove(Connect4GameState gameState) {
        int col = -1;

        // used to check whether the user's placement of a piece has been a
        // success and keeps asking them for input until it is
        boolean success = false;

        do {
            try {
                // keeps generating a random column number between zero and six
                // unitl the move is valid and the column is not full
                col = 0 + (int) (Math.random() * 6);
                System.out.println("Computer dropped counter in " + col);
                gameState.move(col);
                success = true;
            } catch (IllegalColumnException e) {
                System.out.println(e.getMessage());
            } catch (ColumnFullException e) {
                System.out.println(e.getMessage());
            }
        } while (success == false);

    }

}
