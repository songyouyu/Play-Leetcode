/**
 * @author youyusong
 * @date 2018/12/24
 */
public class Solution {

    /**
     * 编写一个函数来查找字符串数组中的最长公共前缀。
     * 如果不存在公共前缀，返回空字符串 ''。
     *
     * 说明:
     * 所有输入只包含小写字母 a-z 。
     *
     * 输入: ["flower","flow","flight"]
     * 输出: "fl"
     * @param strs
     * @return
     */
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        if (strs.length == 1) {
            return strs[0];
        }

        String result = "";
        for (int i = 0; i < strs[0].length(); i ++) {
            char c = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j ++) {
                if (i >= strs[j].length() || c != strs[j].charAt(i)) {
                    return result;
                }
            }
            result += c;
        }

        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] strs = {"flower","flow","flight"};
        String s = solution.longestCommonPrefix(strs);
        System.out.println(s);
    }

}
