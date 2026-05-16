package leetcode.algorithm.binarysearch;

/**
 * @program: LeetCodeSolution
 * @description:
 * @author: WhyWhatHow
 **/

public class Solution_154 {
    public static void main(String[] args) {
        Solution_154 sol = new Solution_154();
        System.out.println(sol.findMin20260516(
                new int[]{1, 3, 3}

        ));
    }

    public int findMin20260516(int[] nums) {
        int n = nums.length;
        int l = 0, r = n - 1;
        while (l <= r) {

            int mid = l + (r - l) / 2;
            if (nums[mid] < nums[r]) { //[mid+1, r] range no minVal ==> [l,mid]
                r = mid;
            } else if (nums[mid] > nums[r]) { // [l,mid] no minVal
                l = mid+1;
            }else { // nums[mid] ==nums[r] ==> [l,r] ->[l,r-1] remove nums[r].
                r--;
            }
//            if (nums[l] >= nums[r])
        }
        return nums[l];
    }


    public int findMin(int[] nums) {
        int n = nums.length;
        int l = 0, r = n - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] < nums[r]) { // [mid+1,r ] 没有最小值
                r = mid;
            } else if (nums[mid] > nums[r]) { // [l,mid]之间没有最小值.换句话说, 最小值一定出现在区间[mid+1,r] 中.
                l = mid + 1;
            } else {
                r--;
            }
        }
        return nums[l];
    }
}


