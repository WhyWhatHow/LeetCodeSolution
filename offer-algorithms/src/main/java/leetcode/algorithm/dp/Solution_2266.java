package leetcode.algorithm.dp;

/**
 * @program: LeetCodeSolution
 * @description: #
 * @author: WhyWhatHow
 **/

public class Solution_2266 {

    public static void main(String[] args) {
        Solution_2266 sol = new Solution_2266();
        System.out.println(sol.countTexts(
//                "22233"
//                "222222222222222222222222222222222222"
                "55555555999977779555"
        ));
        System.out.println("==================");
    }

    int mod = 1000_000_007;
    long[] f = new long[1000_07];// 2 abc , 类比跳楼梯
    long[] ff = new long[1000_07]; // 7, 9 4 char

    void init(int n) {
        f[0] = 1;
        f[1] = 2;
        f[2] = 4;
        for (int i = 3; i < n; i++) {
            f[i] = (f[i - 1] + f[i - 2] + f[i - 3]) % mod;
        }
        ff[0] = 1;
        ff[1] = 2;
        ff[2] = 4;
        ff[3] = 8;
        for (int i = 4; i < n; i++) {
            ff[i] = (ff[i - 1] + ff[i - 2] + ff[i - 3] + ff[i - 4]) % mod;
        }


    }

    public int countTexts(String pressedKeys) {
//        init(pressedKeys.length());
        init(f.length);
        char[] cs = pressedKeys.toCharArray();
        int cnt = 0;
        long res = 1;
        for (int i = 0; i < cs.length; i++) {
            if (i == 0) {
                cnt++;
                continue;
            }
            if (cs[i] == cs[i - 1]) {
                cnt++;
            } else {
                res = getRes(cs[i-1], res, cnt); //  handle cs[i-1]
                cnt = 1;
            }
        }
        res = getRes(cs[cs.length - 1], res, cnt);

        return (int) res;
    }

    private long getRes(char c, long res, int cnt) {
        if (c == '7' || c == '9')
            res = res * ff[cnt - 1];
        else
            res = res * f[cnt - 1];
        res %= mod;
        return res;
    }
}
