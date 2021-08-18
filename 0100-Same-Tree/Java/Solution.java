/**
 * @author youyusong
 * @date 2018/12/26
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
     * 给定两个二叉树，编写一个函数来检验它们是否相同。
     * 如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。
     *
     * @param p
     * @param q
     * @return
     */
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if ((p == null && q == null) ||
                (p != null && q != null && p.val == q.val && isSameTree(p.left, q.left) &&
                (isSameTree(p.right, q.right)))) {
            return true;
        }

        return false;
    }

    /**
     * 该方法会超时
     */
//    public boolean isSameTree(TreeNode p, TreeNode q) {
//        String ps = "#";
//        ps = pre(p, ps);
//
//        String qs = "#";
//        qs = pre(q, qs);
//
//        return ps.equals(qs);
//    }
//
//    private String pre(TreeNode node, String s) {
//        if (node == null) {
//            s += "NULL#";
//            return s;
//        }
//
//        s += node.val + "#";
//        s += pre(node.left, s);
//        s += pre(node.right, s);
//
//        return s;
//    }

    public static void main(String[] args) {
        Solution.TreeNode p = new Solution().new TreeNode(1);
        p.left = new Solution().new TreeNode(2);
        p.right = new Solution().new TreeNode(3);

        Solution.TreeNode q = new Solution().new TreeNode(1);
        q.left = new Solution().new TreeNode(2);
        q.right = new Solution().new TreeNode(3);

        Solution solution = new Solution();
        boolean b = solution.isSameTree(p, q);
        System.out.println(b);
    }

}
