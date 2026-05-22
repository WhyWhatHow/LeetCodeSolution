package leetcode.algorithm.binarysearch;

/**
 * @program: LeetCodeSolution
 * @description:
 * @author: WhyWhatHow
 **/

public class Solution_33 {

    public static void main(String[] args) {
        Solution_33 sol = new Solution_33();
        System.out.println(sol.search(
                new int[]{4, 5, 6, 7, 0, 1, 2},
                3
//                new int[]{5, 1, 3},
//                5
        ));

        System.out.println("==================");
    }

    // 两次二分, 第一次找最小值 位置 i [0,i-1] [i,n-1] binary search 查找值如果存在.
    public int search(int[] nums, int target) {
        int n = nums.length;

        int l = getMin(nums, 0, n - 1);
        int i = l;
        // [0,l-1] , [l,n-1]
        int res = binarysearch(nums, 0, i - 1, target);
        if (res == -1) res = binarysearch(nums, i, n - 1, target);
        return res;
    }

    // 返回 nums[] 中 最小值的下标.做左侧的那一个.
    // 具体的判断思路, nums[mid] 与nums[r] 做比较, 判断 最小值在哪一个区间.
    // nums[mid] > nums[r]  min -> [mid+1, r]
    // nums[mid] <=nums[r]  min -> [l, mid] , 不能说明 nums[mid] 会有最小值.
    private int getMin(int[] nums, int l, int r) {

        while (l < r) { // why ? l<r not l<=r ?
            int mid = l + (r - l) / 2;

            // [l,mid] , [mid+1, r]
            if (nums[mid] > nums[r]) {  // min -> [mid+1,r]
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return l;
    }

    private int binarysearch(int[] nums, int l, int r, int target) {

        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] == target) return mid;
            if (nums[mid] < target) l = mid + 1;
            else r = mid - 1;
        }
        return -1;
    }


}


