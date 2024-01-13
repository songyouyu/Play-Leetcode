import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    
    /**
     * https://leetcode.cn/problems/find-bottom-left-tree-value/
     * 
     * @param root
     * @return
     */
    public int findBottomLeftValue(TreeNode root) {
        int leftValue = root.val;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node.right != null) {
                leftValue = node.right.val;
                queue.add(node.right);
            }
            if (node.left != null) {
                leftValue = node.left.val;
                queue.add(node.left);
            }
        }
        return leftValue;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}   