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
     * 给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次
     *
     * 输入: 1->1->2
     * 输出: 1->2
     * @param head
     * @return
     */
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode dummyNode = new ListNode(-1);
        ListNode curNode = head;
        dummyNode.next = curNode;

        while (curNode.next != null) {
            if (curNode.val == curNode.next.val) {
                ListNode delNode = curNode.next;
                curNode.next = delNode.next;
            } else {
                curNode = curNode.next;
            }
        }

        return dummyNode.next;
    }

    public ListNode deleteDuplicates1(ListNode head) {
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;
        ListNode curNode = dummyNode.next;

        while (curNode != null) {
            if (curNode.next != null && curNode.val == curNode.next.val) {
                curNode.next = curNode.next.next;
            } else {
                curNode = curNode.next;
            }
        }

        return dummyNode.next;
    }

}
