/**
 * @author youyusong
 * @date 2019/1/15
 */
public class Solution2 {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    /**
     * 使用双指针
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null || head.next == null) {
            return null;
        }

        ListNode dummyNode = new ListNode(0);
        dummyNode.next = head;

        ListNode p = dummyNode;
        ListNode q = dummyNode;

        for (int i = 0; i < n + 1; i ++) {
            q = q.next;
        }

        // 循环结束后,此时 p 指向待删除节点的前一个节点
        while (q != null) {
            p = p.next;
            q = q.next;
        }

        p.next = p.next.next;

        return dummyNode.next;
    }

}
