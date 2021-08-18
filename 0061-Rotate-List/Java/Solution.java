/**
 * @author youyu.song
 * @date 2019/8/15 15:07
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
	 * 给定一个链表，旋转链表，将链表每个节点向右移动 k 个位置，其中 k 是非负数。
	 * <p>
	 * 输入: 1->2->3->4->5->NULL, k = 2
	 * 输出: 4->5->1->2->3->NULL
	 * <p>
	 * 输入: 0->1->2->NULL, k = 4
	 * 输出: 2->0->1->NULL
	 *
	 * @param head
	 * @param k
	 * @return
	 */
	public ListNode rotateRight(ListNode head, int k) {
		if (head == null || head.next == null || k == 0) {
			return head;
		}

		ListNode p = head;
		int length = 0;
		while (p != null) {
			length++;
			p = p.next;
		}
		if (k >= length) {
			k = k % length;
		}
		if (k == 0) {
			return head;
		}

		ListNode dummyNode = new ListNode(0);
		dummyNode.next = head;
		ListNode cur = head;
		int a = length - k;
		while (a > 0) {
			head = head.next;
			dummyNode = dummyNode.next;
			a --;
		}
		ListNode node = head;
		while (node.next != null) {
			node = node.next;
		}
		node.next = cur;
		dummyNode.next = null;

		return head;
	}

}
