package leetcode.algorithm.medium;

/**
 * @program: LeetCodeSolution
 * @description: #
 * @author: WhyWhatHow
 **/

public class Solution_3254 {

    public static void main(String[] args) {
        Solution_3254 sol = new Solution_3254();
        sol.resultsArray(new int[]{1, 2, 3, 4, 3, 2, 5}, 3);
        System.out.println("==================");
    }

    public int[] resultsArray(int[] nums, int k) {
        int[] ans = new int[nums.length - k + 1];
        int max = -1;
        int cnt = 0;
        for (int i = k; i < nums.length+1; i++) {
            ans[cnt++] = getMax(nums, i - k, i);
        }
        return ans;
    }

    // [l,r) k 个元素
    private int getMax(int[] nums, int l, int r) {
        boolean yes = true;
        int max = nums[l];
        for (int i = l + 1; i < r; i++) {
            if (nums[i] <= max) {
                yes = false;
                break;
            }
            max = nums[i];
        }
        return yes ? max : -1;
    }
}


