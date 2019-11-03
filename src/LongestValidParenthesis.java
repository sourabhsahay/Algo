import java.util.Stack;

public class LongestValidParenthesis {

        public int longestValidParentheses(String s) {
            Stack <Integer> stack = new Stack<Integer>();
            int longestValid = 0;
            if (s ==null || s.length() ==0)
            {
                return 0;
            }
            stack.push (-1);

            for (int i = 0; i < s.length(); i++)
            {
                if (s.charAt(i)== '(')
                {
                    stack.push(i);
                }
                else
                {

                    if (s.charAt(i)==')')
                    {
                        int j  = stack.pop();
                        if (stack.empty())
                        {
                            stack.push(i);
                        }
                        else
                        {
                            longestValid = Math.max (longestValid, i -stack.peek()  );
                        }
                    }



                }   // -1

            }
            return longestValid;
        }

    public int longestValidParenthesesDP(String s) {
            /*
                Sol[i] = Sol[i-2] + 2
                sol[i] = Sol[i-1] + Sol[i -]

             */
            //Sol[0] = -1;
        //

            return 0;
    }



}
