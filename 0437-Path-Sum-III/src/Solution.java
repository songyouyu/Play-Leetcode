/**
 * @author youyu.song
 * @date 2020/3/22 9:19
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
     * 给定一个二叉树，它的每个结点都存放着一个整数值。
     * 找出路径和等于给定数值的路径总数。
     * 路径不需要从根节点开始，也不需要在叶子节点结束，但是路径方向必须是向下的（只能从父节点到子节点）。
     * 二叉树不超过1000个节点，且节点数值范围是 [-1000000,1000000] 的整数。
     *
     * 示例：
     * root = [10,5,-3,3,2,null,11,3,-2,null,1], sum = 8
     *       10
     *      /  \
     *     5   -3
     *    / \    \
     *   3   2   11
     *  / \   \
     * 3  -2   1
     *
     * 返回 3。和等于 8 的路径有:
     * 1.  5 -> 3
     * 2.  5 -> 2 -> 1
     * 3.  -3 -> 11
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/path-sum-iii
     *
     * @param root
     * @param sum
     * @return
     */
    public int pathSum(TreeNode root, int sum) {
        // 双重递归
        if (root == null) {
            return 0;
        }

        return pathSum(root.left, sum) + pathSum(root.right, sum) + rootPathSum(root, sum);
    }

    private int rootPathSum(TreeNode node, int sum) {
        if (node == null) {
            return 0;
        }
        sum -= node.val;

        return (sum == 0 ? 1 : 0) + rootPathSum(node.left, sum) + rootPathSum(node.right, sum);
    }

}
