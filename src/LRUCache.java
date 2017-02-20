import java.util.HashMap;
import java.util.Map;

/**
 * Created by vishwasourabh.sahay on 08/12/16.
 */
public class LRUCache {

    class Node
    {
        int key;
        int value ;
        Node previous;
        Node next;

        public Node(int key, int value)
        {
            this.key=key;
            this.value=value;
        }

    }

    int capacity;

    public LRUCache(int capacity)
    {
        this.capacity =capacity;
    }

    Map<Integer,Node> map = new HashMap<Integer,Node>();
    Node head = null;
    Node tail=null;

    public int get(int key)
    {
        if(map.containsKey(key))
        {
            Node n = map.get(key);
            remove(n);
            setHead(n);
            return n.value;
        }
        return -1;
    }

    private void remove(Node node)
    {
        if(node.previous!=null)
        node.previous.next = node.next;
        else
            head = node.next;
        if(node.next!=null) {
            node.next.previous = node.previous;
        }
        else
        {
            tail = node.previous;
        }
    }

    private void setHead (Node n)
    {
        n.next = head;
        n.previous =null;
        if(head!=null)
        {
            head.previous =n;
        }
        if(tail ==null)
        {
            tail = head;
        }
    }

    public void set(int key, int value)
    {

        if(map.containsKey(key))
        {
            Node node = map.get(key);
            remove(node);
            setHead(node);
            node.value= value;
            return;
        }
        Node node = new Node(key,value);
        if(capacity==map.size())
        {
            remove(tail);
            map.remove(tail.key);
            setHead(node);
        }
        else
        {
            setHead(node);
        }
        map.put(key,node);
    }
}
