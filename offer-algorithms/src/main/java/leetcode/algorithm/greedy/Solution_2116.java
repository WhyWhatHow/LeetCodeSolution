package leetcode.algorithm.greedy;

/**
 * @program: LeetCodeSolution
 * @description: #
 * @author: WhyWhatHow
 **/

public class Solution_2116 {

    public static void main(String[] args) {
        Solution_2116 sol = new Solution_2116();
        System.out.println(sol.canBeValid(
                "(((())(((())",
                "111111010111"
        ));
        System.out.println("==================");
    }


    /**
     * 所谓的前缀匹配, 即本例中的() , 如果满足题意要求的 ,那么任意前缀子字符串 的结果会 保证 左括号的数量 会≥ 右括号的数量.
     * 同理, 在后缀匹配时, 也已就按照本例() ,  也可以得出同样的结论 右括号的数量>=左括号的数量.
     * @param s
     * @param locked
     * @return
     */

    public boolean canBeValid(String s, String locked) {
        char[] cs = s.toCharArray();
        if ((s.length() & 1) == 1) return false;

        int cnt = 0;

        //left -> right , check ( is fill all )
        for (int i = 0; i < cs.length; i++) {
            if (cs[i] == '(' || locked.charAt(i) == '0') cnt++;
            else cnt--;
        }

        int cc = 0;
        // right -> left  check ) is fill (
        for (int i = cs.length - 1; i >= 0; i--) {
            if (cs[i] == ')' || locked.charAt(i) == '0') cc++;
            else cc--;
        }
        return cc >= 0 && cnt >= 0;


    }
}


