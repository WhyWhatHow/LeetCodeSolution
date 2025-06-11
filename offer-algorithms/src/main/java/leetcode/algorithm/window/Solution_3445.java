package leetcode.algorithm.window;

/**
 * @program: LeetCodeSolution
 * @description: #
 * @author: WhyWhatHow
 **/

public class Solution_3445 {

    public static void main(String[] args) {
        Solution_3445 sol = new Solution_3445();
        System.out.println(sol.maxDifference("110", 3));
        System.out.println("==================");
    }


    /**
     * 设 x为 统计数量为奇数的数, y 为统计数量为偶数的数字, 其他数字统一归零.
     * 设ss[i][j] 表示[0,i) 范围内 数字j出现的次数.
     * 不考虑奇偶性:  对于x,y ,在区间[l,r] 范围内出现的数量是
     * x 在区间 [l,r] 出现的数量 : ss[r][x]-ss[l][x]
     * y 在区间 [l,r] 出现的数量 : ss[r][y] -ss[l][y]
     * 最终结果是 maxDiff = ss[r][x] -ss[r][y] - (ss[l][x]-ss[l][y]);
     * 设 X[i] = ss[i][x] -ss[i][y] 表示 从[0,i) range 内的差值.
     * wait a minute, 是不是遗漏了什么条件.
     * x,y 数量的奇偶性没有进行判断.
     * 那么 我们就设ms[p][q] 为 [l,r] 范围内, x的数量奇偶性是p, y的数量奇偶性是q的情况下 所对应的最小值.
     * maxDiff = max(maxDiff, ss[i][x]- ss[i][y] -ms[p][q]) ; // 其中p 为x数量对于的奇偶性, q为y数量对应的奇偶性.
     *
     * @param s
     * @param k
     * @return
     */
    public int maxDifference(String s, int k) {
        char[] cs = s.toCharArray();
        int INF = Integer.MAX_VALUE / 2;
        int ans = -INF;
        char zero = '0';
        int n = cs.length;

        for (int x = 0; x < 5; x++) {
            for (int y = 0; y < 5; y++) {
                if (x == y) continue;
                int left = 0;
                int[] curs = new int[5]; //
                int[] pres = new int[5]; //


                int[][] ms = new int[][]{{INF, INF}, {INF, INF}};// ms[i][j] 表示 x的奇偶性是i, y的奇偶性是j,在范围[l,r] 范围内的最小值.
                for (int i = 0; i < cs.length; i++) {
                    curs[cs[i] - zero]++;
                    // i-left+1 表示[l,i] 之件数量.
                    while (i - left + 1 >= k && curs[x] > pres[x] && curs[y] > pres[y]) {
                        int p = pres[x] & 1;// x的奇偶性
                        int q = pres[y] & 1;// y的奇偶性
                        ms[p][q] = Math.min(ms[p][q], pres[x] - pres[y]);
                        pres[cs[left] - zero]++;
                        left++;
                    }
                    int res = curs[x] - curs[y] - ms[1 - curs[x] & 1][curs[y] & 1];
                    ans = Math.max(ans, res);
                }

            }
        }

        return ans;
    }
}


