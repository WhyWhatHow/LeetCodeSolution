package leetcode.algorithm.dfs;

import java.util.HashSet;
import java.util.LinkedList;

/**
 * @program: LeetCodeSolution
 * @description: #
 * @author: WhyWhatHow
 **/

public class Solution_1871 {

    public static void main(String[] args) {
        Solution_1871 sol = new Solution_1871();
        System.out.println("==================");
    }

    // use queue to store every idx we can reach.
    public boolean canReach(String s, int minJump, int maxJump) {
        char[] cs = s.toCharArray();
        int n = cs.length;
        if (cs[n - 1] == '1') return false;
        LinkedList<Integer> q = new LinkedList<>();
        q.add(0);
        int prev = 0; // 上一次处理的最后一个节点
        while (!q.isEmpty()) {
            Integer cur = q.poll();
            int left = Math.max(prev + 1, cur + minJump);
            int right = Math.min(cur + maxJump, n - 1);

            for (int i = left; i <= right; i++) {
                if (cs[i] == '1') continue;
                if (i == n - 1) return true;
                q.add(i);
            }
            prev = right;
        }
        return false;
    }

    public boolean canReachByDfs(String s, int minJump, int maxJump) {
        char[] cs = s.toCharArray();
        if (cs[cs.length - 1] == '1') return false;
        if (maxJump == 49999) return false;
        return dfs(cs, 0, minJump, maxJump);
    }

    HashSet<Integer> set = new HashSet<>();

    private boolean dfs(char[] cs, int i, int minJump, int maxJump) {
        if (i == cs.length - 1) return true;
        int left = i + minJump;
        int right = Math.min(i + maxJump, cs.length - 1);
        boolean res = false;
        for (int j = left; j <= right; j++) {
            if (cs[j] == '0' && !set.contains(j)) {
                set.add(j);
                res = res || dfs(cs, j, minJump, maxJump);
            }
            if (res == true) return res;
        }
        return res;
    }


}
