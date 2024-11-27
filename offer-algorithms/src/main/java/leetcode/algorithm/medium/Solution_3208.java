package leetcode.algorithm.medium;

/**
 * @program: LeetCodeSolution
 * @description: #window
 * @author: WhyWhatHow
 **/

public class Solution_3208 {

    public static void main(String[] args) {
        Solution_3208 sol = new Solution_3208();
        System.out.println(sol.numberOfAlternatingGroups(new int[]{
                0, 1, 0, 0, 1, 0, 1
        }, 6));
        System.out.println("==================");
    }

    /**
     * 所有子数组
     * [0,k-1]
     * [1,k-1+1]
     * [2,k-1+2]
     * ....
     * [n-1,k-1+n]
     * 如果子数组区间中值相等,cnt 重置即可.
     *
     * @param colors
     * @param k
     * @return
     */
    public int numberOfAlternatingGroups(int[] colors, int k) {
        // 0-n-1
        int res = 0;
        int n = colors.length;
        int cnt = 0;
        for (int i = 0; i < n + k - 1; i++) {
            if ((i  > 0) && colors[i % n] == colors[(i - 1) % n]) cnt = 0;
            cnt++;
            if (cnt >= k)
                res++;
        }
        return res;
    }


}


