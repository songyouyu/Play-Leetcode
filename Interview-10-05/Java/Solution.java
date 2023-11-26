public class Solution {
    
    /**
     * https://leetcode.cn/problems/sparse-array-search-lcci/
     * 
     * @param words
     * @param s
     * @return
     */
    public int findString(String[] words, String s) {
        int len = words.length;
        int l = 0;
        int r = len - 1;

        while (l <= r) {
            int mid = l + (r - l) / 2;
            while (mid - 1 >= 0 && words[mid].length() == 0) {
                mid = mid - 1;
            }
            if (words[mid].equals(s)) {
                return mid;
            } else if (words[mid].compareTo(s) < 0) {
                l = l + (r - l) / 2 + 1;
            } else {
                r = mid - 1;
            }
        }

        return -1;
    }

    public int findString2(String[] words, String s) {
        int len = words.length;
        int l = 0;
        int r = len - 1;

        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (words[mid].equals(s)) {
                return mid;
            } else if (words[mid].equals("")) {
                if (words[l].equals(s)) {
                    return l;
                } else {
                    l ++;
                }
            } else if (words[mid].compareTo(s) > 0) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        
        return -1;
    }

    public static void main(String[] args) {
        String[] words = {"DirNnILhARNS hOYIFB", "SM ", "YSPBaovrZBS", "evMMBOf", "mCrS", "oRJfjw gwuo", "xOpSEXvfI"};
        String s = "mCrS";
        System.out.println(new Solution().findString(words, s));
    }

}
