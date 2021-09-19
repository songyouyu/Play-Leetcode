import java.util.LinkedList;
import java.util.Queue;

/**
 * @author songyouyu
 * @date 2021/9/19
 */
public class MyStack {

    private Queue<Integer> q1;
    private Queue<Integer> q2;

    /**
     * 请你仅使用两个队列实现一个后入先出（LIFO）的栈，并支持普通栈的全部四种操作（push、top、pop 和 empty）。
     *
     * 链接：https://leetcode-cn.com/problems/implement-stack-using-queues/
     */
    public MyStack() {
        q1 = new LinkedList<>();
        q2 = new LinkedList<>();
    }

    public void push(int x) {
        q1.add(x);
    }

    public int pop() {
        while (true) {
            Integer tmp = q1.poll();
            if (q1.isEmpty()) {
                Queue<Integer> tmpQ = q1;
                q1 = q2;
                q2 = tmpQ;
                return tmp;
            }
            q2.add(tmp);
        }
    }

    public int top() {
        while (true) {
            Integer tmp = q1.poll();
            q2.add(tmp);
            if (q1.isEmpty()) {
                Queue<Integer> tmpQ = q1;
                q1 = q2;
                q2 = tmpQ;
                return tmp;
            }
        }
    }

    public boolean empty() {
        return q1.isEmpty();
    }

    public static void main(String[] args) {
        MyStack m = new MyStack();
        m.push(1);
        System.out.println(m.top());
        System.out.println(m.pop());
        System.out.println(m.empty());

    }

}
