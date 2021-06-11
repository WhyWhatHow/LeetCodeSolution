package jianzhiOffer;

import java.util.Arrays;

/**
 * @program: LeetCodeSolution
 * @description:
 * @author: WhyWhatHow
 * @create: 2020-05-22 08:10
 **/
public class Sol_61 {

    public boolean isStraight(int[] nums) {
        Arrays.sort(nums);
        boolean res = false;
        boolean temp = true;
        int cnt = 0;
        int all = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                cnt++;
            } else {
                break;
            }
        }
        for (int i = cnt + 1; i < nums.length; i++) {
            int val = nums[i] - nums[i - 1];
            all += val;
            if (val == 0) {
                temp = false;
            }
        }
        if (all <= 4) {
            res = true;
        }
        if (all > 4) {
            res = false;
        }
        return res && temp;
    }

    public static void main(String[] args) {
        Sol_61 sol = new Sol_61();
        System.out.println("=======");
    }
}
