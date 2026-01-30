package leetcode.algorithm.dp;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

/**
 * @program: LeetCodeSolution
 * @description: #
 * @author: WhyWhatHow
 **/
public class Solution_2977 {

    public static void main(String[] args) {
        Solution_2977 sol = new Solution_2977();//
        System.out.println(sol.minimumCost(
                "abcdefgh",
                "acdeeghh",
                new String[]{"bcd", "fgh", "thh"},
                new String[]{"cde", "thh", "ghh"},
                new int[]{1, 3, 5}));
        System.out.println("==================");
//        String a = "abcseds";
//        System.out.println(String.valueOf(a.toCharArray(), a.length() - 1 - 2, 2));
    }

    static final int inf = Integer.MAX_VALUE / 2;
    static final long MAX = Long.MAX_VALUE / 2;
    int[][] dist;


    // original-> changed  ,会按照长度划分出不同的连通块(即子图).
    //换句话说，两次操作中选择的下标 不相交 。
    //换句话说，两次操作中选择的下标 相同 。
    //set f[i] 表示[0,i]的情况的最小花费.
    // if cs[i] == ts[i] , f[i] = f[i-1]
    // else :, 枚举不同长度的连通块, 找到这个情况下的最小值.
    public long minimumCost(String source, String target, String[] original, String[] changed, int[] cost) {
        char[] cs = source.toCharArray();
        char[] ts = target.toCharArray();

        var imap = new HashMap<String, Integer>(); // key : str , val: idx. val from zero.
        // dist ==null 的情况传参数进去会有npe问题.
        dist = init( imap, original, changed, cost);

        //  对于len(s) 同一长度的graph.
        var set = new HashSet<Integer>();
//        var map = new HashMap<Integer, Set<Integer>>();
        for (int i = 0; i < original.length; i++) {
            int len = original[i].length();
            set.add(len);
        }

        floyd(dist);

        long[] f = new long[cs.length]; // f[i]
        Arrays.fill(f, MAX);

//        return dfs(f.length - 1, f, cs, ts, dist, imap, map);

        dfs(f.length - 1, f, cs, ts, dist, imap, set);
        return f[cs.length - 1] == MAX ? -1 : f[cs.length - 1];
    }

    long dfs(int i, long[] f, char[] cs, char[] ts, int[][] dist,
             HashMap<String, Integer> imap, HashSet<Integer> set) {
        if (i < 0) return 0; // test
        if (f[i] != MAX) return f[i];


        long res = MAX;

        // 跳过当前元素
        if (cs[i] == ts[i]) res = Math.min(res, dfs(i - 1, f, cs, ts, dist, imap,set ));

        // 不条当前元素.
        for (Integer len : set) {
            if (i + 1 < len) continue;
            var from = String.valueOf(cs, i - len + 1, len);
            var to = String.valueOf(ts, i - len + 1, len);
            Integer x = imap.getOrDefault(from, -1);
            Integer y = imap.getOrDefault(to, -1);
            if (x < 0 || y < 0) continue;
            if (dist[x][y] != inf)
                res = Math.min(res, dist[x][y] + dfs(i - len, f, cs, ts, dist, imap, set));
        }
        return f[i] = res;
    }

    private void floyd(int[][] dist) {
        int n = dist.length;
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (dist[i][k] != inf && dist[k][j] != inf)
                        dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                }
            }
        }
    }

    private int[][] init( HashMap<String, Integer> map, String[] original, String[] changed, int[] cost) {

        for (int i = 0; i < original.length; i++) {
            int x = genIdx(map, original[i]);
            int y = genIdx(map, changed[i]);
        }
        int size = map.size();
//        int cnt = 0;
        dist = new int[size][size];
        for (int i = 0; i < dist.length; i++) {
            Arrays.fill(dist[i], inf);
            dist[i][i] = 0;
        }
        for (int i = 0; i < original.length; i++) {
            int x = map.get(original[i]);
            int y = map.get(changed[i]);
            dist[x][y] = Math.min(dist[x][y], cost[i]);
        }
        return dist;
    }

    private int genIdx(HashMap<String, Integer> map, String s) {
        int n = map.size();
        if (map.containsKey(s)) {
            return map.get(s);
        }
        map.put(s, n);
        return n;
    }


}


