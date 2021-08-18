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
     * 给定一个二叉树，返回它的 后序 遍历。
     * @param root
     * @return
     */
//    public List<Integer> postorderTraversal(TreeNode root) {
//        List<Integer> list = new ArrayList<>();
//
//        postorderTraversal(root, list);
//
//        return list;
//    }
//
//    private void postorderTraversal(TreeNode node, List<Integer> list) {
//        if (node != null) {
//            postorderTraversal(node.left, list);
//            postorderTraversal(node.right, list);
//            list.add(node.val);
//        }
//    }

    /**
     * 非递归实现(借助另一个栈)
     * @param root
     * @return
     */
    public List<Integer> postorderTraversal(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        Stack<TreeNode> stack = new Stack<>();
        Stack<Integer> output = new Stack<>();

        stack.push(root);
        while (! stack.empty()) {

            TreeNode cur = stack.pop();
            output.push(cur.val);

            if (cur.left != null) {
                stack.push(cur.left);
            }

            if (cur.right != null) {
                stack.push(cur.right);
            }
        }

        while (!output.empty()) {
            res.add(output.pop());
        }

        return res;
    }

}
