package leetcode.algorithm.hard;

import java.util.Arrays;

/**
 * @program: LeetCodeSolution
 * @description:
 * @author: WhyWhatHow
 **/

public class Solution_2589 {

    public static void main(String[] args) {
        Solution_2589 sol = new Solution_2589();
        System.out.println(sol.findMinimumTime(new int[][]{
//                {4, 5, 1}, {2, 3, 1}, {1, 5, 2}
                {1, 3, 2}, {2, 5, 3}, {5, 6, 2}
//                {1, 3, 3}, {2, 6, 5}
        }));
        ;
        System.out.println("==================");
    }

    /**\
     * #greedy
     * 思路:  每一个任务, 都是从end-> start 开始,  避免任务的重复使用即可.
     *
     * @param tasks
     * @return
     */
    public int findMinimumTime(int[][] tasks) {
        int ans = 0;
        int[] cnt = new int[2001];
        Arrays.sort(tasks, (a, b) -> a[1] - b[1]);

        for (int[] task : tasks) {
            int start = task[0], end = task[1], dur = task[2];
            // 排除掉 可以重复使用的时间点
            for (int i = start; i <= end; i++) {
                dur -= cnt[i];
            }
            for (int i = end; i >= start &&dur>0; i--) {
                if (cnt[i] == 0) {
                    cnt[i] = 1;
                    ans ++;
                    dur-- ;
                }
            }
        }
        return ans;
    }


//    public int findMinimumTime(int[][] tasks) {
//        int res = 0;
//        // endTime asc order
//        Arrays.sort(tasks, (a, b) -> {
//            return a[1] == b[1] ? a[0] - b[0] : a[1] - b[1];
//        });
//        Stack<int[]> stack = new Stack<>();
//        stack.push(tasks[0]);
//        for (int i = 1; i < tasks.length; i++) {
//            int[] peek = stack.peek();
//            if (peek[1] < tasks[i][0]) { // [],{} // []->peek, {}-> tasks
//                stack.push(tasks[i]);
//            } else if (peek[0] >= tasks[i][0] && peek[1] <= tasks[i][1]) { // { [] }
//                stack.pop();
//                stack.push(tasks[i]);
//            } else { // [ { ] }
//                // running as same time
//                int both = peek[1] - tasks[i][0] + 1; // { ]
//                int preDur = peek[2] - both;
//                int postDur = tasks[i][2] - both;
//                stack.pop();
//                // [ {
//                if (preDur > 0) {
//                    stack.push(new int[]{peek[0], peek[0] + preDur, preDur});
//                }
//                // {]
//                stack.push(new int[]{tasks[i][0], peek[1], both});
//                // ]}
//
//                if (postDur > 0)
//                    stack.push(new int[]{tasks[i][0] + both, tasks[i][1], postDur});
////                if (both == peek[2]) {
////                    stack.pop();            // [{}]
////                    stack.push(tasks[i]);
////                } else if (both < peek[2]) { //[ { ] } -->[]{} peek:[1,3,3] tasks: [2,6,5] -> [1,3,3] [4,5,2]
////                    // [2,3]}
////                    int start = tasks[i][0] + both;
////                    int end = tasks[i][1];
////                    int dur = tasks[i][2] - both;
//////                    stack.pop();
//////                    stack.push(new int[]{peek[0],peek[1]+dur,peek[2]+dur});
////                    stack.push(new int[]{start, end, dur});
//////                        stack.push( new int[]{peek[0],})
////                }
//            }
//        }
//
//
//        while (!stack.isEmpty()) {
//            res += stack.pop()[2];
//        }
//
//        return res;
//    }

}


