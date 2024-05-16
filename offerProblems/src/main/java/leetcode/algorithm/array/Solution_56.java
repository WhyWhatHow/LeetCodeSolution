package leetcode.algorithm.array;

import java.util.Arrays;
import java.util.Stack;

/**
 * @program: LeetCodeSolution
 * @description:
 * @author: WhyWhatHow
 **/

public class Solution_56 {

    public static void main(String[] args) {
        Solution_56 sol = new Solution_56();

        System.out.println("==================");
    }


    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals,(a,b)->a[0]-b[0]);
        int n = intervals.length;
        Stack<int[]> stack = new Stack<>();
        stack.push(intervals[0]);
        int i = 1;
        while (i < n && !stack.isEmpty()) {
            int[] peek = stack.peek();
            if (intervals[i][0] <= peek[1]) {
                stack.pop();
                int end = peek[1]<intervals[i][1]?intervals[i][1]:peek[1];
                stack.push(new int[]{peek[0], end});
            }else{
                stack.push(intervals[i]);
            }
            i++;
        }
//        List<int[]> list = stack.reversed().reversed();
        int[][] ans  = new int[stack.size()][];
        return stack.toArray(ans);
    }
}


