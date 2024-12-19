package leetcode.algorithm.hash;

/**
 * @program: LeetCodeSolution
 * @description: #string #rolling-hash # medium
 * @author: WhyWhatHow
 **/

public class Solution_686 {

    public static void main(String[] args) {
        Solution_686 sol = new Solution_686();
        System.out.println(sol.repeatedStringMatch("abcd", "cdabcdab"));
        System.out.println("==================");
    }

    public int repeatedStringMatch(String a, String b) {
        int n = a.length();
        int m = b.length();
        int time = (m + n - 1) / n; // ceil (m/n)
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < time + 1; i++) {
            sb.append(a);
        }
        int maxRight = n * time - 1;
        String s = sb.toString();
        build(s);
        long hash = 0;
        char[] cs = b.toCharArray();
        for (int i = 0; i < cs.length; i++) {
            hash = i == 0 ? cs[i] : hash * base + cs[i];
        }

        for (int i = 0; i <= s.length() - m; i++) {
            int r = i + m - 1;
            if (query(i, r) == hash) return r > maxRight ? time + 1 : time;
        }

        return -1;
    }

    long[] p; // base^i
    long[] h; // str[0,i]'s hash
    int base = 433;

    void build(String s) {
        int n = s.length();
        p = new long[n];
        h = new long[n];
        for (int i = 0; i < n; i++) {
            p[i] = i == 0 ? 1 : p[i - 1] * base;
            h[i] = i == 0 ? s.charAt(i) : h[i - 1] * base + s.charAt(i);
        }
    }

    // substr[l,r]'s  hash = h[r]- h[l-1]*p[r-(l-1)] ;
    long query(int l, int r) {
        long res = h[r];
        if (l > 0) res -= h[l - 1] * p[r - l + 1];
        return res;
    }
}


