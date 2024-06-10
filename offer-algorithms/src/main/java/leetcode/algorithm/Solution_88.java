package leetcode.algorithm;

/**
 * @program: LeetCodeSolution
 * @description:
 * @author: WhyWhatHow
 * @create: 2020-05-07 12:09
 **/

public class Solution_88 {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] arr = new int[m];
        for (int i = 0; i < m; i++) {
            arr[i] = nums1[i];
        }
        int i = 0, j = 0, k = 0;
        while (i < m && j < n) {
            if (arr[i] <= nums2[j]) {
                nums1[k++] = arr[i++];
            } else {
                nums1[k++] = nums2[j++];
            }
        }
        while (i < m) nums1[k++] = arr[i++];
        while (j < n) nums1[k++] = nums2[j++];
    }

    public int mySqrt(int x) {
        double floor = Math.floor(Math.sqrt(x));
        return (int) floor;
    }
    public static void main(String[] args) {
        Solution_88 sol = new Solution_88();
        System.out.println("==================");
    }
}


