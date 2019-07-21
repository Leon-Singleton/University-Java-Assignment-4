/**
 * @author Leon Singleton
 */
package assignment2017;

import assignment2017.codeprovided.ColumnFullException;
import assignment2017.codeprovided.Connect4GameState;
import assignment2017.codeprovided.IllegalColumnException;
import assignment2017.codeprovided.IllegalRowException;

/**
 * This class represents the current status of the game and the board
 */
public class MyGameState extends Connect4GameState {

    protected boolean playerTurn;

    protected int[][] gameArray = new int[NUM_ROWS][NUM_COLS];

    /**
     * This method starts the game by generating a board with all positions set
     * to be EMPTY and setting the red player as the player to move first
     * 
     */
    public void startGame() {

        // loops through the array which repreents the positions of the board
        // and by default sets all places to be EMPTY
        for (int i = 0; i < NUM_ROWS; i++) {
            for (int j = 0; j < NUM_COLS; j++) {
                gameArray[i][j] = EMPTY;
            }
        }

        // sets the turn so that red moves first
        playerTurn = false;

    }

    /**
     * This method allows a piece to be added onto the board
     * 
     * @param col
     *            the column in which to drop the counter, in the range 0-6
     * @throws ColumnFullException
     *             if the column denoted by col is full (i.e. the move cannot be
     *             played)
     * @throws IllegalColumnException
     *             if col is not in the range 0-6 (i.e. an invalid column)
     */
    public void move(int col) throws ColumnFullException, IllegalColumnException {

        // checks if the supplied column number is in the acceptable range and
        // that its corresponding column is not already full, however if these
        // are true then their corresponding exceptions are thrown
        if (isColumnFull(col)) {
            throw new ColumnFullException(col);
        } else {
            if (col > 6 || col < 0) {
                throw new IllegalColumnException(col);
            } else {
                // This for loop loops through all positions in the column
                // specified by the player and finds the lowest position in that
                // column that is EMPTY
                for (int rowposition = 0; rowposition < NUM_ROWS; rowposition++) {
                    if (gameArray[rowposition][col] == EMPTY) {
                        // once the lowest position has been found the status of
                        // that position is either updated to RED or YELLOW
                        // depending on which players turn it is
                        if (playerTurn == false) {
                            gameArray[rowposition][col] = RED;
                            playerTurn = true;

                            break;
                        } else {
                            gameArray[rowposition][col] = YELLOW;
                            playerTurn = false;

                            break;
                        }
                    }
                }
            }
        }
    }

    /**
     * This method returns the turn of the player that has just moved a piece
     * onto the board
     * 
     * @return the constant RED if it is red's turn, else YELLOW
     */
    public int whoseTurn() {
        // returns the value RED or YELLOW depending on the state of the
        // playerturn boolean
        if (playerTurn == false) {
            return RED;
        } else {
            return YELLOW;
        }
    }

    /**
     * returns a constant denoting the status of the slot at the position
     * denoted by the col and row parameters
     * 
     * @param col
     *            the column of the position being queried (in the range 0-6)
     * @param row
     *            the row of the position being queried (in the range 0-5)
     * @return the EMPTY constant if the slot is EMPTY, the RED constant if the
     *         slot is filled by a red counter, the YELLOW constant if is yellow
     * @throws IllegalColumnException
     *             if col is not in the range 0-6 (i.e. an invalid column)
     * @throws IllegalRowException
     *             if col is not in the range 0-5 (i.e. an invalid row)
     */
    public int getCounterAt(int col, int row) throws IllegalColumnException, IllegalRowException {

        if (col > 6 || col < 0) {
            throw new IllegalColumnException(col);
        } else {
            if (row > 5 || row < 0) {
                throw new IllegalRowException(col);
            } else {
                // returns either the value red or yellow depending on the value
                // of the position specified by the user
                if (gameArray[row][col] == RED) {
                    return RED;
                } else if (gameArray[row][col] == YELLOW) {
                    return YELLOW;
                }
            }
        }
        return EMPTY;
    }

    /**
     * returns whether the board is full and the game has ended in a tie
     * 
     * @return true if the board is full, else false
     */
    public boolean isBoardFull() {

        // loops through all rows and columns to check if there exists atleast
        // one space that is EMPTY, if so false is returned
        for (int i = 0; i < NUM_ROWS; i++) {
            for (int j = 0; j < NUM_COLS; j++) {
                if (gameArray[i][j] == EMPTY) {
                    return false;
                }
            }
        }

        return true;
    }

    /**
     * returns whether the column denoted by the col parameter is full or not
     * 
     * @param col
     *            the column being queried (in the range 0-6)
     * @return true if the column denoted by col is full of counters, else false
     * @throwsIllegalColumnException if col is not in the range 0-6 (i.e. an
     *                               invalid column)
     */
    public boolean isColumnFull(int col) throws IllegalColumnException {

        if (col > 6 || col < 0) {
            throw new IllegalColumnException(col);
        } else {
            // checks if a supplied column is full by checking the highest row
            // index to see if that index is not EMPTY
            if (gameArray[5][col] != EMPTY) {
                return true;
            }
        }
        return false;
    }

    /**
     * This method checks if a win condition has been met by a player (4
     * counters in a row)
     * 
     * @return player returns the value representing the player that has won the
     *         game
     * @return the EMPTY variable if no win condition has been found
     */
    public int getWinner() {
        // gets the persons turn and sets the status of the player variable
        int player = RED;
        if (playerTurn == false) {
            player = YELLOW;
        }

        // checks if there is a horizontal win by checking if there are 4 pieces
        // of the same colour in a horizontal line
        // note the for loop finishes three columns before the last column since
        // that is the last possible horizontal win available and prevents an
        // arrayoutofbounds condition error
        for (int i = 0; i < NUM_COLS - 3; i++) {
            for (int j = 0; j < NUM_ROWS; j++) {
                if (gameArray[j][i] == player && gameArray[j][i + 1] == player 
                        && gameArray[j][i + 2] == player
                        && gameArray[j][i + 3] == player) {
                    return player;
                }
            }
        }

        // checks if there is a vertical win by checking if there are 4 pieces
        // of the same colour in a vertical line
        // note the for loop finishes three rows before the last row since
        // that is the last poisible vertical win available and prevents an
        // arrayoutofbounds condition error
        for (int j = 0; j < NUM_ROWS - 3; j++) {
            for (int i = 0; i < NUM_COLS; i++) {
                if (gameArray[j][i] == player && gameArray[j + 1][i] == player 
                        && gameArray[j + 2][i] == player
                        && gameArray[j + 3][i] == player) {
                    return player;
                }
            }
        }

        // checks if there is a descending win by checking if there are 4 pieces
        // of the same colour in a a diagonal row in an descending shape
        for (int j = 3; j < NUM_ROWS; j++) {
            for (int i = 3; i < NUM_COLS - 3; i++) {
                if (gameArray[j][i] == player && gameArray[j - 1][i - 1] == player 
                        && gameArray[j - 2][i - 2] == player
                        && gameArray[j - 3][i - 3] == player) {
                    return player;
                }
            }
        }

        // checks if there is a ascending win by checking if there are 4 pieces
        // of the same colour in a a diagonal row in an ascending shape
        for (int j = 3; j < NUM_ROWS; j++) {
            for (int i = 0; i < NUM_COLS - 3; i++) {
                if (gameArray[j][i] == player && gameArray[j - 1][i + 1] == player 
                        && gameArray[j - 2][i + 2] == player
                        && gameArray[j - 3][i + 3] == player) {
                    return player;
                }
            }
        }

        return EMPTY;
    }

    /**
     * This method checks whether the game has finished
     * 
     * @return true if there is a winner or the board is full
     */
    public boolean gameOver() {

        // returns true to denote the fact that the game is over if the board is
        // either full or a winner has been found
        if (isBoardFull() || getWinner() != EMPTY) {
            return true;
        }
        return false;
    }

    /**
     * Copies the current Connect4GameState instance into another object
     * 
     * @return the new Connect4GameState instance
     */
    public Connect4GameState copy() {
        MyGameState gamestatecopy = new MyGameState();

        // creates a deep copy of the gamesate object by setting the contnets of
        // the copies game board to be exactly the same as the gamestate invoked
        // upon
        for (int i = 0; i < NUM_ROWS; i++) {
            for (int j = 0; j < NUM_COLS; j++) {
                gamestatecopy.gameArray[i][j] = gameArray[i][j];
            }
        }
        // also sets the playerturn of the gamestate copy to be the same as the
        // gamestate invoked upon
        gamestatecopy.playerTurn = playerTurn;

        return gamestatecopy;
    }

}
