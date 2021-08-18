/**
 * @author songyouyu
 * @date 2021/8/18
 */
public class Solution {

    /**
     * 给你一个有效的 IPv4 地址 address，返回这个 IP 地址的无效化版本。
     *
     * 所谓无效化 IP 地址，其实就是用"[.]"代替了每个 "."。
     *
     * 示例 1：
     *
     * 输入：address = "1.1.1.1"
     * 输出："1[.]1[.]1[.]1"
     * 示例 2：
     *
     * 输入：address = "255.100.50.0"
     * 输出："255[.]100[.]50[.]0"
     *
     * 给出的 address 是一个有效的 IPv4 地址
     *
     * 链接：https://leetcode-cn.com/problems/defanging-an-ip-address
     *
     * @param address
     * @return
     */
    public String defangIPaddr(String address) {
        char[] chars = address.toCharArray();
        char[] result = new char[chars.length + 3 * 2];

        int j = 0;
        for (int i = 0; i < chars.length; i ++) {
            if (chars[i] == '.') {
                result[j++] = '[';
                result[j++] = '.';
                result[j++] = ']';
            } else {
                result[j] = chars[i];
                j ++;
            }
        }

        return new String(result);
    }

    public static void main(String[] args) {
        String s = "255.100.50.0";
        System.out.println(new Solution().defangIPaddr(s));
    }


}
