package Checkers.Gui;

import Checkers.Backend.Game;
import jdk.swing.interop.SwingInterOpUtils;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.*;


public class Window extends Canvas implements MouseListener {
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
        ImageIcon image = new ImageIcon("src/Checkers/Gui/Icon.jpg");
        frame.setIconImage(image.getImage());
        frame.getContentPane().setBackground(new Color(17, 59, 8 ));
        frame.add(new MyPanel(game));
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
                    blackPanel.setBackground(new Color(195,155,119));
                    blackPanel.setBounds(Width,Height,125,125);
                    blackPanel.setOpaque(true);
                    blackPanel.addMouseListener(this);
                    frame.add(blackPanel);
                }
                else if (game.board.Board[i][j] == 0) {
                    //White part of chessboard
                    JPanel whitePanel = new JPanel();
                    whitePanel.setBackground(new Color(101,67,33));
                    whitePanel.setBounds(Width,Height,125,125);
                    whitePanel.setOpaque(true);
                    whitePanel.addMouseListener(this);

                    frame.add(whitePanel);
                }
                Width = Width + 125;
            }

             Width = 300;
             Height = Height - 125;
        }

    }


    @Override
    public void mouseClicked(MouseEvent e) {
        System.out.println("Comon mane");
    }

    @Override
    public void mousePressed(MouseEvent e) {
        System.out.println("your pressed me fam");
    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
