import java.util.List;

public class MaxProfit {


    public int maxProfit(final List<Integer> A) {
        if (A.size()==0)
        {
            return 0;
        }
        int k = 2;
        int[][] profit = new int[k + 1][A.size() + 1];

        for (int i = 0; i <= k; i++) {
            profit[i][0] = 0;
        }

        for (int i = 0; i <= A.size(); i++) {
            profit[0][i] = 0;
        }

        for (int i = 1; i <=k; i++)
        {
            for (int j = 1; j <=A.size(); j++)

            {
                int max_so_far = 0;
                for (int m = 0; m <j ; m++ )
                {
                    profit[i][j] = Math.max(profit[i-1][m ]+ A.get(j) -
                            A.get(m), max_so_far);
                }

                profit[i][j] = Math.max(max_so_far, profit[i-1][j]);
            }

        }
        return profit[k][A.size()  - 1];

    }
}

