package assignment2017;

import java.awt.*;

import javax.swing.*;

import assignment2017.codeprovided.Connect4GameState;

/**
 * This class represents a jpanel which is used to display the board using
 * vector graphics
 */
public class DrawBoardPanel extends JPanel {

    private final MyGameState gameState;

    /**
     * This is the constructor which allows the ganestate to be passed used
     * within this class
     * 
     * @param gamestate
     *            the current gamestate of the board
     */
    public DrawBoardPanel(Connect4GameState gameState) {
        this.gameState = (MyGameState) gameState;
        // sets the background of the panel to blue to resemble a connect4 game
        setBackground(Color.blue);
    }

    /**
     * This method is responsible for drawing the board to the gui display and updating its 
     * appearance to reflect the latest gamestate
     * 
     * @param g
     *            the imported graphics object
     */
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        //creates a new graphics object
        Graphics2D g2 = (Graphics2D) g;

        //here i set variables for the x and y co-ordiante of where to draw each circle
        int XCoordinate = 15;
        int YCoordinate;

        //then using this for loop a coloured circle is drawn depending on its state in the 
        //gamestate, each time the x and y co-ordinates are incremented to there is equal 
        //spacing between each coloured circle
        for (int i = 0; i < Connect4GameState.NUM_COLS; i++) {
            YCoordinate = 15;
            for (int j = Connect4GameState.NUM_ROWS - 1; j >= 0; j--) {

                //sets the colour of the circle depending on the its colour in the gamestate
                if (gameState.gameArray[j][i] == Connect4GameState.EMPTY) {
                    g2.setColor(Color.white);
                } else if (gameState.gameArray[j][i] == Connect4GameState.RED) {
                    g2.setColor(Color.red);
                } else if (gameState.gameArray[j][i] == Connect4GameState.YELLOW) {
                    g2.setColor(Color.yellow);
                }
                //draws the circle
                g2.fillOval(XCoordinate, YCoordinate, 65, 65);
                YCoordinate += 80;
            }
            XCoordinate += 89;
        }

    }

}
