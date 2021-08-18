/**
 * @author youyu.song
 * @date 2020/3/17 10:03
 */
public class Solution {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    /**
     * 计算给定二叉树的所有左叶子之和。
     *
     * 示例：
     *     3
     *    / \
     *   9  20
     *     /  \
     *    15   7
     * 在这个二叉树中，有两个左叶子，分别是 9 和 15，所以返回 24
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/sum-of-left-leaves
     *
     * @param root
     * @return
     */
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int sum = 0;
        if (root.left != null && root.left.left == null && root.left.right == null) {
            sum += root.left.val;
        }
        return sumOfLeftLeaves(root.left) + sumOfLeftLeaves(root.right) + sum;
    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(2);
        node.right = new TreeNode(8);
        node.left.left = new TreeNode(11);
        node.left.right = new TreeNode(1);
        node.right.left = new TreeNode(4);
        System.out.println(new Solution().sumOfLeftLeaves(node));
    }

}
