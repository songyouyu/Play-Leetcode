/**
 * @author songyouyu
 * @date 2021/10/6
 */
public class TripleInOne {

    private int[] arr;
    private int[] size;
    private int stackSize;

    /**
     * 三合一。描述如何只用一个数组来实现三个栈。
     *
     * 你应该实现push(stackNum, value)、pop(stackNum)、isEmpty(stackNum)、peek(stackNum)方法。
     * stackNum表示栈下标，value表示压入的值。
     *
     * 构造函数会传入一个stackSize参数，代表每个栈的大小。
     *
     * 链接：https://leetcode-cn.com/problems/three-in-one-lcci
     * @param stackSize
     */
    public TripleInOne(int stackSize) {
        arr = new int[3 * stackSize];
        size = new int[]{0, 0, 0};
        this.stackSize = stackSize;
    }

    public void push(int stackNum, int value) {
        int len = size[stackNum];
        if (len < stackSize) {
            arr[stackNum * stackSize + len] = value;
            size[stackNum] ++;
        }
    }

    public int pop(int stackNum) {
        if (size[stackNum] == 0) {
            return -1;
        }
        int result = arr[stackNum * stackSize + size[stackNum] - 1];
        size[stackNum] --;
        return result;
    }

    public int peek(int stackNum) {
        if (size[stackNum] == 0) {
            return -1;
        }

        return arr[stackNum * stackSize + size[stackNum] - 1];
    }

    public boolean isEmpty(int stackNum) {
        return size[stackNum] == 0;
    }

}