package leetcode.algorithm.medium;

/**
 * @program: LeetCodeSolution
 * @description: #
 * @author: WhyWhatHow
 **/

public class Solution_1328 {

    public static void main(String[] args) {
        Solution_1328 sol = new Solution_1328();
        sol.breakPalindrome("abccba");
        System.out.println("==================");
    }

    public String breakPalindrome(String palindrome) {
        char[] cs = palindrome.toCharArray();
        if (cs.length == 1) return "";
        int l = 0, r = cs.length - 1;
        boolean yes = false; // check cs[0,mid] changed or not .
        while (l <= r) {
            if (cs[l] == 'a') {
                l++;
                r--; //aba -> aaabaaa
            } else {
                yes = true;
                break;
            }
        }
        if (yes) {
            cs[l] = 'a';
            return String.valueOf(cs);
        } else {
            cs[cs.length - 1] = 'b';
            return String.valueOf(cs);
        }
    }

}


