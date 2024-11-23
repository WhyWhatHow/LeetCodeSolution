package leetcode.algorithm.easy;

/**
 * @program: LeetCodeSolution
 * @description: #
 * @author: WhyWhatHow
 **/

public class Solution_3238 {

    public static void main(String[] args) {
        Solution_3238 sol = new Solution_3238();
        System.out.println("==================");
    }


    public int winningPlayerCount(int n, int[][] pick) {
        int[][] a = new int[n][11]; // a[0][1] ,a[0][0]
        for (int[] ints : pick) {
            int x = ints[0], y = ints[1];
            a[x][y]++;
        }
        int res = 0;
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                if (a[i][j] > i) {
                    res++;
                    break;
                }
            }
        }
        return res;
    }

}


