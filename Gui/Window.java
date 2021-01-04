package Checkers.Gui;

import Checkers.Backend.Game;


import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.*;


public class Window extends JLabel implements MouseListener  {
    JFrame frame = new JFrame();
    Game game;
    MyPanel myPanel;
    public int ShowPathFlag;
    public int ComponentClickedX ;
    public int ComponentClickedY ;
    /**
     *
     */
    private static final long serialVersionUID = 1L;

    public Window(int width, int height, String titleString, Game game) {
        this.game = game;
        //Creates the window
        frame.setMaximumSize(new Dimension(width, height));
        frame.setMinimumSize(new Dimension(width, height));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Sets the title of the window as well the icon and the background colour
        frame.setTitle(titleString);
        ImageIcon image = new ImageIcon("src/Checkers/Gui/Icon.jpg");
        frame.setIconImage(image.getImage());
        frame.getContentPane().setBackground(new Color(17, 59 ,8 ));
        myPanel = new MyPanel(game,this);
        frame.add(myPanel);
        makeBoard(game);

        frame.setLayout(null);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        repaint();
        ShowPathFlag = 1;

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

    }

    @Override
    public void mousePressed(MouseEvent e) {
        if(ShowPathFlag == 1) {
            ComponentClickedX =  ((e.getComponent().getX() - 300) / 125);
            ComponentClickedY =  (e.getComponent().getY()/ 125 );
            for (int i = 0; i < game.Black.length; i++) {
                if(game.Black[i].x == ComponentClickedX && game.Black[i].y == ComponentClickedY){
                    myPanel.CurrentPiece = game.Black[i];
                    ShowPathFlag = 2;
                    myPanel.ShowPathFlag = ShowPathFlag;
                    myPanel.repaint();
                    break;
                }
                else if(game.Red[i].x == ComponentClickedX && game.Red[i].y == ComponentClickedY){
                    myPanel.CurrentPiece = game.Red[i];
                    ShowPathFlag = 2;
                    myPanel.ShowPathFlag = ShowPathFlag;
                    myPanel.repaint();
                    break;
                }
            }

        }
        else if (ShowPathFlag == 2){
            ComponentClickedX =  ((e.getComponent().getX() - 300) / 125);
            ComponentClickedY =  (e.getComponent().getY()/ 125 );
            ShowPathFlag = 1;
            myPanel.ShowPathFlag = ShowPathFlag;
            myPanel.repaint();


        }

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
