import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @author youyu.song
 * @date 2020/1/14 17:10
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
     * 给定一个二叉树，找出其最小深度。
     * 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
     *
     * 说明: 叶子节点是指没有子节点的节点。
     *
     * @param root
     * @return
     */
    public int minDepth(TreeNode root) {
        //if (root == null) {
        //    return 0;
        //}
        //
        //if (root.left == null && root.right != null) {
        //    return 1 + minDepth(root.right);
        //}
        //if (root.left != null && root.right == null) {
        //    return 1 + minDepth(root.left);
        //}
        //
        //return Math.min(minDepth(root.left), minDepth(root.right)) + 1;

        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        int level = 0;
        Queue<TreeNode> q = new ArrayDeque<>();
        q.add(root);

        while (!q.isEmpty()) {
            int size = q.size();
            level++;
            while (size > 0) {
                TreeNode node = q.poll();
                // **
                if (node.left == null && node.right == null) {
                    return level;
                }
                if (node.left != null) {
                    q.add(node.left);
                }
                if (node.right != null) {
                    q.add(node.right);
                }
                size--;
            }

        }
        return level;
    }

}
