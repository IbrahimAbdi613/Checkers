package Checkers.Backend;

import Checkers.Gui.MyPanel;
import java.util.ArrayList;

public class CheckerPiece {
    public int x;
    public int y;
    public String colour;
    public Boolean King;

    public CheckerPiece(int x, int y, String colour, boolean king) {
        this.x = x;
        this.y = y;
        this.colour = colour;
        King = king;
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
                    this.isKing();
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
                    this.isKing();
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
                    this.isKing();
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
                    this.isKing();
                }
                return 1;
            }
        }
        return 0;
    }

    public void removeOpponents(Game game,MyPanel myPanel) {
        game.CoordinatesForKills = new ArrayList<>();
        removeOpponents(game,myPanel,this);
    }

    private int removeOpponents(Game game, MyPanel myPanel, CheckerPiece checkerPiece) {
        int flag = myPanel.ShowPathFlag;
        CheckerPiece cloneRight;
        CheckerPiece cloneLeft;
        CheckerPiece cloneBackRight;
        CheckerPiece cloneBackLeft;

        if (checkerPiece.colour == "Red") {
            int counter = 0;
            cloneRight = new CheckerPiece(checkerPiece.x + 1, checkerPiece.y + 1, checkerPiece.colour,checkerPiece.King);
            cloneLeft = new CheckerPiece(checkerPiece.x - 1, checkerPiece.y + 1, checkerPiece.colour,checkerPiece.King);
            cloneBackRight = new CheckerPiece(checkerPiece.x + 1, checkerPiece.y - 1, checkerPiece.colour,checkerPiece.King);
            cloneBackLeft = new CheckerPiece(checkerPiece.x  - 1, checkerPiece.y - 1, checkerPiece.colour,checkerPiece.King);
            myPanel.ShowPathFlag = 2;
            if (checkerPiece.moveLeft(game, myPanel) == 0) {
                myPanel.ShowPathFlag = 1;
                for (int i = 0; i < game.Black.length; i++) {
                    if (cloneLeft.x == game.Black[i].x && cloneLeft.y == game.Black[i].y) {
                        if (cloneLeft.moveLeft(game, myPanel) == 1) {
                            game.CoordinatesForKills.add(cloneLeft.x);
                            game.CoordinatesForKills.add(cloneLeft.y);
                            counter = counter + 2;
                            if(myPanel.remove == 1){
                                game.Black[i].x = -4;;
                                if(cloneLeft.x == myPanel.window.ComponentClickedX && cloneLeft.y == myPanel.window.ComponentClickedY){
                                    this.x = cloneLeft.x;
                                    this.y = cloneLeft.y;
                                    this.isKing();
                                    return 0;
                                }
                            }
                        }
                    }
                }
                myPanel.ShowPathFlag = 2;
            }
            myPanel.ShowPathFlag = 2;
            if (checkerPiece.moveRight(game, myPanel) == 0) {
                myPanel.ShowPathFlag = 1;
                for (int i = 0; i < game.Black.length; i++) {
                    if (cloneRight.x == game.Black[i].x && cloneRight.y == game.Black[i].y) {
                        if (cloneRight.moveRight(game, myPanel) == 1) {
                            game.CoordinatesForKills.add(cloneRight.x);
                            game.CoordinatesForKills.add(cloneRight.y);
                            counter ++;
                            if(myPanel.remove == 1){
                                game.Black[i].x = -4;
                                if(cloneRight.x == myPanel.window.ComponentClickedX && cloneRight.y == myPanel.window.ComponentClickedY){
                                    this.x = cloneRight.x;
                                    this.y = cloneRight.y;
                                    this.isKing();
                                    return 0;
                                }
                            }
                        }
                    }
                }
            }
            myPanel.ShowPathFlag = 2;
            if (checkerPiece.King && checkerPiece.KingMoveBackRight(game, myPanel) == 0) {
                myPanel.ShowPathFlag = 1;
                for (int i = 0; i < game.Black.length; i++) {
                    if (cloneBackRight.x == game.Black[i].x && cloneBackRight.y == game.Black[i].y) {
                        if (cloneBackRight.KingMoveBackRight(game, myPanel) == 1) {
                            game.CoordinatesForKills.add(cloneBackRight.x);
                            game.CoordinatesForKills.add(cloneBackRight.y);
                            counter ++;
                            if(myPanel.remove == 1){
                                game.Black[i].x = -4;
                                if(cloneBackRight.x == myPanel.window.ComponentClickedX && cloneBackRight.y == myPanel.window.ComponentClickedY){
                                    this.x = cloneBackRight.x;
                                    this.y = cloneBackRight.y;
                                    return 0;
                                }
                            }
                        }
                    }
                }
            }
            myPanel.ShowPathFlag = 2;
            if (checkerPiece.King && checkerPiece.KingMoveBackLeft(game, myPanel) == 0) {
                myPanel.ShowPathFlag = 1;
                for (int i = 0; i < game.Black.length; i++) {
                    if (cloneBackLeft.x == game.Black[i].x && cloneBackLeft.y == game.Black[i].y) {
                        if (cloneBackLeft.KingMoveBackLeft(game, myPanel) == 1) {
                            game.CoordinatesForKills.add(cloneBackLeft.x);
                            game.CoordinatesForKills.add(cloneBackLeft.y);
                            counter ++;
                            if(myPanel.remove == 1){
                                game.Black[i].x = -4;
                                if(cloneBackLeft.x == myPanel.window.ComponentClickedX && cloneBackLeft.y == myPanel.window.ComponentClickedY){
                                    this.x = cloneBackLeft.x;
                                    this.y = cloneBackLeft.y;
                                    return 0;
                                }
                            }
                        }
                    }
                }
            }
            myPanel.ShowPathFlag = flag;
            if(counter == 0){
                return 0;
            }
            else if(counter == 2){
                return removeOpponents(game,myPanel,cloneLeft);
            }
            else if(counter == 1){
                return removeOpponents(game,myPanel,cloneRight);
            }
            else{
                return removeOpponents(game,myPanel,cloneLeft) + removeOpponents(game,myPanel,cloneRight);
            }
        }

       else{
            int counter = 0;
            cloneRight = new CheckerPiece(checkerPiece.x + 1,checkerPiece.y - 1,checkerPiece.colour, checkerPiece.King);
            cloneLeft = new CheckerPiece(checkerPiece.x - 1 ,checkerPiece.y - 1,checkerPiece.colour, checkerPiece.King);
            cloneBackRight = new CheckerPiece(checkerPiece.x + 1, checkerPiece.y + 1, checkerPiece.colour,checkerPiece.King);
            cloneBackLeft = new CheckerPiece(checkerPiece.x  - 1, checkerPiece.y + 1, checkerPiece.colour,checkerPiece.King);
            myPanel.ShowPathFlag = 2;
            if (this.moveLeft(game, myPanel) == 0) {
                myPanel.ShowPathFlag = 1;
                for (int i = 0; i < game.Red.length; i++) {
                    if (cloneLeft.x == game.Red[i].x && cloneLeft.y == game.Red[i].y) {
                        if (cloneLeft.moveLeft(game,myPanel) == 1){
                            game.CoordinatesForKills.add(cloneLeft.x);
                            game.CoordinatesForKills.add(cloneLeft.y);
                            counter = counter + 2;
                            if(myPanel.remove == 1){
                                game.Red[i].x = -4;
                                if(cloneLeft.x == myPanel.window.ComponentClickedX && cloneLeft.y == myPanel.window.ComponentClickedY){
                                    this.x = cloneLeft.x;
                                    this.y = cloneLeft.y;
                                    this.isKing();
                                    return 0;
                                }
                            }
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
                            counter ++;
                            if(myPanel.remove == 1){
                                game.Red[i].x = -4;
                                if(cloneRight.x == myPanel.window.ComponentClickedX && cloneRight.y == myPanel.window.ComponentClickedY){
                                    this.x = cloneRight.x;
                                    this.y = cloneRight.y;
                                    this.isKing();
                                    return 0;
                                }
                            }
                        }
                    }
                }
            }
            myPanel.ShowPathFlag = 2;
            if (checkerPiece.King && checkerPiece.KingMoveBackRight(game, myPanel) == 0) {
                myPanel.ShowPathFlag = 1;
                for (int i = 0; i < game.Red.length; i++) {
                    if (cloneBackRight.x == game.Red[i].x && cloneBackRight.y == game.Red[i].y) {
                        if (cloneBackRight.KingMoveBackRight(game, myPanel) == 1) {
                            game.CoordinatesForKills.add(cloneBackRight.x);
                            game.CoordinatesForKills.add(cloneBackRight.y);
                            counter ++;
                            if(myPanel.remove == 1){
                                game.Red[i].x = -4;
                                if(cloneBackRight.x == myPanel.window.ComponentClickedX && cloneBackRight.y == myPanel.window.ComponentClickedY){
                                    this.x = cloneBackRight.x;
                                    this.y = cloneBackRight.y;
                                    return 0;
                                }
                            }
                        }
                    }
                }
            }
            myPanel.ShowPathFlag = 2;
            if (checkerPiece.King && checkerPiece.KingMoveBackLeft(game, myPanel) == 0) {
                myPanel.ShowPathFlag = 1;
                for (int i = 0; i < game.Red.length; i++) {
                    if (cloneBackLeft.x == game.Red[i].x && cloneBackLeft.y == game.Red[i].y) {
                        if (cloneBackLeft.KingMoveBackLeft(game, myPanel) == 1) {
                            game.CoordinatesForKills.add(cloneBackLeft.x);
                            game.CoordinatesForKills.add(cloneBackLeft.y);
                            counter ++;
                            if(myPanel.remove == 1){
                                game.Red[i].x = -4;
                                if(cloneBackLeft.x == myPanel.window.ComponentClickedX && cloneBackLeft.y == myPanel.window.ComponentClickedY){
                                    this.x = cloneBackLeft.x;
                                    this.y = cloneBackLeft.y;
                                    return 0;
                                }
                            }
                        }
                    }
                }
            }
            myPanel.ShowPathFlag = flag;
            if(counter == 0){
                return 0;
            }
            else if(counter == 2){
                return removeOpponents(game,myPanel,cloneLeft);
            }
            else if(counter == 1){
                return removeOpponents(game,myPanel,cloneRight);
            }
            else{
                return removeOpponents(game,myPanel,cloneLeft) + removeOpponents(game,myPanel,cloneRight);
            }
        }
    }

    public int KingMoveBackLeft(Game game, MyPanel myPanel) {
        if (this.King) {
            if (this.colour == "Black") {
                if ((x - 1 > -1) && (y + 1) < (game.board.Dimension)) {
                    for (int i = 0; i < game.Black.length; i++) {
                        if ((game.Black[i].x == this.x - 1 && game.Black[i].y == this.y + 1) || (game.Red[i].x == this.x - 1 && game.Red[i].y == this.y + 1)) {
                            return 0;
                        }
                    }
                    if (myPanel.ShowPathFlag == 1) {
                        x--;
                        y++;
                    }

                    return 1;
                }
            }
            if (this.colour.equals("Red")) {
                if ((x - 1 > -1) && (y - 1 > -1)) {
                    for (int i = 0; i < game.Black.length; i++) {
                        if ((game.Black[i].x == this.x - 1 && game.Black[i].y == this.y - 1) || (game.Red[i].x == this.x - 1 && game.Red[i].y == this.y - 1)) {
                            return 0;
                        }
                    }
                    if (myPanel.ShowPathFlag == 1) {
                        x--;
                        y--;
                    }
                    return 1;
                }
            }
            return 0;
        }
        return 0;
    }

    public int KingMoveBackRight(Game game, MyPanel  myPanel) {
        if(this.King){
            if (this.colour == "Black") {
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
                    return 1;
                }
            }
            if (this.colour == "Red") {
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
                    return 1;
                }
            }
            return 0;
        }
        return 0;
    }

    public void isKing(){
        if(this.colour == "Red"){
            if (this.y == 7)
                this.King = true;
        }
        else{
            if(this.y == 0)
                this.King = true;
        }
    }

    public void ToString(){
        System.out.println("This Checker Piece has a X coordinate of  " + this .x
                            +  " and a Y coordinate of " + this.y + " ,the Colour of it is " + this.colour + " and the king value is " + this.King);
    }

}
