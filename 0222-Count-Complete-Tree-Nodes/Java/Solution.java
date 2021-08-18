/**
 * @author youyu.song
 * @date 2020/3/8 10:04
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
     * 给出一个完全二叉树，求出该树的节点个数。
     *
     * 完全二叉树的定义如下：在完全二叉树中，除了最底层节点可能没填满外，其余每层节点数都达到最大值，
     * 并且最下面一层的节点都集中在该层最左边的若干位置。若最底层为第 h 层，则该层包含 1~ 2h 个节点。
     *
     * 示例:
     * 输入:
     *     1
     *    / \
     *   2   3
     *  / \  /
     * 4  5 6
     *
     * 输出: 6
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/count-complete-tree-nodes
     *
     * @param root
     * @return
     */
    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int num = 1;
        return countNodes(root, num);
    }

    private int countNodes(TreeNode root, int num) {
        if (root.left == null) {
            return num;
        }
        if (root.left != null && root.right == null) {
            num ++;
            return num;
        }
        if (root.left != null && root.right != null) {
            num += 2;
        }

        num = countNodes(root.left, num);
        num = countNodes(root.right, num);

        return num;
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(2);
        treeNode.right = new TreeNode(3);
        treeNode.left.left = new TreeNode(4);
        treeNode.left.right = new TreeNode(5);
        treeNode.right.left = new TreeNode(6);

        Solution solution = new Solution();
        System.out.println(solution.countNodes(treeNode));
    }

}
