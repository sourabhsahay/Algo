import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PostOrderTraversalWithoutRecursion {

    static class TreeNode
    {
        int value;
        TreeNode left, right;

    }

    static List<Integer> postOrderTraversal(TreeNode treeNode) {
        Stack<TreeNode> stack = new Stack<>();
        stack.push(treeNode);
        List<Integer> postOrderTraversal = new ArrayList<>();
        TreeNode previous = null;

        while (!stack.isEmpty())
        {
             TreeNode current = stack.peek();
            if (previous == null || previous.left == current || previous.right ==current)
            {
                if (current.left != null)
                {
                    stack.push(current.left);
                }
                else if (current.right != null)
                {
                    stack.push(current.right);
                }
                else
                {
                    // leaf node
                    postOrderTraversal.add(current.value);
                    stack.pop();
                }
            }
            else if (current.left == previous)
            {
                // Left traversal complete
                if (current.right != null)
                {
                    stack.push(current.right);
                }
                else
                {
                    postOrderTraversal.add(current.value);
                    stack.pop();
                }

            }
            else
            {
                postOrderTraversal.add(current.value);
                stack.pop();
            }
            previous = current;
        }
        return postOrderTraversal;
    }

     public static void main (String args [])
     {
         TreeNode root = new TreeNode();
         root.value = 1;
         TreeNode left = new TreeNode();
         left.value = 2;
         root.left = left;
         TreeNode leftLeft = new TreeNode();
         leftLeft.value  = 3;
         left.left = leftLeft;
         TreeNode right = new TreeNode();
         right.value = 4;
         root.right = right;
         TreeNode rightRight = new TreeNode();
         rightRight.value  = 5;
         right.right = rightRight;


         /*
                 1
                /\
               2  4
              /    \
             3      5
          */

         System.out.println(postOrderTraversal(root));

     }

}
