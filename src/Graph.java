import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;

/**
 * Created by vishwasourabh.sahay on 04/12/16.
 */
public class Graph  {

    private int v;
    private LinkedList<Integer> adj[];

    public Graph(int v) {
        this.v = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; i++) {
            adj[i] = new LinkedList<Integer>();
        }

    }

    public void addEdge(int v, int w)
    {
        adj[v].add(w);

    }

    public void BFS(int start)
    {
        boolean visited[] = new boolean[v];
        LinkedList<Integer> list = new LinkedList<Integer>();
        list.add(start);
        visited[start]=true;

        while(!list.isEmpty())
        {
            int current = list.poll();
                System.out.println(current);
                Iterator<Integer> iterator = adj[current].iterator();
                while(iterator.hasNext())
                {
                   int neighbour = iterator.next();
                    if(!visited[neighbour])
                    {
                        list.add(neighbour);
                        visited[neighbour]=true;
                    }
                }

        }

    }


    class Subset
    {
        int parent, rank;
    };


    int find(Subset [] subset, int i)
    {
        if(subset[i].parent != i)
        {
            return find (subset,subset[i].parent );
        }
        return subset[i].parent;

    }

    void union(Subset[] subset, int x, int y)
    {
        int xRoot = find (subset, x);
        int yRoot  = find (subset, y);

        if(subset[xRoot].rank < subset[yRoot].rank)
        {
            subset[xRoot].parent = yRoot;
        }
        else if(subset[yRoot].rank < subset[xRoot].rank)
        {
            subset[yRoot].parent = xRoot;
        }

        else
        {
            subset[yRoot].parent = xRoot;
            subset[xRoot].rank ++;
        }
    }

    void KruskalMST()
    {

    }




    void DFS(int v, boolean visited[])
    {
       visited[v] = true;
        System.out.print(v + " ");

        Iterator<Integer> itr =  adj[v].listIterator();
        while(itr.hasNext())
        {
            int neighbour = itr.next();
            if(!visited[neighbour])
                DFS(neighbour,visited);
        }


    }

    void DFS(int vertex)
    {
        boolean[] visited = new boolean[v];
        DFS(vertex,visited);

    }

    void topologicalSortUtil(int i, boolean[] visited, Stack stack)
    {
        visited[v] = true;
        Iterator<Integer> iterator = adj[i].iterator();
        while(iterator.hasNext())
        {
            int neighbour = iterator.next();
            if(visited[neighbour]==false)
            {
                topologicalSortUtil(neighbour,visited,stack);
            }

            stack.push(i);
        }
    }

     void topologicalSort()
     {
         Stack stack = new Stack();
         boolean[] visited  = new boolean[v];
         for(int i = 0; i <visited.length; i++)
         {
             visited[i]= false;
         }

         for(int i=0 ; i <v; i ++)
         {
             if(visited[i]==false)
             {

             }
         }
     }


    public static void main (String args[])
    {
        Graph g = new Graph(4);

        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);
       // g.BFS(2);
        g.DFS(2);


    }

}
