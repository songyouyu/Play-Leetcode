public class Solution {
    
    public boolean CheckPermutation(String s1, String s2) {
        int s1Len = s1.length();
        int s2Len = s2.length();
        if (s1Len != s2Len) {
            return false;
        }

        char[] s1Chars = s1.toCharArray();
        Arrays.sort(s1Chars);
        s1 = new String(s1Chars);
        char[] s2Chars = s2.toCharArray();
        Arrays.sort(s2Chars);
        s2 = new String(s2Chars);

        int i = 0, j = 0;
        while (i < s1Len) {
            if (s1.charAt(i) != s2.charAt(j)) {
                return false;
            }
            i ++;
            j ++;
        }

        return true;
    }

}
