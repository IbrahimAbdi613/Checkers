package Checkers.Gui;

import Checkers.Backend.Game;
import java.awt.*;
import javax.swing.*;


public class Window extends Canvas {
    JFrame frame = new JFrame();

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    public Window(int width, int height, String titleString, Game game) {

        //Creates the window
        frame.setMaximumSize(new Dimension(width, height));
        frame.setMinimumSize(new Dimension(width, height));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Sets the title of the window as well the icon and the background colour
        frame.setTitle(titleString);
        ImageIcon image = new ImageIcon("src/Checkers/Icon.jpg");
        frame.setIconImage(image.getImage());
        frame.getContentPane().setBackground(new Color(245,245,220));
        makeBoard(game);
        frame.setLayout(null);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

    }
    private void makeBoard(Game game){
        int Width = 300;
        int Height = 875;

        for (int i = 0; i < game.board.Dimension; i++) {
            for (int j = 0; j < game.board.Dimension; j++) {
                if(game.board.Board[i][j] == 1){
                    //Black part of chessboard
                    JPanel blackPanel = new JPanel();
                    blackPanel.setBackground(Color.BLACK);
                    blackPanel.setBounds(Width,Height,125,125);
                    frame.add(blackPanel);
                }
                else if (game.board.Board[i][j] == 0) {
                    //White part of chessboard
                    JPanel whitePanel = new JPanel();
                    whitePanel.setBackground(Color.WHITE);
                    whitePanel.setBounds(Width,Height,125,125);
                    frame.add(whitePanel);
                }
                Width = Width + 125;
            }

             Width = 300;
             Height = Height - 125;
        }

    }

}
