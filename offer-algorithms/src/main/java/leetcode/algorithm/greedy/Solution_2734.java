package leetcode.algorithm.greedy;

/**
 * @program: LeetCodeSolution
 * @description: #
 * @author: WhyWhatHow
 **/

public class Solution_2734 {

    public static void main(String[] args) {
        Solution_2734 sol = new Solution_2734();
        System.out.println(sol.smallestString(
//                "aaaz"
                "abab"
        ));

        System.out.println("==================");
    }

    public String smallestString(String s) {
        char[] chars = s.toCharArray();
        boolean changed = false;
        int loc = -1;
        for (int i = 0; i < chars.length; ) {
            while (i < chars.length && chars[i] > 'a') {
                changed = true;
                chars[i]--;
                i++;
            }
            if (changed) break;
            if (chars[i] == 'a') {
                loc = i;
            }
            i++;
        }
        if (!changed) {
            chars[loc] = 'z';
        }
        return String.valueOf(chars);
    }

    public String smallestStringStupid(String s) {


        // find 1st a
        char[] chars = s.toCharArray();
        int first = s.indexOf("a");
        int last = s.lastIndexOf("a");
        if (first > 0) {
            // '**a'
            for (int i = 0; i < first; i++) {
                chars[i]--;
            }
        } else if (first < 0) {
//            no a '****'
            for (int i = 0; i < chars.length; i++) {
                chars[i]--;
            }
        } else {
            boolean changed = false;
            int loc = first + 1;
            for (int i = first + 1; i < chars.length; i++) {
                if (chars[i] != 'a') {
                    loc = i;
                    break;
                }
            }
            for (int i = loc; i < chars.length; i++) {
                if (chars[i] != 'a') {
                    chars[i]--;
                    changed = true;
                } else {
                    break;
                }
            }
            if (!changed) {
                chars[last] = 'z';
            }
        }
        return String.valueOf(chars);
    }
}


