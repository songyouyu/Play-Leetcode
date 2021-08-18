import java.util.ArrayList;
import java.util.List;

/**
 * @author youyu.song
 * @date 2020/3/18 11:00
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
     * 给定一个二叉树和一个目标和，找到所有从根节点到叶子节点路径总和等于给定目标和的路径。
     * 说明: 叶子节点是指没有子节点的节点。
     *
     * 示例:
     * 给定如下二叉树，以及目标和 sum = 22，
     *               5
     *              / \
     *             4   8
     *            /   / \
     *           11  13  4
     *          /  \    / \
     *         7    2  5   1
     * 返回:
     * [
     *    [5,4,11,2],
     *    [5,8,4,5]
     * ]
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/path-sum-ii
     */
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<List<Integer>> res = new ArrayList<>();
        sum -= root.val;
        if(root.left == null && root.right == null && sum == 0){
            List<Integer> list = new ArrayList<>();
            list.add(root.val);
            res.add(list);
            return res;
        }
        List<List<Integer>> left = pathSum(root.left,sum);
        List<List<Integer>> right = pathSum(root.right,sum);

        for(List<Integer> l : left){
            l.add(0,root.val);
            res.add(l);
        }
        for(List<Integer> r : right){
            r.add(0,root.val);
            res.add(r);
        }

        return res;
    }


    //public List<List<Integer>> pathSum(TreeNode root, int sum) {
    //    List<List<Integer>> result  = new ArrayList<List<Integer>>();
    //    sum(root, sum, new ArrayList<Integer>(), result);
    //    return result;
    //}
    //
    //public void sum(TreeNode node,int target,List<Integer> data,List<List<Integer>> result) {
    //    if (node==null) {
    //        return ;
    //    }
    //
    //    int newTarget = target-node.val;
    //    data.add(node.val);
    //    if (newTarget == 0 && node.left == null && node.right == null) {
    //        result.add(new ArrayList<>(data));
    //    } else {
    //        //判断左、右侧
    //        sum(node.left, newTarget, data, result);
    //        sum(node.right, newTarget,data, result);
    //    }
    //
    //    data.remove(data.size()-1);
    //}

    public static void main(String[] args) {
        TreeNode node = new TreeNode(5);
        node.left = new TreeNode(4);
        node.right = new TreeNode(11);
        node.left.left = new TreeNode(11);
        node.right.left = new TreeNode(4);
        node.right.right = new TreeNode(4);
        System.out.println(new Solution().pathSum(node, 20));
    }

}
