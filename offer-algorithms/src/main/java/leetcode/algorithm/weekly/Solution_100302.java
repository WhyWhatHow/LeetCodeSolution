package leetcode.algorithm.weekly;

import java.util.HashSet;
import java.util.PriorityQueue;

/**
 * @program: LeetCodeSolution
 * @description:
 * @author: WhyWhatHow
 **/

public class Solution_100302 {

    public static void main(String[] args) {
        Solution_100302 sol = new Solution_100302();
        System.out.println(sol.maxPointsInsideSquareOld(new int[][]{
                        {2, 2}, {-1, -2}, {-4, 4}, {-3, 1}, {3, -3}
//                        {-6, -4}, {8, -1}, {3, 9}

                },
                "abdca"
//                "ccc"
        ));
        System.out.println("==================");
    }

    public int maxPointsInsideSquare(int[][] points, String s) {
        int maxx = 0, maxy = 0;
        int minx = 0, miny = 0;
        for (int[] point : points) {
            int x = Math.abs(point[0]);
            int y = Math.abs(point[1]);
            maxx = Math.max(x, maxx);
            maxy = Math.max(y, maxy);
            minx = Math.min(x, minx);
            miny = Math.min(y, miny);
        }
        // 找到最小的重复的两个点
        int res = 0;
//        fori
    return res;
    }

    public int maxPointsInsideSquareOld(int[][] points, String s) {
        int res = 0;
        int val = 0;
        PriorityQueue<Point> pq = new PriorityQueue<Point>((a, b) -> {
            return a.x - b.x;
        });
        for (int i = 0; i < points.length; i++) {
            pq.add(new Point(s.charAt(i), points[i]));
        }

        // 存放已经遍历的下标
        HashSet<Character> map = new HashSet<Character>();
        // 枚举边长 1->n, 第一个 正方形 中包含两个相同元素的, 为上一个结果
        int edge = 1;
        boolean done = false;
        while (!done) {
            while (!pq.isEmpty()) {
                Point peek = pq.peek();
                if (peek.x > edge || peek.y > edge) {
                    edge++;
                    res = map.size();
                    break;
                }
                // repeat char
                if (map.contains(peek.c)) {
                    done = true;
                    break;
                }

                map.add(peek.c);
                pq.poll();
            }
        }

        return res;
    }

    class Point {
        public Point(char c, int[] arr) {
            this.x = arr[0];
            this.y = arr[1];
            this.c = c;
        }

        public Point(char c, int y, int x) {
            this.c = c;
            this.y = y;
            this.x = x;
        }

        int x;
        int y;
        char c;

    }

}


