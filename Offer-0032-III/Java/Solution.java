public class Solution {
    
    /**
     * https://leetcode.cn/problems/ping-heng-er-cha-shu-lcof/
     * 
     * @param root
     * @return
     */
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        int lDepth = getDepth(root.left);
        int rDepth = getDepth(root.right);
        return Math.abs(lDepth - rDepth) <= 1 && isBalanced(root.left) && isBalanced(root.right);
    }

    private int getDepth(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int lDepth = getDepth(node.left);
        int rDepth = getDepth(node.right);

        return Math.max(lDepth, rDepth) + 1;
    }

}

class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

}