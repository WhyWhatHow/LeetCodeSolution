package leetcode.algorithm.medium;

/**
 * @program: LeetCodeSolution
 * @description: #
 * @author: WhyWhatHow
 **/

public class Solution_3191 {

    public static void main(String[] args) {
        Solution_3191 sol = new Solution_3191();
        System.out.println(sol.minOperations(new int[]{
                0, 1, 1, 1, 0, 0
//                0, 1, 1, 1
        }));
        System.out.println("==================");
    }

    public int minOperations(int[] nums) {
        int cnt = 0;
        int n = nums.length;
        // 1^1 =0 . 0^1 = 1;
        int l = 0;
        boolean yes = true;
        while (l < n) {
            if (nums[l] == 0) {
                if (l + 1 >= n || l + 2 >= n) {
                    yes = false;
                    break;
                }
                cnt++;
                nums[l] ^= 1;
                nums[l + 1] ^= 1;
                nums[l + 2] ^= 1;
            }
            l++;
        }
        return yes ? cnt : -1;
    }

    public int minOperationsStupid(int[] nums) {
        int cnt = 0;
        boolean yes = true;
        int l = 0, r = 0;
        int n = nums.length;
        int sum = 0;
        while (r < n) {
            if (nums[r] == 0) {
                cnt++;
                l = r;
                int tmp = 0;
                while (r < n && tmp < 3) {
                    nums[r] = nums[r] == 0 ? 1 : 0;
                    r++;
                    tmp++;
                }
                if (tmp < 3) {
                    yes = false;
                    break;
                }
                r = l;
            }
            if (r == n) break;
            sum += nums[r];
            r++;
        }
        yes = sum == n ? true : false;

        return yes ? cnt : -1;
    }
}


