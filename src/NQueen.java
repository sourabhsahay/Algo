import java.util.ArrayList;
import java.util.List;

public class NQueen {


    public List<List<String>> solveNQueens(int n) {

        int[][] board = new int[n][n];
        List<List<String>> chessBoard = new ArrayList<>();

        solveNQueen(board, 0, chessBoard);


        return chessBoard;


    }

    private void addSolution( int[][] board, List<List<String>> chessBoard) {
        List<String> list = new ArrayList();
        for (int i = 0; i <board[0].length; i ++)

        {

            StringBuffer currentRow = new StringBuffer();
            for(int j = 0; j<board[0].length; j++)
            {

                 if(board[i][j]==1)
                 {
                     currentRow.append("Q");
                 }
                 else
                 {
                     currentRow.append (".")     ;
                 }


            }
            list.add(currentRow.toString());

        }
        chessBoard.add(list);
    }

    private boolean solveNQueen(int[][] board, int col,   List<List<String>> chessBoard) {
        boolean res = false;
        if(col==board[0].length)
        {
            addSolution (board, chessBoard);
            return true;
        }
         for (int i = 0; i < board[0].length; i++) {
             if (isSafe(board, i, col)) {
                 board[i][col] = 1;

                 res = solveNQueen(board, col + 1, chessBoard) || res;
                 board[i][col] = 0;
             }
         }

         return res;

    }

    boolean isSafe(int[][] board, int row, int column) {
        for (int i = 0; i < column; i++) {
            if (board[row][i] == 1) {
                return false;
            }
        }

        //Check for upper diagnoal
        for (int i = row, j = column; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 1) {
                return false;
            }

        }
        for (int i = row, j = column; j>= 0 && i<board[0].length; i++, j--) {

            if (board[i][j] == 1) {
                return false;
            }
        }
        return true;
    }

    public static void main (String args[])
    {
        NQueen nQueen = new NQueen();
        nQueen.solveNQueens(4);

    }
}

