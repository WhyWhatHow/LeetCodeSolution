package jianzhiOffer;

/**
 * @program: LeetCodeSolution
 * @description:
 * @author: WhyWhatHow
 * @create: 2020-05-22 08:10
 **/
public class Sol_4 {
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
        int mid = cnt/2;
        if(cnt%2 ==0){
            return (double )(nums[mid]+nums[mid-1])/2.0;
        }
        else
            return (double) nums[mid];

    }

    public static void main(String[] args) {
        Sol_4 sol = new Sol_4();
        int[] a= new int[]{1,2};
        int[] aa= new int[]{3,4};
        sol.findMedianSortedArrays(a,aa);
    }
}
