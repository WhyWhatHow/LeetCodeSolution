package leetcode.algorithm;

import com.sun.jmx.remote.internal.ArrayQueue;

import java.util.*;

/**
 * @program: LeetCodeSolution
 * @description:
 * @author: WhyWhatHow
 * @create: 2020-05-07 12:09
 **/
public class Solution_239 {
    /**
     * 求滑动窗口的最大值,线性时间内
     * 思路: 双端队列，保证队首是最大元素,
     *
     *
     *
     * @param nums
     * @return
     */
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> queue = new ArrayDeque(k);
        int[] ans = new int[nums.length - k + 1];
        int cnt = 0;
        for (int i = 0; i < nums.length; i++) {
            // 判断队列是否已满
            if (queue.size() == k) {
                queue.pollFirst();
                // 寻找队内最大元素

            }
            Integer first = queue.peekFirst();
            if (first == null) {
                //right
                queue.addLast(nums[i]);
            } else if (first > nums[i]) {

                queue.addLast(nums[i]);
            } else {
                while (first < nums[i]) {
                    //right
                    queue.pollFirst();
                    if (queue.size() == 0) {
                        queue.addFirst(nums[i]);
                        break;
                    }
                    first = queue.getFirst();
                }
            }

            // 判断插入元素大于或者小于

            // 第一次到达滑动窗口处

            if (i < k - 1) {
                continue;
            }
            ans[cnt++] = queue.getFirst();
            //
        }

        return ans;
    }


    public static void main(String[] args) {
        Solution_239 sol = new Solution_239();
//        int[] temp = new int[]{1, 3, -1, -3, 5, 3, 6, 7};
//        int[] temp = new int[]{1,-1};
        int[] temp = new int[]{1,3,1,2,0,5};
        int[] ints = sol.maxSlidingWindow(temp, 3);

        for (int anInt : ints) {
            System.out.println(anInt + ",");
        }

    }
}
