/**
 * @author youyusong
 * @date 2018/12/17
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
     * 给定一个单链表，把所有的奇数节点和偶数节点分别排在一起。
     * 请注意，这里的奇数节点和偶数节点指的是节点编号的奇偶性，而不是节点的值的奇偶性。
     * 请尝试使用原地算法完成。你的算法的空间复杂度应为 O(1)，时间复杂度应为 O(nodes)，nodes 为节点总数。
     *
     * 输入: 1->2->3->4->5->NULL
     * 输出: 1->3->5->2->4->NULL
     *
     * 说明:
     * 应当保持奇数节点和偶数节点的相对顺序。
     * 链表的第一个节点视为奇数节点，第二个节点视为偶数节点，以此类推。
     * @param head
     * @return
     */
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) {
            return head;
        }

        ListNode oddNode = head;
        ListNode evenNode = head.next;

        ListNode result1 = oddNode;
        ListNode result2 = evenNode;

        while (evenNode.next != null) {
            oddNode.next = evenNode.next;
            oddNode = evenNode.next;
            if (oddNode.next != null) {
                evenNode.next = oddNode.next;
                evenNode = oddNode.next;
            } else {
                evenNode.next = null;
            }
        }
        oddNode.next = result2;

        return result1;
    }

    public ListNode oddEvenList1(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode l = head;
        ListNode r = head.next;
        ListNode r1 = r;

        while (l.next != null && r.next != null) {
            l.next = r.next;
            l = l.next;

            if (l.next != null) {
                r.next = l.next;
                r = r.next;
            }
        }

        if (r.next != null) {
            r.next = null;
        }

        l.next = r1;
        return dummy.next;
    }

}
