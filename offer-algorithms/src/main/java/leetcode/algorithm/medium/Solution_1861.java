package leetcode.algorithm.medium;

import java.util.Arrays;

/**
 * @program: LeetCodeSolution
 * @description: #
 * @author: WhyWhatHow
 **/
public class Solution_1861 {

    public static void main(String[] args) {
        Solution_1861 sol = new Solution_1861();//
        System.out.println(sol.rotateTheBox(
                new char[][]{{'#','.','#'}}
//                new char[][]{{'#', '.', '*', '.'}, {'#', '#', '*', '.'}}
        ));
        System.out.println("==================");
    }

    public char[][] rotateTheBox(char[][] g) {
        int n = g.length;
        int m = g[0].length;
        char[][] cs = new char[m][n];
        for (int i = 0; i < cs.length; i++) {
            Arrays.fill(cs[i], '.');
        }
        int[] rs = new int[n]; // 记录rows[i] 原行 石头的位置. 如果没有的话记录成-1.
        Arrays.fill(rs, -1);
        for (int i = 0; i < g.length; i++) {
            for (int j = 0; j < m; j++) {
                if (g[i][j] == '*') {
                    rs[i] = j;
                    break;
                }
            }
        }
        for (int i = 0; i < g.length; i++) {
            fill(g[i], rs[i], i, cs, n - i - 1);
        }

        return cs;
    }

    private void fill(char[] chars, int rfid, int rid, char[][] cs, int col) {

        int cnt = 0;
        for (int i = 0; i < chars.length; i++) {

            if (chars[i] == '#')
                cnt++;
            else if (chars[i] == '*') {
                cs[i][col] = '*';
                int j = i - 1;
                while (cnt > 0) {
                    cnt--;
                    cs[j--][col] = '#';
                }
            }
        }

        int end = cs.length - 1;
        while (cnt > 0) {
            cnt--;
            cs[end--][col] = '#';
        }
    }
}