package string;

/**
 * Created by vishwasourabh.sahay on 17/01/17.
 */
public class KMPStringMatching {

    void computeLPSArray (String pattern, int patternSize, int lps[])
    {
        int len= 0;
        lps[0]= 0;
        int i = 1;

        while(i < patternSize)
        {
            if(pattern.charAt(i) == pattern.charAt(len))
            {
                len++;
                lps[i] = len;
                i ++;
            }
            else
            {
                if (len != 0)
                {
                    len = lps[len -1];
                }
                else
                {
                    lps[i] =0;
                    i ++;

                }
            }
        }
    }

    void KMPSearch (String pattern, String txt)
    {
        int M = pattern.length();
        int N = txt.length();

        int lps[] = new int[M];


        computeLPSArray(pattern, M, lps);
        int i = 0;
        int j = 0;
        while (i < N)
        {
            if (pattern.charAt(j) ==txt.charAt(i))
            {
                i ++;
                j ++;
            }
            if(j ==M)
            {
                System.out.println ("Found pattern at index " + (i -M));
                j = lps[j-1];
            }

            else if (i < N && pattern.charAt(j)!= txt.charAt(i))
            {
                if(j !=0)
                {
                    j = lps[j-1];
                }
                else
                {
                    i = i +1;
                }
            }
        }

    }

    public static void main(String args[])
    {
        String txt = "ABABDABACDABABCABAB";
        String pat = "ABABCABAB";
        new KMPStringMatching().KMPSearch(pat,txt);
    }
}
