/**
 * @author youyu.song
 * @date 2019/8/27 10:46
 */
public class Solution {

	public static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	/**
	 * 请判断一个链表是否为回文链表。
	 *
	 * 示例 1:
	 * 输入: 1->2
	 * 输出: false
	 *
	 * 示例 2:
	 * 输入: 1->2->2->1
	 * 输出: true
	 *
	 * @param head
	 * @return
	 */
	public boolean isPalindrome(ListNode head) {
		// 1 1 2 1
		if (head == null || head.next == null) {
			return true;
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

		while (cur != null) {
			if (cur.val != secondNode.val) {
				return false;
			} else {
				cur = cur.next;
				secondNode = secondNode.next;
			}
		}

		return true;
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

	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		head.next = new ListNode(1);
		head.next.next = new ListNode(2);
		head.next.next.next = new ListNode(1);

		Solution solution = new Solution();
		solution.isPalindrome(head);
	}

}
