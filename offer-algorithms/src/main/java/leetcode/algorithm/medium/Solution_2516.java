package leetcode.algorithm.medium;

/**
 * @program: LeetCodeSolution
 * @description: #
 * @author: WhyWhatHow
 **/

public class Solution_2516 {

    public static void main(String[] args) {
        Solution_2516 sol = new Solution_2516();
        System.out.println(sol.takeCharacters(
                "aabaaaacaabc", 2
        ));
        System.out.println("==================");
    }

    public int takeCharacters(String s, int k) {
        char[] cs = s.toCharArray();
        if (cs.length < k * 3) return -1;

        // init -> get cnt
        int[] a = {-k, -k, -k}; //
        for (char c : cs) a[c - 'a']++;
        if (a[0] < 0 || a[1] < 0 || a[2] < 0) return -1;
        if (a[0] == 0 && a[1] == 0 && a[2] == 0) return cs.length;

        int l = 0, r = 0, res = 0;
        while (r < cs.length) {
            // a[i]>=0
            a[cs[r++] - 'a']--;
            if (a[0] < 0 || a[1] < 0 || a[2] < 0) {
                a[cs[l++] - 'a']++;
            } else {
                res = Math.max(res, r - l);
            }

        }
        return cs.length - res;
    }

}


