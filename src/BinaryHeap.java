import java.util.Arrays;

/**
 * Created by vishwasourabh.sahay on 05/12/16.
 */
public class BinaryHeap {

    private static final int d = 2;
    private int heapSize ;
    private int [] heap;

    public BinaryHeap(int capacity)
    {
        heapSize =0;
        heap = new int[capacity + 1];
        Arrays.fill(heap,-1);
    }

    public boolean isEmpty()
    {
        return heapSize ==0;
    }

    public boolean isFull()
    {
        return heapSize ==heap.length;
    }

    private int parent(int i)
    {
        return (i-1)/d;
    }

    private int child(int i,int k)
    {
        return d*i + k;
    }

    public void insert(int x)
    {
        if(!isFull())
        {
            return;
        }
        heap[heapSize++] = x;
        heapifyUp(heapSize -1);
    }

    private void heapifyUp(int childPosition) {
        int childValue = heap[childPosition];
        while(childPosition > 0 && childPosition < heap[parent(childPosition)])
        {
            heap[childPosition] = heap[parent(childPosition)];
            childPosition = parent(childPosition);
        }
        heap[childPosition]= childValue;
    }


    int delete(int index)
    {
        int keyItem = heap[index];
        heap[index] = heap[heapSize-1];
        heapSize -=1;
        heapifyDown(index);
        return keyItem;
    }

    private void heapifyDown(int index)
    {

       int child;
       int temp = heap[index];
       while(child(index,1)< heapSize)
       {
           child  =minChild(index);
           while(child(index,1)< heapSize)
           {
               child = minChild(index);
               if(heap[child]< index)
               {
                   heap[index] = heap[child];
               }
               else
                   break;
               index = child;
           }
           heap[index] = temp;
       }


    }

    private int minChild (int index)
    {
        int bestChild = child(index, 1);
        int k = 2;
        int pos = child(index, k);
        while((k<=d) && (pos < heapSize))
        {
            if (heap[pos]< heap [bestChild])
            {
                bestChild = pos;
            }
            pos = child(index, k++);
        }
        return bestChild;
    }


    public static void main (String args[])
    {

    }
}
