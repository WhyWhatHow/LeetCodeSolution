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

    int[] cnts = new int[10];

    void init() {
        for (int i = 0; i < cnts.length; i++) {
            cnts[i] = i;
        }
    }

    char zero = '0';

    private boolean check(int n) { // 判断number 是否符合题意.
        init();
        char[] cs = String.valueOf(n).toCharArray();
        int len = cs.length;
        int max = 0;
        for (int i = 0; i < cs.length; i++) {
            if (cs[i] == zero) return false; // no zero
            int v = cs[i] - zero;
            max = Math.max(v, max);
            cnts[v]--;
            if (cnts[v] < 0 || cnts[v]> (cs.length - i)) return false;
        }
        for (int i = 0; i <= max; i++) {
            if (cnts[i] == i || cnts[i] == 0) continue;
            else return false;
//            if (cnts[i] != 0) return false;
        }
        return true;
    }

}


