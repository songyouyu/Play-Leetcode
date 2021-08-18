/**
 * @author youyusong
 * @date 2018/12/18
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
     * 给定一棵二叉树，你需要计算它的直径长度。一棵二叉树的直径长度是任意两个结点路径长度中的最大值。
     * 这条路径可能穿过根结点
     *
     * 给定二叉树
     *
     *           1
     *          / \
     *         2   3
     *        / \
     *       4   5
     * 返回 3, 它的长度是路径 [4,2,1,3] 或者 [5,2,1,3]。
     *
     * 两结点之间的路径长度是以它们之间边的数目表示。
     * @param root
     * @return
     */
    int max = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        maxDepth(root);

        return max;
    }

    public int maxDepth(TreeNode root){
        if (root == null) {
            return 0;
        }
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        max = Math.max(max, left + right);
        return 1 + Math.max(left, right);
    }

}
