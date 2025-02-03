package leetcode.algorithm.easy;

/**
 * @program: LeetCodeSolution
 * @description: #
 * @author: WhyWhatHow
 **/

public class Solution_125 {

    public static void main(String[] args) {
        Solution_125 sol = new Solution_125();
        System.out.println("==================");
    }

    public boolean isPalindrome(String s) {
        StringBuilder sb = new StringBuilder();

        char[] cs = s.toCharArray();
        for (char c : cs) {
            if (c >= 'a' && c <= 'z') sb.append(c);
            if (c >= 'A' && c <= 'Z') sb.append(c);
            if(c>='0' &&c<='9') sb.append(c);
        }
        String ss = sb.toString();
        char[] css = ss.toLowerCase().toCharArray();
        return dfs(0, css.length - 1, css);
    }

    boolean dfs(int l, int r, char[] cs) {
        if (l >= r) return true;
        if (cs[l] == cs[r]) return dfs(l + 1, r - 1, cs);
        else return false;
    }

}
