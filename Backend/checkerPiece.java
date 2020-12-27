package Checkers.Backend;

public class checkerPiece {
    int x;
    int y;
    String colour;
    Boolean King;

    public checkerPiece(int x, int y, String colour) {
        this.x = x;
        this.y = y;
        this.colour = colour;
        King = false;
    }

    public int moveRight(Game game) {
        if (this.colour == "Red") {
            if ((x + 1) < (game.board.Dimension) && (y + 1) < (game.board.Dimension)) {
                x++;
                y++;
                if (this.y == game.board.Dimension - 1) {
                    this.King = true;
                }
                return 1;
            }
        }
        if (this.colour == "White") {
            if ((x + 1) < (game.board.Dimension) && (y - 1) < (game.board.Dimension)) {
                x++;
                y--;
                if (this.y == 0) {
                    this.King = true;
                }
                return 1;
            }
        }

        return 0;

    }

    public int moveLeft(Game game) {
        if (this.colour == "Red") {
            if ((x - 1) < (game.board.Dimension - 1) && (y + 1) < (game.board.Dimension - 1)) {
                x--;
                y++;
                if (this.y == game.board.Dimension - 1) {
                    this.King = true;
                }
                return 1;
            }
        }
        if (this.colour == "White") {
            if ((x - 1) < (game.board.Dimension - 1) && (y - 1) < (game.board.Dimension - 1)) {
                x--;
                y--;
                if (this.y == 0) {
                    this.King = true;
                }
                return 1;
            }
        }
        return 0;
    }

}
