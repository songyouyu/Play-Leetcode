/**
 * @author songyouyu
 * @date 2022/11/13
 */
public class Solution {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    /**
     * 定义一个函数，输入一个链表的头节点，反转该链表并输出反转后链表的头节点。
     *
     * 链接：https://leetcode.cn/problems/fan-zhuan-lian-biao-lcof
     *
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode cur = head;

        while (head != null) {
            head = head.next;
            cur.next = prev;
            prev = cur;
            cur = head;
        }

        return prev;
    }

}
