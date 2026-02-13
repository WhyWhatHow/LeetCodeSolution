package leetcode.algorithm.medium;

import java.util.HashMap;
import java.util.HashSet;

/**
 * @program: LeetCodeSolution
 * @description: #
 * @author: WhyWhatHow
 **/
public class Solution_3714 {

    public static void main(String[] args) {
        Solution_3714 sol = new Solution_3714();//
        System.out.println(sol.longestBalanced(
//                "zz"
//                "aba"
//                "aabcc"
                "cabbacc"
        ));
        System.out.println("==================");
    }


    /**
     * 分三种情况讨论:
     * 1.只有a || b|| c
     * tar =a, 算子串长度.
     * 2.只出现(a,b),(a,c),(b,c) 中的一种.
     * 以ab为例:
     *
     * @see leetcode.algorithm.prefix.Solution_525
     * ---
     * <p>
     * fa [0,i) a出现的长度. fb 表示[0,i) 范围 b出现的长度.
     * 如果对于区间[l,r] 表示为平衡字符串 , 会有 fa[r+1] - fa[l] = fb[r+1]-fb[l]
     * 即 fa[r+1]- fb[r+1] = fa[l]-fb[l]
     * 令: F[i] = fa[i]-fb[i] ==> 题目要求等价替换为对于[l,r]为平衡子串, F[l] =F[r]
     * 用map  { key: F[i], val: firstIndx} 标记第一次出现的位置求最大值即可.
     * 3.abc 同时出现.
     * 假设[l,r] 为平衡子串, 我们会有
     * - ab 数量相等.  fa[r+1]- fb[r+1] = fa[l]- fb[l]
     * - bc 数量相等,  fb[r+1] -fc[r+1] = fb[l]- fc[l]
     * 如果在区间[l,r] 返回内相等.
     * 同ab例子,我们可以用 key: {ab, bc} 在统一区间内的数量. val: 标记这个结果第一次出现的标. 循环求求最大值即可.
     */
    public int longestBalanced(String s) {
        char[] cs = s.toCharArray();
        var set = new HashSet<Character>();
        for (char c : cs) {
            set.add(c);
        }

        int res = 0;
        // only one
        for (char c = 'a'; c < 'd'; c++)
            res = Math.max(res, handleOne(c, cs));

        // handle case like ab
        res = Math.max(res, handleTwo(cs, 'a', 'b'));
        res = Math.max(res, handleTwo(cs, 'a', 'c'));
        res = Math.max(res, handleTwo(cs, 'b', 'c'));

        // handle abc
        res = Math.max(handleABC(cs), res);

        return res;
    }

    private int handleABC(char[] cs) {
        int n = cs.length + 1;
        Pair[] f = new Pair[n]; //f[i][0] ab,bc
        f[0] = new Pair(0, 0);
        for (int i = 0; i < cs.length; i++) {
            int t = 0, tt = 0;
            if (cs[i] == 'a') {
                t = 1;
            } else if (cs[i] == 'c') {
                tt = -1;
            } else {
                t = -1;
                tt = 1;
            }
            int ab = f[i].ab + t;
            int bc = f[i].bc + tt;
            f[i + 1] = new Pair(ab, bc);
        }

        int res = 0;
        var map = new HashMap<Pair, Integer>(); // key: pair, val: firstIndex
        for (int i = 0; i < f.length; i++) {
            if (map.containsKey(f[i])) {
                res = Math.max(res, i - map.get(f[i]));
            } else {
                map.put(f[i], i);
            }
        }
        return res;
    }

    record Pair(int ab, int bc) {
    }


    private int handleTwo(char[] cs, char x, char y) {
        int n = cs.length;
        int res = 0;

        for (int i = 0; i < n; i++) {
            if (cs[i] != x && cs[i] != y) continue;
            // 对这个子串进行处理
            int j = i;
            var map = new HashMap<Integer, Integer>();
            map.put(0, i - 1);

            int sum = 0;
            while (j < n && (cs[j] == x || cs[j] == y)) {
                sum = sum + (cs[j] == x ? 1 : -1);
                if (map.containsKey(sum)) {
                    res = Math.max(res, j - map.get(sum));
                } else {
                    map.put(sum, j);
                }
                j++;
            }
            i = j - 1;
        }
        return res;
    }

    private int handleOne(char tar, char[] cs) {
        int res = 0;
        int cnt = 0;
        for (int i = 0; i < cs.length; i++) {
            if (cs[i] == tar) {
                cnt++;
            } else {
                res = Math.max(cnt, res);
                cnt = 0;
            }
        }
        return Math.max(res, cnt);
    }


}
