package assignment2017;

import assignment2017.codeprovided.ColumnFullException;
import assignment2017.codeprovided.Connect4Displayable;
import assignment2017.codeprovided.Connect4GameState;
import assignment2017.codeprovided.IllegalColumnException;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Connect4GuiDisplay extends JFrame implements Connect4Displayable {

    private final MyGameState gameState;

    // creates a panel whcih holds a label indicating the players turn and
    // winner
    private static JLabel bottomLabel = new JLabel("Bottom Label", SwingConstants.CENTER);
    private static JPanel bottompanel = new JPanel();

    public Connect4GuiDisplay(Connect4GameState gameState) {
        // casts the connect4gamestate object to an object of type MyGameState
        this.gameState = (MyGameState) gameState;

        // sets the title of the frame window that opens
        setTitle("Connect 4 game");
        Toolkit toolkit = Toolkit.getDefaultToolkit();

        Dimension screenDimensions = toolkit.getScreenSize();
        // sets the size of the game window and centers it on the screen
        setSize(650, 590);
        setLocation(new Point(screenDimensions.width / 4, screenDimensions.height / 4));

        // makes the game window close when the exit icon is clicked
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // creates the buttons allowing the player to make a move
        JButton button1 = new JButton("Column 1");
        JButton button2 = new JButton("Column 2");
        JButton button3 = new JButton("Column 3");
        JButton button4 = new JButton("Column 4");
        JButton button5 = new JButton("Column 5");
        JButton button6 = new JButton("Column 6");
        JButton button7 = new JButton("Column 7");

        // adds the buttons to a jpanel in a grid row layout
        JPanel gameMovementPanel = new JPanel();
        gameMovementPanel.setLayout(new GridLayout(0, 7));
        gameMovementPanel.add(button1);
        gameMovementPanel.add(button2);
        gameMovementPanel.add(button3);
        gameMovementPanel.add(button4);
        gameMovementPanel.add(button5);
        gameMovementPanel.add(button6);
        gameMovementPanel.add(button7);

        // sets the font and size of the label text
        bottomLabel.setFont(new Font("Serif", Font.PLAIN, 20));

        // depending on the current players turn the label colour changes, text
        // changes
        // and the jpanel background changes
        if (gameState.whoseTurn() == Connect4GameState.YELLOW) {
            bottomLabel.setText("Yellow's turn");
            bottomLabel.setForeground(Color.black);
            bottompanel.setBackground(Color.yellow);
        } else if (gameState.whoseTurn() == Connect4GameState.RED) {
            bottomLabel.setText("red's turn");
            bottomLabel.setForeground(Color.white);
            bottompanel.setBackground(Color.red);
        }

        // adds the label to the panel
        bottompanel.add(bottomLabel);

        // creates an object containing the jpanel that is used to dislay the
        // gui board
        DrawBoardPanel boardDisplay = new DrawBoardPanel(gameState);

        // positions the various jpanels
        Container contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());
        contentPane.add(bottompanel, BorderLayout.SOUTH);
        contentPane.add(gameMovementPanel, BorderLayout.NORTH);
        contentPane.add(boardDisplay, BorderLayout.CENTER);

        // this button listener is used to add a counter to the positiion 1
        button1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                // if the game is not the player makes their move in the column
                // they chose
                if (gameState.gameOver() == false) {

                    try {
                        gameState.move(0);
                        // refreshes the label text to show that it is the next
                        // players turn
                        displayBoard();
                        // refreshes the board to show the gamestate changes
                        setVisible(false);
                        setVisible(true);

                        // if the game has finished and the user clicks to close the 
                        //game as a result of being asked by a joption pane then the 
                        //game gui window is closed
                        if (closeGameWindow(gameState)) {
                            dispose();
                        }
                        // these catch blocks handle the exception if a column
                        // is full or is not valid
                    } catch (IllegalColumnException e1) {
                        System.out.println(e1.getMessage());
                    } catch (ColumnFullException e1) {
                        System.out.println(e1.getMessage());
                    }

                }

            }
        });

        button2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                if (gameState.gameOver() == false) {

                    try {
                        gameState.move(1);
                        displayBoard();
                        setVisible(false);
                        setVisible(true);
                        if (closeGameWindow(gameState)) {
                            dispose();
                        }
                    } catch (IllegalColumnException e1) {
                        System.out.println(e1.getMessage());
                    } catch (ColumnFullException e1) {
                        System.out.println(e1.getMessage());
                    }

                }
            }
        });

        button3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                if (gameState.gameOver() == false) {
                    try {
                        gameState.move(2);
                        displayBoard();
                        setVisible(false);
                        setVisible(true);
                        if (closeGameWindow(gameState)) {
                            dispose();
                        }
                    } catch (IllegalColumnException e1) {
                        System.out.println(e1.getMessage());
                    } catch (ColumnFullException e1) {
                        System.out.println(e1.getMessage());
                    }
                }

            }
        });

        button4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                if (gameState.gameOver() == false) {
                    try {
                        gameState.move(3);
                        displayBoard();
                        setVisible(false);
                        setVisible(true);
                        if (closeGameWindow(gameState)) {
                            dispose();
                        }
                    } catch (IllegalColumnException e1) {
                        System.out.println(e1.getMessage());
                    } catch (ColumnFullException e1) {
                        System.out.println(e1.getMessage());
                    }
                }

            }
        });

        button5.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                if (gameState.gameOver() == false) {
                    try {
                        gameState.move(4);
                        displayBoard();
                        setVisible(false);
                        setVisible(true);
                        if (closeGameWindow(gameState)) {
                            dispose();
                        }
                    } catch (IllegalColumnException e1) {
                        System.out.println(e1.getMessage());
                    } catch (ColumnFullException e1) {
                        System.out.println(e1.getMessage());
                    }
                }

            }
        });

        button6.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                if (gameState.gameOver() == false) {
                    try {
                        gameState.move(5);
                        displayBoard();
                        setVisible(false);
                        setVisible(true);
                        if (closeGameWindow(gameState)) {
                            dispose();
                        }
                    } catch (IllegalColumnException e1) {
                        System.out.println(e1.getMessage());
                    } catch (ColumnFullException e1) {
                        System.out.println(e1.getMessage());
                    }
                }

            }
        });

        button7.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                if (gameState.gameOver() == false) {
                    try {
                        gameState.move(6);
                        displayBoard();
                        setVisible(false);
                        setVisible(true);
                        if (closeGameWindow(gameState)) {
                            dispose();
                        }
                    } catch (IllegalColumnException e1) {
                        System.out.println(e1.getMessage());
                    } catch (ColumnFullException e1) {
                        System.out.println(e1.getMessage());
                    }
                }

            }
        });

    }

    /**
     * This method is used to check if the game is over and ask the user if they
     * want to close the game window
     * 
     * @param gamestate
     *            the current gamestate of the board
     */
    public static boolean closeGameWindow(Connect4GameState gameState) {

        // if the game is over then a joption pane is displayed asking the user
        // if they would like
        // to close the game, if they reply yes then this method returns true
        if (gameState.gameOver() == true) {
            int reply = JOptionPane.showConfirmDialog(null, 
                    "Would you like to close this game window", "Game Over",
                    JOptionPane.YES_NO_OPTION);
            if (reply == JOptionPane.YES_OPTION) {
                return true;
            }
        }

        return false;
    }

    /**
     * This method is used to update the status of the label which either shows
     * the current players turn or the colour of the player that has won the
     * game
     * 
     */
    public void displayBoard() {

        // Changes the text of the label, the colour of the label and the
        // background of the
        // panel the label is in, depending on whose turn it is 
        if (gameState.whoseTurn() == Connect4GameState.YELLOW) {
            bottomLabel.setText("Yellow's turn");
            bottomLabel.setForeground(Color.black);
            bottompanel.setBackground(Color.yellow);
        } else if (gameState.whoseTurn() == Connect4GameState.RED) {
            bottomLabel.setText("Red's turn");
            bottomLabel.setForeground(Color.white);
            bottompanel.setBackground(Color.red);
        }

        // works the same as above but is ised to display the winner if the game
        // is over via the label
        if (gameState.gameOver() == true) {
            if (gameState.getWinner() == 0) {
                bottomLabel.setText("Red Won!");
                bottomLabel.setForeground(Color.white);
                bottompanel.setBackground(Color.red);
            } else if (gameState.getWinner() == 1) {
                bottomLabel.setText("Yellow won!");
                bottomLabel.setForeground(Color.black);
                bottompanel.setBackground(Color.yellow);
            }
        }
    }

}
