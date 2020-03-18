import java.util.ArrayList;
import java.util.List;

/**
 * @author youyu.song
 * @date 2020/3/18 10:29
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
     * 给定一个二叉树，返回所有从根节点到叶子节点的路径。
     * 说明: 叶子节点是指没有子节点的节点。
     *
     * 输入:
     *    1
     *  /   \
     * 2     3
     *  \
     *   5
     *
     * 输出: ["1->2->5", "1->3"]
     * 解释: 所有根节点到叶子节点的路径为: 1->2->5, 1->3
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/binary-tree-paths
     *
     * @param root
     * @return
     */
    public List<String> binaryTreePaths(TreeNode root) {
        ArrayList<String> res = new ArrayList<>();

        if (root == null) {
            return res;
        }

        if (root.left == null && root.right == null) {
            res.add(Integer.toString(root.val));
            return res;
        }

        List<String> left = binaryTreePaths(root.left);
        for(String s: left){
            StringBuilder sb = new StringBuilder(Integer.toString(root.val));
            sb.append("->");
            sb.append(s);
            res.add(sb.toString());
        }
        List<String> right = binaryTreePaths(root.right);
        for(String s: right){
            StringBuilder sb = new StringBuilder(Integer.toString(root.val));
            sb.append("->");
            sb.append(s);
            res.add(sb.toString());
        }
        return res;
    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(2);
        node.right = new TreeNode(3);
        //node.left.left = new TreeNode(11);
        node.left.right = new TreeNode(5);
        //node.right.left = new TreeNode(4);
        System.out.println(new Solution().binaryTreePaths(node));
    }

}
