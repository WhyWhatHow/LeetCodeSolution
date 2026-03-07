package leetcode.algorithm;

/**
 * @program: LeetCodeSolution
 * @description:
 * @author: WhyWhatHow
 **/

public class Solution_153 {
    // 题目要求的是旋转升序数组, 也就是说, 旋转后分成[l,mid], [mid,r] 之前, 大概率可能是升序,的那么最大值可能出现的位置是 mid, r, 没有可能是l么, [nums[n-1], ]
    // 最小值只会出现在左右的一个区间内,
    public int findMin20260307(int[] nums) {
        int n = nums.length;
        int l = 0, r = n - 1;
        int res = -1;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] < nums[r]) { // [l,mid] 可能存在最小值, [mid+1,r] 应该排除掉.
                r = mid ;
            } else {
                l = mid + 1;
            }
        }
        return nums[l];
    }

    /**
     * 把数组分为两个区间[left,mid] [mid+1,right] 比较两者的最大值, 即nums[mid], nums[right]的大小,可以判断 最小值所在的区间,返回值一定是nums[left]
     *
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
            mid = (left + right) >> 1;
            if (nums[right] <= nums[mid]) {
                left = mid + 1;
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
                3, 1, 2
        });
        int min2 = sol.findMin20260307(new int[]{
//                3, 4, 5, 1, 2
//            2,1
                3, 1, 2
        });
        System.out.println(min2);
        System.out.println("==================");
    }
}


