import java.util.Stack;

/**
 * @author songyouyu
 * @date 2021/9/19
 */
public class CQueue {

    private Stack<Integer> stack1;
    private Stack<Integer> stack2;

    /**
     * 用两个栈实现一个队列。队列的声明如下，请实现它的两个函数 appendTail 和 deleteHead ，
     * 分别完成在队列尾部插入整数和在队列头部删除整数的功能。
     * (若队列中没有元素，deleteHead 操作返回 -1 )
     *
     * 链接：https://leetcode-cn.com/problems/yong-liang-ge-zhan-shi-xian-dui-lie-lcof
     */
    public CQueue() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    public void appendTail(int value) {
        stack1.push(value);
    }

    public int deleteHead() {
        if (!stack1.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
            int result = stack2.pop();
            while (!stack2.isEmpty()) {
                stack1.push(stack2.pop());
            }
            return result;
        }
        return -1;
    }

    public static void main(String[] args) {
        CQueue c = new CQueue();
        c.appendTail(2);
        System.out.println(c.deleteHead());
        System.out.println(c.deleteHead());
    }

}
