package Checkers.Gui;
import Checkers.Backend.Game;

import java.awt.*;
import javax.swing.*;
import Checkers.Backend.checkerPiece;
public class MyPanel extends JLayeredPane {

    Game game;
    public int ShowPathFlag;
    public checkerPiece CurrentPiece;
    public checkerPiece clone;
    public checkerPiece[] checkerPieces;
    public Window window;

    MyPanel(Game game, Window window){
        this.window = window;
        checkerPieces = new checkerPiece[4];
        CurrentPiece = null;
        clone = null;
        ShowPathFlag = 1;
        this.game = game;
        this.setPreferredSize(new Dimension(1600,1000));
        this.setMinimumSize(new Dimension(1600, 1000));
        this.setBounds(0,0,1600,1000);

    }

    public void paintComponent(Graphics g){
        Graphics2D graphics2D = (Graphics2D) g;
        if(ShowPathFlag == 2){
            graphics2D.setPaint(Color.BLUE);
            if(CurrentPiece.moveLeft(game,this) == 1){
                clone = new checkerPiece(CurrentPiece.x,CurrentPiece.y,CurrentPiece.colour);
                ShowPathFlag = 1;
                clone.moveLeft(game,this);
                ShowPathFlag = 2;
                checkerPieces[0] = clone;
                int x = 300 + clone.x * (125);
                int y =  clone.y * (125);
                graphics2D.fillRect(x,y,125,125);
            }
            if (CurrentPiece.moveRight(game,this) == 1){
                clone = new checkerPiece(CurrentPiece.x,CurrentPiece.y,CurrentPiece.colour);
                ShowPathFlag = 1;
                clone.moveRight(game,this);
                ShowPathFlag = 2;
                checkerPieces[1] = clone;
                int x = 300 + clone.x * (125);
                int y =  clone.y * (125);
                graphics2D.fillRect(x,y,125,125);
            }

        }

        else {
            for (int i = 0; i < checkerPieces.length; i++) {
                if(checkerPieces[i]!=null) {
                    if (window.ComponentClickedY == checkerPieces[i].y && window.ComponentClickedX == checkerPieces[i].x) {
                        if (i == 0) {
                            for (int j = 0; j < game.Black.length; j++) {
                                if(game.Black[j].x == CurrentPiece.x && game.Black[j].y == CurrentPiece.y){ ;
                                    game.Black[j].moveLeft(game,this);
                                    break;
                                }
                            }
                            for (int j = 0; j < game.Red.length; j++) {
                                if(game.Red[j].x == CurrentPiece.x && game.Red[j].y == CurrentPiece.y){
                                    game.Red[j].moveLeft(game,this);
                                    break;
                                }
                            }
                        }
                        else if (i == 1) {
                            for (int j = 0; j < game.Black.length; j++) {
                                if(game.Black[j].x==CurrentPiece.x && game.Black[j].y == CurrentPiece.y){
                                    game.Black[j].moveRight(game,this);
                                    break;
                                }
                            }
                            for (int j = 0; j < game.Red.length; j++) {
                                if(game.Red[j].x==CurrentPiece.x && game.Red[j].y == CurrentPiece.y){
                                    game.Red[j].moveRight(game,this);
                                    break;
                                }
                            }
                        }
                    }
                }

            }
            CurrentPiece = null;
            checkerPieces = new checkerPiece[4];
        }
            for (int i = 0; i < game.Black.length; i++) {
                int x = 330 + game.Black[i].x * (125);
                int y = 30 + game.Black[i].y * (125);
                graphics2D.setPaint(Color.WHITE);
                graphics2D.fillOval(x, y, 60, 60);
                graphics2D.setPaint(Color.RED);
                graphics2D.fillOval(x + 3, y + 3, 54, 54);

            }

            graphics2D.setPaint(new Color(40, 40, 40));
            for (int i = 0; i < game.Red.length; i++) {
                int x = 330 + game.Red[i].x * (125);
                int y = 30 + game.Red[i].y * (125);
                graphics2D.setPaint(Color.WHITE);
                graphics2D.fillOval(x, y, 60, 60);
                graphics2D.setPaint(new Color(40, 40, 40));
                graphics2D.fillOval(x + 3, y + 3, 54, 54);
            }

    }

}
