public class RabinCarpAlgorithm {

    static void search(char pat[], char txt[], int q)
    {
        int M = pat.length;
        int N = txt.length;
        int i, j;
        int p = 0;
        int t = 0;
        int h = 1;
        int d = 256;

        for ( i = 0; i < M-1; i ++)
        {
           h = (h * d) % q;
        }

        for ( i = 0; i < M; i ++)
        {
            p = (d * p + pat[i]) % q;
            t = (d *t + txt[i])% q;
        }

        for (i = 0; i <= N - M; i++) {

            if (p == t) {
                for (j = 0; j < M; j++) {
                    if (txt[i + j] != pat[j])
                        break;
                }
                if (j == M) {
                    System.out.println("Pattern found at index " + i);
                }
            }
            if (i < N - M) {
                t = (d * (t - txt[i] * h) + txt[i + M]) % q;
                if (t < 0) {
                    t = t + q;
                }
            }
        }

    }

    public static void main (String args[])
    {
        char  txt[] = "GEEKS FOR GEEKS".toCharArray();
        char pat[] = "GEEK".toCharArray();
        int q = 101; // A prime number
        search(pat, txt, q);

    }
}
