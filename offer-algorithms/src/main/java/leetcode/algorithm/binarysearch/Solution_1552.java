package leetcode.algorithm.binarysearch;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @program: LeetCodeSolution
 * @description: #
 * @author: WhyWhatHow
 **/

public class Solution_1552 {

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>(3);
        Solution_1552 sol = new Solution_1552();
        System.out.println(sol.maxDistance(new int[]{
//                1, 2, 3, 4, 7
                5,4,3,2,1,1000000000
        },
//                3
                2
        ));
        System.out.println("==================");
    }

    public int maxDistance(int[] position, int m) {
        Arrays.sort(position);
        int right = position[position.length - 1]- position[0]; // |x-y| max val
        return search(position, m, 0, right);
    }

    private int search(int[] nums, int limit, int left, int right) {
        int mid, res = -1;
        while (left <= right) {
            mid = left + (right - left) / 2;
            if (check(nums, limit, mid)) {
                left = mid + 1;
                res = mid;
            } else {
                //
                right = mid - 1;
            }
        }
        return res;
    }

    private boolean check(int[] nums, int limit, int target) {
        int right = 0;
        // target 表示最小步数 .
        int cnt = 1;
        int left = 0;
        boolean yes = false;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] - nums[left] >= target) {
                left = i;
                cnt++;
            }
            if (cnt >= limit ) return true;
        }

        return false;
    }


}
