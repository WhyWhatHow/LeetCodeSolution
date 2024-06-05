package leetcode.algorithm.pq;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @program: LeetCodeSolution
 * @description:
 * @author: WhyWhatHow
 **/

public class Solution_630 {

    public static void main(String[] args) {
        Solution_630 sol = new Solution_630();
        System.out.println(sol.scheduleCourse(new int[][]{
                {100, 200}, {200, 1300}, {1000, 1250}, {2000, 3200}
        }));

        System.out.println("==================");
    }

    /**
     * 贪心, 安lastDay 升序排列,
     * 在满足可选课程的条件下,优先去做完lastDay在前, 用时少的课程,
     * example:
     * course1{100,200}
     * course2{50,300},
     * 选择课时持续时间短的课程, 留出尽可能多的时间给其他课程.
     * @param courses
     * @return
     */
    public int scheduleCourse(int[][] courses) {
        // lastDay asc
        Arrays.sort(courses, (a, b) -> a[1] - b[1]);

        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        int now = 0;
        for (int[] course : courses) {
            int d = course[0], lastDay = course[1];
            if (now + d <= lastDay) {
                now += d;
                pq.add(d);
            } else if (!pq.isEmpty() && d < pq.peek() && now - pq.peek() + d <= lastDay) {
                now -= pq.poll();
                now += d;
                pq.add(d);
            }
        }
//        int ans = 0;
//        for (int[] course : courses) {
//            if (now + course[0] <= course[1]) {
//                ans++;
//                now += course[0];
//            }
//        }
//        return ans;
        return pq.size();
    }

}


