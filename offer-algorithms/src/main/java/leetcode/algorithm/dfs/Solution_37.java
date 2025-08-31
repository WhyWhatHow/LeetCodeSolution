package leetcode.algorithm.dfs;

/**
 * @program: LeetCodeSolution
 * @description: #
 * @author: WhyWhatHow
 **/

public class Solution_37 {

    public static void main(String[] args) {
        Solution_37 sol = new Solution_37();
        char[][] array = {
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };
        sol.solveSudoku(array);
        System.out.println("==================");
    }

    public void solveSudoku(char[][] board) {
        boolean[][] rs = new boolean[9][10];//rs[i][j] 表示第i行用了j个这个数.
        boolean[][] cs = new boolean[9][10];// cs[i][j] 表示第 i 列用了 j 这个数
        boolean[][][] box = new boolean[3][3][10];// 一共有9个box ,第一个box 对应的(0,0) 第二个(0,1), 即对board[i][j], 求i/3, j/3 即可得到对应box下标.
        char zero = '0';
        // init
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (board[i][j] == '.') continue;
                int t = board[i][j] - zero;
                rs[i][t] = true;
                cs[j][t] = true;
                box[i / 3][j / 3][t] = true;
            }
        }

        // 对于'.' 的位置枚举每一个数字, 判断是否可行,如果可以.
        dfs(board, rs, cs, box, 0, 0);
        System.out.println(board);
    }

    private boolean dfs(char[][] board, boolean[][] rs, boolean[][] cs, boolean[][][] box, int x, int y) {
        if (y == board.length) {
            y = 0;
            x++;
            if (x == board.length)
                return true;
        }
        if (board[x][y] == '.') {
            for (int i = 1; i <= 9; i++) {
                if (rs[x][i] || cs[y][i] || box[x / 3][y / 3][i]) continue;
                //set cur (x,y) val == char(i)
                rs[x][i] = true;
                cs[y][i] = true;
                box[x / 3][y / 3][i] = true;
                board[x][y] = (char) ('0' + i);
                if (dfs(board, rs, cs, box, x, y + 1)) {
                    return true;
                }
                //reset
                rs[x][i] = false;
                cs[y][i] = false;
                box[x / 3][y / 3][i] = false;
                board[x][y] = '.';
            }

        } else {
            return dfs(board, rs, cs, box, x, y + 1);
        }
        return false;
    }
}


