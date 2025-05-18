package leetcode.algorithm.easy;

import java.util.LinkedList;
import java.util.List;

/**
 * @program: LeetCodeSolution
 * @description: #
 * @author: WhyWhatHow
 **/

public class Solution_2900 {

    public static void main(String[] args) {
        Solution_2900 sol = new Solution_2900();
        System.out.println("==================");
    }

    public List<String> getLongestSubsequence(String[] words, int[] groups) {
        List<String> res = new LinkedList<>();
        res.add(words[0]);
        for (int i = 1; i < groups.length; i++) {
            if (groups[i] == groups[i - 1]) continue;
            res.add(words[i]);
        }
        return res ;
    }

}


