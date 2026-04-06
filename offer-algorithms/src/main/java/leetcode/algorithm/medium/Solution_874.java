package leetcode.algorithm.medium;

import java.util.HashMap;
import java.util.TreeSet;

/**
 * @program: LeetCodeSolution
 * @description: #
 * @author: WhyWhatHow
 **/
public class Solution_874 {

    public static void main(String[] args) {
        Solution_874 sol = new Solution_874();//
        System.out.println(sol.robotSim(
//                new int[]{4, -1, 3}, new int[][]{}
//                new int[]{6,-1,-1,6}, new int[][]{}
                new int[]{2, -1, 8, -1, 6}, new int[][]{{1, 5}, {-5, -5}, {0, 4}, {-1, -1}, {4, 5}, {-5, -3}, {-2, 1}, {-2, -5}, {0, 5}, {0, -1}}
        ));
        System.out.println("==================");
    }

    // dir  0 N,1e, 2s, 3w;
    // turn right : dir+1, dir>=4 ,dir =0 ;
    // turn left : dir-1 , dir<0  dir = 3 ;
    public int robotSim(int[] commands, int[][] obstacles) {
        int dir = 0; //
        var obx = new HashMap<Integer, TreeSet<Integer>>();
        var oby = new HashMap<Integer, TreeSet<Integer>>();
        for (int[] a : obstacles) {
            int cx = a[0], cy = a[1];
            var xs = obx.getOrDefault(cx, new TreeSet<>());
            xs.add(cy);
            var ys = oby.getOrDefault(cy, new TreeSet<>());
            ys.add(cx);
            obx.put(cx, xs);
            oby.put(cy, ys);
        }

        int x = 0, y = 0; // 当前坐标

        int max = 0;

        for (int c : commands) {
            if (c == -2) { // go left
                dir = dir - 1 < 0 ? 3 : dir - 1;
            } else if (c == -1) {// go right
                dir = dir + 1 >= 4 ? 0 : dir + 1;
            } else {
                if (dir == 0) { // north
                    if (obx.containsKey(x) && obx.get(x).higher(y) != null)
                        y = Math.min(y + c, obx.get(x).higher(y) - 1);
                    else y += c;
                } else if (dir == 1) { // east
                    Integer h;
                    if (oby.containsKey(y) && (h = oby.get(y).higher(x)) != null) {
                        x = Math.min(x + c, h - 1);
                    } else x = x + c;
                } else if (dir == 2) { // south
                    Integer l;
                    if (obx.containsKey(x) && (l = obx.get(x).lower(y)) != null) {
                        y = Math.max(y - c, l + 1);
                    } else y -= c;
                } else { // west
                    Integer l;
                    if (oby.containsKey(y) && (l = oby.get(y).lower(x)) != null) {
                        x = Math.max(x - c, l + 1);
                    } else x -= c;
                }
                max = Math.max(max, x * x + y * y);

            }
        }

        return max;
    }
}
