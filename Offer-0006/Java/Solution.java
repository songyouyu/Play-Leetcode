import java.util.Stack;

/**
 * @author songyouyu
 * @date 2022/11/12
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
     * 输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
     *
     * 链接：https://leetcode.cn/problems/cong-wei-dao-tou-da-yin-lian-biao-lcof
     *
     * @param head
     * @return
     */
    public int[] reversePrint(ListNode head) {
        if (head == null) {
            return new int[0];
        }

        Stack<Integer> stack = new Stack<>();
        int len = 0;
        while (head != null) {
            stack.push(head.val);
            head = head.next;
            len ++;
        }

        int[] arr = new int[len];
        for (int i = 0; i < len; i ++) {
            arr[i] = stack.pop();
        }

        return arr;
    }

    /**
     * 递归
     * @param head
     * @return
     */
    public int[] reversePrint1(ListNode head) {
        if (head == null) {
            return new int[0];
        }
        ListNode node = head;
        int len = 0;
        while (node != null) {
            len ++;
            node = node.next;
        }
        arr = new int[len];
        arr[len - 1] = head.val;
        reversePrint2(head);

        return arr;
    }

    int i = 0;
    int[] arr;

    private void reversePrint2(ListNode head) {
        if (head.next == null) {
            return;
        }

        head = head.next;
        reversePrint2(head);
        arr[i] = head.val;
        i ++;
    }

}
