package leetcode.algorithm.dp;

/**
 * @program: LeetCodeSolution
 * @description: #
 * @author: WhyWhatHow
 **/

public class Solution_1035 {

    public static void main(String[] args) {
        Solution_1035 sol = new Solution_1035();
        System.out.println(sol.maxUncrossedLines(new int[]{
//                1, 4, 2
                2, 5, 1, 2, 5
        }, new int[]{
//                1, 2, 4
                10, 5, 2, 1, 5, 2
        }));
        System.out.println("==================");
    }

    /**
     * 最长公共子序列.
     * set f[i][j]  a[:i],b[:j] 最长公共子序列.
     * if a[i] == b[j] ==>  f[i][j] = f[i-1][j-1] +1;
     *  else ==>  f[i][j] = max(f[i-1][j],f[i][j-1])
     * @param a
     * @param b
     * @return
     */
    public int maxUncrossedLines(int[] a, int[] b) {
        int[][] f = new int[a.length + 1][b.length + 1];
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < b.length; j++) {
                if (a[i] == b[j]) {
                    f[i + 1][j + 1] = f[i][j]+ 1;
                } else {
                    f[i + 1][j + 1] = Math.max(f[i][j + 1], f[i + 1][j]);
                }
            }
        }
        return f[a.length][b.length];
    }

    /***
     * f[i] [0,i] 可以绘制的最大连接线.
     * 对于f[i] ,
     * if a[i] = b[i]  ==> f[i] = f[i-1]+1
     * else f[i] = max(f[i-1],f[j]+1) b[j] ==a[i]
     * @param a
     * @param b
     * @return
     */
    public int maxUncrossedLinesWa(int[] a, int[] b) {
        if (a.length < b.length) {
            int[] temp = a;
            a = b;
            b = temp;
        }

        int[] f = new int[b.length + 1];
        if (a[0] == b[0]) f[0] = 1;
        for (int i = 1; i < f.length - 1; i++) {
            f[i] = f[i - 1];
            if (a[i] == b[i]) {
                f[i] = f[i] + 1;
            } else {
                for (int j = i - 1; j >= 0; j--) {
                    if (a[i] == b[j]) {
                        f[i] = Math.max(f[i], f[j] + 1);
                        break;
                    }
                }
            }
        }
        // handle b[b.length-1]
        if (a[b.length - 1] != b[b.length - 1]) {
            for (int i = b.length; i < a.length; i++) {
                if (a[i] == b[b.length - 1]) {
                    f[b.length] = f[b.length - 1] + 1;
                    break;
                }
            }
        }

        return a.length == b.length ? f[a.length - 1] : f[f.length - 1];
    }


}


