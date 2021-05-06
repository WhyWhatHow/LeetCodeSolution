package leetcode.algorithm;

import java.util.Arrays;

/**
 * @program: LeetCodeSolution
 * @description:
 * @author: WhyWhatHow
 * @create: 2020-05-07 12:09
 **/

public class Solution_153 {
    /**
     *  把数组分为两个区间[left,mid] [mid+1,right] 比较两者的最大值, 即nums[mid], nums[right]的大小,可以判断 最小值所在的区间,返回值一定是nums[left]
     * @param nums
     * @return
     */
    public int findMin(int[] nums) {
//        Arrays.sort(nums);
//        return nums[0];
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int mid = -1;
        int left = 0, right = nums.length - 1;
        // 判断是否是升序 未旋转的
        if (nums[left] <= nums[right]) {
            return nums[left];
        }

        while (left < right) {//不可以是 left<=right 会发生越界现象
            mid = (left+right)>>1;
            if (nums[right]<= nums[mid]) {
                left = mid+1;
            } else {
                right = mid;
            }
        }
        return nums[left];
    }

    public static void main(String[] args) {
        Solution_153 sol = new Solution_153();
        int min = sol.findMin(new int[]{
//                3, 4, 5, 1, 2
//            2,1
                3,1,2
        });
        System.out.println(min);
        System.out.println("==================");
    }
}


