package Checkers.Backend;

import Checkers.Gui.MyPanel;

import java.util.ArrayList;

public class CheckerPiece {
    public int x;
    public int y;
    public String colour;
    public Boolean King;

    public CheckerPiece(int x, int y, String colour) {
        this.x = x;
        this.y = y;
        this.colour = colour;
        King = false;
    }

    public int moveRight(Game game, MyPanel myPanel) {
        if (this.colour == "Red") {
            if ((x + 1) < (game.board.Dimension) && (y + 1) < (game.board.Dimension)) {
                for (int i = 0; i < game.Black.length; i++) {
                    if((game.Black[i].x == this.x + 1 && game.Black[i].y == this.y + 1) || (game.Red[i].x == this.x + 1 && game.Red[i].y == this.y + 1)){
                        return 0;
                    }
                }
                if(myPanel.ShowPathFlag == 1){
                    x++;
                    y++;
                }

                if (this.y == game.board.Dimension - 1) {
                    this.King = true;
                }
                return 1;
            }
        }
        if (this.colour == "Black") {
            if ((x + 1) < (game.board.Dimension) && (y - 1) > -1) {
                for (int i = 0; i < game.Black.length; i++) {
                    if((game.Black[i].x == this.x + 1 && game.Black[i].y == this.y - 1) ||(game.Red[i].x == this.x + 1 && game.Red[i].y == this.y - 1)){
                        return 0;
                    }
                }
                if(myPanel.ShowPathFlag == 1) {
                    x++;
                    y--;
                }
                if (this.y == 0) {
                    this.King = true;
                }
                return 1;
            }
        }
        return 0;
    }

    public int moveLeft(Game game , MyPanel myPanel) {
        if (this.colour == "Red") {
            if ((x - 1 > -1 ) && (y + 1) < (game.board.Dimension)) {
                for (int i = 0; i < game.Black.length; i++) {
                 if((game.Black[i].x == this.x - 1 && game.Black[i].y == this.y + 1) ||(game.Red[i].x == this.x - 1 && game.Red[i].y == this.y + 1)){
                     return 0;
                 }
                }
                if(myPanel.ShowPathFlag == 1) {
                    x--;
                    y++;
                }
                if (this.y == game.board.Dimension - 1) {
                    this.King = true;
                }
                return 1;
            }
        }
        if (this.colour.equals( "Black")) {
            if ((x - 1 > -1) && (y - 1 > -1)) {
                for (int i = 0; i < game.Black.length; i++) {
                    if((game.Black[i].x == this.x - 1 && game.Black[i].y == this.y - 1) ||(game.Red[i].x == this.x - 1 && game.Red[i].y == this.y - 1)){
                        return 0;
                    }
                }
                if(myPanel.ShowPathFlag == 1) {
                    x--;
                    y--;
                }
                if (this.y == 0) {
                    this.King = true;
                }
                return 1;
            }
        }
        return 0;
    }

    public void removeOpponents(Game game, MyPanel myPanel) {
        int flag = myPanel.ShowPathFlag;
        CheckerPiece cloneRight;
        CheckerPiece cloneLeft;
        if (this.colour == "Red") {
            cloneRight = new CheckerPiece(this.x + 1, this.y + 1, this.colour);
            cloneLeft = new CheckerPiece(this.x - 1, this.y + 1, this.colour);
            game.CoordinatesForKills = new ArrayList<>();
            myPanel.ShowPathFlag = 2;
            if (this.moveLeft(game, myPanel) == 0) {
                myPanel.ShowPathFlag = 1;
                for (int i = 0; i < game.Black.length; i++) {
                    if (cloneLeft.x == game.Black[i].x && cloneLeft.y == game.Black[i].y) {
                        if (cloneLeft.moveLeft(game, myPanel) == 1) {
                            game.CoordinatesForKills.add(cloneLeft.x);
                            game.CoordinatesForKills.add(cloneLeft.y);
                        }
                    }
                }
                myPanel.ShowPathFlag = 2;
            }
            myPanel.ShowPathFlag = 2;
            if (this.moveRight(game, myPanel) == 0) {
                myPanel.ShowPathFlag = 1;
                for (int i = 0; i < game.Black.length; i++) {
                    if (cloneRight.x == game.Black[i].x && cloneRight.y == game.Black[i].y) {
                        if (cloneRight.moveRight(game, myPanel) == 1) {
                            game.CoordinatesForKills.add(cloneRight.x);
                            game.CoordinatesForKills.add(cloneRight.y);
                        }
                    }
                }
                myPanel.ShowPathFlag = 2;
            }
        }

        else if(this.colour == "Black") {
            game.CoordinatesForKills = new ArrayList<>();
            cloneRight = new CheckerPiece(this.x + 1,this.y - 1,this.colour);
            cloneLeft = new CheckerPiece(this.x - 1 ,this.y - 1,this.colour);
            myPanel.ShowPathFlag = 2;
            if (this.moveLeft(game, myPanel) == 0) {
                myPanel.ShowPathFlag = 1;
                for (int i = 0; i < game.Red.length; i++) {
                    if (cloneLeft.x == game.Red[i].x && cloneLeft.y == game.Red[i].y) {
                        if (cloneLeft.moveLeft(game,myPanel) == 1){
                            game.CoordinatesForKills.add(cloneLeft.x);
                            game.CoordinatesForKills.add(cloneLeft.y);

                        }
                    }
                }
                myPanel.ShowPathFlag = 2;
            }
            myPanel.ShowPathFlag = 2;
            if (this.moveRight(game, myPanel) == 0) {
                myPanel.ShowPathFlag = 1;
                for (int i = 0; i < game.Red.length; i++) {
                    if (cloneRight.x == game.Red[i].x && cloneRight.y == game.Red[i].y) {
                        if (cloneRight.moveRight(game,myPanel) == 1){
                            game.CoordinatesForKills.add(cloneRight.x);
                            game.CoordinatesForKills.add(cloneRight.y);
                        }
                    }
                }
                myPanel.ShowPathFlag = 1;
            }
        }
        myPanel.ShowPathFlag = flag;

    }

    public void ToString(){
        System.out.println("This Checker Piece has a X coordinate of  " + this .x
                            +  " and a Y coordinate of " + this.y + " ,the Colour of it is " + this.colour + " and the king value is " + this.King);
    }

}
