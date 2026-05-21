package leetcode.algorithm.medium;

import java.util.ArrayList;
import java.util.Collection;
import java.util.TreeSet;

/**
 * @program: LeetCodeSolution
 * @description: #
 * @author: WhyWhatHow
 **/
public class Solution_3043 {

    public static void main(String[] args) {

        Solution_3043 sol = new Solution_3043();//
        System.out.println(sol.longestCommonPrefix(
//                new int[]{1, 2, 3},
//                new int[]{4, 4, 4}
                new int[]{1,10,100},
                new int[]{1000}
        ));
        System.out.println("==================");
    }

    public int longestCommonPrefix(int[] a, int[] b) {
        var set = new TreeSet<String>();
        for (int i : a) {
            set.addAll(handle(i));
        }
        var ss = new TreeSet<String>();
        for (int i : b) {
            ss.addAll(handle(i));
        }
        int res = 0;
        if (ss.size() < set.size()) {
            for (String s : ss) {
                if (set.contains(s)) {
                    res = Math.max(res, s.length());
                }
            }
        } else {
            for (String s : set) {
                if (ss.contains(s)) {
                    res = Math.max(res, s.length());
                }
            }
        }

        return res;
    }

    private Collection<String> handle(int i) {
        var list = new ArrayList<String>();
        char[] cs = String.valueOf(i).toCharArray();
        int n = cs.length;
        StringBuilder sb = new StringBuilder();
        for (char c : cs) {
            sb.append(c);
            list.add(sb.toString());
        }
        return list;
    }


}
