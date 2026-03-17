package leetcode.algorithm.array;

/**
 * @program: LeetCodeSolution
 * @description:
 * @author: WhyWhatHow
 * @create: 2020-05-07 12:09
 **/

public class Solution_189 {

    public void rotate20260317(int[] nums, int k) {
        int n = nums.length;
        k = k % n;
        int start = 0;
        int cnt = 0;
        while (cnt < n) {
            int i = start; // 表示从0开始的迭代元素, 避免重复, 所以需要start++ ;
            int prev = nums[i];
            do {
                int nxt = (i + k) % n;
                int t = nums[nxt];
                nums[nxt] = prev;
                prev = t;
                i = nxt;
                cnt++;
            } while (start != i);
            start++;
        }
    }

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


