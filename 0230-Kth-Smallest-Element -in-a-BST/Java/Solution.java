/**
 * @author youyu.song
 * @date 2020/3/27 9:52
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
     * 给定一个二叉搜索树，编写一个函数 kthSmallest 来查找其中第 k 个最小的元素.
     * 说明：
     * 你可以假设 k 总是有效的，1 ≤ k ≤ 二叉搜索树元素个数。
     *
     * 示例 1:
     * 输入: root = [3,1,4,null,2], k = 1
     *    3
     *   / \
     *  1   4
     *   \
     *    2
     * 输出: 1
     *
     * 示例 2:
     * 输入: root = [5,3,6,2,4,null,null,1], k = 3
     *        5
     *       / \
     *      3   6
     *     / \
     *    2   4
     *   /
     *  1
     * 输出: 3
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/kth-smallest-element-in-a-bst
     *
     * @param root
     * @param k
     * @return
     */
    int result = 0;
    int j = 0;
    public int kthSmallest(TreeNode root, int k) {
        j = k;

        kthSmallest(root);

        return result;
    }

    private void kthSmallest(TreeNode node) {
        if (node == null || j < 0) {
            return;
        }
        kthSmallest(node.left);
        j --;
        if (j == 0) {
            result = node.val;
        }
        kthSmallest(node.right);
    }

}
