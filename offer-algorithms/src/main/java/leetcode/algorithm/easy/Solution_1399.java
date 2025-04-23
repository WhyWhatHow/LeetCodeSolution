package leetcode.algorithm.easy;

import java.util.HashMap;

/**
 * @program: LeetCodeSolution
 * @description: #
 * @author: WhyWhatHow
 **/

public class Solution_1399 {

    public static void main(String[] args) {
        Solution_1399 sol = new Solution_1399();
        System.out.println("==================");
    }


    public int countLargestGroup(int n) {
        HashMap<Integer, Integer> map = new HashMap<>(); // {sum, cnt }
        int max = 0;
        for (int i = 1; i <= n; i++) {
            int key = f(i);
            max = Math.max(max, map.compute(key, (k, v) -> v == null ? 1 : v + 1));
        }
        int cnt = 0;
        for (Integer value : map.values()) {
            cnt += value == max ? 1 : 0;
        }
        return cnt;
    }

    int f(int i) {
        int res = 0;
        char[] cs = String.valueOf(i).toCharArray();
        for (char c : cs) res += c - '0';
        return res;
    }
}


