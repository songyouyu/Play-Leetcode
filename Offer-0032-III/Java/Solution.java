import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution {
    
    /**
     * https://leetcode.cn/problems/cong-shang-dao-xia-da-yin-er-cha-shu-iii-lcof/
     * 
     * @param root
     * @return
     */
    public List<List<Integer>> decorateRecord(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Stack<TreeNode>[] stacks = new Stack[2];
        for (int i = 0; i < 2; i ++) {
            stacks[i] = new Stack<>();
        }
        stacks[0].push(root);
        int j = 0;
        while (!stacks[j].isEmpty()) {
            List<Integer> list = new ArrayList<>();
            while (!stacks[j].isEmpty()) {
                TreeNode node = stacks[j].pop();
                list.add(node.val);
                if (j == 0) {
                    if (node.left != null) {
                        stacks[1].push(node.left);
                    }
                    if (node.right != null) {
                        stacks[1].push(node.right);
                    }
                } else {
                    if (node.right != null) {
                        stacks[0].push(node.right);
                    }
                    if (node.left != null) {
                        stacks[0].push(node.left);
                    }
                }
            }
            result.add(list);
            j = (j + 1) % 2;
        }

        return result;
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