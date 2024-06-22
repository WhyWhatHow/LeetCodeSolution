package leetcode.algorithm.lcp;

/**
 * @program: LeetCodeSolution
 * @description: #
 * @author: WhyWhatHow
 **/

public class Solution_LCP06 {

    public static void main(String[] args) {
        Solution_LCP06 sol = new Solution_LCP06();
        System.out.println(sol.temperatureTrend(new int[]{
                21, 18, 18, 18, 31
//5,10,16,-6,15,11,3
        }, new int[]{
                34, 32, 16, 16, 17
//16,22,23,23,25,3,-16
        }));
        System.out.println("==================");
    }

    public int temperatureTrend(int[] ta, int[] tb) {
        int i = 0;
        int res = 0;
        int cnt = 0;
        while (i < ta.length - 1) {
            if (check(ta[i + 1] - ta[i], tb[i + 1] - tb[i])) {
                cnt++;
            } else {
                res = Math.max(res, cnt);
                cnt = 0;
            }
            i++;

        }
        res = Math.max(cnt, res);
        return res;
    }

    boolean check(int a, int b) {
        if (a == b || (a < 0 && b < 0) || (a > 0 && b > 0))
            return true;
        else
            return false;
    }
}


