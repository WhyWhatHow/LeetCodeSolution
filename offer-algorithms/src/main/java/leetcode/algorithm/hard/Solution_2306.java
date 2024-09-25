package leetcode.algorithm.hard;

import java.util.Arrays;
import java.util.HashSet;

/**
 * @program: LeetCodeSolution
 * @description: #
 * @author: WhyWhatHow
 **/

public class Solution_2306 {

    public static void main(String[] args) {
        Solution_2306 sol = new Solution_2306();
        System.out.println(sol.distinctNames(new String[]{
//                "coffee", "donuts", "time", "toffee"
                "alrgtxxdj", "illqfngl", "rlrgtxxdj"
        }));
        System.out.println("==================");
    }

    public long distinctNames(String[] ideas) {
        HashSet<String>[] sufs = new HashSet[26];
        char A = 'a';
        // init sufs
        Arrays.setAll(sufs, i -> new HashSet<>());

        // put ideas to sufs: example "apple" -> sufs[0]: {"pple"}
        for (String idea : ideas) {
            char c = idea.charAt(0);
            String suf = idea.substring(1);
            sufs[c - A].add(suf);
        }


        long res = 0;
        // get distinctNames counts
        for (int i = 0; i < sufs.length; i++) {
            for (int j = 0; j < sufs.length; j++) {
                if (i == j) continue;
                long cnt = 0; // sufs[i] and sufs[j] commons suffix's num.
                for (String suf : sufs[i]) {
                    if (sufs[j].contains(suf)) cnt++;
                }
                long cntI = sufs[i].size() - cnt;
                long cntJ = sufs[j].size() - cnt;
                res += cntI * cntJ;
            }
        }
        return res;
    }

}


