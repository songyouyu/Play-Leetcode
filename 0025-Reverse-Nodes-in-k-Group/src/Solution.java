/**
 * @author youyu.song
 * @date 2019/7/3 10:35
 */
public class Solution {

	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	/**
	 * 给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。
	 * k 是一个正整数，它的值小于或等于链表的长度。
	 * 如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
	 *
	 * 示例 :
	 * 给定这个链表：1->2->3->4->5
	 * 当 k = 2 时，应当返回: 2->1->4->3->5
	 * 当 k = 3 时，应当返回: 3->2->1->4->5
	 *
	 * 来源：力扣（LeetCode）
	 * 链接：https://leetcode-cn.com/problems/reverse-nodes-in-k-group
	 *
	 * @param head
	 * @param k
	 * @return
	 */
	public ListNode reverseKGroup(ListNode head, int k) {
		if (k == 1) {
			return head;
		}

		ListNode dummyNode = new ListNode(-1);
		dummyNode.next = head;
		ListNode cur = dummyNode;
		ListNode tail = dummyNode;

		while (true) {
			int count = k;
			while (count != 0 && tail != null) {
				tail = tail.next;
				count --;
			}

			if (tail == null) {
				break;
			}

			ListNode tempNode = cur.next;
			while (cur.next != tail) {
				ListNode nodeNode = cur.next;
				cur.next = nodeNode.next;
				nodeNode.next = tail.next;
				tail.next = nodeNode;
			}
			cur = tempNode;
			tail = tempNode;
		}

		return dummyNode.next;
	}

}

