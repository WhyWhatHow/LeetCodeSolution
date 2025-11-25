package leetcode.algorithm.medium;

/**
 * @program: LeetCodeSolution
 * @description: #
 * @author: WhyWhatHow
 **/

public class Solution_1015 {

    public static void main(String[] args) {
        Solution_1015 sol = new Solution_1015();
        System.out.println("==================");
    }

    public int smallestRepunitDivByK(int k) {
        int cnt = 1;
        long tmp = 1;
        while (cnt < 2000_000) {
            if (tmp % k == 0) {
                break;
            } else {
                tmp = tmp * 10 + 1;
                tmp = tmp % k;
            }
            cnt++;
        }
        return cnt == 2000_000 ? -1 : cnt;
    }
}


