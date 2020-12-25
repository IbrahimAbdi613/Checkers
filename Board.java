public class Board {

    int[][] Board;
    
    public Board(int dimension) {
        Board = new int[dimension][dimension];
        for (int i = 0; i < Board.length; i++) {
            for (int j = 0; j < Board.length; j++) {
                if ((j % 2) == 0) {
                    Board[i][j] = 1;
                } else
                    Board[i][j] = 0;
            }
        }
    }

    public void printBoard() {
        for (int[] is : Board) {
            for (int i : is) {
                System.out.print(i);
            }
            System.out.println();
        }
    }
    
}
