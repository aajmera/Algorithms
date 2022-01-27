package hackerrank.interviewpreparation.trees;

public class HeightOfBinaryTree {

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

    public static int height(Node root) {
        //if root has no child, return zero
        if(root.left == null && root.right == null)
            return 0;

        //get height of left subtree
        int leftHeight = 0;
        if(root.left != null)
            leftHeight = height(root.left) + 1;

        //get height of right subtree
        int rightHeight = 0;
        if(root.right != null)
            rightHeight = height(root.right) + 1;

        //return bigger height
        return Math.max(leftHeight, rightHeight);
    }

    public static void main(String[] args) {

    }
}