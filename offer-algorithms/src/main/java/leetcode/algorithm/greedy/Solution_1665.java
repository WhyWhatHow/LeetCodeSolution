package leetcode.algorithm.greedy;

import java.util.Arrays;

/**
 * @program: LeetCodeSolution
 * @description: #
 * @author: WhyWhatHow
 **/
public class Solution_1665 {

    public static void main(String[] args) {
        Solution_1665 sol = new Solution_1665();//
        System.out.println("==================");
    }


    // 按照min-act 降序, 保留下来多的优先
    public int minimumEffort(int[][] tasks) {

        Arrays.sort(tasks, (a, b) -> {
            return (b[1] - b[0]) - (a[1] - a[0]);
        });
        int res = 0;
        for (int[] task : tasks) {
            res += task[0];
        }

        int cur = res;
        int need = 0;
        for (int[] task : tasks) {
            int act = task[0], min = task[1];
            if (cur < min) {
                need += min - cur;
                cur = min;
            }
            cur -= act;
        }
        return res + need;
    }
}
