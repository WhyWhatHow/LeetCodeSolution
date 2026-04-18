package leetcode.algorithm.easy;

/**
 * @program: LeetCodeSolution
 * @description: #
 * @author: WhyWhatHow
 **/
public class Solution_2042 {

    public static void main(String[] args) {
        Solution_2042 sol = new Solution_2042();//
        System.out.println(sol.areNumbersAscending(
                "1 box has 3 blue 4 red 6 green and 12 yellow marbles"
        ));
        System.out.println("==================");
    }

    public boolean areNumbersAscending(String s) {
        String[] ss = s.split(" ");
        int prev = 0;
        for (String str : ss) {
            try {
                int v = Integer.parseInt(str);
                if (prev >= v) return false;
                prev = v;
            } catch (Exception e) {
                continue;
            }
        }
        return true;
    }

}
