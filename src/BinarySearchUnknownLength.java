public class BinarySearchUnknownLength {

    int binarySearch (int [] values, int k)
    {
        int p = 0;
        while (true)
        {
            int index = (1 << p) -1;
            try
            {
                if (values[index] == k)
                {
                    return index;
                }
                else if (values[index] > k)
                    break;
            }
            catch (Exception e)
            {
                break;
            }
            p++;
        }

        int left = Math.max(0, 1<< p-1);
        int right = (1 <<p ) -2;
        while (left <= right)
        {
            int mid = (right -left)/2;
            try
            {
                if (values[mid] == k)
                {
                    return mid;
                }
                else if (values[mid] > k)
                {
                    right = mid -1;
                }
                else
                {
                    left = mid + 1;
                }
            }
            catch (Exception e)
            {
                right = mid -1;
            }
        }
        return -1;

    }
}
