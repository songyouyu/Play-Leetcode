/**
 * @author youyu.song
 * @date 2020/3/21 10:26
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
     * 给定一个二叉树，它的每个结点都存放一个 0-9 的数字，每条从根到叶子节点的路径都代表一个数字。
     * 例如，从根到叶子节点路径 1->2->3 代表数字 123。
     * 计算从根到叶子节点生成的所有数字之和。
     * 说明: 叶子节点是指没有子节点的节点。
     *
     * 示例 :
     * 输入: [1,2,3]
     *     1
     *    / \
     *   2   3
     * 输出: 25
     * 解释:
     * 从根到叶子节点路径 1->2 代表数字 12.
     * 从根到叶子节点路径 1->3 代表数字 13.
     * 因此，数字总和 = 12 + 13 = 25.
     *
     * @param root
     * @return
     */
    StringBuilder sum = new StringBuilder();
    int res = 0;
    public int sumNumbers(TreeNode root) {
        if (root == null) {
            return 0;
        }
        s(root);
        return res;
    }

    private void s(TreeNode node) {
        sum.append(node.val);
        if (node != null && node.left == null && node.right == null) {
            res += Integer.parseInt(sum.toString());
            return;
        }
        if (node.left != null) {
            s(node.left);
            sum = sum.deleteCharAt(sum.length() - 1);
        }
        if (node.right != null) {
            s(node.right);
            sum = sum.deleteCharAt(sum.length() - 1);
        }

        return;
    }

    //public int sumNumbers(TreeNode root) {
    //    if (root == null) {
    //        return 0;
    //    }
    //
    //    return calculate(root, 0);
    //}
    //
    //private int calculate(TreeNode root, int curr) {
    //    if (root == null) {
    //        return 0;
    //    }
    //
    //    int total = curr * 10 + root.val;
    //    if (root.left == null && root.right == null) {
    //        return total;
    //    }
    //
    //    return calculate(root.left, total) + calculate(root.right, total);
    //}

    public static void main(String[] args) {
        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(2);
        node.right = new TreeNode(3);
        node.left.left = new TreeNode(1);
        node.right.left = new TreeNode(2);
        node.right.right = new TreeNode(3);
        System.out.println(new Solution().sumNumbers(node));
    }

}
