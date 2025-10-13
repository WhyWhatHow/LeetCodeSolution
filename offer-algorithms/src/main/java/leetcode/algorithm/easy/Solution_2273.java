package leetcode.algorithm.easy;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * @program: LeetCodeSolution
 * @description: #
 * @author: WhyWhatHow
 **/

public class Solution_2273 {

    public static void main(String[] args) {
        Solution_2273 sol = new Solution_2273();
        System.out.println(sol.removeAnagrams(new String[]{
                "a", "b", "a"
        }));
        System.out.println("==================");
    }

    public List<String> removeAnagrams(String[] words) {
        var set = new HashSet<Integer>();
        var list = new ArrayList<String>();
        // get count of every words
        for (int i = 1; i < words.length; i++) {
            if(set.contains(i)) continue;
            if (check(words[i - 1], words[i])) {
                set.add(i);
            }
        }


        // collect the list we need.
        for (int i = 0; i < words.length; i++) {
            if (!set.contains(i)) {
                list.add(words[i]);
            }
        }

        return list;
    }

    char c = 'a';

    private boolean check(String a, String b) {
        if (a.length() != b.length()) return false;

        int[] ca = new int[26];
        int[] cb = new int[26];

        for (int i = 0; i < a.length(); i++) {
            char t = a.charAt(i);
            ca[t - c]++;
        }
        for (int i = 0; i < b.length(); i++) {
            char t = b.charAt(i);
            cb[t - c]++;
        }

        boolean yes = true;
        for (int i = 0; i < 26; i++) {
            if (ca[i] != cb[i]) {
                yes = false;
                break;
            }
        }
        return yes;
    }
}


