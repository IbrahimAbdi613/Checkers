package Checkers.Gui;

import Checkers.Backend.Game;


import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.*;


public class Window extends JPanel implements MouseListener  {
    JFrame frame = new JFrame();
    Game game;
    MyPanel myPanel;
    public int ShowPathFlag;
    public int ComponentClickedX ;
    public int ComponentClickedY ;
    JLabel jLabel = new JLabel();
    JPanel jPanel = new JPanel();
    JLabel jLabel2 = new JLabel();
    JPanel jPanel2 = new JPanel();
    JLabel jLabel3 = new JLabel();
    JPanel jPanel3 = new JPanel();
    JLabel jLabel4 = new JLabel();
    JPanel jPanel4 = new JPanel();
    JLabel jLabel5 = new JLabel();
    JPanel jPanel5 = new JPanel();
    JLabel jLabel6 = new JLabel();
    JPanel jPanel6 = new JPanel();
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
        jLabel.setText(game.player1.name + " (red)");
        jLabel.setForeground(new Color(255,255,255));
        jLabel.setFont (jLabel.getFont ().deriveFont (25.0f));
        jPanel.setBounds(0,0,300,35);
        jPanel.setBackground(new Color(17, 59 ,8 ));
        jPanel.setVisible(true);
        jPanel.add(jLabel);

        jLabel2.setText(game.player2.name + " (black)");
        jLabel2.setForeground(new Color(255,255,255));
        jLabel2.setFont (jLabel2.getFont ().deriveFont (25.0f));
        jPanel2.setBounds(1300,0,300,35);
        jPanel2.setBackground(new Color(17, 59 ,8 ));
        jPanel2.setVisible(true);
        jPanel2.add(jLabel2);


        frame.add(jPanel);
        frame.add(jPanel2);
        frame.add(myPanel);
        frame.add(jPanel3);
        frame.add(jPanel4);
        frame.add(jPanel5);
        frame.add(jPanel6);

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

    public void updateScore(){
        jLabel3.setText("Number of Opponent's Pieces : " + (12 -  game.player2.Points));
        jLabel3.setForeground(new Color(255,255,255));
        jLabel3.setFont (jLabel3.getFont ().deriveFont (17.0f));
        jPanel3.setBounds(1300,40,300,35);
        jPanel3.setBackground(new Color(17, 59 ,8 ));
        jPanel3.setVisible(true);
        jPanel3.add(jLabel3);

        jLabel4.setText("Number of Opponent's Pieces : " + ( 12 - game.player1.Points));
        jLabel4.setForeground(new Color(255,255,255));
        jLabel4.setFont (jLabel4.getFont ().deriveFont (17.0f));
        jPanel4.setBounds(0,40,300,35);
        jPanel4.setBackground(new Color(17, 59 ,8 ));
        jPanel4.setVisible(true);
        jPanel4.add(jLabel4);

        jLabel5.setText("Number of Kings : " + ( game.player1.Kings ));
        jLabel5.setForeground(new Color(255,255,255));
        jLabel5.setFont (jLabel5.getFont ().deriveFont (17.0f));
        jPanel5.setBounds(1300,85,300,35);
        jPanel5.setBackground(new Color(17, 59 ,8 ));
        jPanel5.setVisible(true);
        jPanel5.add(jLabel5);

        jLabel6.setText("Number of Opponent's Kings : " + (game.player2.Kings));
        jLabel6.setForeground(new Color(255,255,255));
        jLabel6.setFont (jLabel6.getFont ().deriveFont (17.0f));
        jPanel6.setBounds(0,85,300,35);
        jPanel6.setBackground(new Color(17, 59 ,8 ));
        jPanel6.setVisible(true);
        jPanel6.add(jLabel6);
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
