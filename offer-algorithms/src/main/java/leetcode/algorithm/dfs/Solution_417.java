package leetcode.algorithm.dfs;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: LeetCodeSolution
 * @description: #
 * @author: WhyWhatHow
 **/

public class Solution_417 {

    public static void main(String[] args) {
        Solution_417 sol = new Solution_417();
        System.out.println(sol.pacificAtlantic(new int[][]{
//                {1, 2, 2, 3, 5}, {3, 2, 3, 4, 4}, {2, 4, 5, 3, 1}, {6, 7, 1, 4, 5}, {5, 1, 1, 2, 4}
//                {1,1,1},{1,1,1},{1,1,1}
                {1, 1}, {1, 1}, {1, 1}
        }));
        System.out.println("==================");
    }

    int[] dir = new int[]{-1, 0, 1, 0, -1}; // left, up , 3 right , down ,

    //逆向思考, 思考海浪从四周打来,会侵占那些 location
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> resList = new ArrayList<>();
        int n = heights.length;
        int m = heights[0].length;
        boolean[][] lts = new boolean[n][m];
        boolean[][] rds = new boolean[n][m];

        // ////pacific
        // top
        for (int i = 0; i < m; i++) {
            dfs(0, i, heights, lts);
        }

        // left
        for (int i = 0; i < n; i++) {
            dfs(i, 0, heights, lts);
        }

        /////atlantic
        // right
        for (int i = 0; i < n; i++) {
            dfs(i, m - 1, heights, rds);
        }
        // bottom
        for (int i = 0; i < m; i++) {
            dfs(n - 1, i, heights, rds);
        }

        // lts and rds subSet
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (lts[i][j] && rds[i][j])
                    resList.add(List.of(i, j));
            }
        }

        return resList;

    }

    //  标记 海水来的位置.
    private void dfs(int x, int y, int[][] heights, boolean[][] v) {
        int n = heights.length;
        int m = heights[0].length;
        v[x][y] = true;
        for (int i = 1; i < dir.length; i++) {
            int xx = dir[i - 1] + x;
            int yy = dir[i] + y;
            if (xx < 0 || xx >= n || yy < 0 || yy >= m || v[xx][yy]) continue; // ocean , skip
            if (heights[xx][yy] >= heights[x][y]) {
                dfs(xx, yy, heights, v);
            }
        }
    }


}


