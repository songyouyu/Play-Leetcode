import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author youyu.song
 * @date 2019/9/21 9:15
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

	List<List<Integer>> result = new ArrayList<>();

	/**
	 * 给定一个二叉树，返回其按层次遍历的节点值。 （即逐层地，从左到右访问所有节点）。
	 *
	 * 例如:
	 * 给定二叉树: [3,9,20,null,null,15,7],
	 *     3
	 *    / \
	 *   9  20
	 *     /  \
	 *    15   7
	 * 返回其层次遍历结果：
	 * [
	 *   [3],
	 *   [9,20],
	 *   [15,7]
	 * ]
	 *
	 * 来源：力扣（LeetCode）
	 * 链接：https://leetcode-cn.com/problems/binary-tree-level-order-traversal
	 *
	 * @param root
	 * @return
	 */
	public List<List<Integer>> levelOrder(TreeNode root) {
		if (root == null) {
			return new ArrayList<>();
		}

		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		while (! queue.isEmpty()) {
			List<Integer> list = new ArrayList<>();
			int size = queue.size();
			for (int i = 0; i < size; i ++) {
				TreeNode treeNode = queue.poll();
				list.add(treeNode.val);
				if (treeNode.left != null) {
					queue.add(treeNode.left);
				}
				if (treeNode.right != null) {
					queue.add(treeNode.right);
				}
			}
			result.add(list);
		}

		return result;
	}

	public class TreeNodeWithLevel {
        public TreeNode node;
        public int level;

        public TreeNodeWithLevel(TreeNode node, int level) {
            this.node = node;
            this.level = level;
        }
    }

    public List<List<Integer>> levelOrder1(TreeNode root) {
        if (root == null) {
            return result;
        }
        Queue<TreeNodeWithLevel> queue = new LinkedList<>();
        queue.add(new TreeNodeWithLevel(root, 0));
        while (!queue.isEmpty()) {
            TreeNodeWithLevel node = queue.poll();
            if (node.level > result.size() - 1) {
                result.add(new ArrayList<>());
            }
            result.get(node.level).add(node.node.val);
            if (node.node.left != null) {
                queue.add(new TreeNodeWithLevel(node.node.left, node.level + 1));
            }
            if (node.node.right != null) {
                queue.add(new TreeNodeWithLevel(node.node.right, node.level + 1));
            }
        }

        return result;
    }


    public List<List<Integer>> levelOrder2(TreeNode root) {
        if (root == null) {
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        queue.add(null);
        while (!queue.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            while (!queue.isEmpty()) {
                TreeNode node = queue.poll();
                if (node == null) {
                    break;
                }
                list.add(node.val);
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            if (!list.isEmpty()) {
                result.add(list);
                queue.add(null);
            }
        }

        return result;
    }


    public List<List<Integer>> levelOrder3(TreeNode root) {
        if (root == null) {
            return null;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i ++) {
                TreeNode node = queue.poll();
                list.add(node.val);
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            result.add(list);
        }

        return result;
    }
	

    public List<List<Integer>> levelOrder4(TreeNode root) {
        dfs(root, 0);
        return result;
    }

    private void dfs(TreeNode root, int level) {
        if (root == null) {
            return;
        }
        if (level > result.size() - 1) {
            result.add(new ArrayList<>());
        }
        result.get(level).add(root.val);
        dfs(root.left, level + 1);
        dfs(root.right, level + 1);
    }

}
