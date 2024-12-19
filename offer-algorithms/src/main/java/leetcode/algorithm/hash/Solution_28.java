package leetcode.algorithm.hash;

/**
 * @program: LeetCodeSolution
 * @description: #easy #rolling-hash
 * @author: WhyWhatHow
 **/

public class Solution_28 {

    public static void main(String[] args) {
        Solution_28 sol = new Solution_28();
        System.out.println(sol.strStr(
//                "sadbutsad", "sad"
//                "a", "a"
                "abc","c"
        ));

        System.out.println("==================");
    }

    public int strStr(String haystack, String needle) {
        if (haystack.length() == needle.length()) return needle.equals(haystack) ? 0 : -1;
        build(haystack);
        long hash = 0;
        char[] cs = needle.toCharArray();
        for (int i = 0; i < cs.length; i++) {
            if (i == 0) hash = cs[i];
            else hash = hash * base + cs[i];
        }
        int m = cs.length;
        for (int i = 0; i <= haystack.length() - m; i++) {
            if (hash(i, i + m - 1) == hash) return i;
        }
        return -1;
    }

    int base = 433, mod = 1000_000_007;
    long[] p; // p[i] = base^i
    long[] hash; // hash[i] means str [0,i]  rolling hash

    void build(String s) {
        int n = s.length();
        p = new long[n];
        long ans = base;
        p[0] = 1;
        for (int i = 1; i < p.length; i++) {
            p[i] = p[i - 1] * base;
        }

        hash = new long[n];
        hash[0] = s.charAt(0);
        for (int i = 1; i < n; i++) {
            hash[i] = hash[i - 1] * base + s.charAt(i);
        }
    }

    /**
     * 返回 hash[l,r] 即str 子串[l,r] 对应的字符串hash 值
     * ans = hash[r] - hash[l-1]^(r-l+1)
     *
     * @param l
     * @param r
     * @return
     */
    long hash(int l, int r) {
        long ans = hash[r];
        if (l > 0) ans -= hash[l - 1] * p[r - l + 1];
        return ans;
    }
}


