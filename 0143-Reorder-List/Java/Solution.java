/**
 * @author youyu.song
 * @date 2019/8/21 14:48
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
	 * 给定一个单链表 L：L0→L1→…→Ln-1→Ln ，
	 * 将其重新排列后变为： L0→Ln→L1→Ln-1→L2→Ln-2→…
	 *
	 * 给定链表 1->2->3->4, 重新排列为 1->4->2->3.
	 * 给定链表 1->2->3->4->5, 重新排列为 1->5->2->4->3.
	 *
	 * @param head
	 */
	public void reorderList(ListNode head) {
		if (head == null || head.next == null || head.next.next == null) {
			return;
		}

		ListNode dummyNode = new ListNode(-1);
		dummyNode.next = head;
		ListNode firstNode = dummyNode;
		ListNode secondNode = dummyNode;
		while (secondNode.next != null && secondNode.next.next != null) {
			firstNode = firstNode.next;
			secondNode = secondNode.next.next;
		}
		secondNode = null;
		ListNode cur = firstNode.next;
		firstNode.next = null;

		secondNode = reverseList(cur);
		cur = head;
		ListNode tempA = cur.next;
		ListNode tempB = secondNode.next;
		while (cur != null && secondNode != null) {
			cur.next = secondNode;
			if (tempA == null) {
				secondNode.next = tempB;
				break;
			}
			secondNode.next = tempA;
			cur = tempA;
			secondNode = tempB;
			tempA = tempA.next;
			tempB = tempB.next;
		}

	}

	private ListNode reverseList(ListNode head) {
		// 1->2->3->4->5->NULL
		// 5->4->3->2->1->NULL
		ListNode prev = null;
		ListNode cur = head;

		while (cur != null) {
			ListNode next = cur.next;
			cur.next = prev;
			prev = cur;
			cur = next;
		}

		return prev;
	}

}
