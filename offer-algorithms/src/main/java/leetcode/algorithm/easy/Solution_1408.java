package leetcode.algorithm.easy;

import java.util.LinkedList;
import java.util.List;

/**
 * @program: LeetCodeSolution
 * @description: #
 * @author: WhyWhatHow
 **/

public class Solution_1408 {

    public static void main(String[] args) {
        Solution_1408 sol = new Solution_1408();
        System.out.println("==================");
    }

    public List<String> stringMatching(String[] words) {
        StringBuilder sb = new StringBuilder();
        for (String s : words) {
            sb.append(s).append(";");
        }
        List<String> list = new LinkedList<>();
        String str = sb.toString();
        for (String s : words) {
            if (str.indexOf(s) != str.lastIndexOf(s)) {
                list.add(s);
            }
        }
        return list;
    }

}
