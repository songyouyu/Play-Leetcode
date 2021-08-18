import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

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
     * 给定一个二叉树，返回它的 前序 遍历。
     * @param root
     * @return
     */
//    public List<Integer> preorderTraversal(TreeNode root) {
//        List<Integer> list = new ArrayList<>();
//
//        preorderTraversal(root, list);
//
//        return list;
//    }
//
//    private void preorderTraversal(TreeNode node, List<Integer> list) {
//        if (node != null) {
//            list.add(node.val);
//            preorderTraversal(node.left, list);
//            preorderTraversal(node.right, list);
//        }
//    }

    /**
     * 非递归实现
     * @param root
     * @return
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while (! stack.isEmpty()) {
            TreeNode node = stack.pop();
            list.add(node.val);

            if (node.right != null) {
                stack.push(node.right);
            }

            if (node.left != null) {
                stack.push(node.left);
            }
        }

        return list;
    }

}
