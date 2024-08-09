package leetcode.algorithm.medium;

import java.util.Arrays;

/**
 * @program: LeetCodeSolution
 * @description: #
 * @author: WhyWhatHow
 **/

public class Solution_3132 {

    public static void main(String[] args) {
        Solution_3132 sol = new Solution_3132();
        System.out.println(sol.minimumAddedInteger(new int[]{
//                4, 20, 16, 12, 8
//                3, 3, 5, 5
//                7, 9, 1, 4
                9,4,3,9,4
        }, new int[]{
//                14, 18, 10
//                7, 7
//                0, 8
                7,8,8
        }));
        System.out.println("==================");
    }

    /**
     * #medium
     */
    public int minimumAddedInteger(int[] a, int[] b) {
        Arrays.sort(a);
        Arrays.sort(b);
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < a.length; i++) {
            for (int j = i + 1; j < a.length; j++) {
                res = Math.min(res, handle(i, j, a, b));
            }
        }
        return res;
    }

    private int handle(int pb, int pa, int[] a, int[] b) {
        // a[] , pa, pb can not chose
        int res = Integer.MAX_VALUE;
        int i = 0, j = 0;
        int cur = Integer.MIN_VALUE;
        boolean yes =true;
        while (j < b.length && i < a.length) {
            if (i == pa || i == pb) {
                i++;
                continue;
            }
            if (cur == Integer.MIN_VALUE) {
                cur = b[j] - a[i];
            } else if (cur != b[j] - a[i]) {
                yes =false ;
                break;
            }
            i++;
            j++;
        }
        if (yes) res = cur;
        return res;
    }


}


