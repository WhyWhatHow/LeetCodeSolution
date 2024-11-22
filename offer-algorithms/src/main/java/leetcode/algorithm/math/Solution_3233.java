package leetcode.algorithm.math;

/**
 * @program: LeetCodeSolution
 * @description: #
 * @author: WhyWhatHow
 **/

public class Solution_3233 {

    public static void main(String[] args) {
        Solution_3233 sol = new Solution_3233();
        sol.nonSpecialCount(5, 1000000000);
        System.out.println("==================");
    }

    boolean[] vis = new boolean[1000_000];
    int[] prime = new int[100_000];
    int cnt = 0;
    int max = 1000_000_000;

    void init() {
        for (int i = 2; i < vis.length; i++) {
            if (!vis[i]) {
                if (i * i > max) break;
                prime[cnt++] = i * i;
                for (int j = i + i; j < vis.length; j += i) {
                    vis[j] = true;
                }
            }
        }
    }

    public int nonSpecialCount(int l, int r) {
        init();
        int res = 0;
        for (int i : prime) {
            if (i < l) continue;
            if (i > r) break;
            res++;
        }
        return   (r - l + 1) - res;
    }
}


