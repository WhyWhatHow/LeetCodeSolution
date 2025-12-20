package leetcode.algorithm.easy;

/**
 * @program: LeetCodeSolution
 * @description: #
 * @author: WhyWhatHow
 **/

public class Solution_944 {

    public static void main(String[] args) {
        Solution_944 sol = new Solution_944();
        System.out.println("==================");
    }

    public int minDeletionSize(String[] strs) {
        int n = strs.length;
        int m = strs[0].length();
        int cnt = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (strs[j - 1].charAt(i) > strs[j].charAt(i)) {
                    cnt++;
                    break;
                }
            }
        }
        return cnt;
    }

}


