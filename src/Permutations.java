import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Permutations {

    public static void main (String args[])
    {
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        arrayList.add(0);
        arrayList.add(0);
        arrayList.add(1);
        arrayList.add(9);
        arrayList.add(0);
        System.out.println(permute(arrayList));
    }
    /*public  static List<List<Integer>>  permute(int[] nums) {

        List<List<Integer>> permutations = new ArrayList<List<Integer>>();

        permute (nums, 0, nums.length -1, permutations);
       // return permutations;
    }*/

    public static ArrayList<ArrayList<Integer>> permute(ArrayList<Integer> A) {
        ArrayList<ArrayList<Integer>> permutations = new ArrayList<ArrayList<Integer>>();

        permute (A, 0, A.size() -1, permutations);
        return permutations;
    }

    static void  permute(ArrayList<Integer> A, int left, int right, ArrayList<ArrayList<Integer>> permutations) {


        if (left == right) {

            ArrayList<Integer> copy = new ArrayList<Integer>(A.size());

            for (Integer value: A) {
                copy.add(new Integer(value));
            }
            if (!permutations.contains(copy))
            permutations.add(copy);

        }

        for (int i = left ; i <= right; i++)
        {
            int temp = A.get(i);
            A.set(i, A.get(left));
            A.set(left, temp);
            permute (A, left+ 1, right, permutations);
            temp =A.get(i);
            A.set(i, A.get(left));
            A.set(left, temp);

        }


    }

    static class  IntHolder {
        int value = 0;

        IntHolder(int value)
        {
            this.value= value;
        }

         static void swap(IntHolder a, IntHolder b) {

            int temp = a.value;
            a.value = b.value;
            b.value = temp;
        }
    }
}
