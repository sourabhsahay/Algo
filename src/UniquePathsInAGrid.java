import java.util.ArrayList;

public class UniquePathsInAGrid {

        public int uniquePathsWithObstacles(ArrayList<ArrayList<Integer>> A) {

            if(A.size() == 0)return 0;
            Integer paths [][] = new Integer [A.size()][A.get(0).size()];

            for (int i = 0; i < paths.length; i ++ )
            {
                 for (int j = 0; j < paths[i].length; j++)
                 {
                     paths[i][j]= 0;
                 }
            }

            if (A.get(0).get(0)==1)
            {
                paths[0][0]= 0;
            }
            else
            {
                paths[0][0]= 1;
            }

            for (int i = 1; i < paths.length; i ++)
            {
                if (A.get(0).get(i)== 0)
                {
                    paths[0][i] = paths[0][i-1];
                }
            }

            if (A.size() > 1) {
                for (int i = 1; i < paths[0].length; i++) {
                    if (A.get(i).get(0) == 0) {
                        paths[i][0] = paths[i - 1][0];
                    }
                }
            }

            for (int i = 1; i < paths.length; i ++)
            {
                for ( int j = 1; A.size() > 1 && j < paths[i].length; j++)
                {
                    if (A.get(i).get(0)== 0)
                    paths[i][j] = paths[i][j-1] + paths[i-1][j];
                }
            }

            return paths[A.size()-1][A.size()-1];

        }

    public int numDecodings(String str) {
            int n  = str.length();
        if (str ==null || n == 0)
        {
            return 0;
        }
        int dp [] = new int[n+1];

        dp[0] = 1;
        if (str.charAt(0) != '0')
        {
            dp[1] =1;
        }

        for (int i = 2; i < n; i++)
        {
            int first = Integer.parseInt(str.substring(i-1, i));
            int second = Integer.parseInt(str.substring(i-2, i));

            if (first >= 1 && first <=9)
            {
                dp[i]+=dp[i-1];
            }

            if (second >=10 && second <=26)
            {
                dp[i]+= dp[i-2];
            }
        }

        return dp[n];

    }

    public int isMatch(final String A, final String B) {

            boolean[][] dp = new boolean[A.length()][B.length()];
            dp[0][0]= true;

            for (int i = 1; i <= B.length(); i ++ )
            {
                if(B.charAt(i-1)=='*')
                    dp[0][i]=true;
                else
                    break;
            }

            for (int i = 1; i <= A.length(); i ++)
            {
                for (int j = 1; j <= B.length(); j++)
                {

                    if (B.charAt(j-1)=='?' || A.charAt(i-1)==B.charAt(j-1))
                    {
                       dp[i][j] = dp[i-1][j-1];
                    }
                    else
                    if (B.charAt(j)=='*') {
                        dp[i][j]=dp[i-1][j-1] || dp[i-1][j] || dp[i][j-1];

                    }
                }
            }

            return dp[A.length()][B.length()]? 1: 0;


    }





}
