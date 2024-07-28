package leetcode.algorithm.hard;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: LeetCodeSolution
 * @description: #
 * @author: WhyWhatHow
 **/

public class Solution_699 {

    public static void main(String[] args) {
        Solution_699 sol = new Solution_699();
        System.out.println(sol.fallingSquares(new int[][]{
//                {1, 2},
//                {2, 3},
//                {6, 1}
///////
//                {6, 1},
//                {9, 2},
//                {2, 4}
                /////////////
                {9, 6},
                {2, 2},
                {2, 6}
                /////
//                {9, 1},
//                {6, 5},
//                {6, 7}
        }));
        System.out.println("==================");
    }

    public List<Integer> fallingSquares(int[][] positions) {
        List<Integer> list = new ArrayList<Integer>();
        list.add(0, positions[0][1]);
        int[] rs = new int[positions.length];
        // init right
        for (int i = 0; i < positions.length; i++) {
            rs[i] = positions[i][0] + positions[i][1];
        }

        for (int i = 1; i < positions.length; i++) {

            int curLeft = positions[i][0];
            int curHeight = positions[i][1];
            int curRight = curHeight + curLeft;
            int max = curHeight;
            for (int j = 0; j < i; j++) {
                Integer jh = list.get(j);
                if (j == 0) jh += positions[j][0];

                if ((curLeft <= positions[j][0] &&  positions[j][0] < curRight ) || // left
                        (curLeft >= positions[j][0] && curRight <= rs[j]) || // in
                        (curRight > rs[j] && curLeft < rs[j] )) { // right
                    int h = curHeight + jh;
                    if (j == 0) h -= positions[j][0];
                    max = Math.max(max, h);
                }
            }

            list.add(i, max);
        }

        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i + 1) < list.get(i)) {
                list.set(i + 1, list.get(i));
            }
        }
        return list;
    }

//    boolean checkRange(int check, int[][] positions, int j) {
//
//    }
}


