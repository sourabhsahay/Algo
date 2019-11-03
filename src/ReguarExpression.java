public class ReguarExpression {

    public int isMatch(final String A, final String B) {
        if (B.isEmpty())
        {
             if (A.isEmpty()) {
                 return 1;
             }
            else
                return 0;
        }

        int dp[][] = new int [A.length()+ 1][B.length() + 1];
        dp[0][0] = 1;

        for (int i = 1; i <= B.length(); i ++ )
        {
            if(B.charAt(i-1)=='*')
                dp[0][i]=dp[0][i-2];
            else
                break;
        }

        for (int i = 1; i <= A.length(); i ++)
        {
            for (int j = 1; j <= B.length(); j++)
            {
                 if (A.charAt(i-1)== B.charAt(j-1) || B.charAt(i-1)=='.')
                 {
                     dp[i][j] = dp[i-1][j-1];

                 } else if (B.charAt(j-1)=='*' )
                 {
                     if (A.charAt(i-1)== B.charAt(i-2)  || B.charAt(j-2)=='.')
                     {
                         dp[i][j] = dp[i-1][j];
                     }
                     else {
                         dp[i][j] = dp[i][j - 2];
                     }
                 }
            }
        }
        return dp[A.length()][B.length()];
    }
}
