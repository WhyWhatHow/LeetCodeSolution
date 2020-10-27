package leetcode.algorithm;

/**
 * @program: LeetCodeSolution
 * @description:
 * @author: WhyWhatHow
 * @create: 2020-05-07 12:09
 **/

public class Solution_26 {
    /***
     *
     * @param nums
     * @return
     */
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int cnt = 1;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                continue;
            } else {
                nums[cnt++] = nums[i+1];
            }
        }
        for (int i = 0; i < cnt; i++) {
            System.out.println(nums[i]);
        }
        return cnt;
    }

    public static void main(String[] args) {
        Solution_26 sol = new Solution_26();
//        sol.removeDuplicates(new int[]{1, 1, 2});
        sol.removeDuplicates(new int[]{0,0,1,1,1,2,2,3,3,4});

        System.out.println("==================");
    }
}


