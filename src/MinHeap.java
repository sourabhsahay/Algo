public class MinHeap {
    private int[] Heap;
    private int size;
    private int maxSize;

    public MinHeap(int maxSize) {
        this.maxSize = maxSize;
        this.size = 0;
        Heap = new int[this.maxSize + 1];
        Heap[0] = Integer.MIN_VALUE;
    }

    private int parent(int position) {
        return position / 2;
    }

    private int leftChild(int position) {
        return 2 * position;
    }

    private int rightChild(int position) {
        return 2 * position + 1;
    }

    private boolean isLeaf(int position) {
        if (position >= (size / 2) && position <= size) {
            return true;
        }
        return false;
    }

    private void swap(int fpos, int spos) {
        int tmp;
        tmp = Heap[fpos];
        Heap[fpos] = Heap[spos];
        Heap[spos] = tmp;
    }

    private void minHeapify(int position) {
        if (!isLeaf(position)) {
            if (Heap[position] > Heap[leftChild(position)] || Heap[position] > Heap[leftChild(position)]) {
                if (Heap[leftChild(position)] < Heap[rightChild(position)]) {
                    swap(position, leftChild(position));
                    minHeapify(leftChild(position));
                } else {
                    swap(position, rightChild(position));
                    minHeapify(rightChild(position));
                }
            }
        }
    }

    public void insert(int element) {
        if (size >= maxSize)
            return;
        Heap[++size] = element;
        int current = size;

        while (Heap[current] < Heap[parent(current)]) {
            swap(current, parent(current));
            current = parent(current);
        }

    }


public void minHeap()
{
    for (int pos = (size / 2); pos >= 1; pos--) {
        minHeapify(pos);
    }
}

    public void print()
    {
        for (int i = 1; i <= size / 2; i++) {
            System.out.print(" PARENT : " + Heap[i]
                    + " LEFT CHILD : " + Heap[2 * i]
                    + " RIGHT CHILD :" + Heap[2 * i + 1]);
            System.out.println();
        }
    }

    public int remove ()
{
    int popped = Heap[1];
    Heap[1] = Heap[size--];
    minHeapify(1);
    return popped;
}

    public static void main(String[] arg)
    {
        System.out.println("The Min Heap is ");
        MinHeap minHeap = new MinHeap(15);
        minHeap.insert(5);
        minHeap.insert(3);
        minHeap.insert(17);
        minHeap.insert(10);
        minHeap.insert(84);
        minHeap.insert(19);
        minHeap.insert(6);
        minHeap.insert(22);
        minHeap.insert(9);
        minHeap.minHeap();

        minHeap.print();
        System.out.println("The Min val is " + minHeap.remove());
    }
}


