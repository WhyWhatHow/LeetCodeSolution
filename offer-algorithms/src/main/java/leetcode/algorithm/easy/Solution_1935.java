package leetcode.algorithm.easy;

/**
 * @program: LeetCodeSolution
 * @description: #
 * @author: WhyWhatHow
 **/

public class Solution_1935 {

    public static void main(String[] args) {
        Solution_1935 sol = new Solution_1935();
        System.out.println("==================");
    }

    public int canBeTypedWords(String text, String brokenLetters) {
        String[] s = text.split(" ");
        if (brokenLetters.length() == 0) return s.length;
        String[] bs = brokenLetters.split("");
        int res = 0;
        for (int i = 0; i < s.length; i++) {
            boolean yes = true;
            for (int j = 0; j < bs.length; j++) {
                if (s[i].contains(bs[j])) {
                    yes = false;
                    break;
                }
            }
            if (yes) res++;
        }
        return res;
    }
}


