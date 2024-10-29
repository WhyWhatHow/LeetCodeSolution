package leetcode.algorithm.dfs;

import java.util.LinkedList;
import java.util.List;

/**
 * @program: LeetCodeSolution
 * @description: #meidum #dfs
 * @author: WhyWhatHow
 **/

public class Solution_3211 {

    public static void main(String[] args) {
        Solution_3211 sol = new Solution_3211();
        sol.validStrings(3);
        System.out.println("==================");
    }

        public List<String> validStrings(int n) {
            List<String> resList = new LinkedList<>();
            char[] cs = new char[n];
            dfs(resList, cs, n, 0, true);

            return resList;
        }

        /**
         * prev 1: next {1,0}
         * prev 0 : next {1}
         *
         * @param list
         * @param cs
         * @param n
         * @param cur
         * @param prev 前一个是否是1
         */
        private void dfs(List<String> list, char[] cs, int n, int cur, boolean prev) {
            if (cur == n) {
                list.add(String.valueOf(cs));
                return;
            }
            if (prev) {
                cs[cur] = '0';
                dfs(list, cs, n, cur + 1, false);
                cs[cur] = '1';
                dfs(list, cs, n, cur + 1, true);
            } else {
                cs[cur] = '1';
                dfs(list, cs, n, cur + 1, true);
            }
        }

}


