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
     * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
     *
     * 给定 1->2->3->4, 你应该返回 2->1->4->3
     *
     * 说明:
     * 你的算法只能使用常数的额外空间。
     * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
     * @param head
     * @return
     */
    public ListNode swapPairs(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode dummyNode = new ListNode(0);
        dummyNode.next = head;
        ListNode curNode = head;
        ListNode result = dummyNode;

        while (dummyNode.next != null) {
            if (curNode.next != null) {
                ListNode cur2NextNode = curNode.next.next;
                dummyNode.next = curNode.next;
                curNode.next.next = curNode;
                curNode.next = cur2NextNode;

                dummyNode = curNode;
                curNode = curNode.next;
            } else {
                dummyNode = dummyNode.next;
            }
        }

        return result.next;
    }

}
