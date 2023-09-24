package leetcode.algorithm.demo;

import java.util.Arrays;
import java.util.Stack;

/**
 * @program: LeetCodeSolution
 * @description:
 * @author: WhyWhatHow
 **/

public class Solution_503 {

    public static void main(String[] args) {
        Solution_503 sol = new Solution_503();
        System.out.println("==================");
        int[] ints = sol.nextGreaterElements(new int[]{
                1, 2, 3, 4, 3
//                -2, -1
        });
        System.out.println(ints.toString());
    }

    public int[] nextGreaterElements(int[] nums) {
        int[] res = new int[nums.length];
        Arrays.fill(res, -1);
        if (res.length == 1) return res;
        Stack<Integer> stack = new Stack();
        for (int i = 0; i < 2 * nums.length; i++) {
            int temp = i % nums.length;
            while (!stack.empty() && (nums[stack.peek()] < nums[temp])) {
                    res[stack.pop()] = nums[temp];
            }
            stack.push(temp);
        }

        return res;
    }

    // ugly
    public int[] nextGreaterElements2(int[] nums) {

        int[] res = new int[nums.length];
        Arrays.fill(res, -1);
        if (res.length == 1) return res;
        int max = -1000000000;
        for (int num : nums) {
            max = max < num ? num : max;
        }
        boolean[] vis = new boolean[nums.length];
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        int i = 1;
        int cnt = 0;
        while (cnt < nums.length) {
            if (i == nums.length) {
                i = 0;
            }
            if (nums[i] == max) {
                res[i] = -1;
                vis[i] = true;
            }
            Integer peek = stack.peek();
            while (nums[peek] < nums[i]) {
                res[peek] = nums[i];
                vis[peek] = true;
                stack.pop();
                if (stack.empty()) break;
                peek = stack.peek();
            }
            if (vis[cnt]) {
                cnt++;
            } // count the nums has been record.
            stack.push(i);
            i++;
        }

        return res;
    }
}


