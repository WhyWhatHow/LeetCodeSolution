package leetcode.algorithm.mstack;

import java.util.PriorityQueue;
import java.util.Stack;

/**
 * @program: LeetCodeSolution
 * @description:
 * @author: WhyWhatHow
 **/

public class Solution_1673 {

    public static void main(String[] args) {
        Solution_1673 sol = new Solution_1673();
        System.out.println(sol.mostCompetitive(new int[]{
//                        4, 2, 5, 6
                        84, 10, 71, 23, 66, 61, 62, 64, 34, 41, 80, 25, 91, 43, 4, 75, 65, 13, 37, 41, 46, 90, 55, 8, 85, 61, 95, 71
                },
                24
        ));
        System.out.println("==================");
    }

    /**
     * 单调栈解决
     * res :[10,23,61,62,34,41,80,25,91,43,4,75,65,13,37,41,46,90,55,8,85,61,95,71]...
     *
     * @param nums
     * @param k
     * @return
     */
    public int[] mostCompetitive(int[] nums, int k) {
        if (k == nums.length) return nums;
        int[] res = new int[k];
        Stack<Integer> stack = new Stack<>(); // idx
        stack.push(0);
        int n = nums.length;
        for (int i = 1; i < nums.length; i++) {

            while (!stack.isEmpty()) {
                Integer idx = stack.peek();
                if (i < n - k + stack.size() && nums[i] < nums[idx]) {
                    stack.pop();
                } else {
                    break;
                }

            }
            if (stack.size() < k) {
                stack.push(i);
            }
        }
        int cnt = 0;
        for (int i = 0; i < stack.size(); i++) {
            res[cnt++] = nums[stack.elementAt(i)];
        }

        return res;
    }

    /**
     * #wrong answer
     * case :
     * [84,10,71,23,66,61,62,64,34,41,80,25,91,43,4,75,65,13,37,41,46,90,55,8,85,61,95,71]
     * k = 24
     *
     * @param nums
     * @param k
     * @return
     */
    public int[] mostCompetitivePQ(int[] nums, int k) {
        if (k == nums.length) return nums;

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            if (a[0] != b[0])
                return a[0] - b[0];
            else
                return a[1] - b[1];
        });
        int[] res = new int[k];
        int[] pos = new int[k]; // 记录下标
        int step = 0;

        for (int i = 0; i < nums.length; i++) {
            pq.add(new int[]{nums[i], i});
        }
        int cnt = 0;
        while (!pq.isEmpty() && cnt < k) {
            int[] polled = pq.poll();
            if (nums.length - polled[1] + cnt < k) continue;
            if (cnt > 0 && pos[cnt - 1] > polled[1]) continue; // 找到之前的元素了
            pos[cnt] = polled[1];
            res[cnt++] = polled[0];

        }

        return res;
    }

}


