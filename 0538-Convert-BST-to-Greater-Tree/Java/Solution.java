public class Solution {
    
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {}

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    private int sum = 0;

    /**
     * https://leetcode.cn/problems/convert-bst-to-greater-tree/
     * 
     * @param root
     * @return
     */
    public TreeNode convertBST(TreeNode root) {
        inorder(root);
        return root;
    }

    private void inorder(TreeNode root) {
        if (root == null) return;
        inorder(root.right);
        sum += root.val;
        root.val = sum;
        inorder(root.left);
    }

}
