package leetcode.algorithm.greedy;

import java.util.Arrays;

/**
 * @program: LeetCodeSolution
 * @description:
 * @author: WhyWhatHow
 **/

public class Solution_135 {

    public static void main(String[] args) {
        Solution_135 sol = new Solution_135();
        System.out.println(sol.candy(new int[]{
//                1,0,2
                29, 51, 87, 87, 72, 12
//                1,2,2
//                1, 3, 2, 2, 1
        }));
        ;
        System.out.println("==================");
    }

    public int candy(int[] ratings) {
        int n = ratings.length;
        int[] ls = new int[n];
        int[] rs = new int[n];
        Arrays.fill(ls, 1);
        Arrays.fill(rs, 1);

        // left -> right
        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i] > ratings[i - 1]) {
                ls[i] = ls[i - 1] + 1;
            }
        }

        // right-> left
        for (int i = ratings.length - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                rs[i] = rs[i + 1] + 1;
            }
        }

        int ans = 0 ;
        for (int i = 0; i < n; i++) {
            ans += Math.max(ls[i],rs[i]);
        }
        return ans ;

    }


}



