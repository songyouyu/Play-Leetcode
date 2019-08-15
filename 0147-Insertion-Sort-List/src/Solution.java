/**
 * @author youyu.song
 * @date 2019/7/13 11:16
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
	 * 从第一个元素开始，该链表可以被认为已经部分排序（用黑色表示）。
	 * 每次迭代时，从输入数据中移除一个元素（用红色表示），并原地将其插入到已排好序的链表中。
	 *
	 * 输入: 4->2->1->3
	 * 输出: 1->2->3->4
	 *
	 * @param head
	 * @return
	 */
	public ListNode insertionSortList(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}

		ListNode dummyNode = new ListNode(-1);
		dummyNode.next = head;
		ListNode curNode = head.next;

		while (curNode != null) {
			if (curNode.val < head.val) {
				head.next = curNode.next;
				if (curNode.val <= dummyNode.next.val) {
					ListNode minNode = dummyNode.next;
					dummyNode.next = curNode;
					curNode.next = minNode;
				} else {
					ListNode maxNode = dummyNode.next;
					while (curNode.val > maxNode.val) {
						if (curNode.val <= maxNode.next.val) {
							curNode.next = maxNode.next;
							maxNode.next = curNode;
							break;
						}
						maxNode = maxNode.next;
					}
				}
				curNode = head.next;
			} else {
				head = curNode;
				curNode = curNode.next;
			}
		}

		return dummyNode.next;
	}

}
