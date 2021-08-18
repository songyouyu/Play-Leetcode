import java.util.LinkedList;
import java.util.Queue;

/**
 * @author youyu.song
 * @date 2020/1/13 11:14
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
     * 给定一个二叉树，找出其最大深度。
     * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
     *
     * 说明: 叶子节点是指没有子节点的节点。
     *
     * @param root
     * @return
     */
    public int maxDepth(TreeNode root) {
        //if (root == null) {
        //    return 0;
        //}
        //
        //return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;

        if (root == null) {
            return 0;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        int preCount = 1;
        int pCount = 0;

        int level = 0;

        while (!q.isEmpty()) {
            TreeNode temp = q.poll();
            preCount--;

            if (temp.left != null) {
                q.offer(temp.left);
                pCount++;
            }
            if (temp.right != null) {
                q.offer(temp.right);
                pCount++;
            }

            if (preCount == 0) {
                preCount = pCount;
                pCount = 0;
                level++;
            }
        }
        return level;
    }

}
