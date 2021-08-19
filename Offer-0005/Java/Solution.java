/**
 * @author songyouyu
 * @date 2021/8/19
 */
public class Solution {

    /**
     * 请实现一个函数，把字符串 s 中的每个空格替换成"%20"。
     *
     * @param s
     * @return
     */
    public String replaceSpace(String s) {
        StringBuilder result = new StringBuilder();
        char[] chars = s.toCharArray();

        for (char aChar : chars) {
            if (aChar == ' ') {
                result.append("%20");
            } else {
                result.append(aChar);
            }
        }

        return result.toString();
    }

}
