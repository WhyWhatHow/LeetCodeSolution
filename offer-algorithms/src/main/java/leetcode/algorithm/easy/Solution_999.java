package leetcode.algorithm.easy;

/**
 * @program: LeetCodeSolution
 * @description: #
 * @author: WhyWhatHow
 **/

public class Solution_999 {

    public static void main(String[] args) {
        Solution_999 sol = new Solution_999();
        System.out.println("==================");
    }

    int[] d = new int[]{-1, 0, 1, 0, -1}; //

    public int numRookCaptures(char[][] g) {

        int res = 0;
        int x = 0, y = 0;
        // find rook
        for (int i = 0; i < g.length; i++) {
            for (int j = 0; j < g.length; j++) {
                if (g[i][j] == 'R') {
                    x = i;
                    y = j;
                }
            }
        }

        for (int i = 1; i < d.length; i++) {
            int dx = x;
            int dy = y;
            while (true) {
                dx += d[i - 1];
                dy += d[i];
                if (dx < 0 || dy < 0 || dx == g.length || dy == g.length) break;
                if (g[dx][dy] == 'B') break; // find bishop , end of road
                if (g[dx][dy] == 'p') {res++; break;}
            }
        }
        return res;

    }

}


