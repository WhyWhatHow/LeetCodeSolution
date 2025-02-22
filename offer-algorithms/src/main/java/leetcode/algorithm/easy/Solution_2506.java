package leetcode.algorithm.easy;

import java.util.ArrayList;

/**
 * @program: LeetCodeSolution
 * @description: #
 * @author: WhyWhatHow
 **/

public class Solution_2506 {

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>(3);
        Solution_2506 sol = new Solution_2506();
        System.out.println(sol.similarPairs(new String[]{
                "aba","aabb","abcd","bac","aabc"
        }));
        System.out.println("==================");
    }
    public int similarPairs(String[] words) {
        int n = words.length;
        boolean[][] arr = new boolean[n][26];
        for (int i = 0; i < n; i++) {
            int len = words[i].length();
            for (int j = 0; j < len; j++) {
                arr[i][words[i].charAt(j) - 'a'] = true;
            }
        }

        int res = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (check(arr, i, j))
                    res++;
            }
        }
        return res;

    }

    boolean check(boolean[][] arr, int i, int j) {
        int len = 26;
        for (int k = 0; k < len; k++) {
            if (arr[i][k] != arr[j][k])
                return false;
        }
        return true;
    }


}
