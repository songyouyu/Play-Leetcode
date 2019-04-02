import java.util.HashMap;

/**
 * @author youyu.song
 * @date 2019/4/2
 */
public class Solution {

    /**
     * 给定两个字符串 s 和 t，判断它们是否是同构的。
     * 如果 s 中的字符可以被替换得到 t ，那么这两个字符串是同构的。
     * 所有出现的字符都必须用另一个字符替换，同时保留字符的顺序。两个字符不能映射到同一个字符上，但字符可以映射自己本身。
     *
     * 你可以假设 s 和 t 具有相同的长度。
     *
     * 输入: s = "egg", t = "add"
     * 输出: true
     *
     * @param s
     * @param t
     * @return
     */
    public boolean isIsomorphic(String s, String t) {
        HashMap<Character, Character> map = new HashMap<>();
        for (int i =0; i < s.length(); i ++) {
            char charS = s.charAt(i);
            char charT = t.charAt(i);
            if (map.containsKey(charS)) {
                if (! map.get(charS).equals(charT)) {
                    return false;
                }
            } else {
                if (map.containsValue(charT)) {
                    return false;
                }

                map.put(charS, charT);
            }
        }

        return true;

        //int[] numS = new int[256];
        //int[] numT = new int[256];
        //for (int i = 0; i < s.length(); i ++) {
        //    if (numS[s.charAt(i)] != numT[t.charAt(i)]) {
        //        return false;
        //    }
        //    numS[s.charAt(i)] = i + 1;
        //    numT[t.charAt(i)] = i + 1;
        //}
        //
        //return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "abb";
        String t = "bab";
        boolean b = solution.isIsomorphic(s, t);
        System.out.println(b);
    }
}
