public class LCA {

    static class Node{
        int data;
        Node right, left;

        public Node(int data)
        {
            this.data=data;
            right=left=null;
        }
    }

    public static class BinaryTree{
        Node root;
        Boolean nodePresent(Node root, int num){
            if(root==null)
            {
                return false;
            }
            if(root.data==num){
                return true;
            }
            if(root.left!= null && nodePresent(root.left,num)){
                return true;
            }
            if(root.right != null && nodePresent(root.right,num)){
                return true;
            }
            return false;
        }

        int findLCA(int n1, int n2){
            if(!nodePresent(root,n1)||!nodePresent(root,n2))
            {
                return -1;
            }
            return LCA(root, n1, n2).data;
        }

        Node LCA(Node root, int n1, int n2)
        {
                if (root == null) {
                    return null;
                } else if (root.data == n1 || root.data == n2) {
                    return root;
                }

                Node left = LCA(root.left, n1, n2);
                Node right = LCA(root.right, n1, n2);

                if (left != null && right != null) {
                    return root;
                }
                if (left == null) {
                    return right;
                } else {
                    return left;
                }
        }
    }
}
