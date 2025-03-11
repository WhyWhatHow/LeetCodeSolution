package leetcode.algorithm.array;

/**
 * @program: LeetCodeSolution
 * @description: #
 * @author: WhyWhatHow
 **/

public class Solution_2012 {

    public static void main(String[] args) {
        Solution_2012 sol = new Solution_2012();
        System.out.println("==================");
    }

        public int sumOfBeauties(int[] nums) {
            int[] mx = new int[nums.length];// [0,i] 最大的数
            int[] mn = new int[nums.length];// [i, n] 最小的数
            mx[0] = nums[0];
            for (int i = 1; i < nums.length; i++) {
                mx[i] = Math.max(mx[i - 1], nums[i]);
            }
            mn[nums.length - 1] = nums[nums.length - 1];
            for (int i = nums.length - 2; i >= 0; i--) {
                mn[i] = Math.min(mn[i + 1], nums[i]);
            }
            int res = 0 ;
            for(int i = 1; i< nums.length-1 ;i++){
                if(nums[i]>mx[i-1] && nums[i]<mn[i+1]) res+=2;
                else if (nums[i-1]<nums[i] && nums[i]<nums[i+1]) res+=1;
            }
            return res ;
        }

}


