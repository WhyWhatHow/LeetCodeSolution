package leetcode.algorithm.medium;

/**
 * @program: LeetCodeSolution
 * @description: #
 * @author: WhyWhatHow
 **/

public class Solution_3115 {

    public static void main(String[] args) {
        Solution_3115 sol = new Solution_3115();
        System.out.println(2 << 1);
        System.out.println(sol.maximumPrimeDifference(new int[]{

        }));
        ;
        System.out.println("==================");


    }

    int MAX = 300006;
    int[] prime = new int[MAX];
    boolean[] vis = new boolean[MAX];

    void initPrime() {
        int cnt = 0;
        vis[0] = vis[1] = true;
        for (int i = 2; i < prime.length; i++) {
            if (!vis[i]) {
                prime[cnt++] = i;
                for (int j = i << 1; j < MAX; j += i) {
                    vis[j] = true;
                }
            }
        }
    }

    public int maximumPrimeDifference(int[] nums) {
        initPrime();
        int left = -1, right = -1;
        for (int i = 0; i < nums.length; i++) {
            if (!vis[nums[i]]) {
                if (left < 0)
                    left = i;
                right = i;
            }
        }
        return right - left;
    }


}


