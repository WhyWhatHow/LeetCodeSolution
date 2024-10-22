package leetcode.algorithm.medium;

/**
 * @program: LeetCodeSolution
 * @description: #
 * @author: WhyWhatHow
 **/

public class Solution_3185 {

    public static void main(String[] args) {
        Solution_3185 sol = new Solution_3185();
        System.out.println(sol.countCompleteDayPairs(new int[]{
                1, 49, 289
        }));
        System.out.println("==================");
    }

    /**
     * hours.length <=5*10^5, 所以需要策略.
     * [...,i) 范围内, 与 hours[i] 之和是24 整数倍的.
     *
     * @param hours
     * @return
     */
    public long countCompleteDayPairs(int[] hours) {
        long res = 0;
        int[] a = new int[24];
        a[hours[0]%24]++;
        for (int i = 1; i < hours.length; i++) {
            int mod = hours[i] % 24;
            int key = mod == 0 ? 0 : 24 - mod;
            res += a[key];
            a[mod]++;
        }
        return res;
    }
}


