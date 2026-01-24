package leetcode.algorithm.dp;

/**
 * @program: LeetCodeSolution
 * @description: #
 * @author: WhyWhatHow
 **/

public class Solution_2147 {

    public static void main(String[] args) {
        Solution_2147 sol = new Solution_2147();
        System.out.println(sol.numberOfWays("SSPPSPS"));
        System.out.println("==================");
    }

    //    " SPS PP SS P SS SS"
    public int numberOfWays(String corridor) {
        char[] cs = corridor.toCharArray();
        int n = cs.length;
        int mod = 1000_000_007;

        long res = 1;
        int pc = 0; // plant count
        int sc = 0; // all space count
        int c = 0; //  space count
        for (int i = 0; i < n; i++) {
            if (cs[i] == 'S') {
                c++;
                sc++;
                if (c == 2) {
                    pc = 0;
                } else if (c > 2) {
                    c = 1;
                    res = res * (pc + 1);
                    res %= mod;
                    pc = 0;
                }
            } else if (cs[i] == 'P' && c == 2)
                pc++;
        }

        if (sc == 0 || (sc & 1) == 1)
            return 0;
        return (int) res;

    }

    //     两个sit 分别分组, 对于分组间的plants 数量,可以使用分组数是 plants+1
    public int numberOfWaysOld(String corridor) {
        char[] cs = corridor.toCharArray();
        int mod = 1000_000_007;
//        long prev = 1;
        long res = 1;
        int lastIdx = -1; //标记上一个分组出现的位置.
        int cnt = 0;
        int scnt = 0;
        for (int i = 0; i < cs.length; i++) {
            if (cs[i] == 'S') {
                scnt++;
                if (cnt == 0 && lastIdx != -1) {
                    res = res * (i - lastIdx) % mod;
                }
                cnt++;
                if (cnt == 2) {
                    lastIdx = i;
                    cnt = 0;
                }
            }
        }

        if ((scnt & 1) == 1) return 0;
        else return (int) res;
    }

}


