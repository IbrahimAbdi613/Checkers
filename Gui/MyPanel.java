package Checkers.Gui;
import Checkers.Backend.Game;

import java.awt.*;
import javax.swing.*;
import Checkers.Backend.checkerPiece;
public class MyPanel extends JLayeredPane {

    Game game;
    public int ShowPathFlag;
    public checkerPiece CurrentPiece;

    MyPanel(Game game){
        CurrentPiece = null;
        ShowPathFlag = 1;
        this.game = game;
        this.setPreferredSize(new Dimension(1600,1000));
        this.setMinimumSize(new Dimension(1600, 1000));
        this.setBounds(0,0,1600,1000);

    }
    public void paintComponent(Graphics g){
        System.out.println(ShowPathFlag);
        Graphics2D graphics2D = (Graphics2D) g;
        graphics2D.setPaint(Color.red);

        if(ShowPathFlag == 2){
            int x = 320 + CurrentPiece.x * (125);
            int y = 20 + CurrentPiece.y * (125);
            CurrentPiece.ToString();
            if(CurrentPiece.CheckMoveLeft(game)){
                System.out.println("You can move Left");
            }
            if (CurrentPiece.CheckMoveRight(game)){
                System.out.println("You can move Right");
            }
            CurrentPiece = null;
            graphics2D.fillOval(x,y,75,75);

        }

        for (int i = 0; i < game.Black.length; i ++){
            int x = 320 + game.Black[i].x * (125);
            int y = 20 + game.Black[i].y * (125);
            graphics2D.fillOval(x,y,75,75);
        }
        graphics2D.setPaint(new Color(40,40,40));
        for (int i = 0; i < game.Red.length; i ++){
            int x = 320 + game.Red[i].x * (125);
            int y = 20 + game.Red[i].y * (125);
            graphics2D.fillOval(x,y,75,75);
        }

    }

}
