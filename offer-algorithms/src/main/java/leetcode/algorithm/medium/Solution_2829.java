package leetcode.algorithm.medium;

/**
 * @program: LeetCodeSolution
 * @description: #
 * @author: WhyWhatHow
 **/

public class Solution_2829 {

    public static void main(String[] args) {
        Solution_2829 sol = new Solution_2829();
        System.out.println("==================");
    }

    public int minimumSum(int n, int k) {
        boolean[] vis = new boolean[k];
        int cnt = 0;
        int sum = 0;
        for (int i = 1; i < vis.length; i++) {
            if (cnt == n) break;
            if (!vis[i]) {
                sum += i;
                cnt++;
                vis[k - i] = true;
            }
        }
        while (cnt < n) {
            cnt++;
            sum += k;
            k++;
        }
        return sum;
    }
}


