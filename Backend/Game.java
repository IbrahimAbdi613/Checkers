package Checkers.Backend;

import java.awt.Canvas;

import Checkers.Gui.Window;

public class Game extends Canvas implements Runnable {
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    public Board board;
    public checkerPiece[] Red;
    public checkerPiece[] Black;
    public static final int WIDTH = 1600, HEIGHT = 1040;


    public Game(int dimension) {
        board = new Board(dimension);
        Red = new checkerPiece[12];
        Black = new checkerPiece[12];
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
            Red[i] = new checkerPiece(x, 7 - y, "Black");
            Black[i] = new checkerPiece(x2, y, "Red");
            x = x + 2;
            x2 = x2 + 2;
        }
        new Window(WIDTH, HEIGHT, "Checkers (By Ibrahim Abdirahman)", this);

    }

    public void printGame() {
        System.out.println("Black");
        for (checkerPiece checkerPiece : Red) {
            System.out.println("The X value is " + checkerPiece.x + " and the y value is " + checkerPiece.y
                    + " the colour is " + checkerPiece.colour);
        }
        System.out.println("\n\nRed");
        for (checkerPiece checkerPiece : Black) {
            System.out.println("The X value is " + checkerPiece.x + " and the y value is " + checkerPiece.y
                    + " the colour is " + checkerPiece.colour);
        }

        System.out.println("\n\nThis is the board");
        board.printBoard();

    }


    public void run() {

    }

    public synchronized void start() {

    }

    public static void main(String[] args) {
        Game game = new Game(8);
        //game.printGame();

    }
}
