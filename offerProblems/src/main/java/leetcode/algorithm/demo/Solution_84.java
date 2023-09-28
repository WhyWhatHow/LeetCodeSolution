package leetcode.algorithm.demo;

import java.util.Arrays;
import java.util.Stack;

/**
 * @program: LeetCodeSolution
 * @description:
 * @author: WhyWhatHow
 **/

public class Solution_84 {

    public static void main(String[] args) {
        Solution_84 sol = new Solution_84();
        System.out.println("==================");
        System.out.println(sol.largestRectangleArea(new int[]{
//                2, 1, 5, 6, 2, 3
//                2, 4
//                2,1,2
                4,0,3,2,5
        }));
    }

    public int largestRectangleArea(int[] heights) {
        int res = 0;
        Stack<Integer> stack = new Stack<>();
//        int[] h = new int[heights.length + 1];
        int[] h = Arrays.copyOf(heights, heights.length+1);
//        h[h.length - 1] = 0;
        for (int i = 0; i < h.length; i++) {

            while (!stack.empty() && h[stack.peek()] > h[i]) {
                Integer pop = stack.pop();
                //
                int left = stack.empty() ? 0 : stack.peek()+1;
                int width = i - left;
                int area = width * h[pop];
                res = Math.max(res, area);
            }
            stack.push(i);
        }
        return res;
    }

}


