package leetcode.algorithm.hard;

import java.util.Arrays;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 * @program: LeetCodeSolution
 * @description: #
 * @author: WhyWhatHow
 **/

public class Solution_1847 {

    public static void main(String[] args) {
        Solution_1847 sol = new Solution_1847();
        System.out.println(sol.closestRoom(new int[][]{
                {2, 2},
                {1, 2},
                {3, 2}
        }, new int[][]{
                {3, 1},
                {3, 3},
                {5, 2}
        }));
        System.out.println("==================");
    }

    /**
     * 这道题我的思路是,
     * 1. 将同 size 的roomid 放在一起, 这里用到的是treemap<size, int[]>
     * 2. queries 按minsize大小 降序, 需要保存 idx -> nums
     * 3. 按照minSize 大小  处理结果
     * 将>=当前size的 int[] 并入另一个treeset 中
        *  map.subMap(from ,to ) -> [from ,to)
     * 然后执行查询
     *
     * @param rooms
     * @param queries
     * @return
     */
    public int[] closestRoom(int[][] rooms, int[][] queries) {
        TreeMap<Integer, TreeSet<Integer>> map = new TreeMap<>();

        for (int[] room : rooms) {
            int id = room[0];
            int size = room[1];
            map.compute(size, (k, v) -> {
                if (v == null) {
                    v = new TreeSet<>();
                }
                v.add(id);
                return v;
            });
        }

        TreeSet<Integer> set = new TreeSet<>(); // 用来放

        int n = queries.length;
        Integer[] nums = new Integer[n];
        for (int i = 0; i < n; i++) nums[i] = i;
        Arrays.sort(nums, (a, b) -> queries[b][1] - queries[a][1]);

        int[] ans = new int[n];
        Arrays.fill(ans, -1);
        int last = 0 ;
        for (Integer i : nums) {
            int res = -1;
            int minSize = queries[i][1];
            // remove not exist size
            if (map.ceilingKey(minSize) == null) continue;

            if(last == 0 )
            map.tailMap(minSize).values().forEach(vs -> set.addAll(vs));
            else
                map.subMap(minSize,last).values().forEach(vs->set.addAll(vs));
            last =minSize;
            int targetId = queries[i][0];
            Integer ceil = set.ceiling(targetId);
            Integer floor = set.floor(targetId);
                if (ceil == null) ans[i] = floor;
                else if (floor == null) ans[i] = ceil;
                else ans[i] = targetId - floor <= ceil - targetId ? floor : ceil;
        }

        return ans;
    }


}


