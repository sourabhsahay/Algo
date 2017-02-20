/**
 * Created by vishwasourabh.sahay on 03/12/16.
 */
public class LongestCommonSubsequence {

    public static void main (String args[])
    {
        String string1 = "AGGTAB";
        String string2 = "GXTXAYB";
        System.out.println("Longest common subsequence length is " + lcm(string1,string2,string1.length(),string2.length()));
    }

    static int lcm(String string1, String string2, int m, int n )
    {
        int [][] dp = new int[m+1][n+1];
        for(int i = 0; i<= m ; i ++)
        {
            for(int j = 0 ;j <=n ; j ++)
            {
                if(string1.length() ==0 || string2.length()==0)
                {
                   dp[i][j]=0;
                }
                if(string1.charAt(i-1)== string2.charAt(j-1))
                {
                    dp[i][j]= dp[i-1][j-1];
                }
                else
                {
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        return dp[m][n];

    }
}
