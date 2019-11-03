import java.lang.reflect.Array;
import java.util.*;

public class CombinationSum {

    public ArrayList<ArrayList<Integer>> combinationSum(ArrayList<Integer> A, int B) {

        ArrayList<ArrayList<Integer>> results = new ArrayList<ArrayList<Integer>>();
        List<Integer> singleResult = new ArrayList<Integer>();

        Set<Integer> set = new HashSet<Integer>(A);
        A.clear();
        A.addAll(set);

        Collections.sort(A);


        findNumbers(A, B, results, singleResult, 0);
        return results;

    }

    void findNumbers(ArrayList<Integer> A, int B ,ArrayList<ArrayList<Integer>> results, List<Integer> singleResult, int position)
    {
        if (B == 0)
        {
            ArrayList BList = new ArrayList(singleResult.size());
            for (Integer value: singleResult) {
                BList.add(new Integer(value));
            }
            if (!results.contains(BList))
            results.add(BList);
        }

        if (B < 0)
        {
            return;
        }

        while (position < A.size() && (B - A.get(position) >=0))
        {
            singleResult.add(A.get(position));
            findNumbers(A, B - A.get(position), results, singleResult, position);
            position++;
            singleResult.remove(singleResult.size() -1);
        }
    }

    public static void main (String args[])
    {
        int [] A  = new int[] {2,3,5};
        CombinationSum sum = new CombinationSum();
        // sum.combinationSum(A, 8);
    }

}
