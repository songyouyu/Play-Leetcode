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

/**
 * https://leetcode.cn/problems/binode-lcci/
 */
public class Solution {

    TreeNode dummyNode = new TreeNode();
    TreeNode curr = dummyNode;
    
    public TreeNode convertBiNode(TreeNode root) {
        inorder(root);
        return dummyNode.right;
    }

    private void inorder(TreeNode root) {
        if (root == null) return;
        inorder(root.left);
        curr.right = root;
        curr = root;
        root.left = null;
        inorder(root.right);
    }

}
