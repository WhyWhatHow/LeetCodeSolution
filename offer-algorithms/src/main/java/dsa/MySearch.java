package dsa;

/**
 * @program: LeetCodeSolution
 * @description:
 * @author: WhyWhatHow
 * @create: 2020-12-24 15:19
 **/
public class MySearch {
    // 返回下标 最左测下标
    int binarySearch(int[] nums, int target) {
        int l = 0, r = nums.length - 1, mid = -1, ans = -1;
        while (l <= r) {
            mid = l + (r - l) / 2;
            if (nums[mid] <= target) {
                ans = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return ans;
    }

}
