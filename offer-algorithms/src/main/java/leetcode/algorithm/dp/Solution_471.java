package leetcode.algorithm.dp;

import java.util.HashMap;

/**
 * @program: LeetCodeSolution
 * @description: #
 * @author: WhyWhatHow
 **/

public class Solution_471 {

    public static void main(String[] args) {
        Solution_471 sol = new Solution_471();
        System.out.println(sol.findMaxForm(new String[]{
                        "10", "0001", "111001", "1", "0"
//                "00011","00001","00001","0011","111"
                },
                5, 3
//                8,5
        ));
        System.out.println("==================");
    }

    HashMap<Integer, Integer> map = new HashMap<>(); // key i |10 , j 10 | 10

    int genKey(int i, int j, int k) {
        return (i << 20) | (j << 10) | k;
    }

    // m 个0 , n 个1
    // 设 f[i][j][k] means [0,i] range, have j number of 0 , k number of 1 condition, answer.
    // f[i][j][k]  =max (f[i-1][j][k], f[i-1][j-cnt[i]][k-cnt[i]]+1
    public int findMaxForm(String[] strs, int m, int n) {
        int[][] cnts = new int[strs.length][2];
        int i = 0;
        for (String s : strs) {
            cnts[i++] = handleStr(s.toCharArray());
        }
        return dfs(cnts, strs.length - 1, m, n);
    }

    // dfs(i,j,k) means [0,i] range , has j zero , k one 's answer.
    private int dfs(int[][] cnts, int i, int m, int n) {
        if (i < 0 || m < 0 || n < 0) return 0;

        int key = genKey(i, m, n);
        if (map.containsKey(key)) {
            return map.get(key);
        }
        int res = dfs(cnts, i - 1, m, n);
        if (m >= cnts[i][0] && n >= cnts[i][1]) {
            res = Math.max(res,
                    dfs(cnts, i - 1, m - cnts[i][0], n - cnts[i][1]) + 1);
        }
        map.put(key, res);
        return res;

    }


    private int[] handleStr(char[] cs) {
        int a = 0, b = 0;
        for (char c : cs) {
            if (c == '0') {
                a++;
            } else b++;
        }
        return new int[]{a, b};
    }
}


