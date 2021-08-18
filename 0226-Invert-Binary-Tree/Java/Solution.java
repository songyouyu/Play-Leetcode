/**
 * @author youyu.song
 * @date 2020/1/22 9:50
 */
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
     * 翻转一棵二叉树。
     *
     * 输入：
     *      4
     *    /   \
     *   2     7
     *  / \   / \
     * 1   3 6   9
     *
     * 输出：
     *      4
     *    /   \
     *   7     2
     *  / \   / \
     * 9   6 3   1
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/invert-binary-tree
     *
     * @param root
     * @return
     */
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }

        TreeNode node = root.left;
        root.left = root.right;
        root.right = node;
        root.left = invertTree(root.left);
        root.right = invertTree(root.right);

        return root;
    }

}
