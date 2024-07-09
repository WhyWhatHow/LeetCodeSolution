package leetcode.algorithm.hard;

import java.util.TreeMap;

/**
 * @program: LeetCodeSolution
 * @description: #math #曼哈顿距离 #切比雪夫距离
 * @author: WhyWhatHow
 **/

public class Solution_3102 {

    public static void main(String[] args) {
        Solution_3102 sol = new Solution_3102();
        System.out.println("==================");
    }

    /**
     * #think #onemore #don't understand  #cv
     * 曼哈顿距离-> 切比雪夫距离
     * 将每个点绕原点旋转45度,并且扩大 √2倍,  (x,y)->(x+y,y-x)
     * @param points
     * @return
     */
    public int minimumDistance(int[][] points) {
        TreeMap<Integer, Integer> xmap = new TreeMap<>();
        TreeMap<Integer, Integer> ymap = new TreeMap<>();

        for (int[] p : points) {
            xmap.merge(p[0] + p[1], 1, Integer::sum);
            ymap.merge(p[1] - p[0], 1, Integer::sum);
        }

        int ans = Integer.MAX_VALUE;
        for (int[] p : points) {
            int x = p[0] + p[1];
            int y = p[1] - p[0];
            if (xmap.get(x) == 1) xmap.remove(x);
            else xmap.merge(x, -1, Integer::sum);
            if (ymap.get(y) == 1) ymap.remove(y);
            else ymap.merge(y, -1, Integer::sum);

            int dx = xmap.lastKey() - xmap.firstKey();
            int dy = ymap.lastKey() - ymap.firstKey();

            ans = Math.min(ans, Math.max(dx, dy));

            xmap.merge(x, 1, Integer::sum);
            ymap.merge(y, 1, Integer::sum);
        }
        return ans;
    }


}


