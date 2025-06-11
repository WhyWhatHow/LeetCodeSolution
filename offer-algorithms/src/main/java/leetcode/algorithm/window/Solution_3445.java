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


