import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution {

    List<Integer> res = new ArrayList<>();
    
    /**
     * https://leetcode.cn/problems/n-ary-tree-postorder-traversal/
     * 
     * @param root
     * @return
     */
    public List<Integer> postorder(Node root) {
        if (root == null) {
            return res;
        }

        for (Node node : root.children) {
            postorder(node);
        }
        res.add(root.val);
        return res;
    }

    public List<Integer> postorder1(Node root) {
        List<Integer> res1 = new ArrayList<>();
        if (root == null) {
            return res1;
        }

        Stack<Node> stack = new Stack<>();
        Stack<Node> newStack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node node = stack.pop();
            newStack.push(node);
            for (int i = 0; i < node.children.size(); i ++) {
                stack.push(node.children.get(i));
            }
        }

        while (!newStack.isEmpty()) {
            res1.add(newStack.pop().val);
        }

        return res1;
    }

}

class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};