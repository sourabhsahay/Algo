import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class MergeSortedLists {

    public class ListNode {
      int val;
      ListNode next;
     ListNode(int x) { val = x; }
  }

     public static void main (String args[])
     {

     }

        public ListNode mergeKLists(ListNode[] lists) {
            Map<Integer, ListNode> values = new HashMap<Integer, ListNode>();

            ListNode  node = new ListNode( -1);
            ListNode head = node;


            PriorityQueue<Integer> pq = new PriorityQueue<Integer>(lists.length);
            for (int i = 0; i < lists.length; i ++)
            {
                pq.add(lists[i].val);
                values.put(lists[i].val, lists[i]);

            }
            while (!pq.isEmpty())
            {
                ListNode queueTop = values.get(pq.poll());
                node.next =  queueTop;
                node = node.next;
                if(queueTop.next !=null) {
                    pq.add(queueTop.next.val);
                    values.put(queueTop.next.val, queueTop.next);
                }


            }
            return head.next;

        }

}
