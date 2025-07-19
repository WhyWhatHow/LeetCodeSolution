package leetcode.algorithm.heap;

import java.util.PriorityQueue;

/**
 * @program: LeetCodeSolution
 * @description: #
 * @author: WhyWhatHow
 **/

public class Solution_2163 {

    public static void main(String[] args) {
        Solution_2163 sol = new Solution_2163();

        System.out.println(sol.minimumDifference(new int[]{
//                7, 9, 5, 8, 1, 3
                16, 46, 43, 41, 42, 14, 36, 49, 50, 28, 38, 25, 17, 5, 18, 11, 14, 21, 23, 39, 23
        }));
        System.out.println("==================");
    }

    /**
     * 设sum(nums[0,n)) =s1, sum(nums[2n, 3n)) = s2 ;
     * 题目要求 s1-s2 的最小值.
     * 那么, 需要做的是 :让s1 尽可能的小, s2 尽可能的大.
     * 需要处理的就是[n,2n) 范围内, 让数小的 去替换s1中的大数, 让数大的去替换s2的小数, 那么, 要如何取得最终结果呢?
     * 假设分割点是 n+2,  也就意味着: s1 会删掉两个最大值. 对应的, s2 会删掉[2n-1-n-2=> n-3个最小值.
     * 我们所需要做的, 就是 枚举分割点,  判断这个过程中所给出的最大值.
     *
     * @param nums
     * @return
     */
    public long minimumDifference(int[] nums) {
        int n = nums.length / 3;
        PriorityQueue<Integer> minpq = new PriorityQueue<>(); //
        PriorityQueue<Integer> maxpq = new PriorityQueue<>((a, b) -> b - a); //

        //[2n,3n)
        long sum = 0;
        for (int i = 2 * n; i < nums.length; i++) {
            sum += nums[i];
            minpq.add(nums[i]);
        }

        //[n,2n) 后面的, 总值越大越好.
        long[] ss = new long[n + 1];// 表示[n,2n) 之间的和. 值越大越好.
        ss[n] = sum;// 表示2n的取值.
        for (int i = 2 * n - 1; i >= n; i--) {
            if (minpq.peek() < nums[i]) {
                Integer cur = minpq.poll();
                sum = sum - cur + nums[i];
                minpq.add(nums[i]);
            }
            ss[i - n] = sum;
            // if minpq.peek() > nums[i] , nums[i] 会被丢弃, 不变.
        }


        // [0,n) sum , maxheap
        long presum = 0;
        for (int i = 0; i < n; i++) {
            presum += nums[i];
            maxpq.add(nums[i]);
        }

//         处理s1 [n,2n)
        long ans = presum - ss[0]; // pre: [0,n) , sufs:[n,3n)
        for (int i = n; i < 2 * n; i++) {
            if (maxpq.peek() > nums[i]) {
                Integer cur = maxpq.poll();
                presum = presum - cur + nums[i];
                maxpq.add(nums[i]);
            }
            ans = Math.min(ans, presum - ss[i - n + 1]);
        }
        return ans;
    }

}


