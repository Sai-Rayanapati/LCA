import org.junit.Test;

import static org.junit.Assert.*;

public class LCATest {

    @Test
    public void LCA() {
        LCA.BinaryTree tree = new LCA.BinaryTree();

        // Root node is null
        assertEquals(-1,tree.findLCA(1,2));

        tree.root = new LCA.Node(1);
        tree.root.left = new LCA.Node(2);
        tree.root.right = new LCA.Node(3);
        tree.root.left.left = new LCA.Node(4);
        tree.root.left.right = new LCA.Node(5);
        tree.root.right.left = new LCA.Node(6);
        tree.root.right.right = new LCA.Node(7);

        // Nodes with same parent node
        assertEquals(2, tree.findLCA(4,5));

        //Nodes with different parent nodes
        assertEquals(1, tree.findLCA(4,6));

        // Nodes with different depths
        assertEquals(1, tree.findLCA(3,4));

        //Nodes as parent and child
        assertEquals(2, tree.findLCA(2,4));

        // Nodes not present
        assertEquals(-1, tree.findLCA(2,8));

        //Same Nodes
        assertEquals(1, tree.findLCA(1,1));
    }
}