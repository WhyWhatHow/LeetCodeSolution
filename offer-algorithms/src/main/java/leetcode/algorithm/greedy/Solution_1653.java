package leetcode.algorithm.greedy;

/**
 * @program: LeetCodeSolution
 * @description: #
 * @author: WhyWhatHow
 **/
public class Solution_1653 {

    public static void main(String[] args) {
        Solution_1653 sol = new Solution_1653();//
        System.out.println(sol.minimumDeletions(
//                "aababbab"
                "b"
//                "bbaaaaabb"
//                "baababbaabbaaabaabbabbbabaaaaaabaabababaaababbb"
//                "ababaaaabbbbbaaababbbbbbaaabbaababbabbbbaabbbbaabbabbabaabbbababaa"
        ));
        System.out.println("==================");
    }

    // 枚举分割点 i , s[0,i] range 都是a , s[i+1, n)都是b
    // 分别对点i 统计 其前缀s[0,i] 范围内 b 的数量, 后缀 s[i+1,n) 中 a的数量.
    public int minimumDeletions(String s) {
        char[] cs = s.toCharArray();
        int n = cs.length;

        int[] ps = new int[n + 1]; // ps[i+1] means[0,i] range b count .
        for (int i = 0; i < cs.length; i++) {
            ps[i+1] = cs[i] == 'b' ? ps[i] + 1 : ps[i];
        }

        int[] ss = new int[n + 1]; // ss[i] means[i,n-1] range a count
        for (int i = cs.length - 1; i >= 0; i--) {
            ss[i] = cs[i] == 'a' ? ss[i + 1] + 1 : ss[i + 1];
        }

        int res = n;
        // 对分割点进行枚举, 找到最小值.
        // ps[i+1] means[0,i] range b count
        // ss[i] means [i,n) range a count .
        for (int i = 0; i <= n; i++) {
            res = Math.min(res, ss[i] + ps[i]);
        }

        return res;
    }

    // greedy
    public int minimumDeletionsByGreedy(String s) {
        char[] cs = s.toCharArray();
        int n = cs.length;
        int cnt = 0; // 'b*a' 的数量.
        int res = 0;
        for (char c : cs) {
            if (c == 'b') {
                cnt++;
            } else {
                if (cnt > 0) { // 'ba' 情况
                    res++;
                    cnt--; //
                }
            }
        }
        return res;
    }
}
