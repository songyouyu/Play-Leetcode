/**
 * @author youyu.song
 * @date 2019/6/26
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
	 * 给定两个非空链表来代表两个非负整数。数字最高位位于链表开始位置。
	 * 它们的每个节点只存储单个数字。将这两数相加会返回一个新的链表。
	 *
	 * 你可以假设除了数字 0 之外，这两个数字都不会以零开头。
	 *
	 * 输入: (7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
	 * 输出: 7 -> 8 -> 0 -> 7
	 *
	 * 来源：力扣（LeetCode）
	 * 链接：https://leetcode-cn.com/problems/add-two-numbers-ii
	 *
	 * @param l1
	 * @param l2
	 * @return
	 */
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode listNode1 = reverseList(l1);
		ListNode listNode2 = reverseList(l2);

		ListNode result = new ListNode(0);
		ListNode tmp = result;
		int num = 0;

		while (listNode1 != null || listNode2 != null) {
			int cur = num;
			if (listNode1 != null) {
				cur += listNode1.val;
				listNode1 = listNode1.next;
			}
			if (listNode2 != null) {
				cur += listNode2.val;
				listNode2 = listNode2.next;
			}

			tmp.next = new ListNode(cur % 10);
			tmp = tmp.next;
			num = cur / 10;
		}

		if (num != 0) {
			tmp.next = new ListNode(num);
		}

		return reverseList(result.next);
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
