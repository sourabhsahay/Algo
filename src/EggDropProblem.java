public class EggDropProblem {

    /* Function to get minimum number of
    trials needed in worst case with n
    eggs and k floors */
    static int eggDrop(int n, int k)
    {
        int eggFloor[][] = new int[n+1][k+1];
        int res;

        for (int i = 1; i <= n; i ++)
        {
            eggFloor[i][1] =1;
            eggFloor[i][0] =0;
        }

        for (int i = 1; i <=k; i ++)
        {
            eggFloor[1][k] =1;
        }

        for (int i = 2; i <= n; i ++)
        {
            for (int j = 2; j <=k; j ++)
            {
                eggFloor[i][j] = Integer.MAX_VALUE;

                for (int x = 1; x <= k;  x++)
                {
                    res = 1 + Math.max( eggFloor[i-1] [x-1], eggFloor[i][k-x]);
                    if (res < eggFloor[i][j])
                    {
                        eggFloor[i][j] = res;
                    }
                }
            }
        }

        return eggFloor[n][k];

    }
    }
