package leetcode.algorithm.pq;

import java.util.PriorityQueue;

/**
 * @program: LeetCodeSolution
 * @description: #
 * @author: WhyWhatHow
 **/
public class Solution_3296 {

    public static void main(String[] args) {
        Solution_3296 sol = new Solution_3296();//
        System.out.println(sol.minNumberOfSeconds(
//                10,
//                new int[]{3, 2, 2, 4}
                5,
                new int[]{1, 7}
        ));
        System.out.println("==================");
    }

    //    山的高度降低 x，需要花费 workerTimes[i] + workerTimes[i] * 2 + ... + workerTimes[i] * x 秒
    // workTimes[i] *sum(1...x)
    // max min*(1+x)
//    输入： mountainHeight = 10, workerTimes = [3,2,2,4]
//    输出： 12
//    工人 0 将高度降低 2，花费 workerTimes[0] + workerTimes[0] * 2 = 9 秒。
//    工人 1 将高度降低 3，花费 workerTimes[1] + workerTimes[1] * 2 + workerTimes[1] * 3 = 12 秒。
//    工人 2 将高度降低 3，花费 workerTimes[2] + workerTimes[2] * 2 + workerTimes[2] * 3 = 12 秒。
//    工人 3 将高度降低 2，花费 workerTimes[3] + workerTimes[3] * 2 = 12 秒。
//    所需的最少时间为 max(9, 12, 12, 12) = 12 秒。
    // 每一次高度降低,选择耗时最少的工人去做, 同时,需要同步更新工人下一次可以使用的最短时间.

    public long minNumberOfSeconds(int mountainHeight, int[] workerTimes) {
        long[] cs = new long[workerTimes.length];
        // idx 下标, nextTime 表示下一高度处理需要的耗费时间, cnt: 表示处理的高度. .
        var pq = new PriorityQueue<long[]>((a, b) -> { // long[] ==> {idx, nextTime,cnt}
            return Long.compare(a[1], b[1]);
        }); // idx , workTime , cnt
        for (int i = 0; i < workerTimes.length; i++) {
            pq.add(new long[]{i, workerTimes[i], 1});
        }

        long max = 0;

        while (mountainHeight-- > 0) {
            long[] a = pq.poll();
            int i = (int) a[0];
            long cur = a[1];
            var cnt = a[2];
            cnt++;
            max = Math.max(cur, max);
            pq.add(new long[]{i, cur + (long) workerTimes[i] * cnt, cnt});

        }


        return max;

    }


}
