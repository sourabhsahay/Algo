import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class HuffManEncoding {

    class CharWithFrequency
    {
        public char getC() {
            return c;
        }

        public double getFrequency() {
            return frequency;
        }

        char c;
        double frequency;
    }
    class TreeNode
    {
        double aggregateFrequency;
        Character character;
        TreeNode left, right;

        public TreeNode(double aggregateFrequency, Character character, TreeNode left, TreeNode right) {
            this.aggregateFrequency = aggregateFrequency;
            this.character = character;
            this.left = left;
            this.right = right;
        }
    }
    private PriorityQueue<TreeNode> candidates =new  <TreeNode>PriorityQueue();


    Map<Character, String> createHuffManEncoding (List<CharWithFrequency> charWithFrequencies)
    {
         for (CharWithFrequency charWithFrequency : charWithFrequencies)
        {
            candidates.add(new TreeNode(charWithFrequency.getFrequency(), charWithFrequency.getC(), null, null));
        }

         while (candidates.size() > 1)
         {
             TreeNode left = candidates.poll();
             TreeNode right = candidates.poll();
             TreeNode aggregateNode = new TreeNode (left.aggregateFrequency + right.aggregateFrequency,
                     null, left, right);
             candidates.add(left);

         }
         Map<Character, String> huffManEncoding = new HashMap<>();
         StringBuilder codeSoFar = new StringBuilder();
         createHuffManEncoding(candidates.peek(), codeSoFar, huffManEncoding);

         return huffManEncoding;

    }

    void createHuffManEncoding (TreeNode treeNode, StringBuilder codeSoFar, Map <Character, String> huffmanEncoding)
    {
        if (treeNode!= null)
        {
           if (treeNode.character != null)
           {
               huffmanEncoding.put(treeNode.character, codeSoFar.toString());
           }
           else
           {
               codeSoFar.append('0');
               createHuffManEncoding(treeNode.left, codeSoFar, huffmanEncoding);
               codeSoFar.deleteCharAt(codeSoFar.length() -1);
               codeSoFar.append('1');
               createHuffManEncoding(treeNode.right, codeSoFar, huffmanEncoding);
               codeSoFar.deleteCharAt(codeSoFar.length() -1);
           }
        }
    }


}
