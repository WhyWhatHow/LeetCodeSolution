package leetcode.algorithm.medium;

/**
 * @program: LeetCodeSolution
 * @description: #
 * @author: WhyWhatHow
 **/

public class Solution_2207 {

    public static void main(String[] args) {
        Solution_2207 sol = new Solution_2207();
        System.out.println(sol.maximumSubsequenceCount(
//                "aabb", "ab"
//                "mffiqmrvjmkfmbnaivajzecfdta", "hh"

                "fwymvreuftzgrcrxczjacqovduqaiig", "yy"
        ));
        System.out.println("==================");
    }

    /**
     * x = pattern[0] , y = pattern[1]
     * cx [0,i) x 出现的次数, cy[0,i) y 出现的次数
     * 有题意知, x+text, text+y 对应的最大值.
     * 设 res 为 text 中pattern 出现的次数
     * if `x+text` 最大 -> cnty+ res
     * if `text+y` 最大 -> cntx+ res
     * @param text
     * @param pattern
     * @return
     */
    public long maximumSubsequenceCount(String text, String pattern) {
        char[] cs = text.toCharArray();
        char x = pattern.charAt(0), y = pattern.charAt(1);
        long cntx = 0, cnty = 0;
        long res = 0;

        // count text 中 xy pattern 出现的次数.
        for (int i = 0; i < cs.length; i++) {

            if (cs[i] == y) {
                res += cntx;
                cnty++;
            }
            if (cs[i] == x) { // [0,i) ,所以需要后处理
                cntx++;
            }
        }

        // x +text -> res+ cntx
        //text+y -> res+ cnty
        res += Math.max(cntx, cnty);
        return res;
    }

    /**
     * pattern 长度是2, p[0]+text,  text+p[1],算数量,求大值.
     *
     * @param text
     * @param pattern
     * @return
     */
    public long maximumSubsequenceCountStupid(String text, String pattern) {
        StringBuilder sb = new StringBuilder();
        sb.append(pattern.charAt(0));
        sb.append(text);

        long res = getCount(sb.toString(), pattern);
        sb.deleteCharAt(0);
        sb.append(pattern.charAt(1));

        res = Math.max(res, getCount(sb.toString(), pattern));
        return res;

    }

    private long getCount(String text, String pattern) {
        long res = 0;
        char[] cs = text.toCharArray();
        char[] ps = pattern.toCharArray();
        int[] a = new int[cs.length]; // 记录 [i,n) 返回内 ps[1] 的数量.
        int cnt = 0;

        for (int i = cs.length - 1; i > 0; i--) {
            if (ps[1] == cs[i]) {
                cnt++;
            }
            a[i] = cnt;
        }

        for (int i = 0; i < cs.length - 1; i++) {
            if (cs[i] == ps[0]) {
                if (ps[0] == ps[1]) a[i]--; // yy ,hh 类型
                res += a[i];
            }
        }
        return res;
    }


}


