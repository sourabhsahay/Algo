import java.util.HashMap;
import java.util.Map;

/**
 * Created by vishwasourabh.sahay on 08/12/16.
 */
public class Trie {

    class TrieNode
    {
        char c;
        Map<Character,TrieNode> children = new HashMap<Character,TrieNode>();
        boolean isLeaf;

        public TrieNode()
        {

        }

        public TrieNode(char c)

        {
            this.c=c;
        }
    }

    private TrieNode root;

    public void insert(String word)
    {
        HashMap<Character,TrieNode> children = new HashMap<Character,TrieNode>();
        for(int i = 0; i < word.length(); i ++)
        {
            TrieNode t;
            char c = word.charAt(i);
            if(children.containsKey(i))
            {
                t =children.get(c);
            }
            else
            {
                t = new TrieNode(c);
                children.put(c,t);

            }
            if(i ==word.length() -1)
            {
                t.isLeaf = true;
            }
        }

    }

    public boolean search(String word)
    {
        TrieNode t = searchNode(word);

        return false;

    }



    private TrieNode searchNode(String word)
    {
        Map<Character, TrieNode> children = root.children;
        TrieNode t = null;
        for(int i = 0; i < word.length() ; i ++)
        {
            char c = word.charAt(i);
            if(children.containsKey(c))
            {
                t = children.get(c);
                children = t.children;
            }
            else
            {
                return null;
            }
        }
        return t;
    }
}
