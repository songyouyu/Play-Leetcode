import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author youyu.song
 * @date 2019/9/16 17:31
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

	//public List<Integer> inorderTraversal(TreeNode root) {
	//	List<Integer> list = new ArrayList<>();
	//
	//	inorderTraversal(root, list);
	//
	//	return list;
	//}
	//
	//private void inorderTraversal(TreeNode node, List<Integer> list) {
	//	if (node != null) {
	//		inorderTraversal(node.left, list);
	//		list.add(node.val);
	//		inorderTraversal(node.right, list);
	//	}
	//}

	/**
	 * 非递归实现
	 * @param root
	 * @return
	 */
	public List<Integer> inorderTraversal(TreeNode root) {
		List<Integer> list = new ArrayList<>();
		if(root == null)
			return list;
		Stack<TreeNode> stack = new Stack<>();
		while(root != null || stack.size() > 0) {
			while(root != null) {
				stack.push(root);
				root = root.left;
			}
			root = stack.pop();
			list.add(root.val);
			root = root.right;
		}
		return list;


	}

}
