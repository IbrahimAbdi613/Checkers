package Checkers.Backend;

import Checkers.Gui.MyPanel;

public class checkerPiece {
    public int x;
    public int y;
    public String colour;
    public Boolean King;

    public checkerPiece(int x, int y, String colour) {
        this.x = x;
        this.y = y;
        this.colour = colour;
        King = false;
    }

    public int moveRight(Game game, MyPanel myPanel) {
        if (this.colour == "Red") {
            if ((x + 1) < (game.board.Dimension) && (y + 1) < (game.board.Dimension)) {
                for (int i = 0; i < game.Black.length; i++) {
                    if((game.Black[i].x == this.x + 1 && game.Black[i].y == this.y + 1) ||(game.Red[i].x == this.x + 1 && game.Red[i].y == this.y + 1)){
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

    public void ToString(){
        System.out.println("This Checker Piece has a X coordinate of  " + this .x
                            +  " and a Y coordinate of " + this.y + " ,the Colour of it is " + this.colour + " and the king value is " + this.King);
    }

}
