import java.util.Stack;

public class LargestRectangleHistogram {

    static int getMaxArea(int hist[], int n)
    {
        Stack<Integer> s = new Stack<>();
        int max_area = 0;
        int top;
        int areawithTop;

        int i = 0;
        while (i < n)
        {
            if (s.empty() || hist[s.peek()]<= hist[i])
            {
                s.push(i++);
            }
            else
            {
                top  = s.peek();
                s.pop();
                areawithTop = hist[top] * (s.empty()? i : i - s.peek() - 1);
                if(max_area > areawithTop)
                    areawithTop = max_area;
            }
        }
        while (s.empty() == false)
        {
            top  = s.peek();
            s.pop();
            areawithTop = hist[top] * (s.empty() ? i : i - s.peek() - 1);
            if (max_area < areawithTop)
                max_area = areawithTop;
        }
         return max_area;
    }
    }
