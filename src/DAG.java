import java.util.*;

public class DAG {
    int V,E;
    ArrayList<Integer>[] adj;
    int[] indegree;
    boolean hasCycle;
    boolean[] marked;
    boolean[] stack;

    public DAG(int v){
        this.V=v;
        this.E=0;
        adj=(ArrayList<Integer>[]) new ArrayList[v];
        for (int i=0;i<v;i++)
            adj[i]=new ArrayList<>();
        indegree = new int[v];
        marked = new boolean[v];
        stack = new boolean[v];
    }

    public int Vertices(){
        return this.V;
    }

    public int Edges(){
        return this.E;
    }

    public boolean hasCycle(){
        return hasCycle;
    }

    public void findCycle(int v){
        marked[v]=true;
        stack[v]=true;
        for(int w : adj(v)){
            if(!marked[w])
                findCycle(w);
            else if (stack[w]){
                hasCycle =true;
                break;
            }
        }
        stack[v]=false;
    }

    public int indegree(int v){
        if (validateVertex(v)<0)
            return -1;
        else return indegree[v];
    }

    public int outdegree(int v){
        if (validateVertex(v)<0)
            return -1;
        else return adj[v].size();
    }

    public Iterable<Integer> adj(int v){
        return adj[v];
    }

    private int validateVertex(int v) {
        if(v<0||v>=V)
            return -1;
        else return 1;
    }

    public void addEdge(int v, int w){
        if(validateVertex(v)>0 && validateVertex(w)>0){
            adj[v].add(w);
            indegree[w]++;
            E++;
        }
    }

    public int findLCA(int v1, int v2){
        if(validateVertex(v1)<0 || validateVertex(v2)<0)
            return -1;
        if(v1==v2)
            return v1;
        findCycle(0);
        if(hasCycle)
            return -1;
        DAG reverse = reverse();
        ArrayList<Integer> v1Path= reverse.breadthFirstSearch(v1);
        ArrayList<Integer> v2Path = reverse.breadthFirstSearch(v2);
        ArrayList<Integer> mutual = new ArrayList<>();
        boolean found = false;
        for(int i=0; i<v1Path.size();i++)
            for (int j=0; j<v2Path.size();j++)
                if (v1Path.get(i)==v2Path.get(j)){
                    mutual.add(v1Path.get(i));
                    found=true;
                }
        if (found)
            return mutual.get(0);
        else return -1;
    }
    private DAG reverse(){
        DAG reverse = new DAG(V);
        for (int v1=0 ; v1<V;v1++)
            for(int v2 : adj(v1))
                reverse.addEdge(v2,v1);
        return reverse;
    }
    public ArrayList<Integer> breadthFirstSearch(int v){
        boolean visited[] = new boolean[V];
        LinkedList<Integer> queue = new LinkedList<>();
        ArrayList<Integer> order = new ArrayList<>();
        visited[v]=true;
        queue.add(v);
        while (queue.size()!=0){
            v=queue.poll();
            order.add(v);
            Iterator<Integer> i = adj[v].listIterator();
            while (i.hasNext()){
                int n = i.next();
                if(!visited[n]){
                    visited[n]=true;
                    queue.add(n);
                }
            }
        }
        return order;
    }
}
