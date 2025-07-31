package leetcode.algorithm.medium;

/**
 * @program: LeetCodeSolution
 * @description: #
 * @author: WhyWhatHow
 **/

public class Solution_2683 {

    public static void main(String[] args) {
        Solution_2683 sol = new Solution_2683();

        System.out.println("==================");
    }

    public boolean doesValidArrayExist(int[] derived) {
        int[] os = new int[derived.length];

        // check os[0] = 0 , os[0] =1 ;
        return check(os, 0, derived) || check(os, 1, derived);
    }

    private boolean check(int[] os, int val, int[] derived) {
        os[0] = val;
        int n = derived.length;
        boolean check = true;
        os[n - 1] = derived[n - 1] == 0 ? os[0] : 1 - os[0];
        for (int i = 0; i < derived.length - 1; i++) {
            os[i + 1] = derived[i] == 0 ? os[i] : 1 - os[i];
        }
        // check
        for (int i = 0; i < derived.length - 1; i++) {
            if (derived[i] != (os[i] ^ os[i + 1])) {
                check = false;
                break;
            }
        }
        return check && derived[n - 1] == (os[0] ^ os[n - 1]);
    }
}


