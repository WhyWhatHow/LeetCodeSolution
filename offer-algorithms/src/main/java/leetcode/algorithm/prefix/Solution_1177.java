package leetcode.algorithm.prefix;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: LeetCodeSolution
 * @description: #
 * @author: WhyWhatHow
 **/

public class Solution_1177 {

    public static void main(String[] args) {
        Solution_1177 sol = new Solution_1177();
        System.out.println(sol.canMakePaliQueries(
//                "abcda",
                "xebyvmjqbmbs",
                new int[][]{
//                        {3, 3, 0},
//                        {1, 2, 0},
//                        {0, 3, 1},
//                        {0, 3, 2},
//                        {0, 4, 1}}
                ///////////////////////
                        {1,10,3}

                }
        ));
        System.out.println("==================");
    }


    public List<Boolean> canMakePaliQueries(String s, int[][] queries) {
        List<Boolean> resList = new ArrayList<>();
        char[] cs = s.toCharArray();
        int n = cs.length;
        int[][] ns = new int[n + 1][26]; // ns[i][j] means [0,i) range , j-'a' 出现次数
        char c = 'a';

        for (int i = 0; i < cs.length; i++) {
//            ns[i + 1][cs[i] - c]=;
            for (int j = 0; j < 26; j++) {
                ns[i + 1][j] = cs[i] - c == j ? ns[i][j] + 1 : ns[i][j];
            }
        }

        for (int[] q : queries) {
            int l = q[0], r = q[1];
            int sum = 0;
            for (int i = 0; i < 26; i++) {

                int tmp = ns[r + 1][i] - ns[l][i];
                if ((tmp & 1) == 1) {
                    sum ++;
                }
            }
            resList.add(sum / 2 <= q[2]);
        }
        return resList;
    }
}


