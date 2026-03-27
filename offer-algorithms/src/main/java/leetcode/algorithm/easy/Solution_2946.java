package leetcode.algorithm.easy;

/**
 * @program: LeetCodeSolution
 * @description: #
 * @author: WhyWhatHow
 **/
public class Solution_2946 {

    public static void main(String[] args) {
        Solution_2946 sol = new Solution_2946();//
        System.out.println(sol.areSimilar(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}, 4));

        System.out.println("==================");
    }

    public boolean areSimilar(int[][] mat, int k) {
        int n = mat[0].length;
//        k = k % n;
        for (int[] a : mat) {
            for (int i = 0; i < n; i++) {
                if (a[i] != a[(i + k) % n])
                    return false;
            }
        }
        return true;
    }
}
