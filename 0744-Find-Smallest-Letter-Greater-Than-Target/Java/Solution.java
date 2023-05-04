/**
 * @author songyouyu
 * @date 2023/5/4 18:38:08
 */
public class Solution {

    /**
     * https://leetcode.cn/problems/find-smallest-letter-greater-than-target/submissions/
     *
     * @param letters
     * @param target
     * @return
     */
    public char nextGreatestLetter(char[] letters, char target) {
        int len = letters.length;
        int l = 0;
        int r = len - 1;
        int a = target - '0';

        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (letters[mid] - '0' == a) {
                if (mid + 1 < len && letters[mid + 1] - '0' > a) {
                    return letters[mid + 1];
                }
                l = mid + 1;
            } else if (letters[mid] - '0' < a) {
                if (mid + 1 < len && letters[mid + 1] - '0' > a) {
                    return letters[mid + 1];
                }
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return letters[0];
    }

    public static void main(String[] args) {
        char[] letters = {'c', 'f', 'g'};
        char target = 'g';
        System.out.println(new Solution().nextGreatestLetter(letters, target));
    }

}
