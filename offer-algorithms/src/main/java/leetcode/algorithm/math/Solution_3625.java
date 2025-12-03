package leetcode.algorithm.math;

import java.util.HashMap;

/**
 * @program: LeetCodeSolution
 * @description: #
 * @author: WhyWhatHow
 **/

public class Solution_3625 {

    public static void main(String[] args) {
        Solution_3625 sol = new Solution_3625();
        System.out.println(sol.countTrapezoids(new int[][]
                        {{-3, 2}, {3, 0}, {2, 3}, {3, 2}, {2, -3}}
                )
        );
        System.out.println("==================");
    }

    /**
     * 灵神的思路: 两点之间算斜率, 可能存在这样的一种情况,
     * 俩线段斜率相同, 为了区分, 判断与y轴的交点是否相等,即b 如果相等,记为统一线段数量.
     * 第二种特殊情况是平行四边形, 如何区分: 平行四边形对角线 中点 进行判断
     * 其中一个特殊情况是: 有两条平行线, 且其中点坐标相等,如果属于同一条直线,不能区分,
     * 所以引入第二个 map{ mid_idx, map{k, cnt}}
     * hint:  我们需要枚举所有可能构成平行四边形的边(即对角线) 因而第二个map 为对角线map.
     *
     * @param points
     * @return
     */
    public int countTrapezoids(int[][] points) {
        var kmap = new HashMap<Double, HashMap<Double, Integer>>(); // key: k, val{ key: b, val: cnt} k = dy/dx , b = y-kx
        var map = new HashMap<Integer, HashMap<Double, Integer>>(); // key: 对角线中点,  val : {key: 斜率, val : cnt} // 对应边的数量.

        // 1. 计算每一条边的斜率 k, b, 以及作为对角线时的中点坐标.
        for (int i = 0; i < points.length; i++) {
            int x = points[i][0], y = points[i][1];
            for (int j = i + 1; j < points.length; j++) {
                int xx = points[j][0], yy = points[j][1];
                int dx = xx - x;
                int dy = yy - y;

                // calculate edge's k and b ==>  k= dy/dx and b
                double k = dx != 0 ? 1.0d * dy / dx : Double.MAX_VALUE;
                double b = dx == 0 ? x : 1.0d * y - k * x; // dx ==0 , 平行与y轴, 认为规定是 x.
                if (k == -0.0) k = 0.0;
                if (b == -0.0) b = 0.0;

                HashMap<Double, Integer> tmap = kmap.getOrDefault(k, new HashMap<>());
                tmap.compute(b, (kk, v) -> v == null ? 1 : v + 1);
                kmap.put(k, tmap);

                // 设当前线段为对角线,因而计算 中点坐标.
                int mkey = (x + xx + 2000) * 10000 + (y + yy + 2000); // 去掉负数,以及移位. 将中点坐标作为key.
                HashMap<Double, Integer> tm = map.getOrDefault(mkey, new HashMap<>());
                tm.compute(k, (kk, v) -> v == null ? 1 : v + 1);
                map.put(mkey, tm);
            }
        }

        int cnt = 0;
        // 2. 计算所有的梯形数量, 包含平行四边形.
        for (HashMap<Double, Integer> bm : kmap.values()) {
            int s = 0; // 之前的边的数量.
            for (Integer i : bm.values()) { //
                cnt += s * i;
                s += i;
            }
        }

        // 3. 计算所有的平行四边形的数量.
        for (HashMap<Double, Integer> km : map.values()) {
            int s = 0;
            for (Integer i : km.values()) {
                cnt -= s * i;
                s += i;
            }

        }
        return cnt;
    }


}


