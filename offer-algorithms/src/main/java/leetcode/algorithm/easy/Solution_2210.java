package leetcode.algorithm.easy;

/**
 * @program: LeetCodeSolution
 * @description: #
 * @author: WhyWhatHow
 **/

public class Solution_2210 {

    public static void main(String[] args) {
        Solution_2210 sol = new Solution_2210();
        System.out.println(" ans : "+sol.countHillValley(new int[]{2, 4, 1, 1, 6, 5}));
        System.out.println("==================");
    }

    public int countHillValley(int[] nums) {
        int left = 0, right = 0; // -1 < cur , 1 > cur

        int cnt = 0;
        for (int i = 1; i < nums.length - 1; i++) {
            if(nums[i] ==nums[i-1]) continue;
            for (int j = i - 1; j >= 0; j--) {
                if (nums[j] == nums[i]) continue;
                if (nums[j] > nums[i]) left = 1;
                else left = -1;
                break;
            }
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] == nums[i]) continue;
                if (nums[j] > nums[i]) right = 1;
                else right = -1;
                break;
            }
            if (right == left) {
                cnt++;
                System.out.println(i);
            }
        }
        return cnt;
    }

}


