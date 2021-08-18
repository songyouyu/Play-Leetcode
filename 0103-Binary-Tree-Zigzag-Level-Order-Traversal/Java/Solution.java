import java.util.*;

/**
 * @author youyu.song
 * @date 2019/10/12 15:01
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
	 * 给定一个二叉树，返回其节点值的锯齿形层次遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
	 *
	 * 例如：
	 * 给定二叉树 [3,9,20,null,null,15,7],
	 *
	 *     3                  1
	 *    / \                / \
	 *   9  20              2   3
	 *     /  \            /     \
	 *    15   7          4       5
	 * 返回锯齿形层次遍历如下：
	 *
	 * [
	 *   [3],
	 *   [20,9],
	 *   [15,7]
	 * ]
	 *
	 * 来源：力扣（LeetCode）
	 * 链接：https://leetcode-cn.com/problems/binary-tree-zigzag-level-order-traversal
	 *
	 * @param root
	 * @return
	 */
	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
		if (root == null) {
			return new ArrayList<>();
		}

		boolean flag = true;
		LinkedList<List<Integer>> result = new LinkedList<>();
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);

		while (! queue.isEmpty()) {
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
			if (! flag) {
				Collections.reverse(list);
			}
			result.add(list);
			flag = ! flag;
		}

		return result;
	}

}
