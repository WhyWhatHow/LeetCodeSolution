package leetcode.algorithm.dp;

/**
 * @program: LeetCodeSolution
 * @description: #
 * @author: WhyWhatHow
 **/

public class Solution_2272 {

    public static void main(String[] args) {
        Solution_2272 sol = new Solution_2272();
//        System.out.println(sol.largestVariance(""));
//        System.out.println(sol.largestVariance("aababbb"));
        System.out.println(sol.largestVariance("ababab"));
        System.out.println("==================");
    }

    public int largestVariance(String s) {
        char[] cs = s.toCharArray();
        int ans = 0;
        for (char i = 'a'; i <= 'z'; i++) {
            for (char j = 'a'; j <= 'z'; j++) {
                if (i == j) continue;
                ans = Math.max(ans, dp(cs, i, j));
//                System.out.println(i + "," + j);
            }
        }
        return ans;
    }

    /**
     * dp(CS,a,b) 表示在cs 所有子串中,以a为最多元素,b为最少元素 的所有子串中的最大波动.  (a->1, b->-1, other c -> 0)
     * f[i][0] ==> 表示 以s[i] 结尾的最大波动,(其中,不一定有b元素)
     * f[i][0] = max(f[i-1][0],0)+v;  (a->v=1; b->v=-1; other->v=0)
     * f[i][1] ==> 表示 以s[i]结尾, 且有b元素的最大波动值.
     * if (s[i] == a) ==> f[i][1] = f[i-1][1]+1 ;
     * if (s[i] == b) ==> f[i][1] = max(f[i-1][1]-1, f[i][0]) ;  { 补充 s[i]==b, 是不是意味着 f[i][1] =f[i][0] }
     * 令d = f[i][0], dd = f[i][1]
     * d= max(d,0)+1
     * dd = max(dd-1, d)  s[i] ==b
     * dd =dd+1 s[i] =a
     * 最后一个问题, 关于初始值,f[i][0] = 0 ,
     * f[i][1] 呢? (最初没有b元素, 所以在遇到第一个b前,都是不符合题意的解,可以去掉
     * f[i][1] = -cs.length
     * @param cs
     * @param a  出现最多的次数
     * @param b  出现最少次数.
     * @return
     */
    private int dp(char[] cs, char a, char b) {
        int ans = 0;
        int f = 0;// f = max(f,0)+v ,  if cs[i]==a ,v= 1; if cs[i] ==b v= -1; else cs[i]=0;
        int ff = -cs.length; // 在cs[0,i] 中 以s[i] 结尾, b元素结尾的最大值.
        for (char c : cs) {
            if (c == a) {
                f = Math.max(f, 0) + 1;
                ff++;
            } else if (c == b) { // namb (n>m)
                f = Math.max(f, 0) - 1;
                ff = f;
            }

            ans = Math.max(ans, ff);
        }
        return ans;
    }

}


