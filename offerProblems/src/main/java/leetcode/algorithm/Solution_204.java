package leetcode.algorithm;

/**
 * @program: LeetCodeSolution
 * @description:
 * @author: WhyWhatHow
 * @create: 2020-05-07 12:09
 **/

public class Solution_204 {

    final int MAX = 5000001;
    int[] prime = new int[MAX];
    boolean[] vis = new boolean[MAX];
    int cnt = 0;

    void getPrime(int max) {
        for (int i = 2; i < max; i++) {
            if (!vis[i]) {
                prime[cnt++] = i;
                for (int j = i << 1; j < max; j += i) {
                    vis[j] = true;
                }
            }
        }
    }

    public int countPrimes(int n) {
        getPrime(n);
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (!vis[i]) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Solution_204 sol = new Solution_204();
        int i = sol.countPrimes(13);
        System.out.println(i);
        System.out.println("==================");
    }
}


