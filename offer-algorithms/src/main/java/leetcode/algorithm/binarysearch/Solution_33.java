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
        int l = 0, r = n - 1;

        if (n == 1) return nums[0] == target ? 0 : -1;
        // find min Index -> i
        int i = -1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if ((mid + 1 < n && nums[mid] < nums[mid + 1])
                    && (mid - 1 >= 0 && nums[mid] < nums[mid - 1])) {
                i = mid;
                break;
            }
            // [l,mid] , [mid+1, r]
            if (nums[mid] <= nums[r]) {  // min -> [l,mid]
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }

        // [0,l-1] , [l,n-1]
        int res = binarysearch(nums, 0, i - 1, target);
        if (res == -1) res = binarysearch(nums, i, n - 1, target);
        return res;
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


