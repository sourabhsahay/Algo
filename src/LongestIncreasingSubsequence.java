import java.util.List;

public class LongestIncreasingSubsequence {

    public int lis(final List<Integer> A) {


        int lis[] = new int[A.size()];
        int max = 1;

        for (int i = 0; i < A.size(); i ++)
        {
            lis[i] = 1;
        }

        for (int i = 0; i < A.size(); i++)
        {
            for(int j =0; j< i; j++)
            {
                if (A.get(i) > A.get(j) && lis[i] < lis[j] + 1)
                {
                    lis[i] = lis[j] + 1;
                    if (max < lis[i])
                    {
                        max = lis[i];
                    }
                }
            }
        }
        return max;

    }

    public int maxProfit(final List<Integer> A) {

        int max = 0;
        for (int i = 0 ; i< A.size(); i ++)
        {
            for (int j= 0; j < i; j++)
            {

                if (A.get(i) - A.get(j) > max)
                {
                    max = A.get(i) - A.get(j);
                }
            }
        }
        return max;

    }


}
