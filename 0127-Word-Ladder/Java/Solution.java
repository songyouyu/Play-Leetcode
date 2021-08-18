import java.util.*;

/**
 * @author youyu.song
 * @date 2019/11/20 10:05
 */
public class Solution {

    /**
     * 给定两个单词（beginWord 和 endWord）和一个字典，找到从 beginWord 到 endWord 的最短转换序列的长度。转换需遵循如下规则：
     * <p>
     * 每次转换只能改变一个字母。
     * 转换过程中的中间单词必须是字典中的单词。
     * 说明:
     * <p>
     * 如果不存在这样的转换序列，返回 0。
     * 所有单词具有相同的长度。
     * 所有单词只由小写字母组成。
     * 字典中不存在重复的单词。
     * 你可以假设 beginWord 和 endWord 是非空的，且二者不相同。
     * <p>
     * 示例 1:
     * 输入:
     * beginWord = "hit",
     * endWord = "cog",
     * wordList = ["hot","dot","dog","lot","log","cog"]
     * <p>
     * 输出: 5
     * 解释: 一个最短转换序列是 "hit" -> "hot" -> "dot" -> "dog" -> "cog", 返回它的长度 5。
     * <p>
     * 示例 2:
     * 输入:
     * beginWord = "hit"
     * endWord = "cog"
     * wordList = ["hot","dot","dog","lot","log"]
     * <p>
     * 输出: 0
     * 解释: endWord "cog" 不在字典中，所以无法进行转换。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/word-ladder
     *
     * @param beginWord
     * @param endWord
     * @param wordList
     * @return
     */
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (wordList.isEmpty() || wordList == null) {
            return 0;
        }

        // BFS
        HashSet<String> start = new HashSet<>();
        start.add(beginWord);
        HashSet<String> end = new HashSet<>();
        end.add(endWord);
        HashSet<String> dic = new HashSet<>(wordList);
        if (! dic.contains(endWord)) {
            return 0;
        }

        // 此处说明一定可以找到一条路径，并且转换序列的长度为 2.
        int step = 1;
        while (! start.isEmpty()) {
            step ++;
            HashSet<String> tmpSet = new HashSet<>();
            // 使用过的不重复使用
            dic.removeAll(start);
            for (String s : start) {
                // 把单词转换成 char 数组
                char[] charArray = s.toCharArray();
                // 对数组进行遍历，改变单词中的每一个字母，每改变一次就去字典中查找
                for (int i = 0; i < charArray.length; i ++) {
                    char tmp = charArray[i];
                    for (char c = 'a'; c <= 'z'; c ++) {
                        if (tmp == c) {
                            continue;
                        }
                        charArray[i] = c;
                        String strTmp = new String(charArray);
                        if (dic.contains(strTmp)) {
                            // 变换单词中的一个字母，若 end　集合中可以找到则直接返回．
                            if (end.contains(strTmp)) {
                                return step;
                            } else {
                                tmpSet.add(strTmp);
                            }
                        }
                    }
                    // 对单词进行复原操作
                    charArray[i] = tmp;
                }
            }
            // 双端查找，用少的去找多的.
            // hot 改变一个字母可以有两种变化，即 dot lot，此时从尾端开始查找，从 cog 如何变化到 dot 或 lot
            if (tmpSet.size() < end.size()) {
                start = tmpSet;
            } else {
                start = end;
                end = tmpSet;
            }
        }

        return 0;
    }



    public static void main(String[] args) {
        String beginWord = "hit";
        String endWord = "cog";
        List<String> wordList = new ArrayList<>();
        wordList.addAll(Arrays.asList("hot","dot","dog","lot","log","cog"));

        System.out.println(new Solution().ladderLength(beginWord, endWord, wordList));
    }

}
