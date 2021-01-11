package Checkers.Backend;

import java.awt.Canvas;
import java.util.ArrayList;

import Checkers.Gui.LaunchPage;
import Checkers.Gui.MyPanel;
import Checkers.Gui.Window;

public class Game extends Canvas implements Runnable {
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    public Board board;
    public CheckerPiece[] Red;
    public CheckerPiece[] Black;
    public static final int WIDTH = 1600, HEIGHT = 1040;
    public ArrayList<Integer> CoordinatesForKills;
    public Player player1;
    public Player player2;




    public Game(int dimension, String player1Name, String player2Name ) {


        board = new Board(dimension);
        Red = new CheckerPiece[12];
        Black = new CheckerPiece[12];
        int x = 0;
        int x2 = 0;
        int y = -1;
        for (int i = 0; i < 12; i++) {
            if ((i % 4) == 0) {
                y++;
                if (board.Board[y][0] == 1) {
                    x = 0;
                    x2 = 1;
                } else {
                    x = 1;
                    x2 = 0;
                }
            }
            Red[i] = new CheckerPiece(x, y, "Red",false);
            Black[i] = new CheckerPiece(x2, 7- y, "Black",false);
            x = x + 2;
            x2 = x2 + 2;
        }

        player1 = new Player(player1Name,this,"Red");
        player2= new Player(player2Name,this,"Black");

        new Window(WIDTH, HEIGHT, "Checkers (By Ibrahim Abdirahman)", this);

    }

    public void printGame() {
        System.out.println("Black");
        for (CheckerPiece checkerPiece : Red) {
            checkerPiece.ToString();
        }
        System.out.println("\n\nRed");
        for (CheckerPiece checkerPiece : Black) {
            checkerPiece.ToString();
        }

        System.out.println("\n\nThis is the board");
        board.printBoard();

    }


    public void run() {

    }

    public synchronized void start() {

    }

    public static void main(String[] args) {
        new LaunchPage();

    }
}
