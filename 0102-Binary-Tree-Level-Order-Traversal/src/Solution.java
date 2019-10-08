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

		List<List<Integer>> result = new ArrayList<>();
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

}
