import org.junit.Test;

import static org.junit.Assert.*;

public class DAGTest {

    @Test
    public void vertices() {
        DAG graph= new DAG(25);

        assertEquals(25,graph.Vertices());
    }

    @Test
    public void edges() {
        DAG graph = new DAG(4);

        graph.addEdge(0,1);
        graph.addEdge(0,3);
        graph.addEdge(2,3);

        assertEquals(3,graph.Edges());
    }

    @Test
    public void hasCycle() {
        // for cycle
        DAG graph = new DAG(2);

        graph.addEdge(0,1);
        graph.addEdge(1,0);

        graph.findCycle(0);

        assertTrue(graph.hasCycle());

        // for no cycle
        graph = new DAG(4);

        graph.addEdge(0,1);
        graph.addEdge(0,3);
        graph.addEdge(2,3);

        graph.findCycle(0);
        assertFalse(graph.hasCycle());

    }

    @Test
    public void indegree() {
        DAG graph = new DAG(4);

        graph.addEdge(0,1);
        graph.addEdge(0,3);
        graph.addEdge(2,3);

        assertEquals(2,graph.indegree(3));
        assertEquals(-1,graph.indegree(20));
    }

    @Test
    public void outdegree() {
        DAG graph = new DAG(4);

        graph.addEdge(0,1);
        graph.addEdge(0,3);
        graph.addEdge(2,3);

        assertEquals(2,graph.outdegree(0));
        assertEquals(-1,graph.outdegree(20));
    }

    @Test
    public void adj() {
        DAG graph = new DAG(4);

        graph.addEdge(0,1);
        graph.addEdge(0,3);
        graph.addEdge(2,3);

        assertEquals("[1, 3]", graph.adj(0).toString());
    }

    @Test
    public void addEdge() {
        DAG graph = new DAG(4);

        graph.addEdge(0,1);
        graph.addEdge(0,3);
        graph.addEdge(2,3);

        assertEquals(3,graph.Edges());
    }

    @Test
    public void findLCA() {
        DAG graph= new DAG(0);
        assertEquals(-1,graph.findLCA(1,2));

        graph = new DAG(2);
        graph.addEdge(0,1);
        graph.addEdge(1,0);
        assertEquals(-1,graph.findLCA(0,1));

        graph= new DAG(5);
        graph.addEdge(0,1);
        graph.addEdge(0,2);
        graph.addEdge(0,3);
        graph.addEdge(0,4);
        graph.addEdge(1,3);
        graph.addEdge(2,3);
        graph.addEdge(2,4);

        assertEquals(0,graph.findLCA(1,2));
        assertEquals(1,graph.findLCA(1,1));
        assertEquals(0,graph.findLCA(1,4));
        assertEquals(1,graph.findLCA(1,3));
        assertEquals(0,graph.findLCA(3,4));
        assertEquals(1,graph.findLCA(1,3));
        assertEquals(2,graph.findLCA(2,4));

    }

}
