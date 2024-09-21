package leetcode.algorithm.medium;

/**
 * @program: LeetCodeSolution
 * @description: #
 * @author: WhyWhatHow
 **/

public class Solution_2374 {

    public static void main(String[] args) {
        Solution_2374 sol = new Solution_2374();
        System.out.println("==================");
    }

    public int edgeScore(int[] edges) {
        int n = edges.length;
        long[] in = new long[n];
        for (int i = 0; i < edges.length; i++) {
            in[edges[i]] += i;
        }

        long max = -1;
        int pos = -1;
        for (int i = 0; i < in.length; i++) {
            if (max < in[i]) {
                max = in[i];
                pos = i;
            }
        }
        return pos;
    }

}


