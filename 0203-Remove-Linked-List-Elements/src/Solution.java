/**
 * @author youyusong
 * @date 2018/12/13
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
     * 删除链表中等于给定值 val 的所有节点。
     *
     * 输入: 1->2->6->3->4->5->6, val = 6
     * 输出: 1->2->3->4->5
     * @param head
     * @param val
     * @return
     */
    public ListNode removeElements(ListNode head, int val) {

        // 使用虚拟头结点
        ListNode dummyNode = new ListNode(0);

        dummyNode.next = head;
        ListNode curNode = dummyNode;

        while (curNode.next != null) {
            if (curNode.next.val == val) {
                ListNode delNode = curNode.next;
                curNode.next = delNode.next;
            } else {
                curNode = curNode.next;
            }
        }

        return dummyNode.next;
    }

}
