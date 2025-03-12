package leetcode.algorithm.window;

/**
 * @program: LeetCodeSolution
 * @description: #
 * @author: WhyWhatHow
 **/

public class Solution_3305 {

    public static void main(String[] args) {
        Solution_3305 sol = new Solution_3305();
        System.out.println("abced".indexOf('c') != -1);
        System.out.println(sol.countOfSubstrings(
//                "ieaouqqieaouqq"
                "iqeaouqi"
                ,
//                1
                2
        ));
        System.out.println("==================");
    }

    /**
     * 恰好k个元素 <==> 至少k个元素 - (至少k+1) 个元素, (想不明白就花数轴)
     *
     * @param word
     * @param k
     * @return
     */
    public int countOfSubstrings(String word, int k) {
        char[] cs = word.toCharArray();
        return func(cs, k) - func(cs, k + 1);
    }

    /**
     * fun(cs, k ) 表示在 cs[] 中, 至少有k的辅音+5元音的数量.
     *
     * @param cs
     * @param k
     * @return
     */
    private int func(char[] cs, int k) {
        int[] cnt = new int[26];
        int acnt = 0;
        int bcnt = 0;
        int res = 0;
        int left = 0;
        for (int i = 0; i < cs.length; i++) {
            char c = cs[i];
            if (check(c)) {
                if (cnt[c - 'a'] == 0) acnt++;
                cnt[c - 'a']++;
            } else bcnt++;

            // [left,i] 满足 acnt==5 && bcnt>=k的元素数量
            while (acnt == 5 && bcnt >= k) {
                if (check(cs[left])) {
                    cnt[cs[left] - 'a']--;
                    if (cnt[cs[left] - 'a'] == 0) acnt--;
                } else {
                    bcnt--;
                }
                left++;
            }
            res += left;
        }
        return res;
    }

    boolean check(char c) {
        return "aeiou".indexOf(c) != -1;
//        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
}


