public class AddList {
    class Node {
        int value;
        Node next ;
    }


    Node addLists (Node head1, Node head2 )
    {
        if (head1 == null && head2 != null)
        {
            return head2;
        }
        else if (head2== null && head1 !=null)
        {
            return head1;
        }
        int size1 = getSize(head1);
        int size2 = getSize(head2);
        Node result = new Node();
        int carry = 0;


        if (size1 ==size2)
        {
            addsamesize(head1, head2, result);
        }
        else
        {
            int diff = Math.abs(size1 - size2);
            Node temp = head1;
            Node current = null;
            while (diff-- > 0)
            {
                current = temp;
                temp = temp.next;

            }
            carry = addsamesize(current, head2, result);
            propogateCarry(head1, result,carry);
        }
        if (carry > 0)
        {
            Node carryNode = new Node();
            carryNode.next = result;
            result.next = carryNode;
        }

     return result;
    }

    int propogateCarry(Node head1, Node result, int carry)
    {
       if(head1 !=null)
       {
           carry = propogateCarry(head1, result, carry);
           int sum = carry + head1.value;
           carry  = sum/10;
           sum = sum % 10;

           Node node = new Node();
           node.value = sum;
           node.next = result;
           result = node;

       }
       return carry;
    }

    int  addsamesize(Node node1, Node  node2, Node result)
    {
      if(node1 ==null)
          return 0;
      int carry = addsamesize(node1.next, node2.next, result);
      int sum = node1.value+ node2.value + carry;
      carry = sum/10;
      Node node = new Node();
      node.value = sum;
      node.next = result;
      result = node;
      return carry;


    }


        int  getSize (Node list )
   {
       int count = 0;
       while (list!=null)
       {
           list = list.next;
           count++;
       }
       return count;
   }
}
