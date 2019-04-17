import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * @author youyu.song
 * @date 2019/4/3
 */
public class Solution {

    /**
     * 给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。
     *
     * 输入: ["eat", "tea", "tan", "ate", "nat", "bat"],
     * 输出:
     * [
     *   ["ate","eat","tea"],
     *   ["nat","tan"],
     *   ["bat"]
     * ]
     *
     * 所有输入均为小写字母。
     * 不考虑答案输出的顺序。
     *
     * @param strs
     * @return
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> hashMap = new HashMap<>(16);
        for (int i = 0; i < strs.length; i ++) {
            char[] array = strs[i].toCharArray();
            Arrays.sort(array);
            String newStr = String.valueOf(array);
            if (! hashMap.containsKey(newStr)) {
                hashMap.put(newStr, new ArrayList<>());
            }

            hashMap.get(newStr).add(strs[i]);
        }

        return new ArrayList<>(hashMap.values());
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> lists = solution.groupAnagrams(strs);
        System.out.println(lists);
    }

}
