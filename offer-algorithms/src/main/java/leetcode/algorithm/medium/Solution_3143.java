package leetcode.algorithm.medium;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

/**
 * @program: LeetCodeSolution
 * @description: #
 * @author: WhyWhatHow
 **/

public class Solution_3143 {

    public static void main(String[] args) {
        Solution_3143 sol = new Solution_3143();
        System.out.println(sol.maxPointsInsideSquare(new int[][]{
//                        {2, 2}, {-1, -2}, {-4, 4}, {-3, 1}, {3, -3}
                        {-1, -4}, {16, -8}, {13, -3}, {-12, 0}
                },
//                "abcda"
                "abda"
        ));
        System.out.println("==================");
    }

    public int maxPointsInsideSquare(int[][] points, String s) {
        if (s.length() == 1) return 1;
        char[] chars = s.toCharArray();

        int[][] edges = new int[points.length][2];
        for (int i = 0; i < points.length; i++) {
            edges[i][0] = Math.max(Math.abs(points[i][0]), Math.abs(points[i][1]));
            edges[i][1] = i;
        }
        Arrays.sort(edges, (a, b) -> a[0] - b[0]);

        int[] cnts = new int[26];// count
        int ans = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < edges.length; i++) {
            int val = edges[i][0];
            int idx = chars[edges[i][1]] - 'a';
            cnts[idx]++;
            if (cnts[idx] > 1) {
                ans -= map.getOrDefault(val, 0);
                break;
            }
            map.compute(val, (k, v) -> v == null ?1: v + 1);
//            map.put(val, map.getOrDefault(val, 0) + 1);
            ans++;
        }
        return ans;
    }

    /**
     * 统计每一个顶点的作为正方形所需的边长, 即(x,y) 中max(|x| , |y|)
     * 然后从小到大, 依次遍历,  出现重复元素,删除当前边,然后返回结果.
     * #greedy #stupid #hashset
     *
     * @param points
     * @param s
     * @return
     */
    public int maxPointsInsideSquareStupid(int[][] points, String s) {
        if (s.length() == 1) return 1;

        int[][] edges = new int[points.length][2];
        for (int i = 0; i < points.length; i++) {
            edges[i][0] = Math.max(Math.abs(points[i][0]), Math.abs(points[i][1]));
            edges[i][1] = i;
        }
        char[] chars = s.toCharArray();
        Arrays.sort(edges, (a, b) -> a[0] - b[0]);

        HashSet<Character> set = new HashSet<>();
        HashSet<Character> edgeSet = new HashSet<>();
        edgeSet.add(chars[edges[0][1]]);
        int prevVal = edges[0][0];
        for (int i = 1; i < edges.length; i++) {
            int val = edges[i][0];
            int idx = edges[i][1];

            if (prevVal == val) {
                if (edgeSet.contains(chars[idx]) || set.contains(chars[idx])) {
                    edgeSet.clear();
                    break;
                }
                edgeSet.add(chars[idx]);
            } else {
                set.addAll(edgeSet);
                edgeSet.clear();
                if (set.contains(chars[idx])) break;
                edgeSet.add(chars[idx]);
            }
            prevVal = val;
        }
        if (edgeSet.size() != 0)
            set.addAll(edgeSet);

        return set.size();
    }
}


