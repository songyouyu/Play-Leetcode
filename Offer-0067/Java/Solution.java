/**
 * @author songyouyu
 * @date 2021/8/19
 */
public class Solution {

    /**
     * 写一个函数 StrToInt，实现把字符串转换成整数这个功能。不能使用 atoi 或者其他类似的库函数。
     *
     * @param str
     * @return
     */
    public int strToInt(String str) {
        int len = str.length();
        if (len == 0) {
            return 0;
        }

        char[] strChar = str.toCharArray();

        int i = 0;
        while (i < len && strChar[i] == ' ') {
            i ++;
        }
        if (i == len) {
            return 0;
        }

        // 符号位
        int sign = 1;
        if (strChar[i] == '+') {
            i ++;
        } else if (strChar[i] == '-') {
            sign = -1;
            i ++;
        }

        // -2,147,483,648 到2,147,483,647
        int tmp = 214748364;
        int result = 0;

        while (i < len && strChar[i] >= '0' && strChar[i] <= '9') {
            int j = strChar[i] - '0';
            if (result > tmp) {
                if (sign == 1) {
                    return Integer.MAX_VALUE;
                } else {
                    return Integer.MIN_VALUE;
                }
            } else if (result == tmp) {
                if (j > 7 && sign == 1) {
                    return Integer.MAX_VALUE;
                }
                if (j > 8 && sign == -1) {
                    return Integer.MIN_VALUE;
                }
            }

            result = result * 10 + j;
            i ++;
        }

        return sign * result;
    }

    public static void main(String[] args) {
        String str = "   --234 man";
        System.out.println(new Solution().strToInt(str));
    }

}
