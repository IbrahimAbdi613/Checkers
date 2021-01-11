package Checkers.Backend;

public class Player {
    public String name;
    public int Points;
    public int Kings;
    public Game game;
    public CheckerPiece [] checkerPieces;

    public Player(String name,Game game, String Colour){
        this.name = name;
        this.Points = 0;
        this.Kings = 0;
        this.game = game;
        if(Colour == "Red"){
            this.checkerPieces = game.Red;
        }
        else if(Colour == "Black"){
            this.checkerPieces = game.Black;
        }
    }

    public void CountScore(){
        int points = 0;
        for(int i = 0; i < checkerPieces.length; i++){
            if(checkerPieces[i].x > -1)
                points ++;
        }
        this.Points = points;
    }
    public void CountKings(){
        int Kings = 0;
        for(int i = 0; i < checkerPieces.length; i++){
            if(checkerPieces[i].King)
                Kings ++;
        }
        this.Kings = Kings;
    }

    public void ToString(){
        System.out.println("The Player's name is " + this.name + " and has " + this.Points + " Pieces and " + this.Kings + " many Kings.");
    }


}
