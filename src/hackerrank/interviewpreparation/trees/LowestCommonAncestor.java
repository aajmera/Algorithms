package hackerrank.interviewpreparation.trees;

public class LowestCommonAncestor {

    class Node {
        Node left;
        Node right;
        int data;

        Node(int data) {
            this.data = data;
            left = null;
            right = null;
        }
    }

    public static Node lca(Node root, int v1, int v2) {
        /* compare v1 and v2 with current node
         * if node key lies between v1 and v2
         * it is the common ancestor
         */
        if (root.data == v1 || root.data == v2) return root;
        else if (v1 < root.data && v2 > root.data) return root;
        else if (v1 > root.data && v2 < root.data) return root;
        else if (v1 < root.data && v2 < root.data)
            return lca(root.left, v1, v2);
        else
            return lca(root.right, v1, v2);
    }

    public static void main(String[] args) {

    }

}