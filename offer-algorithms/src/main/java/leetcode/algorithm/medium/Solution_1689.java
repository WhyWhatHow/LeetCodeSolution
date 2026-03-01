package leetcode.algorithm.medium;

/**
 * @program: LeetCodeSolution
 * @description: #
 * @author: WhyWhatHow
 **/
public class Solution_1689 {

    public static void main(String[] args) {
        Solution_1689 sol = new Solution_1689();//
        System.out.println("==================");
    }

    public int minPartitions(String n) {
        char[] cs = n.toCharArray();
        int max = 0;
        for (char c : cs) {
            max = Math.max(max, c - '0');
        }
        return max;
    }

}
