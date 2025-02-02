package leetcode.algorithm.easy;

/**
 * @program: LeetCodeSolution
 * @description: #
 * @author: WhyWhatHow
 **/

public class Solution_598 {

    public static void main(String[] args) {
        Solution_598 sol = new Solution_598();
        System.out.println("==================");
    }

    public int maxCount(int m, int n, int[][] ops) {
        if (ops.length == 0) return m * n;
//        Arrays.sort(ops, (a, b) -> {
//            if (a[0] != b[0]) return a[0] - b[0];
//            else return a[1] - b[1];
//        });
        int[] xs = new int[m];
        int[] ys = new int[n];
        int mx = 0, my = 0;
        int xx = 0, yy = 0;
        for (int[] op : ops) {
            for (int i = 0; i < op[0]; i++) {
                xs[i]++;
                if (mx <= xs[i]) {
                    mx = xs[i];
                    xx = i;
                }
            }
            for (int i = 0; i < op[1]; i++) {
                ys[i]++;
                if (my <= ys[i]) {
                    my = ys[i];
                    yy = i;
                }
            }
        }
        return (xx + 1) * (yy + 1);
    }
}
