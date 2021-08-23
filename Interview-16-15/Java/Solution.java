import java.util.Arrays;

/**
 * @author songyouyu
 * @date 2021/8/22
 */
public class Solution {

    /**
     * 珠玑妙算游戏（the game of master mind）的玩法如下。
     *
     * 计算机有4个槽，每个槽放一个球，颜色可能是红色（R）、黄色（Y）、绿色（G）或蓝色（B）。
     * 例如，计算机可能有RGGB 4种（槽1为红色，槽2、3为绿色，槽4为蓝色）。作为用户，你试图猜出颜色组合。
     * 打个比方，你可能会猜YRGB。要是猜对某个槽的颜色，则算一次“猜中”；要是只猜对颜色但槽位猜错了，则算一次“伪猜中”。
     * 注意，“猜中”不能算入“伪猜中”。
     *
     * 给定一种颜色组合solution和一个猜测guess，编写一个方法，返回猜中和伪猜中的次数answer，
     * 其中answer[0]为猜中的次数，answer[1]为伪猜中的次数。
     *
     * 示例：
     * 输入： solution="RGBY",guess="GGRR"
     * 输出： [1,1]
     * 解释： 猜中1次，伪猜中1次。
     *
     * 提示：
     * len(solution) = len(guess) = 4
     * solution和guess仅包含"R","G","B","Y"这4种字符
     *
     * 链接：https://leetcode-cn.com/problems/master-mind-lcci
     *
     * @param solution
     * @param guess
     * @return
     */
    public int[] masterMind(String solution, String guess) {
        boolean[] solutionFlag = new boolean[4];
        boolean[] guessFlag = new boolean[4];

        char[] solutionChar = solution.toCharArray();
        char[] guessChar = guess.toCharArray();

        int i = 0;
        int j = 0;
        while (i < 4) {
           if (solutionChar[i] == guessChar[i]) {
               j ++;
               solutionFlag[i] = true;
               guessFlag[i] = true;
           }
           i ++;
        }

        int k = 0;
        int n = 0;
        while (k < 4) {
            if (!solutionFlag[k]) {
                for (int m = 0; m < 4; m ++) {
                    if (!guessFlag[m] && solutionChar[k] == guessChar[m]) {
                        n ++;
                        guessFlag[m] = true;
                        break;
                    }
                }
            }
            k ++;
        }

        return new int[]{j, n};
    }

    public static void main(String[] args) {
        String solution = "BBBB";
        String guess = "YBBB";
        System.out.println(Arrays.toString(new Solution().masterMind(solution, guess)));
    }

}
