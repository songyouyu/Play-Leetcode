/**
 * @author youyusong
 * @date 2018/12/13
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
     * 反转一个单链表。
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {

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
