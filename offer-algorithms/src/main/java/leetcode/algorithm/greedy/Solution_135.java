package leetcode.algorithm.greedy;

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
                1,3,2,2,1
        }));;
        System.out.println("==================");
    }

    //    每个孩子至少分配到 1 个糖果
//    相邻两个孩子评分更高的孩子会获得更多的糖果
    public int candy(int[] ratings) {

        int min = 30000;
        int ans = 0;
        int start = -1;
        int[] nums = new int[ratings.length];

        // find start loc
        for (int i = 0; i < ratings.length; i++) {
            if (min > ratings[i]) {
                min = ratings[i];
                start = i;
            }
        }

        nums[start] = 1;
        //start -> n
        for (int i = start + 1; i < ratings.length; i++) {
            if (ratings[i] > ratings[i - 1]) {
                nums[i] = nums[i - 1] + 1;
            } else {
                nums[i] = nums[i - 1] - 1 > 0 ? nums[i - 1] - 1 : 1;
            }
        }
        // start -> 0
        for (int i = start - 1; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                nums[i] = nums[i + 1] + 1;
            } else {
                nums[i] = nums[i + 1] - 1 > 0 ? nums[i + 1] - 1 : 1;
            }
        }
        for (int num : nums) {
            ans += num;
        }
        return ans;
    }


}



