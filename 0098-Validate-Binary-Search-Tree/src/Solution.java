/**
 * @author youyu.song
 * @date 2020/3/24 9:42
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
     * 给定一个二叉树，判断其是否是一个有效的二叉搜索树。
     *
     * 假设一个二叉搜索树具有如下特征：
     * 节点的左子树只包含小于当前节点的数。
     * 节点的右子树只包含大于当前节点的数。
     * 所有左子树和右子树自身必须也是二叉搜索树。
     *
     * 示例 1:
     * 输入:
     *     2
     *    / \
     *   1   3
     * 输出: true
     *
     * 示例 2:
     * 输入:
     *     5
     *    / \
     *   1   4
     *      / \
     *     3   6
     * 输出: false
     * 解释: 输入为: [5,1,4,null,null,3,6]。
     *      根节点的值为 5 ，但是其右子节点值为 4 。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/validate-binary-search-tree
     *
     * @param root
     * @return
     */
    long last = -Long.MIN_VALUE;
    public boolean isValidBST(TreeNode root) {
        // 中序遍历
        if (root == null) {
            return true;
        }

        boolean l = isValidBST(root.left);
        if (last < root.val) {
            last = root.val;
        } else {
            return false;
        }
        boolean r = isValidBST(root.right);

        return l && r;
    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode(5);
        node.left = new TreeNode(4);
        node.right = new TreeNode(8);
        node.left.left = new TreeNode(2);
        node.right.left = new TreeNode(3);
        node.right.right = new TreeNode(9);
        System.out.println(new Solution().isValidBST(node));
    }

}
