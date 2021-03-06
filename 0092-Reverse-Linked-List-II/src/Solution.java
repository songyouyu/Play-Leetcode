/**
 * @author youyu.song
 * @date 2019/4/17
 */
public class Solution {

    public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
    }

    /**
     * 反转从位置 m 到 n 的链表。请使用一趟扫描完成反转。
     * 说明:
     * 1 ≤ m ≤ n ≤ 链表长度。
     *
     * 输入: 1->2->3->4->5->NULL, m = 2, n = 4
     * 输出: 1->4->3->2->5->NULL
     *
     * @param head
     * @param m
     * @param n
     * @return
     */
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;
        ListNode startNode = dummyNode;

        n -= m;
        m --;

        while (m != 0) {
            startNode = startNode.next;
            m --;
        }

        ListNode curNode = startNode.next;

        while (n != 0) {
            ListNode tempNode = startNode.next;
            startNode.next = curNode.next;
            curNode.next = curNode.next.next;
            startNode.next.next = tempNode;

            n --;
        }

        return dummyNode.next;
    }

}
