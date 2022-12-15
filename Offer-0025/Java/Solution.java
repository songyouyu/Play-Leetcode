/**
 * @author songyouyu
 * @date 2021/8/29
 */
public class Solution {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummyNode = new ListNode(-1);
        ListNode head1 = l1;
        ListNode head2 = l2;
        ListNode p = dummyNode;

        while (head1 != null && head2 != null) {
            if (head1.val < head2.val) {
                p.next = head1;
                head1 = head1.next;
            } else {
                p.next = head2;
                head2 = head2.next;
            }

            p = p.next;
        }

        if (head1 != null) {
            p.next = head1;
        }
        if (head2 != null) {
            p.next = head2;
        }

        ListNode ret = dummyNode.next;
        dummyNode.next = null;

        return ret;
    }

    public ListNode mergeTwoLists1(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        if (l1.val < l2.val) {
            ListNode newHead = mergeTwoLists1(l1.next, l2);
            l1.next = newHead;
            return l1;
        } else {
            ListNode newHead = mergeTwoLists1(l1, l2.next);
            l2.next = newHead;
            return l2;
        }
    }

}
