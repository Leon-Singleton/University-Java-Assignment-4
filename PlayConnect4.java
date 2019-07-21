/**
 * @author Leon Singleton
 */
package assignment2017;

import java.util.Scanner;

import assignment2017.codeprovided.Connect4GameState;
import assignment2017.codeprovided.Connect4Player;
import uk.ac.sheffield.com1003.graphics.CentredFrame;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 * This class initialises the game
 */
public class PlayConnect4 {

    /**
     * This method creates all the required objects needed to play a game of
     * connect4 and then begins the game
     */
    public static void main(String[] args) {

        // This if statement checks the args condtion to determine whether to load a
        // console or gui display of the game
        if (args[0].equals("-gui")) {

            // Stores an array of strings of the various game options
            String[] gameTypeArray = { "Two Player Game", "Vs Random Ai player", 
                    "Vs Intelligent Ai player" };

            // using the above array of strings generates a joptionpane to get the players
            // selection on which gamemode to play
            String selectedValue = (String) JOptionPane.showInputDialog(null, 
                    "Select a game type from the list below:",
                    "Connect 4 menu", JOptionPane.QUESTION_MESSAGE, null, 
                    gameTypeArray, gameTypeArray[0]);

            // chceks the user has clicked the ok button
            if (selectedValue != null) {
                // depending on the players choice, begins a game using the graphical gui
                // display for the players choice
                if (selectedValue.equals("Two Player Game")) {
                    // creates the object instances needed to play the game
                    Connect4GameState gameState = new MyGameState();

                    // creates th gui display and makes it become visible
                    Connect4GuiDisplay display2 = new Connect4GuiDisplay(gameState);
                    display2.setVisible(true);

                    Connect4Player yellow = new GuiPlayer();
                    Connect4Player red = new GuiPlayer();
                    // Initialises the game by using the above created objects and invoking
                    // the play method of game
                    Connect4 game = new Connect4(gameState, red, yellow, display2);
                    game.play();

                } else if (selectedValue.equals("Vs Random Ai player")) {
                    // creates the object instances needed to play the game
                    Connect4GameState gameState = new MyGameState();

                    Connect4GuiDisplay display2 = new Connect4GuiDisplay(gameState);
                    display2.setVisible(true);

                    Connect4Player yellow = new RandomPlayer();
                    Connect4Player red = new GuiPlayer();
                    Connect4 game = new Connect4(gameState, red, yellow, display2);
                    game.play();

                } else if (selectedValue.equals("Vs Intelligent Ai player")) {
                    // creates the object instances needed to play the game
                    Connect4GameState gameState = new MyGameState();

                    Connect4GuiDisplay display2 = new Connect4GuiDisplay(gameState);
                    display2.setVisible(true);

                    Connect4Player yellow = new IntelligentPlayer();
                    Connect4Player red = new GuiPlayer();
                    Connect4 game = new Connect4(gameState, red, yellow, display2);
                    game.play();

                }
            } else {
                //if a user clicks cancel when selecting the game mode the game closes
                System.exit(0);
            }

        }

        if (args[0].equals("-nogui")) {

            // creates the object instances needed to play the game
            Connect4GameState gameState = new MyGameState();
            Connect4Player yellow = new RandomPlayer();
            Connect4Player red = new KeyboardPlayer();
            Connect4ConsoleDisplay display = new Connect4ConsoleDisplay(gameState);
            // Initialises the game by using the above created objects and invoking
            // the play method of game

            Connect4 game = new Connect4(gameState, red, yellow, display);
            game.play();

        }

    }
}
