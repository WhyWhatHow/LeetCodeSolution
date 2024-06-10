package leetcode.algorithm.demo;

/**
 * @program: LeetCodeSolution
 * @description:
 * @author: WhyWhatHow
 **/

public class Solution_55 {

    public static void main(String[] args) {
        Solution_55 sol = new Solution_55();
        System.out.println("==================");
        System.out.println(sol.canJump(new int[]{
//            2,3,1,1,4
                1, 0, 1, 0
        }));
    }

    // #greedy
    // nums[i] == 0 --> can't go to this position
    public boolean canJump(int[] nums) {

        if (nums.length == 1) {
            return true;
        }
        int cover = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (cover >= i)
                cover = Math.max(cover, i + nums[i]);
        }
        return cover >= nums.length - 1;
    }
}


