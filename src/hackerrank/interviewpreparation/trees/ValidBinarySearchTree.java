package hackerrank.interviewpreparation.trees;

import java.util.ArrayList;
import java.util.List;

public class ValidBinarySearchTree {

    class Node {
        Node left;
        Node right;
        int val;

        Node(int data) {
            this.val = data;
            left = null;
            right = null;
        }
    }

    Integer temp;

    public boolean isValidBST(Node root) {

        if(root == null) return true;
        else if(root.left == null && root.right == null) return true;

        List<Integer> inOrderList = new ArrayList<>();

        saveInorder(root, inOrderList);

        int temp = inOrderList.get(0);

        for(int i=1; i<inOrderList.size(); i++) {
            if(temp >= inOrderList.get(i)) return false;
            temp = inOrderList.get(i);
        }

        return true;
    }

    private void saveInorder(Node root, List<Integer> inOrderList) {
        if(root.left != null) saveInorder(root.left, inOrderList);
        inOrderList.add(root.val);
        if(root.right != null) saveInorder(root.right, inOrderList);
    }
}
