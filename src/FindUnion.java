public class FindUnion {

    public static void main(String[] args) {
        System.out.println("Hello World!");


    }

    int Arr[];
    int size [];


    FindUnion(int Arr[],int N )
    {
        this.Arr = Arr;
        this.size = new int[N];

        for (int i= 0; i < N; i ++)
        {
            this.Arr[i] = i;
            this.size[i] = 1;

        }
    }


    int root (int i)
    {
        while (Arr[i]!= i)
        {
            i = Arr[i];
            Arr[i] = Arr[Arr[i]];
        }
        return i;
    }

    boolean find (int A, int B)
    {
        if (root (A)== root ( B))
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    void union ( int A, int B)
    {
        int root_A = root (A);
        int root_B = root (B);

        if (size[root_A] > size[root_B]) {
            Arr[root_B] = root_A;
            size[root_A] += size[root_B];
        }
        else
        {
            Arr[root_A] = root_B;
            size[root_B] += size[root_A];
        }

    }



}
