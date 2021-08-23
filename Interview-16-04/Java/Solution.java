/**
 * @author songyouyu
 * @date 2021/8/23
 */
public class Solution {

    public String tictactoe(String[] board) {
        int n = board.length;
        char[][] boards = new char[n][n];
        for (int i = 0; i < n; i ++) {
            boards[i] = board[i].toCharArray();
        }

        boolean win;
        // 检查行
        for (int i = 0; i < n; i ++) {
            // 检查下一行
            if (boards[i][0] == ' ') {
                continue;
            }
            win = true;
            for (int j = 0; j < n; j ++) {
                if (boards[i][j] != boards[i][0]) {
                    win = false;
                    // 继续检查下一行
                    break;
                }
            }
            if (win) {
                return boards[i][0] + "";
            }
        }

        // 检查列
        for (int j = 0; j < n; j ++) {
            if (boards[0][j] == ' ') {
                continue;
            }
            win = true;
            for (int i = 1; i < n; i ++) {
                if (boards[i][j] != boards[0][j]) {
                    win = false;
                    break;
                }
            }
            if (win) {
                return boards[0][j] + "";
            }
        }

        // 检查对角线：左上->右下
        if (boards[0][0] != ' ') {
            int i = 1;
            int j = 1;
            win = true;
            while (i < n && j < n) {
                if (boards[i][j] != boards[0][0]) {
                    win = false;
                    break;
                }
                i ++;
                j ++;
            }
            if (win) {
                return boards[0][0] + "";
            }
        }

        // 检查对角线：左下->右上
        if (boards[n - 1][0] != ' ') {
            int i = n - 2;
            int j = 1;
            win = true;
            while (i >= 0 && j < n) {
                if (boards[i][j] != boards[n -1][0]) {
                    win = false;
                    break;
                }
                i --;
                j ++;
            }
            if (win) {
                return boards[n -1][0] + "";
            }
        }

        // 检查游戏是否暂停
        for (int i = 0; i < n; i ++) {
            for (int j = 0; j < n; j ++) {
                if (boards[i][j] == ' ') {
                    return "Pending";
                }
            }
        }

        return "Draw";
    }

}
