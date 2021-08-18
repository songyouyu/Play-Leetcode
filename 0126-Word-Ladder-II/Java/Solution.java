import java.util.*;

/**
 * @author youyu.song
 * @date 2019/12/10 15:26
 */
public class Solution {

    /**
     * 给定两个单词（beginWord 和 endWord）和一个字典 wordList，找出所有从 beginWord 到 endWord 的最短转换序列。转换需遵循如下规则：
     *
     * 每次转换只能改变一个字母。
     * 转换过程中的中间单词必须是字典中的单词。
     *
     * 说明:
     * 如果不存在这样的转换序列，返回一个空列表。
     * 所有单词具有相同的长度。
     * 所有单词只由小写字母组成。
     * 字典中不存在重复的单词。
     * 你可以假设 beginWord 和 endWord 是非空的，且二者不相同。
     *
     * 示例 1:
     * 输入:
     * beginWord = "hit",
     * endWord = "cog",
     * wordList = ["hot","dot","dog","lot","log","cog"]
     *
     * 输出:
     * [
     *   ["hit","hot","dot","dog","cog"],
     *   ["hit","hot","lot","log","cog"]
     * ]
     *
     * 示例 2:
     * 输入:
     * beginWord = "hit"
     * endWord = "cog"
     * wordList = ["hot","dot","dog","lot","log"]
     *
     * 输出: []
     *
     * 解释: endWord "cog" 不在字典中，所以不存在符合要求的转换序列。
     *
     * 来源：力扣(LeetCode)题解
     * 链接：https://leetcode-cn.com/problems/word-ladder-ii
     *
     * @param beginWord
     * @param endWord
     * @param wordList
     * @return
     */

    // 存储最终结果
    List<List<String>> res = new ArrayList<>();
    // key 为字符串，value 为某一个点的临近点的 list，begin 向 end 前进所产生的记录
    Map<String, List<String>> map = new HashMap<>();

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        if (wordList.isEmpty() || wordList == null) {
            return res;
        }
        Set<String> dictSet = new HashSet<>(wordList);
        if (! dictSet.contains(endWord)) {
            return res;
        }
        if (dictSet.contains(beginWord)) {
            dictSet.remove(beginWord);
        }
        Set<String> beginSet = new HashSet<>();
        beginSet.add(beginWord);
        Set<String> endSet = new HashSet<>();
        endSet.add(endWord);
        boolean finish = false;
        // 双端 bfs，false 表示从头，true 表示从尾
        boolean reverse = false;

        while (! beginSet.isEmpty()) {
            dictSet.removeAll(beginSet);
            Set<String> tmpSet = new HashSet<>();
            for (String str : beginSet) {
                char[] charArray = str.toCharArray();
                for (int i = 0; i < charArray.length; i ++) {
                    char tmp = charArray[i];
                    for (char c = 'a'; c < 'z'; c ++) {
                        if (tmp == c) {
                            continue;
                        }
                        charArray[i] = c;
                        String newStr = new String(charArray);
                        if (! dictSet.contains(newStr)) {
                            continue;
                        }
                        if (endSet.contains(newStr)) {
                            finish = true;
                        } else {
                            tmpSet.add(newStr);
                        }
                        // 无论怎么变换方向，永远用开始方向的字符做key，是为了后面的dfs，单一方向搜索
                        String key = reverse ? newStr : str;
                        String value = reverse ? str : newStr;
                        if (! map.containsKey(key)) {
                            map.put(key, new ArrayList<>());
                        }
                        map.get(key).add(value);
                    }
                    // 对单词进行复原操作
                    charArray[i] = tmp;
                }
            }
            if (tmpSet.size() <= endSet.size()) {
                beginSet = tmpSet;
            } else {
                reverse = !reverse;
                beginSet = endSet;
                endSet = tmpSet;
            }
            if (finish) {
                break;
            }
        }
        // dfs 前进路线保存list
        List<String> subList = new ArrayList<>();
        subList.add(beginWord);
        dfs(subList, beginWord, endWord);

        return res;
    }

    private void dfs (List<String> subList,String beginWord,String endWord) {
        if (beginWord.equals(endWord)) {
            res.add(new ArrayList<>(subList));
            return;
        }
        if (! map.containsKey(beginWord)) {
            return;
        }

        for (String s : map.get(beginWord)) {
            subList.add(s);
            dfs(subList, s, endWord);
            subList.remove(subList.size() - 1);
        }
    }

    public static void main(String[] args) {
        String beginWord = "hit";
        String endWord = "cog";
        List<String> wordList = new ArrayList<>();
        wordList.addAll(Arrays.asList("hot","dot","dog","lot","log","cog"));

        System.out.println(new Solution().findLadders(beginWord, endWord, wordList));
    }

}
