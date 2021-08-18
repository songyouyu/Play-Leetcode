/**
 * @author youyu.song
 * @date 2019/5/8
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
     * 给定一个链表和一个特定值 x，对链表进行分隔，使得所有小于 x 的节点都在大于或等于 x 的节点之前。
     * 你应当保留两个分区中每个节点的初始相对位置。
     *
     * 输入: head = 1->4->3->2->5->2, x = 3
     * 输出: 1->2->2->4->3->5
     *
     * @param head
     * @param x
     * @return
     */
    public ListNode partition(ListNode head, int x) {
        ListNode dummyNode = new ListNode(0);
        dummyNode.next = head;
        ListNode greaterNode = dummyNode;

        while (greaterNode.next != null && greaterNode.next.val < x) {
            greaterNode = greaterNode.next;
        }

        ListNode curNode = greaterNode.next;
        while (curNode != null && curNode.next != null) {
            if (curNode.next.val < x) {
                ListNode tempNode = greaterNode.next;
                greaterNode.next = curNode.next;
                curNode.next = curNode.next.next;
                greaterNode.next.next = tempNode;
                greaterNode = greaterNode.next;
            } else {
                curNode = curNode.next;
            }
        }

        return dummyNode.next;
    }

}
