package leetcode.algorithm.array;

/**
 * @program: LeetCodeSolution
 * @description: #binary Indexed Array
 * @author: WhyWhatHow
 **/

public class Solution_419 {

    public static void main(String[] args) {
        Solution_419 sol = new Solution_419();
        System.out.println(sol.countBattleships(new char[][]{
                {'X', '.', '.', 'X'}, {'.', '.', '.', 'X'}, {'.', '.', '.', 'X'}
        }));
        System.out.println("==================");
    }

    public int countBattleships(char[][] board) {
        int res = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                // left, top boarder check
                if (i - 1 < 0 || j - 1 < 0) {
                    if (board[i][j] == 'X') {
                        res++;
                        continue;
                    }
                }
                // left check
                if (i - 1 >= 0 && board[i - 1][j] == 'X') continue;
                // top check
                if (j - 1 >= 0 && board[i][j - 1] == 'X') continue;

                if (board[i][j] == 'X') {
                    res++;
                }

            }
        }
        return res;
    }
}


