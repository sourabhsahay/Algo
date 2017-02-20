package interviewBit.arrays;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by vishwasourabh.sahay on 15/01/17.
 */
public class AddOneToNumber {
    public static void main (String args [])
    {
        ArrayList arrayList = new ArrayList();
        arrayList.add(1);
        arrayList.add(3);
        arrayList.add(-1);
        System.out.println(maxArr(arrayList));

    }

    public ArrayList<Integer> plusOne(ArrayList<Integer> A) {
        ArrayList<Integer> result = new ArrayList<>(A);
        int carry = 1;
        int len = A.size();
            for( int i = len -1; i  >= 0; i--)
            {
                if (carry ==0)
                {
                    break;
                }

                int currentSum = carry + A.get(i);
                if(currentSum > 0) {
                    result.set(i, currentSum % 10);
                    carry = currentSum / 10;
                }
                else
                {
                    result.set(i,currentSum);
                    carry = 0;
                }
            }
            if(carry != 0)
            {
                result.add(0,1);
            }
            int index = 0;
        while (index < result.size() && result.get(index)==0)
        {
            result.remove(index);
        }
        return result;
    }


    public static int maxArr(ArrayList<Integer> A) {
        int n=A.size(),max1=A.get(0),max2=A.get(0), min1=A.get(0),min2=A.get(0),ans=0;

        for(int i=0;i<n; i++){
            max1=Math.max(max1, A.get(i)+i);
            max2=Math.max(max2, A.get(i)-i);
            min1=Math.min(min1,  A.get(i)+i);
            min2=Math.min(min2, A.get(i)-i);
        }

        ans = Math.max(ans, (max2 - min2));
        ans = Math.max(ans, (max1 - min1));

        return ans;
    }

}
