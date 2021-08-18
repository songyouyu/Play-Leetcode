import java.util.HashMap;

/**
 * @author youyu.song
 * @date 2019/3/30
 */
public class Solution {

    /**
     * 给定一种 pattern(模式) 和一个字符串 str ，判断 str 是否遵循相同的模式。
     * 这里的遵循指完全匹配，例如， pattern 里的每个字母和字符串 str 中的每个非空单词之间存在着双向连接的对应模式。
     *
     * 输入: pattern = "abba", str = "dog cat cat dog"
     * 输出: true
     *
     * 说明:
     * 你可以假设 pattern 只包含小写字母， str 包含了由单个空格分隔的小写字母。
     *
     * @param pattern
     * @param str
     * @return
     */
    public boolean wordPattern(String pattern, String str) {
        String[] split = str.split(" ");
        if (pattern.length() != split.length) {
            return false;
        }

        HashMap<Character, String> map = new HashMap<Character, String>();
        for (int i = 0; i < pattern.length(); i ++) {
            char c = pattern.charAt(i);
            String world = split[i];
            if (map.containsKey(c)) {
                if (! map.get(c).equals(world)) {
                    return false;
                }
            } else {
                if (map.containsValue(world)) {
                    return false;
                }
                map.put(c, world);
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String pattern = "abba";
        String str = "dog cat cat dog";
        boolean b = solution.wordPattern(pattern, str);
        System.out.println(b);
    }

}
