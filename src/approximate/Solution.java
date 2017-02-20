package approximate;

import java.util.ArrayList;

/**
 * Created by vishwasourabh.sahay on 11/01/17.
 */
public class Solution {
    // X and Y co-ordinates of the points in order.
    // Each point is represented by (X.get(i), Y.get(i))
    public int coverPoints(ArrayList<Integer> X, ArrayList<Integer> Y) {
        int size = X.size();
        int totalSteps = 0;
        for (int i = 1; i < X.size(); i ++)
        {
            int horizantalDistance = Math.abs(X.get(i) -X.get(i-1));
            int verticalDistance = Math.abs(Y.get(i) -Y.get(i-1));
            totalSteps +=  horizantalDistance > verticalDistance? horizantalDistance :verticalDistance;
        }
            return totalSteps;
    }

    public static void main (String args [])
    {
        ArrayList list = new ArrayList ();
        list.add(1);
        list.add(2);
        list.add(5);
        list.add(-7);
        list.add(2);
        list.add(5);
        Solution solution = new Solution();
        System.out.println (solution.maxset(list));

    }

    public ArrayList<Integer> maxset(ArrayList<Integer> a) {
        int s = a.size();
        int ans = a.get(0);
        int maximum = Integer.MIN_VALUE;
        int sumSoFar = 0 ;
        int startIndex = 0;
        int maxEndIndex = -1;
        int maxStartIndex = 0;

        for (int i = 0; i < a.size(); i ++)
        {
            sumSoFar =  sumSoFar + a.get(i);
            if (a.get(i)> sumSoFar)
            {
                sumSoFar = a.get(i);
                startIndex = i;

            }
            if(sumSoFar > maximum )
            {
                maximum = sumSoFar;
                maxStartIndex = startIndex;
                maxEndIndex = i;
            }
            if(sumSoFar ==maximum)
            {
                int maxIndexDiff = maxEndIndex - maxStartIndex + 1;
                int currentDiff = i - startIndex + 1;
                if(currentDiff >maxIndexDiff)
                {
                    maxStartIndex = startIndex;
                    maxEndIndex = i;
                }
            }

        }
        ArrayList<Integer> subArray = new ArrayList<Integer>();
        for(int i = maxStartIndex; i <=maxEndIndex; i ++)
        {
            subArray.add(a.get(i));
        }
        return subArray;
    }

}
