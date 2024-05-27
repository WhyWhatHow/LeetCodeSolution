package leetcode.algorithm.array;

import java.util.Arrays;

/**
 * @program: LeetCodeSolution
 * @description:
 * @author: WhyWhatHow
 **/

public class Solution_2028 {

    public static void main(String[] args) {
        Solution_2028 sol = new Solution_2028();
        System.out.println(sol.missingRolls(new int[]{
//                        1, 2, 3, 4
//                        1, 5, 6
                3,5,3
                },
//                6, 4
//                3, 4
                5,3
        ));


        System.out.println("==================");
    }


    public int[] missingRolls(int[] rolls, int mean, int n) {
        int sum = 0;
        for (int roll : rolls) {
            sum += roll;
        }
        int all = (rolls.length + n) * mean;

        int val = (all - sum) / n;
        int mod = (all - sum) % n;
        if (val > 6 || val <=0) return new int[]{};

        int[] res = new int[n];

        Arrays.fill(res, val);
        int step = 6 - val;
        if(step == 0 && mod >0) return new int[]{};
        for (int i = 0; i < res.length; i++) {
            if (mod - step >= 0) {
                res[i] += step;
                mod -= step;
            } else {
                res[i] += mod;
                mod = 0;
            }
            if (mod == 0) {
                break;
            }
        }
        return res;
    }
}


