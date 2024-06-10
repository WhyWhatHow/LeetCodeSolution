package leetcode.algorithm;

/**
 * @program: LeetCodeSolution
 * @description:
 * @author: WhyWhatHow
 * @create: 2020-05-07 12:09
 **/

public class Solution_4 {
    /**
     *     合并两个有序数组 , 然后计算中位数
      */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
    int[] nums = new int[nums1.length + nums2.length];
    int cnt = 0;
    int i = 0, j = 0;
    while (i < nums1.length && j < nums2.length) {
        if (nums1[i] <= nums2[j]) nums[cnt++] = nums1[i++];
        else  if (nums2[j] < nums1[i]) nums[cnt++] = nums2[j++];
    }
    while (i < nums1.length) nums[cnt++] = nums1[i++];
    while (j < nums2.length) nums[cnt++] = nums2[j++];
    int mid = nums.length/2;
    if(nums.length%2 ==0){
        return (double )(nums[mid]+nums[mid-1])/2.0;
    }
    else
        return (double) nums[mid];

}

    public static void main(String[] args) {
        Solution_4 sol = new Solution_4();
        System.out.println("==================");
    }
}


