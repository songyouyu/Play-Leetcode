/**
 * @author youyu.song
 * @date 2019/5/25
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
     * 给出两个 非空 的链表用来表示两个非负的整数。
     * 其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
     * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
     * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
     *
     * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
     * 输出：7 -> 0 -> 8
     * 原因：342 + 465 = 807
     *
     * 9 -> 8      1
     *
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(0);
        ListNode tmp = result;
        int num = 0;

        while (l1 != null || l2 != null) {
            int cur = num;
            if (l1 != null) {
                cur += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                cur += l2.val;
                l2 = l2.next;
            }

            tmp.next = new ListNode(cur % 10);
            tmp = tmp.next;
            num = cur / 10;
        }

        if (num != 0) {
            tmp.next = new ListNode(num);
        }

        return result.next;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode listNode1 = new ListNode(1);
        listNode1.next = new ListNode(8);
        //listNode1.next.next = new ListNode(3);

        ListNode listNode2 = new ListNode(0);
        //listNode2.next = new ListNode(6);
        //listNode2.next.next = new ListNode(4);

        ListNode listNode = solution.addTwoNumbers(listNode1, listNode2);
    }

}
