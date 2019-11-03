public class TreeAlgorithms {


     static class TreeNode {
         int val;
         TreeNode left;
          TreeNode right;
         TreeNode(int x) {
          val = x;
           left=null;
           right=null;
          }
      }

      static class HeightAndDiameter
    {
        double height, diaMeter;
    }

    public static int isValidBST(TreeNode A) {
         if (A == null)
         {
             return 1;
         }

         if (A.left != null && A.left.val > A.val)
         {
             return 0;
         }
        if (A.right != null && A.right.val < A.val)
        {
            return 0;
        }
        if (isValidBST(A.left)== 0 || isValidBST(A.right)==0)
        {
            return 0;
        }
        return 1;
    }
       public  static int lca(TreeNode A, int B, int C) {

          if(A == null || A.val == -1)
          {
              return -1;
          }

          if (A.val == B || A.val == C)
          {
              return A.val;
          }

          int lca_left = lca (A.left, B, C);
          int lca_right = lca(A.right, B, C);

          if (lca_left != -1 && lca_right!= -1)
          {
              return A.val;
          }
          else
          {
              return lca_left != -1 ? lca_left : lca_right;

          }
    }

    public static void main (String args[])
    {
        /*TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode( 2);
        treeNode.right = new TreeNode(3);
        treeNode. right.left = new TreeNode(4);
        treeNode.right.left.right = new TreeNode(5);
        System.out.println(lca (treeNode, 1, 3));
        System.out.println (isValidBST(treeNode));*/

        TreeNode treeNode = new TreeNode(11);
        treeNode.left =  new TreeNode(4);
        //treeNode.right = new TreeNode(-1);
        treeNode.left.left =  new TreeNode(5);
        treeNode.left.right = new TreeNode(1);
        System.out.println (isValidBST(treeNode));

    }

    HeightAndDiameter computeHeightAndDiameter(TreeNode treeNode, HeightAndDiameter heightAndDiameter)
    {
        double diameter = Integer.MIN_VALUE;
        HeightAndDiameter heightAndDiameterLeft = new HeightAndDiameter();
        HeightAndDiameter heightAndDiameterRight = new HeightAndDiameter();

        if (treeNode ==  null)
        {

            heightAndDiameter.height = 0;
            heightAndDiameter.diaMeter = 0;
            return heightAndDiameter;
        }

        heightAndDiameterLeft = computeHeightAndDiameter( treeNode.left, heightAndDiameterLeft);
        double leftDiameter = heightAndDiameterLeft.diaMeter;
        heightAndDiameterRight = computeHeightAndDiameter( treeNode.right, heightAndDiameterRight);
        double rightDiameter = heightAndDiameterRight.diaMeter;

        heightAndDiameter.height = Math.max (heightAndDiameterLeft.height, heightAndDiameterRight.height) + 1;

        heightAndDiameter.diaMeter = Math.max(heightAndDiameterLeft.height +  heightAndDiameterRight.height + 1,
                Math.max(heightAndDiameterLeft.diaMeter, heightAndDiameterRight.diaMeter));

         return heightAndDiameter;
    }

    class Status
    {
        int numberOfNodes;
        TreeNode ancestor;

        public Status(int numberOfNodes, TreeNode ancestor) {
            this.numberOfNodes = numberOfNodes;
            this.ancestor = ancestor;
        }
    }

    Status leastCommonAncestor(TreeNode treeNode, TreeNode node1, TreeNode node2)
    {
       if(treeNode ==null)
       {
           return new Status(0, null);
       }
       Status leftStatus = leastCommonAncestor(treeNode, node1, node2);
       if (leftStatus.numberOfNodes ==2)
       {
           return leftStatus;
       }
        Status rightStatus = leastCommonAncestor(treeNode, node1, node2);
        if (rightStatus.numberOfNodes ==2)
        {
            return rightStatus;
        }

        int numberOfNodes = leftStatus.numberOfNodes + rightStatus.numberOfNodes + ((treeNode ==node1) ?1 : 0)
                + (treeNode == node1? 1: 0);

         return new Status (numberOfNodes, numberOfNodes ==2? treeNode : null);

    }

}
