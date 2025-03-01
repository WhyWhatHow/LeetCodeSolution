package leetcode.algorithm.dfs;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: LeetCodeSolution
 * @description: #
 * @author: WhyWhatHow
 **/

public class Solution_131 {

    public static void main(String[] args) {
        Solution_131 sol = new Solution_131();
        System.out.println(sol.partition("aab"));
        System.out.println("==================");
    }

    List<List<String>> reslist = new ArrayList<>();
    List<String> list = new ArrayList<>();

    public List<List<String>> partition(String s) {
        char[] cs = s.toCharArray();
        dfs(cs, 0);
        return reslist;
    }

    // dfs(i,used) 是否在 cs[i]位置分割,
    //    if true, 判断[start_idx, i] 是否是回文, 如果是,表示可以添加,如果不是, 默false)

    /**
     * @param cs
     * @param start
     */
    private void dfs(char[] cs, int start) {
        if (start == cs.length) {
            reslist.add(new ArrayList<>(list));
            return;
        }

        for (int i = start; i < cs.length; i++) {
            if (check(cs, start, i)) {
                list.addLast(String.valueOf(cs, start, i - start + 1));
                dfs(cs, i + 1);
                list.removeLast();
            }
        }
    }

    // check cs[st,end]
    boolean check(char[] cs, int start, int end) {
        if (end == start) return true;
        while (start <= end) {
            if (cs[start] != cs[end]) return false;
            start++;
            end--;
        }
        return true;
    }


}


