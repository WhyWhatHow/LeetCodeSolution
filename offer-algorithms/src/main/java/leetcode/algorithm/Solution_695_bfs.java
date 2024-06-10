package leetcode.algorithm;

/**
 * @program: LeetCodeSolution
 * @description:
 * @author: WhyWhatHow
 * @create: 2020-05-07 12:09
 **/

import java.util.LinkedList;

/**
 * [0,0,1,0,0,0,0,1,0,0,0,0,0],
 * [0,0,0,0,0,0,0,1,1,1,0,0,0],
 * [0,1,1,0,1,0,0,0,0,0,0,0,0],
 * [0,1,0,0,1,1,0,0,1,0,1,0,0],
 * [0,1,0,0,1,1,0,0,1,1,1,0,0],
 * [0,0,0,0,0,0,0,0,0,0,1,0,0],
 * [0,0,0,0,0,0,0,1,1,1,0,0,0],
 * [0,0,0,0,0,0,0,1,1,0,0,0,0]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/max-area-of-island
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution_695_bfs {
    int ans = 0;
    boolean vis[][] = new boolean[51][51]; // 标记遍历过的节点
    // 上下左右四个方向
    int arr[][] = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public int maxAreaOfIslands(int[][] grid) {

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    bfs(i, j, grid);
                }
            }
        }
        return ans;
    }

    private void bfs(int i, int j, int[][] grid) {
        int temp = 0;
        LinkedList<Integer> list = new LinkedList();
        LinkedList<Integer> list1 = new LinkedList();
        list.add(i);
        list1.add(j);
        while (!list.isEmpty()) {
            Integer x = list.removeFirst();
            Integer y = list1.removeFirst();
            temp++;
            grid[x][y] = 0;
            for (int i1 = 0; i1 < arr.length; i1++) {

                int xx = x + arr[i1][0];
                int yy = y + arr[i1][1];
                if (xx < 0 || yy < 0 || grid.length <= xx || grid[xx].length <= yy) {
                    continue;
                }
                if (grid[xx][yy] == 1) {
                    grid[xx][yy] = 0;
                    list.add(xx);
                    list1.add(yy);
                }
            }
        }
        ans = Math.max(ans, temp);
        return;
    }


//    public int maxAreaOfIsland(int[][] grid) {
//
//        for (int i = 0; i < grid.length; i++) {
//            for (int j = 0; j < grid[i].length; j++) {
//                if (grid[i][j] == 0 || vis[i][j]) { //
//                    continue;
//                } else {
//                    dfs(i, j, grid);
//                }
//            }
//        }
//        return ans;
//    }

//
//    private void dfs(int x, int y, int[][] grid) {
//        int temp = 0;// 代表当前节点的
//        for (int i = 0; i < arr.length; i++) {
//            for (int j = 0; j < arr.length; j++) {
//                // 避免下标越界
//                if (x + i < 0 || y + j < 0 || x + i >= grid.length || y + j >= grid.length) {
//                    continue;
//                }
//                if (grid[x + i][y + j] == 0) {
//                    continue;
//                } else if (!vis[x + i][y + j]) {
//                    vis[x + i][y + j] = true;
//                    temp++;
//                    ans = Math.max(ans, temp);
//                    dfs(x + i, y + j, grid);
////                    vis[x + i][y + j] = false;
////                    temp--;
//                }
//            }
//        }
////        ans = Math.max(ans,temp);
//    }

    public static void main(String[] args) {
        Solution_695_bfs sol = new Solution_695_bfs();
//        int i = sol.maxAreaOfIslands(new int[][]{
//                {0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
//                {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
//                {0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
//                {0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0},
//                {0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0},
//                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
//                {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
//                {0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0}
//
//        });
        int i = sol.maxAreaOfIslands(new int[][]{
                {1, 1, 0, 0, 0},
                {1, 1, 0, 0, 0},
                {0, 0, 0, 1, 1},
                {0, 0, 0, 1, 1}
        });
        System.out.println(i);
        System.out.println("==================");
    }
}


