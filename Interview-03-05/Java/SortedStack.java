import java.util.Stack;

/**
 * @author songyouyu
 * @date 2021/9/19
 */
public class SortedStack {

    private Stack<Integer> s1;
    private Stack<Integer> s2;

    /**
     * 栈排序。 编写程序，对栈进行排序使最小元素位于栈顶。最多只能使用一个其他的临时栈存放数据，
     * 但不得将元素复制到别的数据结构（如数组）中。
     * 该栈支持如下操作：push、pop、peek 和 isEmpty。当栈为空时，peek 返回 -1。
     *
     * 链接：https://leetcode-cn.com/problems/sort-of-stacks-lcci
     */
    public SortedStack() {
        s1 = new Stack<>();
        s2 = new Stack<>();
    }

    public void push(int val) {
        if (s1.isEmpty()) {
            s1.push(val);
        } else {
            while (!s1.isEmpty()) {
                Integer peek = s1.peek();
                if (val <= peek) {
                    s1.push(val);
                    while (!s2.isEmpty()) {
                        s1.push(s2.pop());
                    }
                    break;
                } else {
                    s2.push(s1.pop());
                }
            }
            if (s1.isEmpty()) {
                s1.push(val);
                while (!s2.isEmpty()) {
                    s1.push(s2.pop());
                }
            }
        }
    }

    public void pop() {
        if (!s1.isEmpty()) {
            s1.pop();
        }
    }

    public int peek() {
        if (s1.isEmpty()) {
            return -1;
        }
        return s1.peek();
    }

    public boolean isEmpty() {
        return s1.isEmpty();
    }

    public static void main(String[] args) {
        SortedStack s = new SortedStack();
        s.push(2);
        s.push(3);
        s.push(4);
        s.push(1);
    }

}
