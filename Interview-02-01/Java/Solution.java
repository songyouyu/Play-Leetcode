import java.util.Map;

public class Solution {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
    
    public ListNode removeDuplicateNodes(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummyNode = head;
        Map<Integer, Boolean> map = new HashMap<>();
        map.put(head.val, true);
        while (head.next != null) {
            ListNode next = head.next;
            Boolean exist = map.get(next.val);
            if (exist != null && exist) {
                head.next = next.next;
                next.next = null;                
            } else {
                map.put(next.val, true);
                head = head.next;
            }
        }

        return dummyNode;
    }

}
