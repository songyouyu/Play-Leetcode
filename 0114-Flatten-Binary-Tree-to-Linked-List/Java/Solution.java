
public class Solution {

    class TreeNode {
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

    TreeNode dummyNode = new TreeNode(-1);
    TreeNode curr = dummyNode;

    /**
     * https://leetcode.cn/problems/flatten-binary-tree-to-linked-list/
     * @param root
     */
    public void flatten(TreeNode root) {
        preorder(root);
    }

    private void preorder(TreeNode root) {
        if (root == null) {
            return;
        }
        TreeNode left = root.left;
        TreeNode right = root.right;
        curr.right = root;
        curr = root;
        root.left = null;

        preorder(left);
        preorder(right);
    }

}