package leetcode.algorithm.medium;

/**
 * @program: LeetCodeSolution
 * @description: #
 * @author: WhyWhatHow
 **/

public class Solution_2048 {

    public static void main(String[] args) {
        Solution_2048 sol = new Solution_2048();
        System.out.println(sol.nextBeautifulNumber(
                        1400
                )
        );
        System.out.println("==================");
    }

    public int nextBeautifulNumber(int n) {

        int res = n + 1;
        while (!check(res)) {
            res++;
        }
        return res;

    }



    char zero = '0';

    private boolean check(int n) { // 判断number 是否符合题意.

        int[] cnts = new int[10];
        String s = String.valueOf(n);
        if (s.contains("0")) return false;

        char[] cs = s.toCharArray();

        for (char c : cs) {
            cnts[c - zero]++;
            if (cnts[c - zero] > (c - zero)) return false;
        }

        for (int i = 0; i < 10; i++) {
            if (cnts[i] == i || cnts[i] == 0) continue;
            else return false;
//            if (cnts[i] != 0) return false;
        }
        return true;
    }

}


