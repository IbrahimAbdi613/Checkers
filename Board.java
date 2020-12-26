public class Board {

    int[][] Board;
    
    public Board(int dimension) {
        Board = new int[dimension][dimension];
        for (int i = 0; i < Board.length; i++) {
            int col = 0;
            if (i > 0 && Board[i - 1][Board.length - 1] == 1)
                col++;
            for (int j = 0; j < Board.length; j++) {
                if (((col + 1) % 2) == 0) 
                    Board[i][j] = 1;
                 else
                     Board[i][j] = 0;
                col++;
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
