package leetcode.algorithm.medium;

import java.util.Arrays;
import java.util.TreeSet;

/**
 * @program: LeetCodeSolution
 * @description: #
 * @author: WhyWhatHow
 **/

public class Solution_1930 {

    public static void main(String[] args) {
        Solution_1930 sol = new Solution_1930();
        System.out.println(sol.countPalindromicSubsequence(
//                "bbcbaba"
                "uuuuu"
//                "aabca"
        ));
        System.out.println("==================");
    }

    public int countPalindromicSubsequence(String s) {
        char[] cs = s.toCharArray();
        TreeSet<Integer>[] ss = new TreeSet[26];
        Arrays.setAll(ss, i -> new TreeSet<Integer>());
        char a = 'a';
        for (int i = 0; i < cs.length; i++) {
            int idx = cs[i] - a;
            ss[idx].add(i);
        }

        int cnt = 0;
        // palString   s_j, s_i,s_j
        for (int i = 0; i < ss.length; i++) {
            if (ss[i].isEmpty()) continue;
            for (int j = 0; j < ss.length; j++) {
                if (ss[j].isEmpty()) continue;
                if (i == j && ss[i].size() >= 3) cnt++;

                else if (i != j && ss[j].size() >= 2) {
                    for (Integer k : ss[i]) {
                        if (ss[j].first() < k && ss[j].last() > k) {
                            cnt++;
                            break;
                        }
                    }
                }
//                else if (ss[i].size() > 2) cnt++;
            }
        }
        return cnt;
    }

}


