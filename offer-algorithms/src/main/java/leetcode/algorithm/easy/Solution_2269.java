package leetcode.algorithm.easy;

/**
 * @program: LeetCodeSolution
 * @description: #
 * @author: WhyWhatHow
 **/

public class Solution_2269 {

    public static void main(String[] args) {
        Solution_2269 sol = new Solution_2269();
        System.out.println(sol.divisorSubstrings(240, 2));
        System.out.println("==================");
    }
    public int divisorSubstrings(int num, int k) {
        char[] cs = String.valueOf(num).toCharArray();
//        num % k(cs) == 0 ;
        int cnt = 0;
        for (int i = 0; i < cs.length-k; i++) {
            Integer b = Integer.valueOf(String.valueOf(cs, i, k));
            if (b!=0 && num % b == 0) cnt++;
        }
        return cnt;
    }

}


