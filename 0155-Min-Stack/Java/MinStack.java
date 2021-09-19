import java.util.Stack;

/**
 * @author songyouyu
 * @date 2021/9/19
 */
public class MinStack {

    private Stack<Min> s;

    /**
     * 设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。
     *
     * push(x) —— 将元素 x 推入栈中。
     * pop()—— 删除栈顶的元素。
     * top()—— 获取栈顶元素。
     * getMin() —— 检索栈中的最小元素。
     *
     * 链接：https://leetcode-cn.com/problems/min-stack
     */
    public MinStack() {
        s = new Stack<>();
    }

    public void push(int val) {
        if (s.isEmpty()) {
            Min min = new Min(val, val);
            s.push(min);
        } else {
            Min peek = s.peek();
            if (val < peek.getCurMin()) {
                s.push(new Min(val, val));
            } else {
                s.push(new Min(val, peek.getCurMin()));
            }
        }
    }

    public void pop() {
        s.pop();
    }

    public int top() {
        return s.peek().getValue();
    }

    public int getMin() {
        return s.peek().getCurMin();
    }

    public static void main(String[] args) {
        MinStack m = new MinStack();
        m.push(-2);
        m.push(0);
        m.push(-3);
        System.out.println(m.getMin());
        m.pop();
        System.out.println(m.getMin());
    }

}

class Min {

    private Integer value;
    private Integer curMin;

    public Min(Integer value, Integer curMin) {
        this.value = value;
        this.curMin = curMin;
    }

    public Integer getValue() {
        return value;
    }

    public Integer getCurMin() {
        return curMin;
    }

}