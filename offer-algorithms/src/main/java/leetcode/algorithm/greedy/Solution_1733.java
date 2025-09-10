package leetcode.algorithm.greedy;

import java.util.Arrays;
import java.util.HashSet;

/**
 * @program: LeetCodeSolution
 * @description: #
 * @author: WhyWhatHow
 **/

public class Solution_1733 {

    public static void main(String[] args) {
        Solution_1733 sol = new Solution_1733();
        System.out.println("==================");
    }

    /**
     * 1. 找到不能沟通的两个用户 加入到list中.
     * 2. 枚举每一个语言,作为目标值, 统计学习这门语言的用户数量. 找到最小值即为答案.
     *
     * @param n
     * @param languages
     * @param friendships
     * @return
     */
    public int minimumTeachings(int n, int[][] languages, int[][] friendships) {
        int m = languages.length;
        int[] cs = new int[n + 1]; // count each language user
        HashSet<Integer>[] ss = new HashSet[m + 1]; // ss[i] means number i people knows lang.
        Arrays.setAll(ss, i -> new HashSet<>());
        for (int i = 0; i < languages.length; i++) {
            for (int j : languages[i]) {
                ss[i].add(j);
                cs[j]++;
            }
        }

        // 2.find people can't talk each other
        var list = new HashSet<Integer>();
        for (int[] f : friendships) {
            int u = f[0] - 1;
            int v = f[1] - 1;
            boolean yes = false; // means u and v can't talk to each other .
            for (int i = 1; i <= n; i++) {
                if (ss[u].contains(i) && ss[v].contains(i)) {
                    yes = true;
                    break;
                }
            }
            if (!yes) {
                list.add(u);
                list.add(v);
            }
        }

        // 3. foreach every lang , find the min value.
//        int lan = findMostLang(cs);
        int res = m;
        for (int i = 1; i <= n; i++) {
            int cnt = 0;
            for (Integer p : list) { // people can't talk each other.
                if (!ss[p].contains(i)) {
                    cnt++;
                }
            }
            res = Math.min(res, cnt);
        }
        return res;
    }



}


