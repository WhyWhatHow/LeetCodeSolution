package leetcode.algorithm.window;

/**
 * @program: LeetCodeSolution
 * @description: #
 * @author: WhyWhatHow
 **/

public class Solution_3297 {

    public static void main(String[] args) {
        Solution_3297 sol = new Solution_3297();
//        System.out.println(sol.validSubstringCount("bcca", "abc"));
//        System.out.println(sol.validSubstringCount("abcabc", "abc"));
        System.out.println(sol.validSubstringCount("dcbdcdccb", "cdd"));
        System.out.println("==================");
    }

    public long validSubstringCount(String word1, String word2) {
        char[] cs = word1.toCharArray();
        char[] css = word2.toCharArray();

        int[] counts = new int[26]; // get word2 every char's count.
        for (char c : css) {
            counts[c - 'a']++;
        }

        int all = 0;
        for (int count : counts) {
            if (count > 0) all++;
        }

        int l = 0;
        long res = 0;
        for (int r = 0; r < cs.length; r++) {
            char c = cs[r];
            counts[c - 'a']--;
            if (counts[c - 'a'] == 0) { // if char c not exists in word2 , counts[c] should less than 0
                all--;
            }

            while (all == 0) {
                char cc = cs[l++];
                counts[cc - 'a']++;
                if (counts[cc - 'a'] == 0) {
                    all++;
                }
            }
            res += l;
        }

        return res;

    }
}
