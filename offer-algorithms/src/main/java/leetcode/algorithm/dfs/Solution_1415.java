package leetcode.algorithm.dfs;

import java.util.ArrayList;

/**
 * @program: LeetCodeSolution
 * @description: #
 * @author: WhyWhatHow
 **/
public class Solution_1415 {

    public static void main(String[] args) {
        Solution_1415 sol = new Solution_1415();//
        System.out.println(sol.getHappyString(3, 10));
        System.out.println("==================");
    }

    // 生成长度为n的所有字符串. 然后返回第k小的.
    public String getHappyString(int n, int k) {
        int pow = 1 << (n - 1);
        int max = 3 * pow;
        if (k > max) return "";
        char[] cs = new char[n];
        var list = new ArrayList<String>();
        char[] as = new char[]{'a', 'b', 'c'};
        dfs(cs, list, as, 0, n);
        return list.get(k - 1);
    }

    private void dfs(char[] cs, ArrayList<String> list, char[] as, int i, int n) {
        if (i == n) {
            list.add(String.valueOf(cs));
            return;
        }
        if (i == 0) {
            for (char a : as) {
                cs[i] = a;
                dfs(cs, list, as, i + 1, n);
            }
        } else {
            char pc = cs[i - 1];
            for (char a : as) {
                if (a == pc) continue;
                cs[i] = a;
                dfs(cs, list, as, i + 1, n);
            }
        }

    }

}
