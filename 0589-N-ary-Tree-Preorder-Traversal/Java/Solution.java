import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution {

    List<Integer> res = new ArrayList<>();
    
    /**
     * https://leetcode.cn/problems/n-ary-tree-preorder-traversal/
     * 
     * @param root
     * @return
     */
    public List<Integer> preorder(Node root) {
        if (root == null) {
            return res;
        }

        res.add(root.val);
        for (Node node : root.children) {
            preorder(node);
        }
        return res;
    }

    /**
     * @param root
     * @return
     */
    public List<Integer> preorder1(Node root) {
        List<Integer> res1 = new ArrayList<>();
        if (root == null) {
            return res1;
        }
        
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node node = stack.pop();
            res1.add(node.val);
            for (int i = node.children.size() - 1; i >= 0; i --) {
                stack.push(node.children.get(i));
            }
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