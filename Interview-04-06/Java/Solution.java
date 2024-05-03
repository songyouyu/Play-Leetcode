public class Solution {
    
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    /**
     * https://leetcode.cn/problems/successor-lcci/
     * 
     * @param root
     * @param p
     * @return
     */
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if (root == null) return null;
        inorder(root, p);
        return result;
    }

    private boolean coming = false;
    private TreeNode result = null;

    private void inorder(TreeNode root, TreeNode p) {
        if (root == null) return;

        inorder(root.left, p);

        if (result != null) return;
        if (coming) {
            coming = false;
            result = root;
            return;
        } 
        if (root == p) {
            coming = true;
        }

        inorder(root.right, p);
    }

}
