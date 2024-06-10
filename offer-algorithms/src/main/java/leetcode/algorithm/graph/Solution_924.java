package leetcode.algorithm.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @program: LeetCodeSolution
 * @description: bfs
 * @author: WhyWhatHow
 **/

public class Solution_924 {

    public static void main(String[] args) {
        Solution_924 sol = new Solution_924();

        System.out.println("==================");
    }

    public int minMalwareSpread(int[][] graph, int[] initial) {
        int res = 0;
        int max = -1;
        Arrays.sort(initial);
        for (int i : initial) {
            int cnt = 0;
            for (int j = 0; j < graph[i].length; j++) {
                if (i != j && graph[i][j] == 1) {
                    cnt++;
                }
            }
            if (max < cnt) {
                max = cnt;
                res = i;
            }
        }
        return res;
    }

}


