package jianzhiOffer;

/**
 * @program: LeetCodeSolution
 * @description:
 * @author: WhyWhatHow
 * @create: 2020-05-22 08:10
 **/
public class Sol_51 {
    /**
     * 题目要求 数组中的逆序对个数,
     * 解决方案 : 归并排序 , 求逆序对, 默认 两个有序的数组, 存在逆序对的情况,只发生在不同的数组中.
     *
     * @param nums
     * @return
     */
    public int reversePairs(int[] nums) {
        if (nums.length < 2) {// 数组长度为1, 或者0
            return 0;
        }
        int[] temp = new int[nums.length];
        int left = 0, right = nums.length - 1;
        return mergeSort(left, right, nums, temp);
    }

    /**
     * 利用归并排序解决逆序对
     * 闭区间 [left,right],-> [left,mid], [mid+1,right] 区间进行处理
     * 不保存原始数组
     *
     * @param left
     * @param right
     * @param nums
     * @param temp
     * @return
     */
    private int mergeSort(int left, int right, int[] nums, int[] temp) {
        if (left == right) {
            return 0;
        }
        int mid = left + ((right - left) >> 1);
        int solLeft = mergeSort(left, mid, nums, temp);
        int solRight = mergeSort(mid + 1, right, nums, temp);
        int sol = merge(left, mid, right, nums, temp);
        return sol + solLeft + solRight;
    }

    /**
     * 合并 [left,mid] 与 [mid+1,right] 两个数组
     *
     * @param left
     * @param mid
     * @param right
     * @param nums
     * @param temp
     * @return
     */
    private int merge(int left, int mid, int right, int[] nums, int[] temp) {
        int cnt = 0;
        int i = left, j = mid + 1, k = left;
//        [left,mid][mid+1, right]
        while (i <= mid && j <= right) {
            // [left,mid] x <=[mid+1,right] y
            if (nums[i] <= nums[j]) {// 归并排序,默认有序, 有序: 不改变 2,2, 的顺序
                temp[k++] = nums[i++];

            } else if (nums[j] < nums[i]) {
                temp[k++] = nums[j++];
                cnt = cnt + (mid - i + 1);
            }
        }
        while (i <= mid) temp[k++] = nums[i++];
        while (j <= right) temp[k++] = nums[j++];
        for (int l = left; l <= right; l++) {
            nums[l] = temp[l];
        }
        return cnt;
    }

    public static void main(String[] args) {
        Sol_51 sol = new Sol_51();
        int i = sol.reversePairs(new int[]{
                7, 5, 6, 4
        });
        System.out.println(i);
        System.out.println("=======");
    }
}
