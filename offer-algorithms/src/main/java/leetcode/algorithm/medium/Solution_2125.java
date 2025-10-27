package leetcode.algorithm.medium;

/**
 * @program: LeetCodeSolution
 * @description: #
 * @author: WhyWhatHow
 **/

public class Solution_2125 {

    public static void main(String[] args) {
        Solution_2125 sol = new Solution_2125();
        System.out.println(sol.numberOfBeams(new String[]{
                "011001","000000","010100","001000"
        }));
        System.out.println("==================");
    }

    public int numberOfBeams(String[] bank) {
        int n = bank.length;
        int res = 0;
        boolean yes = false;
        int first = 0;
        int sec = 0;
        for (int i = 0; i < bank.length; i++) {
            if ( !bank[i].contains("1")) continue; //
            if (!yes) {
                yes = true;
                first = getCount(bank[i]);
            } else {
                sec = getCount(bank[i]);
                res += first * sec;
                first = sec;
            }
        }
        return res;
    }

    private int getCount(String s) {
        int cnt = 0;
        for (char c : s.toCharArray()) {
            if (c == '1') cnt++;
        }
        return cnt;
    }

}


