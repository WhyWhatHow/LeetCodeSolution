package leetcode.algorithm.easy;

import java.util.List;

/**
 * @program: LeetCodeSolution
 * @description: #
 * @author: WhyWhatHow
 **/

public class Solution_3248 {

    public static void main(String[] args) {
        Solution_3248 sol = new Solution_3248();
        System.out.println("==================");
    }

    public int finalPositionOfSnake(int n, List<String> commands) {
        int[][] g = new int[n][n];

        int cnt = 0 ;
        // init
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                g[i][j] = cnt++;
            }
        }

        int x = 0, y = 0;
        for (String s : commands) {
            if ("UP".equals(s)) {
                x--;
            } else if ("DOWN".equals(s)) {
                x++;
            } else if ("LEFT".equals(s)) {
                y--;
            } else if("RIGHT".equals(s)) {
                y++;
            }
        }
        // System.out.print(x+":"+y);
        // return 0;
        return g[x][y];

    }

}


