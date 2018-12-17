import java.util.ArrayList;
import java.util.List;

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
     * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
     * <p>
     * 给定一个链表: 1->2->3->4->5, 和 n = 2.
     * 当删除了倒数第二个节点后，链表变为 1->2->3->5.
     * <p>
     * 说明：
     * 给定的 n 保证是有效的。
     *
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null || head.next == null) {
            return null;
        }

        ListNode curNode = head;
        // 把链表中的值依次放入 list 中，以确定第 n 个节点的值
        List<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        // 需要删除的节点的值
        int delNodeVal = list.get(list.size() - n);

        // 保证链表中有相同元素时，能正确的删除
        int i = 0;
        ListNode dummyNode = new ListNode(0);
        dummyNode.next = curNode;
        ListNode result = dummyNode;

        while (dummyNode.next != null) {
            if (dummyNode.next.val == delNodeVal && i == list.size() - n) {
                ListNode delNode = dummyNode.next;
                dummyNode.next = delNode.next;
                delNode = null;
            } else {
                dummyNode = dummyNode.next;
            }
            i++;
        }

        return result.next;
    }

}
