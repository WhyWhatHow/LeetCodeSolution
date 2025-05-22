package leetcode.algorithm.greedy;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @program: LeetCodeSolution
 * @description: #
 * @author: WhyWhatHow
 **/

public class Solution_3362 {

    public static void main(String[] args) {
        Solution_3362 sol = new Solution_3362();
        System.out.println(sol.maxRemoval(new int[]{
//                2, 0, 2
                0, 0, 3
//                1,1,1,1
        }, new int[][]{
//                {0, 2},
//                {0, 2},
//                {1, 1}
                /////////////////
                {0, 2},
                {1, 1},
                {0, 0},
                {0, 0}
                ///////
//                {1, 3},
//                {0, 2},
//                {1, 3},
//                {1, 2}
        }));
        System.out.println("==================");
    }

    public int maxRemoval(int[] nums, int[][] queries) {
        int n = queries.length;

        // init diff
        int[] diff = new int[nums.length + 1];
        diff[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            diff[i] = nums[i] - nums[i - 1];
        }

        Arrays.sort(queries, (a, b) -> a[0] - b[0]);
        int res = -1;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[1] - a[1]);
        int i = 0, j = 0;
//        int k = 0;
        while (i < nums.length) {

            // 跳过不需要处理的节点.
            if (nums[i] <= 0) {
                i++;
                continue;
            }

            // 把所有符合条件的数据入队.
            while (j < queries.length) {
                if (queries[j][0] > i) {
                    break;
                }
                pq.add(queries[j++]);
            }


            // 处理nums[i] //条件不满足.
            if (nums[i] > pq.size()) return -1;
            int cnt = 0; // 标记对于nums[i] 最大处理次数.
            int right = -1;
            while (!pq.isEmpty() && cnt < nums[i]) {
                n--;
                int[] a = pq.poll();
                diff[a[0]]--;
                diff[a[1] + 1]++;
                right = Math.max(right, a[1] + 1);
                cnt++;
            }

            nums[0] = diff[0];
            // 将修改结果填入nums
            for (int l = 1; l < right; l++) {
                nums[l] = diff[l] + nums[l - 1];
            }
            if (nums[i] > 0) return -1;
            i++;
        }

        return n;
    }
}


