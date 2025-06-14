package leetcode.algorithm.medium;

/**
 * @program: LeetCodeSolution
 * @description: #
 * @author: WhyWhatHow
 **/

public class Solution_1432 {

    public static void main(String[] args) {
        Solution_1432 sol = new Solution_1432();
        System.out.println(Integer.MAX_VALUE > 1000_000_000);
        System.out.println(sol.maxDiff(
                123456
        ));
        System.out.println("==================");
    }

    public int maxDiff(int num) {
        char[] cs = String.valueOf(num).toCharArray();
        int n = cs.length;


        int maxIdx = 0;
        int minIdx = 0;
        for (int i = 0; i < cs.length; i++) {
            if (cs[i] != '9') {
                maxIdx = i;
                break;
            }
        }
        for (int i = 0; i < cs.length; i++) {
            if (cs[i] == '0') continue;
            if (i == 0 && cs[i] != '1') {
                minIdx = i;
                break;
            } else if (i > 0 && cs[i] != cs[0]) {
                minIdx = i;
                break;
            }
        }

        int max = handle(cs, maxIdx, '9');
        int min = handle(cs, minIdx, minIdx == 0 ? '1' : '0');

        return max - min;
    }

    private int handle(char[] cs, int idx, char c) {
        int sum = 0;
        char zero = '0';
        for (int i = 0; i < cs.length; i++) {
            sum *= 10;
            if (i == idx || cs[i] == cs[idx]) {
                sum += c - zero;
            } else
                sum += cs[i] - zero;
        }
        return sum;
    }

}


