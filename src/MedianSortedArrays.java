public class MedianSortedArrays {

    double medianOf2(int a, int b)
    {
        return (a+ b)/2;
    }

    double medianOf3 (int a, int b, int c)
    {
        return a + b + c  - Math.max( a , Math.max (b, c)) - Math.min(a, Math.min(b, c));
    }

    double medianOf4 (int a, int b, int c, int d )
    {
        int max =  Math.max(a, Math.max(b, Math.max(c, d)));
        int min =  Math.min(a, Math.min(b, Math.min(c, d)));
       return  (a + b + c + d - max - min)/2;
    }

    double medianSingleArray (int arr[])
    {
        if (arr.length == 0)
        {
            return - 1;
        }
        if (arr.length %2 == 0)
        {
            return (arr[arr.length /2] + arr[arr.length/2 -1]) /2;
        }
        return arr.length/2;
    }

    double findMedianTwoArraysUtil (int A[], int B[], int aSize, int bSize)
    {


        if(A.length == 0 && B.length == 0)
        {
            return - 1;

        }
        if (A.length == 0 && B.length != 0)
        {
            return medianSingleArray(B);
        }
        if (aSize == 1 )
        {
            if (bSize ==1)
            {
                return medianOf2(A[0], B[0]);
            }
            if (bSize %2 !=0)
            {
                return medianOf2(B[bSize/2], (int)medianOf3(A[0], B[bSize/2 -1], B[bSize/2 +1]));
            }
            else
            {
                // 1, 5, 10, 15
                // Case 1. 1, 5, 6, 10, 15
                // CASE, 1, 4, 5, 10, 15
                // CASE 3, 5, 10, 11, 15
                //
                return medianOf3(B[bSize/2], A[0], B[bSize/2 -1]);
            }


        }
        else if (aSize == 2)
        {
            // 1, 5, 10, 15, 20
            //CASE .
            if (bSize == 2)
            {
                return medianOf4(A[0], A[1], B[bSize/2], B[bSize/2 -1]);
            }
            else if (bSize % 2 != 0)
            {
                return medianOf3(B[bSize/2], Math.max(B[bSize/2 -1], A[0]), Math.min(B[bSize/2+ 1], A[1]));
            }
            else
            {
                //1, 5, 10, 15
                return medianOf4(B[bSize/2], B[bSize/2-1], Math.max(B[bSize/2 -2], A[0]), Math.min(B[bSize/2+ 1], A[1]));
            }
        }
        else
        {
            int indexA = (aSize -1)/2;
            int indexB = (bSize -1)/2;
            if (A[indexA] <= B[indexB])
            {
               // return findMedianTwoArraysUtil(A + indexA, aSize/2 +1, B , bSize - indexA );
            }
        }

         return -1;
    }
}
