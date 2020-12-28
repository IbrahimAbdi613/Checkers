package Checkers.Backend;

import java.awt.Canvas;

import Checkers.Gui.Window;

public class Game extends Canvas implements Runnable {
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    Board board;
    checkerPiece[] White;
    checkerPiece[] Red;
    public static final int WIDTH = 900, HEIGHT = 900;

    public Game(int dimension) {
        new Window(WIDTH, HEIGHT, "Checker", this);
        board = new Board(dimension);
        White = new checkerPiece[12];
        Red = new checkerPiece[12];
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
            White[i] = new checkerPiece(x, 7 - y, "White");
            Red[i] = new checkerPiece(x2, y, "Red");
            x = x + 2;
            x2 = x2 + 2;
        }
    }

    public void printGame() {
        System.out.println("White");
        for (checkerPiece checkerPiece : White) {
            System.out.println("The X value is " + checkerPiece.x + " and the y value is " + checkerPiece.y
                    + " the colour is " + checkerPiece.colour);
        }
        System.out.println("\n\nRed");
        for (checkerPiece checkerPiece : Red) {
            System.out.println("The X value is " + checkerPiece.x + " and the y value is " + checkerPiece.y
                    + " the colour is " + checkerPiece.colour);
        }

        System.out.println("\n\nThis is the board");
        board.printBoard();

    }

    @Override
    public void run() {
        // TODO Auto-generated method stub

    }

    public synchronized void start() {

    }

    public static void main(String[] args) {
        Game game = new Game(8);
        System.out.println(game.White[8].moveRight(game));
        System.out.println(game.White[8].moveRight(game));
        System.out.println(game.White[8].moveRight(game));
        game.printGame();

    }
}
