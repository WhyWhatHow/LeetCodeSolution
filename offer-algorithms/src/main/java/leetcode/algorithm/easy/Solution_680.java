package leetcode.algorithm.easy;

/**
 * @program: LeetCodeSolution
 * @description: #
 * @author: WhyWhatHow
 **/

public class Solution_680 {

    public static void main(String[] args) {
        Solution_680 sol = new Solution_680();
//        System.out.println(sol.validPalindrome("deeee"));
//        System.out.println(sol.validPalindrome("abc"));
        System.out.println(sol.validPalindrome("aguokepatgbnvfqmgmlcupuufxoohdfpgjdmysgvhmvffcnqxjjxqncffvmhvgsymdjgpfdhooxfuupuculmgmqfvnbgtapekouga"));
        System.out.println("==================");
    }

    public boolean validPalindrome(String s) {
        char[] cs = s.toCharArray();

        int l = 0, r = cs.length - 1;
        return dfs(l, r, cs, false);
//        int cnt = 0;
//        while (l < r) {
//            if (cs[l] != cs[r]) {
//                 cnt++;
//                if (cs[l + 1] == cs[r]) l++;
//                else if (cs[l] == cs[r - 1]) r--;
//                else return false ;
//            }
//            l++;
//            r--;
//        }
//        return cnt <= 1;
    }

    private boolean dfs(int l, int r, char[] cs, boolean b) {
        if (l >= r) return true;
        if (cs[l] == cs[r]) {
            return dfs(l + 1, r - 1, cs, b);
        } else {
            if (b != true)
                return dfs(l + 1, r, cs, true) || dfs(l, r - 1, cs, true);
            else
                return false;
        }
    }

}
