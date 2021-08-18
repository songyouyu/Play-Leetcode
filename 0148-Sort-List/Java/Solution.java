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
     * 在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序。
     *
     * 示例 1:
     * 输入: 4->2->1->3
     * 输出: 1->2->3->4
     *
     * 示例 2:
     * 输入: -1->5->3->4->0
     * 输出: -1->0->3->4->5
     * @param head
     * @return
     */
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode curNode = head.next;
        head.next = null;
        ListNode minNode = head;
        ListNode maxNode = head;
        ListNode nextNode;
        while (curNode != null) {
            nextNode = curNode.next;
            int value = curNode.val;
            if (value < minNode.val) {
                curNode.next = minNode;
                minNode = curNode;
            } else if (value >= maxNode.val){
                maxNode.next = curNode;
                maxNode = curNode;
                maxNode.next = null;
            } else {
                ListNode node = minNode;
                ListNode prevNode;
                while (node != null) {
                    prevNode = node.next;
                    if (curNode.val < prevNode.val) {
                        node.next = curNode;
                        curNode.next = prevNode;
                        break;
                    } else {
                        node = node.next;
                    }
                }
            }
            curNode = nextNode;
        }

        return minNode;
    }

}
