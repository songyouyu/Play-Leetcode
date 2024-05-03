import java.util.List;

public class Solution {
    
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
    }

    /**
     * https://leetcode.cn/problems/maximum-depth-of-n-ary-tree
     * 
     * @param root
     * @return
     */
    public int maxDepth(Node root) {
        return maxDepth(root, 0);
    }

    public int maxDepth(Node root, int level) {
        if (root == null) {
            return level;
        }
        level ++;
        int childMaxLevel = 0;
        for (Node child : root.children) {
            int childLevel = maxDepth(child, level);
            childMaxLevel = Math.max(childMaxLevel, childLevel);
        }
        return Math.max(level, childMaxLevel);
    }

    public int maxDepth2(Node root) {
        if (root == null) {
            return 0;
        }

        int childMaxLevel = 0;
        for (Node node : root.children) {
            int level = maxDepth2(node);
            childMaxLevel = Math.max(childMaxLevel, level);
        }
        
        return childMaxLevel + 1;
    }

}
