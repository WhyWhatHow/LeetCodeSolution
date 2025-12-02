package leetcode.algorithm.medium;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * @program: LeetCodeSolution
 * @description: #
 * @author: WhyWhatHow
 **/

public class Solution_3623 {

    public static void main(String[] args) {
        Solution_3623 sol = new Solution_3623();
        System.out.println(sol.countTrapezoids(new int[][]
//                {{1, 0}, {2, 0}, {3, 0}, {0, 0}, {2, 2}, {3, 2}, {1, 2}, {0, 2}}
                        {{-17, -64}, {45, 65}, {85, -64}, {-13, -64}, {-92, 69}, {-97, 69}, {56, 69}, {88, 65}}
        ));

        System.out.println("==================");
    }

    int mod = 1000_000_007;

    /**
     * 思路: count y , 然后 对于y相等的点而言可以构筑的边的数量是Cn2== (n*n-1)/2 条边.
     * 对边进行枚举, 假设边的数量是 e0 ,e1, e2, e3 .
     * 对于 e0 而言, 左侧没有边, 所以可以统计的数量是0
     *     e1:  e1*(e0)
     *     e2 : e2* (e0+e1)
     *     e3 : e3*(e0+e1+e2)
     *     ....
     * 可以构成的数量为其结果之和.
     * #两数之和
     * @param points
     * @return
     */
    // ( )枚举右,维护左.
    public int countTrapezoids(int[][] points) {
        var list = new ArrayList<Long>(); // count : when points have same y value.
        var map = new HashMap<Integer, Integer>(); // key : y : val: cnt
        for (int[] point : points) {
            int y = point[1];
            map.compute(y, (k, v) -> v == null ? 1 : v + 1);
        }
        for (Integer value : map.values()) {
            list.add((long) value * (value - 1) / 2);
        }

        long res = 0;
        long presum = 0;
        for (int i = 0; i < list.size(); i++) {
            long v = list.get(i);
            res = (res + v * presum) % mod;
            presum += v;
        }
        return (int) res;
    }


}


