public class Palindrome {

    static int longestPalSubstr(String str) {
        int length = str.length();
        boolean [][]table  = new boolean[length][length];
        int maxlength = 1;
        for (int i = 0; i < length; i++)
        {
            table[i][i] = true;
        }
        int start = 0;
        for (int i = 0; i < length - 1; i ++)
        {
            if (str.charAt(i)== str.charAt(i+1))
            {
                    table[i][i+1] = true;
                    start = i;
                    maxlength = 2;
            }

        }
        for (int k = 3; k <= length; k++)
        {
            for(int i = 0; i< length-k + 1; i++)
            {
                int j = i + k -1;
                if (table[i+1][j-1] && str.charAt(i) ==str.charAt(j))
                {
                    table[i][j] = true;
                    if (k> maxlength)
                    {
                        start = i;
                        maxlength = k;
                    }
                }
            }
        }
        return maxlength;

    }
    public static void main(String[] args) {

        String str = "forgeeksskeegfor";
        System.out.println("Length is: " +
                longestPalSubstr(str));
    }
}
