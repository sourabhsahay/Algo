public class LinkedList {
    int data ;
    LinkedList next;

   LinkedList reverse (LinkedList head)
    {
        LinkedList previous = null;
        LinkedList current = head;

        while (current != null)
        {
            LinkedList next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }
        return previous;

    }

    LinkedList reverseBetween(LinkedList head, int m, int n)
    {
        LinkedList current = head;
        int count = 0;
        while (count < m -1)
        {
           current = current.next;
        }
        LinkedList reverseIter = current.next;
        while (count != n)
        {
            count ++;
            LinkedList temp = reverseIter.next;
            current.next =  temp;
            reverseIter.next = temp.next;
            temp.next = current.next;

        }
        return current;

    }

    }
