package leetcode.algorithm.easy;

/**
 * @program: LeetCodeSolution
 * @description: #
 * @author: WhyWhatHow
 **/

public class Solution_3330 {

    public static void main(String[] args) {
        Solution_3330 sol = new Solution_3330();
        System.out.println(sol.possibleStringCount(
//                "abbcccc"
//                "ccr"
                "ccraabcc"
        ));
        System.out.println("==================");
    }

    public int possibleStringCount(String word) {
        char[] cs = word.toCharArray();
        int cnt = 1;
        int res = 0;
        for (int i = 1; i < cs.length; i++) {
            if (cs[i] == cs[i - 1]) {
                cnt++;
            } else {
                if (cnt > 1) {
                    res += cnt - 1;
                    System.out.println(cnt);
                }
                cnt = 1;
            }
        }
        res += cnt > 1 ? cnt - 1 : 0;
        return ++res;
    }
}


