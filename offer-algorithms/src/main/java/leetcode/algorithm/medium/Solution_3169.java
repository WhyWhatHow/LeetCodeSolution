package leetcode.algorithm.medium;

import java.util.Arrays;

/**
 * @program: LeetCodeSolution
 * @description: #
 * @author: WhyWhatHow
 **/

public class Solution_3169 {

    public static void main(String[] args) {
        Solution_3169 sol = new Solution_3169();
        System.out.println(sol.countDays(10, new int[][]{
                {5,7},{1,3},{9,10}
        }));
        System.out.println("==================");
    }

    public int countDays(int days, int[][] meetings) {
        Arrays.sort(meetings, (a, b) -> a[0] - b[0]);
        int cnt = meetings[0][0] - 1;
        //
        int st = meetings[0][0];
        int end = meetings[0][1];
        for (int i = 1; i < meetings.length; i++) {
            int s = meetings[i][0], e = meetings[i][1];
            if (s <= end) {
                end = Math.max(end, e);
            } else {
//                if(e<end) continue;
                cnt+=s-end-1;
                end = e;
                st =s;
            }
        }
        cnt+=days-end;
        return cnt;

    }

}


