package leetcode.algorithm.weekly;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * @program: LeetCodeSolution
 * @description:
 * @author: WhyWhatHow
 * @create: 2025-12-07 10:29
 **/
public class Weekly_486 {
    public static void main(String[] args) {
        Weekly_486 sol = new Weekly_486();
//        System.out.println(sol.specialNodes(
//                4,
//                new int[][]{{0, 1}, {0, 2}, {0, 3}},
//                1,
//                2,
//                3
//        ));
//        sol.rotateElements(
//                new int[]{1, -2, 3, -4},
//                3
////                new int[]{5, 4, -9, 6},
////                2
//        );
//        System.out.println(s"1101");
        System.out.println(sol.nthSmallest(
                4, 2
        ));
        System.out.println("---------------------");
    }

    // 从高位到低位依次枚举每一位的数据,
    // 判断当前位置设置0 对应的数量 为 m ,
    // 如果m >= n 表示当前位置设置为 0 ,前进1位
    // 如果 m < n, 表示当前位置需要设置为1, 更新余下的方案数(n-m),  因为 m 表示的bit==0 的数量.需要减去.
    // 前进一位, 依次判断出最后的结果.
    public long nthSmallest(long n, int k) {
//        char[] cs = new char[51]; // r->l , 高到低
//        Arrays.fill(cs, '1');
//        int cnt = k;
        long res = 0;
//        int
        for (int bit = 50; bit >= 0; bit--) {
            if (k == 0) break;
            long count = combination(bit, k);
            if (count < n) { //
                res |= (1l << bit);
                k--;
                n -= count;
            }
        }
        return res;
    }

    // C(n,k) 那个数中选择k个数的方案数. n*(n-1) *(n-k-1) / k!
//    C(n,k) = n*(n-1)*...*(n-k+1) / (1*2*...*k)
    long combination(int n, int k) {
        if (k < 0 || k > n) return 0;
        if (k == 0 || k == n) return 1;

        // C(n,k) == C(n, n-k)
        k = Math.min(k, n - k);
        long res = 1;
        // 使用公式：C(n,k) = n*(n-1)*...*(n-k+1) / (1*2*...*k)
        for (int i = 0; i <= k; i++) {
            res *= (n - i);
            res /= (i + 1);
        }
        return res;
    }

    // 枚举每一个点 计算 dx, dy,dz 判断是否 aa+bb =cc
    public int specialNodes(int n, int[][] edges, int x, int y, int z) {
        // init graph
        var g = new ArrayList[n];
        Arrays.setAll(g, i -> new ArrayList<Integer>());
        for (int[] edge : edges) {
            int u = edge[0], v = edge[1];
            g[u].add(v);
            g[v].add(u);
        }

        // calculate dx, dy, dz , x-> 其他点的最小距离. bfs
        int[] xs = bfs(x, g);
        int[] ys = bfs(y, g);
        int[] zs = bfs(z, g);

        // enum every
        int res = 0;
        for (int i = 0; i < n; i++) {
            int a = xs[i] * xs[i], b = ys[i] * ys[i], c = zs[i] * zs[i];
            if (a + b == c || a + c == b || b + c == a) res++;
        }
        return res;
    }

    private int[] bfs(int st, ArrayList<Integer>[] g) {
        int[] rs = new int[g.length];
        rs[st] = 0;
        boolean[] v = new boolean[g.length];
//        v[st] = true;
        var q = new ArrayDeque<int[]>();
        q.add(new int[]{st, 0});
        while (!q.isEmpty()) {
            int[] ints = q.pollFirst();
            int i = ints[0], val = ints[1];

            if (v[i]) continue;
            v[i] = true;
            for (var o : g[i]) {
                if (!v[o]) {
                    rs[o] = val + 1;
                    q.add(new int[]{o, val + 1});
//                    v[o] = true;
                }
            }
        }
        return rs;
    }

    public int minimumPrefixLength(int[] nums) {
        int n = nums.length;
        int cnt = 0;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] > nums[i - 1]) cnt++;
            else break;
        }
        return n - cnt - 1;
    }

    public int[] rotateElements(int[] nums, int k) {
        var list = new ArrayList<Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= 0) list.add(i);
        }
        int[] rs = new int[nums.length];

        int n = list.size();
        if (n > 0) {
            k %= n;
            // rotate index.
            for (int i = 0; i < list.size(); i++) {
                var idx = (i - k);
                idx = idx < 0 ? idx + n : idx;

                idx %= n; //
                rs[list.get(idx)] = nums[list.get(i)];
            }
        }
        // add number <0
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0) rs[i] = nums[i];
        }
        return rs;
    }
}

