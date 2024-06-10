package leetcode.algorithm.greedy;

/**
 * @program: LeetCodeSolution
 * @description:
 * @author: WhyWhatHow
 **/

public class Solution_134 {

    public static void main(String[] args) {
        Solution_134 sol = new Solution_134();
        System.out.println(sol.canCompleteCircuit(new int[]{
                1, 2, 3, 4, 5
        }, new int[]{
                3, 4, 5, 1, 2
        }));
        System.out.println("==================");
    }

    /**
     * 如果存在解的话, 题目告诉我们是唯一的,
     * 思路:
     * 首先判断是否有解 --> 只需要统计 sum(gas[i]- cost[i]) > 0 即可.
     * 在有解的情况下, 即total>=0, 如果存在加油站点i, 使得到i+1到汽油不够, 那么必定存在点k, 可以保证完成全程.

     * 在有解的情况下, 已经知道总的汽油量是足够的（total >= 0），这意味着如果存在一个点 B，从这个点出发无法到达下一个加油站，那么必然存在另外一个点 C，从 C 出发可以补偿这个缺口，并且完成全程

     * @param gas
     * @param cost
     * @return
     */
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int cur = 0;
        int total = 0;
        int start = 0;
        //  check if exists solution
        for (int i = 0; i < gas.length; i++) {
            total += gas[i] - cost[i];
        }
        if (total < 0) {
            return -1;
        }
        // have answer
        for (int i = 0; i < gas.length; i++) {
            cur += gas[i] - cost[i];
            if (cur < 0) { // now position 0 zero can't be a start index, so change it.
                start = i + 1;
                cur = 0;
            }
        }
        return start;

    }


}


