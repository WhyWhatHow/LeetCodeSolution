package leetcode.algorithm;

/**
 * @program: LeetCodeSolution
 * @description:
 * @author: WhyWhatHow
 * @create: 2020-05-07 12:09
 **/

public class Solution_189 {
    // o(1)space
    public void rotate(int[] nums, int k) {
        if (nums.length == 1) return;
        k = k % nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
        return;
    }

    void reverse(int[] a, int start, int end) {
        while (start < end) {
            int temp = a[start];
            a[start] = a[end];
            a[end] = temp;
            start++;
            end--;
        }
    }

    // o(n) space
    public void rotate2(int[] nums, int k) {
        int[] arrs = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            arrs[(i + k) % nums.length] = nums[i];// 可以不用算,吗直接移位
        }
        for (int i = 0; i < arrs.length; i++) {
            nums[i] = arrs[i];
        }
    }
//
//    public void rotate(int[] nums, int k) {
//        if (nums == null || nums.length == 0) {
//            return;
//        }
//        k = k % nums.length;
//        int temp = nums[0];
//        int temp1 ;
//        int cnt = 0;
//        while (cnt < nums.length) {
//            int loc = cnt+k
//            temp1 = nums[cnt+k];
//            nums[cnt+k]=temp;
//        }
//        for (int num : nums) {
//            System.out.println(num);
//        }
//    }

    public static void main(String[] args) {
        Solution_189 sol = new Solution_189();
        System.out.println("==================");
    }
}


