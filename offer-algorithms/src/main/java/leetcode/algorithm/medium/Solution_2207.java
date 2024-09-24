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
     * pattern 长度是2, p[0]+text,  text+p[1],算数量,求大值.
     *
     * @param text
     * @param pattern
     * @return
     */
    public long maximumSubsequenceCount(String text, String pattern) {
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


