package leetcode.algorithm.medium;

import java.util.Arrays;

/**
 * @program: LeetCodeSolution
 * @description: #binary Indexed Array
 * @author: WhyWhatHow
 **/

public class Solution_2938 {

    public static void main(String[] args) {
        Solution_2938 sol = new Solution_2938();
        System.out.println(sol.minimumSteps(
                "101"
        ));
        System.out.println("==================");
    }
    // 将遇到0 之前的所有的白球移到右侧去
    public long minimumStepsBetter(String s) {
        long cnt = 0;// 1-> 白色球的数量
        long ans = 0;
        char[] arr = s.toCharArray();

        for (char c : arr) {
            if (c == '1') {
                cnt++;
            } else {
                ans += cnt;
            }
        }
        return ans ;
    }

    public long minimumSteps(String s) {
        char[] arr = s.toCharArray();
        char[] sorted = Arrays.copyOf(arr, arr.length);
        Arrays.sort(sorted);

        int idx = 0;
        long ans = 0;
        for (int i = 0; i < arr.length && sorted[idx] == '0'; i++) {
            if (arr[i] == '1') continue;
            ans += i - idx;
            idx++;
        }
        return ans;
    }

}


