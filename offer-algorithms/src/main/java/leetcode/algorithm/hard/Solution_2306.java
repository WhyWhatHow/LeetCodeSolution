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
                long cntI = 0;
                for (String suf : sufs[i]) {
                    if (!sufs[j].contains(suf)) {
                        cntI++;
                    }
                }
                long commonSize = sufs[i].size() - cntI; // (sufs[i] and sufs[j])'s common suffix number
                long cntJ = sufs[j].size() - commonSize;
                res += cntI * cntJ;
            }

        }
        return res;
    }

//    public long distinctNames(String[] ideas) {
//        HashSet<String> set = new HashSet<>();
//        long res = 0 ;
//        int n = ideas.length;
//        HashMap<String, ArrayList<Character>> map = new HashMap<>(); // suffix, [prefix]
//        int[] cnt = new int[26]; //
//        char A = 'a';
//        for (String idea : ideas) {
//            set.add(idea);
//            char c = idea.charAt(0);
//            cnt[c - A]++;
//            map.compute(idea.substring(1), (key, v) -> {
//                if (v == null)
//                    v = new ArrayList<>();
//                v.add(c);
//                return v;
//            });
//        }
//        // wa : coffee, toffee, time : time-coffee ,不可以用. 所以变成了一个建图的过程了.
//        for (Map.Entry<String, ArrayList<Character>> entry : map.entrySet()) {
//            ArrayList<Character> list = entry.getValue();
//            long temp = 0;
//            for (Character c : list) {
//                temp += cnt[c - A];
//            }
//            res +=ideas.length-temp;
//        }
//        return res;
//    }
}


