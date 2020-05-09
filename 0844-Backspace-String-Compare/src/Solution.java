import java.util.Stack;

/**
 * @author youyu.song
 * @date 2020/5/9 10:59
 */
public class Solution {


    /**
     * 给定 S 和 T 两个字符串，当它们分别被输入到空白的文本编辑器后，判断二者是否相等，并返回结果。 # 代表退格字符。
     * 注意：如果对空文本输入退格字符，文本继续为空。
     *
     * 输入：S = "ab#c", T = "ad#c"
     * 输出：true
     * 解释：S 和 T 都会变成 “ac”。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/backspace-string-compare
     *
     * @param S
     * @param T
     * @return
     */
    public boolean backspaceCompare(String S, String T) {
        char[] sChar = S.toCharArray();
        char[] tChar = T.toCharArray();

        Stack<Character> sStack = new Stack<>();
        Stack<Character> tStack = new Stack<>();

        for (int i = 0; i < sChar.length; i ++) {
            char c = sChar[i];
            if (c == '#' &&  !sStack.isEmpty()) {
                sStack.pop();
            } else if (c != '#') {
                sStack.push(c);
            }
        }

        for (int j = 0; j < tChar.length; j ++) {
            char c = tChar[j];
            if (c == '#' &&  !tStack.isEmpty()) {
                tStack.pop();
            } else if (c != '#') {
                tStack.push(c);
            }
        }

        while (!sStack.isEmpty() && !tStack.isEmpty()) {
            if (sStack.pop() != tStack.pop()) {
                return false;
            }
        }
        if ((!sStack.isEmpty() && tStack.isEmpty()) || (sStack.isEmpty() && !tStack.isEmpty())) {
            return false;
        }

        return true;
    }

    public static void main(String[] args) {
        String S = "y#fo##f";
        String T = "y#f#o##f";
        System.out.println(new Solution().backspaceCompare(S, T));
    }

}
