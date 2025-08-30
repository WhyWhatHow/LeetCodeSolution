package leetcode.algorithm.medium;

/**
 * @program: LeetCodeSolution
 * @description: #
 * @author: WhyWhatHow
 **/

public class Solution_36 {

    public static void main(String[] args) {
        Solution_36 sol = new Solution_36();
        System.out.println(2 / 3);
        System.out.println(3/3+3);
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
        System.out.println(sol.isValidSudoku(array));
        System.out.println("==================");
    }

    public boolean isValidSudoku(char[][] board) {
        boolean yes = true;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                char c = board[i][j];
                if(c =='.') continue;
                if (!checkRow(board, i, c) || !checkCol(board, j, c) || !checkBox(board, i, j)) {
                    return false;
                }
            }
        }
        return yes;
    }

    private boolean checkBox(char[][] board, int x, int y) {
        char c = board[x][y];
        int stx = 3*(x / 3);
        int endx = stx + 3;
        int sty = 3*(y / 3);
        int endy = sty + 3;
        int cnt = 0 ;
        for(int i = stx ; i<endx ;i++){
            for(int j = sty ; j<endy; j++){
                if(board[i][j]==c)cnt++;
                if(cnt>1) return false;
            }
        }
        return true;
    }


    boolean checkRow(char[][] g, int row, char c) {
        int cnt = 0;
        for (int i = 0; i < g[row].length; i++) {
            if (g[row][i] == c) cnt++;
            if (cnt > 1) return false;
        }
        return true;
    }

    boolean checkCol(char[][] g, int col, char c) {
        int cnt = 0;
        for (int i = 0; i < g.length; i++) {
            if (g[i][col] == c) cnt++;
            if (cnt > 1) return false;
        }
        return true;
    }
}


