/**
 * @author youyu.song
 * @date 2020/3/16 10:44
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
     * 给定一个二叉树和一个目标和，判断该树中是否存在根节点到叶子节点的路径，这条路径上所有节点值相加等于目标和。
     * 说明: 叶子节点是指没有子节点的节点。
     *
     * 示例: 
     * 给定如下二叉树，以及目标和 sum = 22，
     *               5
     *              / \
     *             4   8
     *            /   / \
     *           11  13  4
     *          /  \      \
     *         7    2      1
     * 返回 true, 因为存在目标和为 22 的根节点到叶子节点的路径 5->4->11->2。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/path-sum
     *
     * @param root
     * @param sum
     * @return
     */
    boolean flag = false;
    public boolean hasPathSum(TreeNode root, int sum) {
        //if (root == null)
        //    return false;
        //
        //sum -= root.val;
        //if (root.left == null && root.right == null)
        //    return sum == 0;
        //return hasPathSum(root.left, sum) || hasPathSum(root.right, sum);

        if (root == null) {
            return false;
        }

        return isPathSum(root, sum, flag);
    }

    private boolean isPathSum(TreeNode node, int sum, boolean flag) {
        if (node != null && node.left != null && node.right == null && node.val == sum) {
            return false;
        }
        if (node != null && node.right != null && node.left == null && node.val == sum) {
            return false;
        }
        if (node == null && sum != 0) {
            return false;
        }
        if (node == null && sum == 0) {
            return true;
        }

        boolean l = isPathSum(node.left, sum - node.val, flag);
        boolean r = isPathSum(node.right, sum - node.val, flag);

        if (l || r) {
            flag = true;
        }

        return flag;
    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(2);
        //node.right = new TreeNode(8);
        //node.left.left = new TreeNode(11);
        //node.left.right = new TreeNode(1);
        //node.right.right = new TreeNode(4);
        System.out.println(new Solution().hasPathSum(node, 1));
    }

}
