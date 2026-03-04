package leetcode.algorithm.easy;

/**
 * @program: LeetCodeSolution
 * @description: #
 * @author: WhyWhatHow
 **/
public class Solution_541 {

    public static void main(String[] args) {
        Solution_541 sol = new Solution_541();//
        System.out.println(sol.reverseStr(
//                "abcdefg",
//                2
//                "abcd",
//                2
                "krmyfshbspcgtesxnnljhfursyissjnsocgdhgfxubewllxzqhpasguvlrxtkgatzfybprfmmfithphckksnvjkcvnsqgsgosfxc",
                20
        ));
        System.out.println("==================");
    }

    public String reverseStr(String s, int k) {
        char[] cs = s.toCharArray();
        char[] ts = new char[cs.length];
        int n = cs.length;

        int mod = n % (2 * k);
        int round = n / (2 * k);
        int i = 0; // index

        while (round-- > 0) {
            doReverse(cs, i, k, ts, i + k - 1);
            doFill(cs, i + k, ts, k);
            i += 2 * k;
        }


        // fill last
        if (mod >= k) {
            doReverse(cs, i, k, ts, i + k - 1);
            doFill(cs, i + k, ts, n - i - k);
        } else {
            doReverse(cs, i, mod, ts, n - 1);
        }

        return String.valueOf(ts);
    }

    private void doFill(char[] cs, int i, char[] ts, int len) {
        while (len-- > 0) {
            ts[i] = cs[i];
            i++;
        }
    }

    private void doReverse(char[] cs, int st, int len,
                           char[] ts, int tend) {
        while (len-- > 0) {
            ts[tend--] = cs[st++];
        }
    }
}
