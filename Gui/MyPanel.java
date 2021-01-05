package Checkers.Gui;
import Checkers.Backend.Game;

import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;
import Checkers.Backend.CheckerPiece;
public class MyPanel extends JLayeredPane {

     Game game;
    public int ShowPathFlag;
    public CheckerPiece CurrentPiece;
    public CheckerPiece clone;
    public CheckerPiece[] CheckerPieces;
    public Window window;
    public int remove;

    MyPanel(Game game, Window window){
        this.window = window;
        CheckerPieces = new CheckerPiece[4];
        CurrentPiece = null;
        clone = null;
        ShowPathFlag = 1;
        this.game = game;
        this.setPreferredSize(new Dimension(1600,1000));
        this.setMinimumSize(new Dimension(1600, 1000));
        this.setBounds(0,0,1600,1000);
        remove = 0;
        game.CoordinatesForKills = new ArrayList<>();
    }

    public void paintComponent(Graphics g){
        Graphics2D graphics2D = (Graphics2D) g;
        if(ShowPathFlag == 2){
            graphics2D.setPaint(Color.BLUE);
            if(CurrentPiece.moveLeft(game,this) == 1){
                clone = new CheckerPiece(CurrentPiece.x,CurrentPiece.y,CurrentPiece.colour,CurrentPiece.King);
                ShowPathFlag = 1;
                clone.moveLeft(game,this);
                ShowPathFlag = 2;
                CheckerPieces[0] = clone;
                int x = 300 + clone.x * (125);
                int y = clone.y * (125);
                graphics2D.fillRect(x,y,125,125);
            }
            if (CurrentPiece.moveRight(game,this) == 1){
                clone = new CheckerPiece(CurrentPiece.x,CurrentPiece.y,CurrentPiece.colour,CurrentPiece.King);
                ShowPathFlag = 1;
                clone.moveRight(game,this);
                ShowPathFlag = 2;
                CheckerPieces[1] = clone;
                int x = 300 + clone.x * (125);
                int y = clone.y * (125);
                graphics2D.fillRect(x,y,125,125);
            }
            if (CurrentPiece.KingMoveBackRight(game,this) == 1){
                clone = new CheckerPiece(CurrentPiece.x,CurrentPiece.y,CurrentPiece.colour,CurrentPiece.King);
                ShowPathFlag = 1;
                clone.KingMoveBackRight(game,this);
                ShowPathFlag = 2;
                CheckerPieces[2] = clone;
                int x = 300 + clone.x * (125);
                int y = clone.y * (125);
                graphics2D.fillRect(x,y,125,125);
            }
            if (CurrentPiece.KingMoveBackLeft(game,this) == 1){
                clone = new CheckerPiece(CurrentPiece.x,CurrentPiece.y,CurrentPiece.colour,CurrentPiece.King);
                ShowPathFlag = 1;
                clone.KingMoveBackLeft(game,this);
                ShowPathFlag = 2;
                CheckerPieces[3] = clone;
                int x = 300 + clone.x * (125);
                int y = clone.y * (125);
                graphics2D.fillRect(x,y,125,125);
            }

            CurrentPiece.removeOpponents(game,this);
            graphics2D.setPaint(Color.RED);

            for (int i = 0; i < game.CoordinatesForKills.size();i++){
                int x = 300 + game.CoordinatesForKills.get(i) * (125);
                int y = game.CoordinatesForKills.get(i + 1)* (125);
                i++;
                graphics2D.fillRect(x,y,125,125);
            }
        }

        else {
            this.remove = 1;
            for (int i = 0; i < CheckerPieces.length; i++) {
                if(CheckerPieces[i]!=null) {
                    if (window.ComponentClickedY == CheckerPieces[i].y && window.ComponentClickedX == CheckerPieces[i].x) {
                        if (i == 0) {
                            for (int j = 0; j < game.Black.length; j++) {
                                if(game.Black[j].x == CurrentPiece.x && game.Black[j].y == CurrentPiece.y){
                                    game.Black[j].moveLeft(game,this);
                                    break;
                                }
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
                                if(game.Red[j].x==CurrentPiece.x && game.Red[j].y == CurrentPiece.y){
                                    game.Red[j].moveRight(game,this);
                                    break;
                                }
                            }
                        }
                        else if(i == 2){
                            for (int j = 0; j < game.Black.length; j++) {
                                if(game.Black[j].x==CurrentPiece.x && game.Black[j].y == CurrentPiece.y){
                                    game.Black[j].KingMoveBackRight(game,this);
                                    break;
                                }
                                if(game.Red[j].x==CurrentPiece.x && game.Red[j].y == CurrentPiece.y){
                                    game.Red[j].KingMoveBackRight(game,this);
                                    break;
                                }
                            }
                        }
                        else if(i == 3){
                            for (int j = 0; j < game.Black.length; j++) {
                                if(game.Black[j].x==CurrentPiece.x && game.Black[j].y == CurrentPiece.y){
                                    game.Black[j].KingMoveBackLeft(game,this);
                                    break;
                                }
                                if(game.Red[j].x==CurrentPiece.x && game.Red[j].y == CurrentPiece.y){
                                    game.Red[j].KingMoveBackLeft(game,this);
                                    break;
                                }
                            }
                        }
                    }
                }
            }
            for(int i = 0; i < game.CoordinatesForKills.size(); i++){
                if(game.CoordinatesForKills.get(i) != null && game.CoordinatesForKills.get(i + 1) != null) {
                    if(game.CoordinatesForKills.get(i) == window.ComponentClickedX && game.CoordinatesForKills.get(i + 1) == window.ComponentClickedY ){
                        CurrentPiece.removeOpponents(game,this);
                    }
                }
                i++;
            }
            CurrentPiece = null;
            CheckerPieces = new CheckerPiece[4];
            this.remove = 0;
        }
            for (int i = 0; i < game.Black.length; i++) {
                if(game.Black[i].x > -2){
                    int x = 330 + game.Black[i].x * (125);
                    int y = 30 + game.Black[i].y * (125);
                    graphics2D.setPaint(Color.WHITE);
                    if(game.Black[i].King){
                        graphics2D.setPaint(new Color(218,165,32));
                    }
                    graphics2D.fillOval(x, y, 60, 60);
                    graphics2D.setPaint(Color.RED);
                    graphics2D.fillOval(x + 3, y + 3, 54, 54);
                }
            }

            graphics2D.setPaint(new Color(40, 40, 40));
            for (int i = 0; i < game.Red.length; i++) {
                if (game.Red[i].x > -2) {
                    int x = 330 + game.Red[i].x * (125);
                    int y = 30 + game.Red[i].y * (125);
                    graphics2D.setPaint(Color.WHITE);
                    if(game.Red[i].King){
                        graphics2D.setPaint(new Color(218,165,32));
                    }
                    graphics2D.fillOval(x, y, 60, 60);
                    graphics2D.setPaint(new Color(40, 40, 40));
                    graphics2D.fillOval(x + 3, y + 3, 54, 54);
                }
            }
    }
}
