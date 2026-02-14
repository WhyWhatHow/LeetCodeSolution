package leetcode.algorithm.medium;

/**
 * @program: LeetCodeSolution
 * @description: #
 * @author: WhyWhatHow
 **/
public class Solution_799 {

    public static void main(String[] args) {
        Solution_799 sol = new Solution_799();//
        System.out.println(sol.champagneTower(
//                2,
//                1,
//                1
                100000009,
                33,
                17
        ));
        System.out.println("==================");
    }

    //  bfs 模拟层次遍历.
    record Node(int x, int y, double left) {
    }

    ;

    public double champagneTower(int poured, int query_row, int query_glass) {
        if (poured == 0) return 0;

        double[][] g = new double[101][101]; // 总的层数.
        int n = 100;
        g[0][0] = poured;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                if (g[i][j] >= 1.0d) {
                    double left = (g[i][j] - 1.0d) / 2;
                    g[i + 1][j] += left;
                    g[i + 1][j + 1] += left;
                    g[i][j] = 1;
                }
            }
        }
        return Math.min(1.0d, g[query_row][query_glass]);
    }
}
