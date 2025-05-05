package leetcode.algorithm.dp;

/**
 * @program: LeetCodeSolution
 * @description: #
 * @author: WhyWhatHow
 **/

public class Solution_790 {

    public static void main(String[] args) {
        Solution_790 sol = new Solution_790();
        System.out.println(sol.numTilings(30));
        ;
        System.out.println("==================");
    }


    int mod = 1000_000_007;

    /**
     * f[i][j] means [0,i) 全部都是涂满, 第i列中状态 j,
     * j 的取值: (0, ww) , (1, bw) ,(2,wb) (3,bb) w 表示没有贴瓷砖, b表示贴了瓷砖.
     * f[i][0] = f[i-1][3]     第i列为上下均空的情况
     * f[i][1] = f[i-1][0] + f[i-1][2]
     * f[i][2] = f[i-1][0] + f[i-1][1]
     * f[i][3] = f[i-1][3] + f[i-1][2] + f[i-1][1]+ f[i-1][0]
     * f[0][0] = 0, f[0][1]=0, f[0][2]=0, f[0][3]=1
     *
     * @param n
     * @return
     */
    public int numTilings(int n) {
        long[][] f = new long[n + 1][4]; //
        f[0][3] = 1;
        for (int i = 1; i <=n; i++) {
            f[i][0] = f[i - 1][3];
            f[i][1] = (f[i - 1][0] + f[i - 1][2]) % mod;
            f[i][2] = (f[i - 1][0] + f[i - 1][1]) % mod;
            f[i][3] = (f[i - 1][0] + f[i - 1][1] + f[i - 1][2] + f[i - 1][3]) % mod;
        }
        return (int) f[n][3];

    }
}


