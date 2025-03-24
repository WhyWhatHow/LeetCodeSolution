package leetcode.algorithm.easy;

import java.util.HashSet;

/**
 * @program: LeetCodeSolution
 * @description: #
 * @author: WhyWhatHow
 **/

public class Solution_2255 {

    public static void main(String[] args) {
        Solution_2255 sol = new Solution_2255();

        System.out.println("==================");
    }



    // stringHash
    public int countPrefixes(String[] words, String s) {
        build(s);

        char[] cs = s.toCharArray();
        HashSet<Integer> set = new HashSet<>();

        for (int i : h) {
            set.add(i);
        }

        int res = 0;
        for (String word : words) {
            char[] a = word.toCharArray();
            int hash = 0;
            for (int i = 0; i < a.length; i++) {
                hash = i == 0 ? a[i] : hash * base + a[i];
            }
            if (set.contains(hash)) res++;
        }
        return res;

    }

    int[] p; // base^i ;
    int base = 433;
    int[] h;// [0,i] hash

    void build(String s) {
        int n = s.length();
        p = new int[n];
        h = new int[n];
        char[] cs = s.toCharArray();
        for (int i = 0; i < cs.length; i++) {
            p[i] = i == 0 ? 1 : p[i - 1] * base;
            h[i] = i == 0 ? cs[i] : cs[i] + h[i - 1] * base;
        }
    }

    // [l,r] -> h[r] -h[l-1]*p[r-l+1]
    int query(int l, int r) {
        int ans = h[r];
        if (l > 0) {
            ans -= h[l] * p[r - l + 1];
        }
        return ans;
    }


}


