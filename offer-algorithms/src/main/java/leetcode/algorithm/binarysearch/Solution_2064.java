package leetcode.algorithm.binarysearch;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @program: LeetCodeSolution
 * @description: #
 * @author: WhyWhatHow
 **/

public class Solution_2064 {

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>(3);
        Solution_2064 sol = new Solution_2064();
        System.out.println("==================");
    }

    public int minimizedMaximum(int n, int[] quantities) {
        Arrays.sort(quantities);
        int right = quantities[quantities.length - 1];
        return search(quantities, n, 1, right);
    }

    // m种产品-> n号商店(商店可以不保存数量) ,

    /**
     * @param nums
     * @param n     (limit)
     * @param left
     * @param right
     * @return m 中产品,放在n个商店的最大值.
     */
    private int search(int[] nums, int n, int left, int right) {
        int mid;
        int res = 0;
        while (left <= right) {
            mid = left + (right - left) / 2;
            if (check(mid, nums, n)) {
                res = mid;
                right = mid - 1; // 最小化分配
            } else
                left = mid + 1;
        }
        return res;
    }

    // mid: 表示每家商店的最小库存.
    private boolean check(int mid, int[] nums, int n) {
        int cnt = 0;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] < mid) cnt++;
            else {
                cnt += nums[i] / mid;
                if (nums[i] % mid != 0) {
                    cnt++;
                }
            }
            if (cnt > n) return false;
        }
        return true;
    }

}
