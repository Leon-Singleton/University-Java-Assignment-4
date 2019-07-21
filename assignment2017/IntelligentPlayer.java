/**
 * @author Leon Singleton
 */
package assignment2017;

import assignment2017.codeprovided.ColumnFullException;
import assignment2017.codeprovided.Connect4GameState;
import assignment2017.codeprovided.Connect4Player;
import assignment2017.codeprovided.IllegalColumnException;

/**
 * This class extends the connect4player class so that an intelligent player
 * (AI) can make a move on the board by looking two moves ahead
 */
public class IntelligentPlayer extends Connect4Player {

    /**
     * This method allows a the intelligent ai to make a move based on the
     * current gamestate by looking two moves ahead of itself
     * 
     * @param gameState
     *            The object representing the current gamestate of the connect4
     *            board
     */
    public void makeMove(Connect4GameState gameState) {

        int columntoMove = -1;
        // this boolean is used to check if the ai has made its move or not
        boolean success = false;

        // This validation check is used to check if the AI player can win from
        // its next move
        if (success == false) {
            for (int i = 0; i < Connect4GameState.NUM_COLS; i++) {
                // This validation check works by making 7 copies of the current gamestate,
                // then by placing a piece in each column from 1 to 7 through the gamestates
                // if one of the moves results in a winning gamestate then the ai player moves
                // a piece into the column that will result in a win
                Connect4GameState copystate = new MyGameState();
                copystate = gameState.copy();

                try {
                    copystate.move(i);
                    // checks for a winning move and if it is a winning move the
                    // ai moves in that column
                    if (copystate.getWinner() == 1) {
                        columntoMove = i;
                        try {
                            gameState.move(columntoMove);
                            success = true;
                            break;
                        } catch (IllegalColumnException e) {
                            System.out.println(e.getMessage());
                        } catch (ColumnFullException e) {
                            System.out.println(e.getMessage());
                        }
                    }
                } catch (IllegalColumnException e) {
                    System.out.println(e.getMessage());
                } catch (ColumnFullException e) {
                    System.out.println(e.getMessage());
                }
            }
        }

        // This section of code checks if the human player can win from its next move
        // and if the human player can the Ai will block the human player from winning
        if (success == false) {
            for (int i = 0; i < Connect4GameState.NUM_COLS; i++) {

                // this validation check works by casting a new copy of the gamestate and
                // chaning the player turn to the human player
                // then a piece is inserted into each column and if a win is recorded then the Ai
                // will record this position and make its move there to stop the
                // human player from winning on his/her next move
                Connect4GameState copystate = new MyGameState();
                copystate = gameState.copy();
                MyGameState copied = (MyGameState) copystate;
                copied.playerTurn = false;

                try {
                    copied.move(i);
                    if (copystate.getWinner() == 0) {
                        columntoMove = i;
                        try {
                            gameState.move(columntoMove);
                            success = true;
                            break;
                        } catch (IllegalColumnException e) {
                            System.out.println(e.getMessage());
                        } catch (ColumnFullException e) {
                            System.out.println(e.getMessage());
                        }
                    }
                } catch (IllegalColumnException e) {
                    System.out.println(e.getMessage());
                } catch (ColumnFullException e) {
                    System.out.println(e.getMessage());
                }

            }
        }

        // The ai player will make a random move if it can neither block nor win
        // from its next move
        if (success == false) {
            boolean success2 = false;
            do {
                try {
                    // keeps generating a random column number between zero and six
                    // unitl the move is valid and the column is not full
                    columntoMove = 0 + (int) (Math.random() * 6);
                    gameState.move(columntoMove);
                    success2 = true;
                    break;
                } catch (IllegalColumnException e) {
                    System.out.println("");
                } catch (ColumnFullException e) {
                    System.out.println("");
                }
            } while (success2 == false);
        }
    }

}