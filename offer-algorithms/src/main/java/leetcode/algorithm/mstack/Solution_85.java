package leetcode.algorithm.mstack;

import java.util.Stack;

/**
 * @program: LeetCodeSolution
 * @description: #
 * @author: WhyWhatHow
 **/
public class Solution_85 {

    public static void main(String[] args) {
        Solution_85 sol = new Solution_85();
        System.out.println(sol.getMaxRectangle(new int[]{0, 1}));
        System.out.println("==================");
    }

    public int maximalRectangle(char[][] matrix) {
        int m = matrix[0].length;
        int h[] = new int[m];
        int res = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == '0') h[j] = 0;
                else h[j]++;
            }
            res = Math.max(res, getMaxRectangle(h));
        }
        return res;
    }

    private int getMaxRectangle(int[] a) {
        int n = a.length;
        int res = 0;
        var s = new Stack<Integer>();
        for (int i = 0; i <= n; i++) {
            int cur = i == n ? -1 : a[i];

            // i ==> r
            while (!s.isEmpty() && cur < a[s.peek()]) {
                Integer p = s.pop();
                int h = a[p];
                //
                int l = s.isEmpty() ? 0 : s.peek() + 1; // 获取高度=h的范围.
                int w = i - l;

                res = Math.max(res, h * w);
            }
            s.push(i);
        }
        return res;
    }


    // wa : 最大值不一定是 从[l,r] 的最小高度确定的.
//    private int getMaxRectangle(int[] a) {
//        int res = 0;
//        int l = 0, h = 0;
//        int n = a.length;
//        for (int i = 0; i < n; i++) {
//            if (a[i] == 0 || h == 0) {
//                l = i;
//                h = a[i];
//            } else {
//                h = Math.min(h, a[i]);
//            }
//            res = Math.max(res, (i - l + 1) * h);
//        }
//        //
//        res = Math.max(res, (n - l) * h);
//        return res;
//    }

}


