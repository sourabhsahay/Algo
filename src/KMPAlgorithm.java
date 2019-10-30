public class KMPAlgorithm {

    static void KMPSearch(String pat, String txt)
    {
        int M = pat.length();
        int N = txt.length();

        int lps [] = new int[M];
        int j = 0;

        computeLPSArray(pat, M, lps);

        int i = 0;
        while (i < N)
        {
            if (pat.charAt(j)== txt.charAt(i))
            {
                i++;
                j++;
            }

            if (j == M)
            {

                System.out.print("Match found at " + (i - j));
                j = lps[j-1];
            }
            else if (i < N && pat.charAt(j)!= txt.charAt(i))
            {
                if (j!=0)
                {
                    j = lps[j-1];
                }
                else
                {
                    i++;
                }
            }



        }


    }

    static void computeLPSArray(String pat, int M, int lps[])
    {
        int length = 0;
        int i = 1;
        lps[0]= 0;
        if (pat.charAt(length) == pat.charAt(i))
        {
            length++;
            lps[i]= length;
            i++;
        }
        else
        {
            if (length!=0)
            {
                length  = lps[length - 1];
            }
            else
            {
                lps[i]= length;
                i++;
            }
        }
    }

    public static void main(String args[])
    {
        String txt = "ABABDABACDABABCABAB";
        String pat = "ABABCABAB";
        KMPSearch(pat, txt);
    }
}
