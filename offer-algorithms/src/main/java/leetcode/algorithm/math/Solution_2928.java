package leetcode.algorithm.math;

/**
 * @program: LeetCodeSolution
 * @description: #
 * @author: WhyWhatHow
 **/

public class Solution_2928 {

    public static void main(String[] args) {
        Solution_2928 sol = new Solution_2928();
        System.out.println(sol.distributeCandies(
//                5, 2
                3, 3
        ));

        System.out.println("==================");
    }


    public long distributeCandies(int n, int limit) {
        long res = 0;
        for (int i = 0; i <= Math.min(n, limit); i++) { // i 表示第一个小朋友可以分配到的糖果数量
            if ((n - i) > 2 * limit) continue; // 超出限制.
            // 第二个小朋友 最少可以分配糖果数量是 max(0, n-i-limit)个.  最多可以分配的糖果数量是 min(n-i, limit) 个.
            res += Math.min(n - i, limit) - Math.max(0, n - i - limit) + 1;
        }
        return res;
    }

    //

}


