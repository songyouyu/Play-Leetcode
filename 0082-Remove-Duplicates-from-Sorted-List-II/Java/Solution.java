/**
 * @author youyusong
 * @date 2018/12/14
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
     * 给定一个排序链表，删除所有含有重复数字的节点，只保留原始链表中 没有重复出现 的数字。
     *
     * 输入: 1->2->3->3->4->4->5
     * 输出: 1->2->5
     * @param head
     * @return
     */
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode dummyNode = new ListNode(0);
        dummyNode.next = head;
        ListNode prevNode = dummyNode;
        ListNode curNode = head;

        while (prevNode.next != null && prevNode.next.next != null) {
            if (prevNode.next.val == prevNode.next.next.val) {
                curNode = curNode.next;
                while (curNode.next != null && curNode.val == curNode.next.val) {
                    curNode = curNode.next;
                }
                prevNode.next = curNode.next;
            } else {
                prevNode = prevNode.next;
                curNode = curNode.next;
            }
        }

        return dummyNode.next;
    }

}
