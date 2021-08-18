/**
 * @author youyusong
 * @date 2018/12/25
 */
public class Solution {

    /**
     * 给定一个仅包含大小写字母和空格 ' ' 的字符串，返回其最后一个单词的长度。
     * 如果不存在最后一个单词，请返回 0 。
     *
     * 说明：一个单词是指由字母组成，但不包含任何空格的字符串。
     *
     * Hello World
     * @param s
     * @return
     */
    public int lengthOfLastWord(String s) {
        if (s.length() == 0) {
            return 0;
        }

        if (s.equals(" ")) {
            return 0;
        }

        int result = 0;
        int index = s.length() - 1;
        while (index >= 0 && s.charAt(index) == ' ') {
            index --;
        }

        while (index >= 0 && s.charAt(index) != ' ') {
            index --;
            result ++;
        }

        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "hello    ";
        int i = solution.lengthOfLastWord(s);
        System.out.println(i);
    }
}
