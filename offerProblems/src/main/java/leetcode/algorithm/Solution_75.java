package leetcode.algorithm;

import sun.security.util.Length;

import java.util.Arrays;
import java.util.Random;

/**
 * @program: LeetCodeSolution
 * @description:
 * @author: WhyWhatHow
 * @create: 2020-05-07 12:09
 **/

public class Solution_75 {

    public void sortColors(int[] nums) {
//        Arrays.sort(nums);
        quickSort(nums, 0, nums.length - 1);

    }

    void quickSort(int[] nums, int l, int r) {
        if (l >= r) return;
        int i = l, j = r;
        int k = nums[i];
        while (i < j) {
            while (i < j && k <= nums[j]) j--;
            nums[i] = nums[j];
            while (i < j && nums[i] < k) i++;
            nums[j] = nums[i];
        }
        nums[i] = k;
        quickSort(nums, l, i - 1);
        quickSort(nums, i + 1, r);
    }

    public static void main(String[] args) {
        Solution_75 sol = new Solution_75();
        int arr[] = new int[10];
        Random random = new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(100);
            System.out.print(arr[i] + ",");
        }
        System.out.println();
        sol.quickSort(arr, 0, 9);
        System.out.println(arr);
        System.out.println("==================");
    }

    void quickSort1(int[] a, int left, int right) {
        if (left >= right) return;
        // low , high
        int lo = left, hi = right;
        int k = a[lo];
        while (lo <= hi) {
            while (lo <= hi && k <= a[hi]) hi--;
            a[lo] = a[hi];
            while (lo <= hi && a[lo] < k) lo++;
            a[hi] = a[lo];
        }
        a[lo] = k;
        quickSort1(a, left, lo - 1);
        quickSort1(a, lo + 1, right);
    }
}


