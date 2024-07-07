package leetcode.algorithm.medium;

/**
 * @program: LeetCodeSolution
 * @description: #
 * @author: WhyWhatHow
 **/

public class Solution_1958 {

    public static void main(String[] args) {
        Solution_1958 sol = new Solution_1958();
        System.out.println(sol.checkMove(new char[][]{
//                        {'.', '.', '.', '.', 'W', 'B', 'B', 'B'},
//                        {'.', '.', '.', '.', '.', '.', '.', 'B'},
//                        {'W', '.', '.', 'W', '.', '.', 'W', '.'},
//                        {'B', '.', 'B', 'B', 'B', '.', '.', 'W'},
//                        {'W', '.', '.', 'B', 'W', 'B', 'B', '.'},
//                        {'W', 'B', '.', '.', 'W', 'B', 'B', '.'},
//                        {'.', 'W', 'B', 'B', 'W', 'B', '.', 'W'},
//                        {'B', '.', 'W', 'B', 'W', '.', 'W', '.'}

////                ////////////////////////////
//                        {'.', '.', 'W', '.', 'B', 'W', 'W', 'B'},
//                        {'B', 'W', '.', 'W', '.', 'W', 'B', 'B'},
//                        {'.', 'W', 'B', 'W', 'W', '.', 'W', 'W'},
//                        {'W', 'W', '.', 'W', '.', '.', 'B', 'B'},
//                        {'B', 'W', 'B', 'B', 'W', 'W', 'B', '.'},
//                        {'W', '.', 'W', '.', '.', 'B', 'W', 'W'},
//                        {'B', '.', 'B', 'B', '.', '.', 'B', 'B'},
//                        {'.', 'W', '.', 'W', '.', 'W', '.', 'W'}
                        ///////////////
                        {'.', '.', '.', '.', '.', '.', '.', '.'},
                        {'.', 'B', '.', '.', 'W', '.', '.', '.'},
                        {'.', '.', 'W', '.', '.', '.', '.', '.'},
                        {'.', '.', '.', 'W', 'B', '.', '.', '.'},
                        {'.', '.', '.', '.', '.', '.', '.', '.'},
                        {'.', '.', '.', '.', 'B', 'W', '.', '.'},
                        {'.', '.', '.', '.', '.', '.', 'W', '.'},
                        {'.', '.', '.', '.', '.', '.', '.', 'B'}
                },
//                0, 0, 'B'
//                5, 4, 'W'
                4, 4, 'W'
        ));
        System.out.println("==================");
    }

    int[][] dir = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}, {1, 1}, {1, -1}, {-1, 1}, {-1, -1}};
    boolean res = false;

    public boolean checkMove(char[][] board, int rMove, int cMove, char color) {
        int rows = board.length;
        int cols = board[0].length;
        boolean res = false;
        for (int[] ints : dir) {
            int x = ints[0];
            int y = ints[1];
            int cnt = 1;
            char firstColor = '.';
            for (int i = rMove + x, j = y + cMove; ; i += x, j += y) {
                if (i < 0 || j < 0 || i >= rows || j >= cols) break; // board check

                // no  color
//                if (board[i][j] == '.') break;

                if (cnt >= 2 && board[i][j] == color) {
                    res = true;
                    break;
                }


                if (cnt == 1 && board[i][j] != color) {
                    firstColor = board[i][j];
                }
                // no firstColor
                if(firstColor =='.') break;
                // middle check
                if (cnt > 1 && board[i][j] != firstColor) break;

                cnt++;
            }

            if (res) break;

        }
//        dfs(rMove, cMove, len, color, board);
        return res;
    }
//
//    private void dfs(int x, int y, int len, char color, char[][] board) {
//        if (len >= 3 && color == board[x][y]) {
//            res = true;
//            return;
//        }
//
//        for (int[] ints : dir) {
//            int xx = ints[0] + x;
//            int yy = ints[1] + y;
//            if (xx < 0 || yy < 0 || xx >= board.length || yy >= board[0].length) return;
//
//            if (board[x][y] == '.' || board[x][y] == color) return;
//
//            if (color != board[xx][yy] && board[xx][yy] != '.')
//                dfs(xx, yy, len + 1, color, board);
//        }
}



