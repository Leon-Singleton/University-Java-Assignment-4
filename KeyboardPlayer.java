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
 * This class extends the connect4player class so that a keyboard player (human
 * player) object can be created which allows a keyboard player to input their
 * move choice and process their move choice
 */
public class KeyboardPlayer extends Connect4Player {
    /**
     * This method allows the user to enter a column number in which to drop
     * their piece, in doing this it makes sure that the users entry is valid.
     * Once a user has entered their choice a counter is dropped in the
     * corresponding column by invoking the move method of the gamestate class
     * 
     * @param gameState
     *            The object representing the current gamestate of the connect4
     *            board
     */
    public void makeMove(Connect4GameState gameState) {
        // allows user input into the console to be read
        Scanner in = new Scanner(System.in);
        int col = -1;
        // used to check whether the user's placement of a piece has been a
        // success and keeps asking them for input until it is
        boolean success = false;

        do {
            try {

                // keeps asking for the users choice of column input until their
                // input is in the expected range between 0 and 6 and the chosen
                // column is not already full
                System.out.println("Please enter a column number, 0 to 6 followed by return");
                // checks whether the entry made by the keyboard player is an
                // integer, if not then the user is asked to re-enter their choice
                while (!in.hasNextInt()) {
                    in.next();
                    System.out.println("Please enter a column number, 0 to 6 followed by return");
                }
                col = in.nextInt();
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
