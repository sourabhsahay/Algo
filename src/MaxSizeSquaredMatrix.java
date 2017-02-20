/**
 * Created by vishwasourabh.sahay on 03/12/16.
 */
public class MaxSizeSquaredMatrix {
    public static void main (String args[])
    {

        int [][] array =  {
                {0, 1, 1, 0, 1},
                {1, 1, 0, 1, 0},
                {0, 1, 1, 1, 0},
                {1, 1, 1, 1, 0},
                {1, 1, 1, 1, 1},
                {0, 0, 0, 0, 0}};



        int size = maxSizeSubMatrix(array, array.length,array[0].length);
        System.out.println("Minimum size array is " +  size);
    }

    private static int maxSizeSubMatrix(int[][] array,  int m, int n) {
        int dp[][] = new int[m][n];

         int max = 1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0) {
                    dp[i][j] = array[i][j];
                } else if (j == 0)
                    dp[i][j] = array[i][j];

                else
                {
                     if(array[i][j]==1) {
                         dp[i][j] = 1 + min(dp[i - 1][j - 1], dp[i - 1][j], dp[i][j - 1]);
                         if (dp[i][j] > max) {
                             max = dp[i][j];
                         }
                     }
                     else
                     {
                         dp[i][j]=0;
                     }
                }

            }
        }
        return  max;
    }

    static int min(int x,int y,int z)
    {
        if (x < y && x <z) return x;
        if (y < x && y < z) return y;
        else return z;
    }
}
