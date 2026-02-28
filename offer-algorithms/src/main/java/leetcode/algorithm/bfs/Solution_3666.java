package leetcode.algorithm.bfs;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.TreeSet;

/**
 * @program: LeetCodeSolution
 * @description: #
 * @author: WhyWhatHow
 **/
public class Solution_3666 {

    public static void main(String[] args) {
        Solution_3666 sol = new Solution_3666();//
        System.out.println(sol.minOperations(
                "110", 1
        ));
        System.out.println("==================");
    }

    // 设z 表示 s中0的数量.  n 表示s的长度.
    // 假设在一次操作中我们对x个0 flip-> 1, 那么我们就会有 z1 = z - x + (k-x) 个 零的数量. ( k-x ) 表示剩余的操作需要将 1-> 0 .
    // 整理后的 z1 = z+k -2x ; x<=min(z,k), (k-x) <= min(n-z, k)  ==>  min(k-n+z, 0) <= x <= min(z,k)
    // 题目要求的 在经过n次迭代后, zn = 0, 表示我们有解. zn!=0 表示我们没有解.
    // 因而, 题目就可以 等价转化成 从起点 z 到 0 的最短路. 其中 ` 节点`的定义是对于string s 而言, 中零的数量.
    public int minOperations(String s, int k) {
        char[] cs = s.toCharArray();
        // init d
        int[] d = new int[cs.length + 1];
        Arrays.fill(d, Integer.MAX_VALUE);
        int n = cs.length;

        // init z
        int z = 0;
        for (int i = 0; i < cs.length; i++) {
            if (cs[i] == '0') {
                z++;
            }
        }
        if (z == 0) return 0;

        TreeSet<Integer>[] ss = new TreeSet[2]; // ss[0] 偶数下标中,没有访问的节点.  ss[1] 奇数下标中, s 可以有的zero数量.
        Arrays.setAll(ss, i -> new TreeSet<Integer>());
        for (int i = 0; i <= n; i++) {
            ss[i % 2].add(i);
        }


        // init d[z]  && q
        d[z] = 0;
        ss[z % 2].remove(z);
        var q = new ArrayDeque<Integer>();// node's index .
        q.add(z);


        while (!q.isEmpty()) {
            Integer cur = q.poll();


            int a = Math.max(0, k - n + cur); //why ?
            int b = Math.min(cur, k);
            int l = cur + k - 2 * b;
            int r = cur + k - 2 * a;

            var set = ss[l & 1];

            Integer nxt;
            while ((nxt = set.ceiling(l)) != null && nxt <= r) {
                d[nxt] = d[cur] + 1;
                q.add(nxt);
                set.remove(nxt);
            }

        }

        return d[0] == Integer.MAX_VALUE ? -1 : d[0];
    }
}
