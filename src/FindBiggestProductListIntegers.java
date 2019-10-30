public class FindBiggestProductListIntegers {

    int findBiggestProduct (int [] values)
    {
        int negativeCount = 0;
        int leastNegativeIndex = -1 ;
        int maximumNegativeIndex = -1 ;
        int leastPositiveIndex = -1;

        for (int i = 0; i < values.length; i ++)
        {
            if (values[i] < 0)
            {
                negativeCount ++;
                if (leastNegativeIndex ==-1 || values[leastNegativeIndex] < values[i])
                {
                    leastNegativeIndex = i;
                }
                if (maximumNegativeIndex ==-1 || values[maximumNegativeIndex] > values[i])
                {
                    maximumNegativeIndex = i;
                }
            }
            else
            {
                if (leastPositiveIndex ==-1 || values[leastPositiveIndex] > values[i])
                {
                    leastPositiveIndex = i;
                }
            }
        }

        int indexToSkip = (negativeCount % 2!= 0) ? leastNegativeIndex : (leastPositiveIndex != -1 ? leastPositiveIndex : maximumNegativeIndex);
        int product  = 1;
        for (int i = 0; i < values.length; i ++)
        {
            if (i != indexToSkip)
                product *= values[i];
        }
        return product;

    }
}
