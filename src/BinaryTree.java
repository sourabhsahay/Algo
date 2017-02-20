public class BinaryTree
{
    static class Node
    {
        int data ;
        Node left, right;

        public Node(int data) {
            this.data = data;
        }
    }


    public BinaryTree(Node root) {
        this.root = root;
    }

    Node root;

    private int height(Node root)
    {
        if(root ==null)
        {
            return 0;
        }
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);
        return 1 + Math.max(leftHeight,rightHeight);

    }

    private static void levelOrderTraversal(Node root, int depth)
    {

        if(root ==null )
        {
            return;
        }
        if(depth == 1)
        {
            System.out.print(root.data);
        }
        else
        {
            levelOrderTraversal(root.left,depth-1);
            levelOrderTraversal(root.right,depth -1);

        }
    }

    int diaMeter(Node root)
    {
        if(root ==null)
        {
            return 0;
        }
            int leftDiameter = diaMeter(root.left);
            int rightDiameter = diaMeter(root.right);
            int maxSubTreeDiameter = Math.max(leftDiameter,rightDiameter);
            return Math.max(maxSubTreeDiameter,height(root.right)+height(root.left)+1);

    }

    private void levelOrderTraversal(Node root)
    {
        int height = height(root);
        System.out.println("Height is "  + height);

        for(int i = 1; i <= height;i++)
        {
            levelOrderTraversal(root,i);
            System.out.println();
        }
    }

    public static void main(String args [])
    {
        BinaryTree tree = new BinaryTree(null);
        tree.root= new Node(1);
        tree.root.left= new Node(2);
        tree.root.right= new Node(3);
        tree.root.left.left= new Node(4);
        tree.root.left.right= new Node(5);


        //tree.levelOrderTraversal(tree.root);
        System.out.println("Tree structure is " + tree.diaMeter(tree.root));

    }
}

