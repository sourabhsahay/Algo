import java.util.List;

public class FindElementsOccuringOnce {

    /*
        All the remaining elements appear 3 times.
     */

    int findElementsOccurringOnce (List<Integer> values)
    {
        int count [] = new int [32];
       for (Integer value : values)
       {
           for (int i = 0; i < 32; i++)
           {
               if ((value.intValue() & (1 <<i))!=0 )
               {
                   ++count[i];
               }
           }
       }
       int result  = 0;
       for (int i = 0; i < 32; i ++)
       {
           result |= (count[i] % 3) * (i<<1);
       }
       return result;
    }
}
