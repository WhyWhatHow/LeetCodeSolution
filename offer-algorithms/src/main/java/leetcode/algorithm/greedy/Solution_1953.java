package leetcode.algorithm.greedy;

import java.util.Arrays;

/**
 * @program: LeetCodeSolution
 * @description:
 * @author: WhyWhatHow
 **/

public class Solution_1953 {

    public static void main(String[] args) {
        Solution_1953 sol = new Solution_1953();
        int[] nums = {1, 2, 3, 4, 5}; // 注意这里是Integer数组

        // 直接逆序排序

        System.out.println(Arrays.toString(nums)); // 打印逆序排序后的数组

        System.out.println(sol.numberOfWeeks(new int[]{
//                1, 2, 3, 4,
                5, 7, 5, 7, 9, 7
//                9,3,6,8,2,1
//                5, 2, 1
        }));
        ;
        System.out.println("==================");
    }

    /**
     * #greedy
     *
     * 对milestones 进行排序, max 为最大的元素, sum 为数组之和.
     * 如果除最大元素的和小于最大元素 即 max > (sum-max), 可以让最大milestone的任务 去匹配其他任务, 即ans = (sum-max)*2 + 1 (+1 在最大元素中可以多添加一个)
     * else , max <= sum-max , 可以填满整个工作 --> ans = sum
     * @param milestones
     * @return
     */
    public long numberOfWeeks(int[] milestones) {
        long ans = 0;
//        Arrays.sort(milestones);
       long sum = 0;
       int max = -1 ;
        for (int mi : milestones) {
            sum+= mi;
            max = Math.max(max,mi);
        }
        // 如果 排除掉最大的
        if( max > sum-max){
            ans = 2*(sum-max)+1;
        }else {
            ans = sum ;
        }

        return ans;
    }

}


