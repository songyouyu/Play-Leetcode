import javax.xml.stream.FactoryConfigurationError;
import java.util.ArrayList;
import java.util.List;

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
     * 给定一个带有头结点 head 的非空单链表，返回链表的中间结点。
     * 如果有两个中间结点，则返回第二个中间结点。
     *
     * @param head
     * @return
     */
    public ListNode middleNode(ListNode head) {
        //ListNode node = head;
        //List<Integer> list = new ArrayList<>();
        //int num;
        //int i = 0;
        //
        //while (head != null) {
        //    num = head.val;
        //    list.add(i, num);
        //    i ++;
        //
        //    head = head.next;
        //}
        //
        //int a = list.size() / 2;
        //int result = list.get(a);
        //
        //int j = 0;
        //while (node != null) {
        //    if (node.val == result && j == a) {
        //        return node;
        //    }
        //    j ++;
        //    node = node.next;
        //}
        //
        //return null;

        // 使用双指针
        if (head.next == null) {
            return head;
        }
        if (head.next.next == null) {
            return head.next;
        }

        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;
        ListNode slow = dummyNode;
        ListNode fast = dummyNode;

        while (fast != null) {
            if ((fast.next == null) || (fast.next != null && fast.next.next == null)) {
                slow = slow.next;
                break;
            }
            fast = fast.next.next;
            slow = slow.next;
        }

        return slow;
    }

}
