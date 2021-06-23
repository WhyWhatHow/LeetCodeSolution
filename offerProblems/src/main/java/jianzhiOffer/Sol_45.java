package jianzhiOffer;

import jdk.nashorn.internal.ir.BaseNode;

import java.util.Arrays;

/**
 * @program: LeetCodeSolution
 * @description:
 * @author: WhyWhatHow
 * @create: 2020-05-22 08:10
 **/
public class Sol_45 {
    /**
     * x+y > y+x , 则返回 y+x, 否则返回x+y
     * Arrays.sort() ,
     * 利用string 重写的compareto 方法
     *
     * @param nums
     * @return
     */
    public String minNumberBySys(int[] nums) {
        StringBuilder builder = new StringBuilder();
        String[] ss = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            ss[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(ss, (x, y) -> {
            return (x + y).compareTo(y + x);
        });
//        Arrays.sort(nums, ( Integer x,Integer y) -> {
////            try {
//                int xx = Integer.parseInt(builder.append(x).append(y).toString());
//                int yy = Integer.parseInt(builder.reverse().toString());
//                return  xx - yy;
////            }catch (Exception e){
//////                int i = x - y;
//////                return i;
////                return -1;
////            }
//        });
        for (String s : ss) {
            builder.append(s);
        }
        return builder.toString();
    }

    /**
     * x+y<y+x , 返回x+y ,否则放回y+x
     *
     * @param nums
     * @return
     */
    public String minNumber(int[] nums) {
        String[] strs = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            strs[i] = String.valueOf(nums[i]);
        }
        quickSort(0, nums.length-1, strs);
        StringBuilder builder =new StringBuilder();
        for (String str : strs) {
            builder.append(str);
        }
        return builder.toString();
    }

    /**
     * [left,right] 区间
     *
     * @param left
     * @param right
     * @param strs
     */
    void quickSort(int left, int right, String[] strs) {
        if (left >= right) {
            return;
        }
        int i = left, j = right;
        String temp = strs[i];
        while (i < j) {
            // x+y < y+x, 不动
            while (i < j && (strs[left] + strs[j]).compareTo(strs[j] + strs[left]) <= 0) j--;// 从后往前找,找到第一个不满足条件的节点

            while (i < j && (strs[left] + strs[i]).compareTo(strs[i] + strs[left]) <= 0) i++;// 从前往后找,找到第一个不满足条件的节点
            // 交换i,j 的值
            temp = strs[i];
            strs[i] = strs[j];
            strs[j] = temp;
        }
        strs[i] = strs[left];
        strs[left] = temp;
        quickSort(left, i - 1, strs);
        quickSort(i + 1, right, strs);

    }

    /**
     * [left,right]
     *
     * @param left
     * @param right
     * @param nums
     */
    void quick_sort(int left, int right, int[] nums) {
        if (left >= right) {
            return;
        }
        int i = left, j = right;
        int temp = nums[left];
        while (i < j) {
            while (i < j && nums[left] < nums[j]) j--;
            nums[left] = nums[j];
            while (i < j && nums[i] <= nums[left]) i++;
            nums[j] = nums[i];
        }
        nums[i] = temp;// nums[left] 确定nums[left] 所在的位置
        quick_sort(left, i - 1, nums);
        quick_sort(i + 1, right, nums);
    }

    public static void main(String[] args) {
        Sol_45 sol = new Sol_45();
        String s = sol.minNumber(new int[]{
                1,2,3,1
        });
        System.out.println(s);
        System.out.println("=======");
    }
}
