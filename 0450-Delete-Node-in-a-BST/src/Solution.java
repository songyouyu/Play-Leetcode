/**
 * @author youyu.song
 * @date 2020/3/25 9:15
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
     * 给定一个二叉搜索树的根节点 root 和一个值 key，删除二叉搜索树中的 key 对应的节点，
     * 并保证二叉搜索树的性质不变。返回二叉搜索树（有可能被更新）的根节点的引用。
     *
     * 一般来说，删除节点可分为两个步骤：
     *
     * 首先找到需要删除的节点；
     * 如果找到了，删除它。
     * 说明： 要求算法时间复杂度为 O(h)，h 为树的高度。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/delete-node-in-a-bst
     *
     * @param root
     * @param key
     * @return
     */
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }

        if (key < root.val) {
            root.left = deleteNode(root.left, key);
            return root;
        } else if (key > root.val) {
            root.right = deleteNode(root.right, key);
            return root;
        } else {
            // 若待删除的节点左子树为空
            if (root.left == null) {
                TreeNode rightNode = root.right;
                root.right = null;
                return rightNode;
            }

            // 若待删除的节点右子树为空
            if (root.right == null) {
                TreeNode leftNode = root.left;
                root.left = null;
                return leftNode;
            }

            // 待删除的节点左右子树都不为空

            // 找到比待删除节点大的最小节点, 即待删除节点右子树的最小节点, 用这个节点顶替待删除节点的位置
            TreeNode successor = minimum(root.right);
            successor.right = removeMin(root.right);
            successor.left = root.left;
            root.left = null;
            root.right = null;

            return successor;
        }
    }

    /**
     * 找到二叉搜索树的最小节点
     * @param node
     * @return
     */
    private TreeNode minimum(TreeNode node) {
        if (node.left == null) {
            return node;
        }

        return minimum(node.left);
    }

    /**
     * 删除以 node 为根的二分搜索树的最小节点, 返回新的二分搜索树的根
     * @param node
     * @return
     */
    private TreeNode removeMin(TreeNode node) {
        if (node.left == null) {
            TreeNode rightNode = node.right;
            node.right = null;
            return rightNode;
        }
        node.left = removeMin(node.left);

        return node;
    }

}
