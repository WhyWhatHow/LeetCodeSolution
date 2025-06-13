package leetcode.algorithm.easy;

/**
 * @program: LeetCodeSolution
 * @description: #
 * @author: WhyWhatHow
 **/

public class Solution_2566 {

    public static void main(String[] args) {
        Solution_2566 sol = new Solution_2566();
        System.out.println(sol.minMaxDifference(90));

        System.out.println("==================");
    }

    public int minMaxDifference(int num) {
        char[] cs = String.valueOf(num).toCharArray();
        int maxIdx = 0;
        for (int i = 0; i < cs.length; i++) {
            if (cs[i] != '9') {
                maxIdx = i;
                break;
            }
        }
        Integer max = handle(cs, cs[0], '9');
        Integer min = handle(cs, cs[0], '0');
        return max - min;
    }

    private Integer handle(char[] cs, char c, char to) {
        char zero = '0';
        int sum = 0;
        for (int i = 0; i < cs.length; i++) {
            sum *= 10;
            int tmp = cs[i] - zero;
            if (cs[i] == c) {
                tmp = to - zero;
            }
            sum += tmp;
        }
        return sum;
    }
}


