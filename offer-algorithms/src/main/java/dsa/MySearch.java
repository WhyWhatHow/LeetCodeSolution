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

    /**
     * [)  开区间写法
     */
    int search(int[] a, int target) {
        int l = 0, r = a.length;
        int mid = r / 2;
        int res = -1;
        while (l < r) {
            mid = l + (r - l) / 2;
            if (a[mid] <= target) {
                res = mid;
                l = mid + 1;// 最大值 <=target
            } else {
                r = mid;
//                res = mid;  // 最小值 >=target
            }
        }
        return res;
    }

    //[] 闭区间, 二分查找
    int search(int[] a, int target, int l, int r) {
        int res = -1;
        int mid = l + (r - l) / 2;
        while (l <= r) {
            mid = l + (r - l) / 2;
            if (a[mid] >= target) {
                l = mid + 1;
                res = mid; // min>=target
            } else {
                r = mid - 1;
            }
        }
        return res;
    }

}
