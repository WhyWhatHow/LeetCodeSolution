package leetcode.algorithm.demo;

/**
 * @program: LeetCodeSolution
 * @description:
 * @author: WhyWhatHow
 **/

public class Solution_2369 {

    public static void main(String[] args) {
        Solution_2369 sol = new Solution_2369();
        Integer num = new Integer(4);
        int length = num.toString().length();
        System.out.println("==================");
    }

    public int[] findColumnWidth(int[][] grid) {

        int[] ans = new int[grid[0].length];
        int len = ans.length;
        for (int i = 0; i < len; i++) {

            for (int j = 0; j < grid.length; j++) {
//                grid[j][i];
                int len1 = getLen(grid[j][i]);
                if (ans[i]<len1) {
                    ans[i] = len1;
                }
            }
        }
        return ans;
    }

    int getLen(Integer num) {
//        int res = 0;
//        if (num < 0) res++;
      return   num.toString().length();
//        return res;
    }

}


