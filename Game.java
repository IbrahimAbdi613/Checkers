public class Game {
    Board board;
    checkerPiece[] White;
    checkerPiece[] Black;

    public Game(int dimension) {
        board = new Board(dimension);
        White = new checkerPiece[12];
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
                }
                else {
                    x = 1;
                    x2 = 0;
                }
            }
            White[i] = new checkerPiece(x, y, "White");
            Black[i] = new checkerPiece(x2, 7 - y, "Black");
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
        System.out.println("\n\nBlack");
        for (checkerPiece checkerPiece : Black) {
            System.out.println("The X value is " + checkerPiece.x + " and the y value is " + checkerPiece.y
                    + " the colour is " + checkerPiece.colour);
        }

        System.out.println("This is the board \n");
        board.printBoard();
    
    }


    public static void main(String[] args) {
        Game game = new Game(8);
        game.printGame();
        
    }
    
}
