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

    private int count = 0;
    private int result = 0;

    /**
     * https://leetcode.cn/problems/er-cha-sou-suo-shu-de-di-kda-jie-dian-lcof/description/
     * 
     * @param root
     * @param cnt
     * @return
     */
    public int findTargetNode(TreeNode root, int cnt) {
        inorder(root, cnt);
        return result;
    }

    /**
     * 二叉搜索数中序遍历为有序序列
     * @param root
     * @param cnt
     */
    private void inorder(TreeNode root, int cnt) {
        if (root == null) return;
        inorder(root.right, cnt);
        if (count >= cnt) return;
        count ++;
        if (count == cnt) {
            result = root.val;
            return;
        }

        inorder(root.left, cnt);
    }

}
