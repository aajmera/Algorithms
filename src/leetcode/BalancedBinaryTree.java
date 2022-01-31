package leetcode;

class BalancedBinaryTree {

    public class TreeNode {
        int val;
         TreeNode left;
         TreeNode right;
         TreeNode() {}
         TreeNode(int val) { this.val = val; }
         TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
 }

    class BalancedHeight {
        boolean isBalanced;
        int height;

        public BalancedHeight(boolean isBalanced, int height) {
            this.isBalanced = isBalanced;
            this.height = height;
        }
    }

    public boolean isBalanced(TreeNode root) {
        return isBalancedCheck(root).isBalanced;
    }

    public BalancedHeight isBalancedCheck(TreeNode root) {
        if(root == null) return new BalancedHeight(true, 0);
        if(root.left == null && root.right == null) return new BalancedHeight(true, 1);

        BalancedHeight leftBalanced = isBalancedCheck(root.left);
        BalancedHeight rightBalanced = isBalancedCheck(root.right);

        boolean balanced = leftBalanced.isBalanced && rightBalanced.isBalanced
                && Math.abs(leftBalanced.height - rightBalanced.height) <= 1;
        int height = (leftBalanced.height > rightBalanced.height ?
                leftBalanced.height : rightBalanced.height) + 1;

        return new BalancedHeight(balanced, height);
    }
}