package leetcode.algorithm.greedy;

import java.util.ArrayList;
import java.util.PriorityQueue;

/**
 * @program: LeetCodeSolution
 * @description: #
 * @author: WhyWhatHow
 **/

public class Solution_3440 {

    public static void main(String[] args) {
        Solution_3440 sol = new Solution_3440();
        System.out.println(sol.maxFreeTime(
//                5
                10
                , new int[]{
//                1, 3
                        0, 7, 9
                }, new int[]{
//                2, 5
                        1, 8, 10
                }));
        System.out.println("==================");
    }

    /***
     * 对于 eventsI, 若左侧freeTime 为最大值, 右侧freeTime 为次大值, 那么只需要判断第三大的freeTime 是否可以放下eventsI所需要的时间即可.
     * @param eventTime
     * @param startTime
     * @param endTime
     * @return
     */
    public int maxFreeTime(int eventTime, int[] startTime, int[] endTime) {
        int n = startTime.length;
        // count every_freeTime that we have. 
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[1] - a[1]); // freeTime.start, freeTime.length
        pq.add(new int[]{0, startTime[0]});
        for (int i = 1; i < n; i++)
            pq.add(new int[]{endTime[i - 1], startTime[i] - endTime[i - 1]});
        pq.add(new int[]{endTime[n - 1], eventTime - endTime[n - 1]});

        ArrayList<int[]> list = new ArrayList<>();// store Top3 freeTime that we can compare. 
        int cnt = 0;
        while (!pq.isEmpty() && cnt++ < 3) {
            list.add(pq.poll());
        }

        int res = 0;
        for (int i = 0; i < n; i++) {
            int st = startTime[i];
            int before = i == 0 ? 0 : endTime[i - 1]; // leftFreeTime.start
            int end = endTime[i]; // rightFreeTime.start
            int costTime = end - st;
            boolean yes = false;
            for (int[] ints : list) {
                if (ints[0] == end || ints[0] == before) continue;
                if (ints[1] >= costTime) {
                    yes = true;
                    break;
                }
            }
            int leftFreeTime = i == 0 ? startTime[0] : startTime[i] - endTime[i - 1];
            int rightFreeTime = i == n - 1 ? eventTime - endTime[n - 1] : startTime[i + 1] - end;
            if (yes) { // we can move eventI to another time
                res = Math.max(res, leftFreeTime + rightFreeTime + costTime);
            } else { // we can move eventI to left , or right freeTime, and maxFreeTime win.
                int rightEndTime = i == n - 1 ? eventTime : startTime[i + 1];
                int leftStartTime = i == 0 ? 0 : endTime[i - 1];
                // if we can  move left , no difference .
                int moveLeft = leftStartTime == 0 ? -1 : rightEndTime - (leftStartTime + costTime);
                int moveRight = (rightEndTime - costTime) - leftStartTime;
                res = Math.max(res, Math.max(moveLeft, moveRight));
            }
        }
        return res;


    }
}


