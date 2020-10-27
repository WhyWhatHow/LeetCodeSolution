package JulyTest;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * @program: LeetCodeSolution
 * @description:
 * @author: WhyWhatHow
 * @create: 2020-07-17 18:56
 **/
class Node {
    int pre;
    int next;
    int val;

    public Node(int pre, int next, int val) {
        this.pre = pre;
        this.next = next;
        this.val = val;
    }

    public Node() {
    }
}

public class Main {
    public Main() {
        for (int i = 0; i < map.length; i++) {
            for (int i1 = 0; i1 < map.length; i1++) {
                if (i == i1) {
                    map[i][i1] = 0;
                } else {
                    map[i][i1] = Integer.MAX_VALUE;
                }

            }
        }
    }

    int[][] map = new int[10001][10001];

    public static void main(String[] args) {
        Main sol = new Main();
        int x, y, temp;
        Scanner in = new Scanner(System.in);
//         System.out.println(longeger.MAX_VALUE);
        while (in.hasNext()) {
            int n = in.nextInt();
            int m = in.nextInt();
            int s = in.nextInt();
            int t = in.nextInt();

            while (m-->0) {
                x = in.nextInt();
                y = in.nextInt();
                temp = in.nextInt();
                sol.map[x][y] = temp;
            }
            int dfs = sol.dfs(s, t, n);
            dfs += sol.dfs(t, s, n);
            System.out.println(dfs);
        }
    }

    int[] dist = new int[10001];

    // 单元最短路径
    private int dfs(int s, int t, int n) {

        boolean[] vis = new boolean[n+1];
        PriorityQueue<Node> queue = new PriorityQueue();
        queue.add(new Node(s, s, map[s][s]));

        int sol = 0;
        while (!queue.isEmpty()) {
            Node poll = queue.poll();
            if (!vis[poll.pre]) {
                sol += poll.val;
                vis[poll.pre] = true;
            }
            for (int i = 1; i <= n; i++) {
                if (map[poll.pre][i] != Integer.MAX_VALUE  && !vis[i]) {
                    queue.add(new Node(poll.pre, i, map[poll.pre][i]));
                }
//                queue.add(new Node())
            }
        }

        return sol;
    }

//    4
//    1 1 1 1
//    2 0 0 4
//    3 0 2 5
//    4 24 0 0

    /**
     * 一天 只能吃6分
     *
     * @param n 高温天数
     * @param a 一盒一个的雪糕
     * @param b 一盒两个的雪糕
     * @param c 一盒三个的雪糕
     */
    private boolean eat(long n, long a, long b, long c) {
        if (n < 0)
            return false;
        long sum = a + b * 2 + c * 3;
        if (sum < n * 6) {
            return false;
        }
        long temp = 6;
        long cnt = 0;
        boolean loop = false;
        // 先吃3 , 再吃2 ,最后吃1
        while (n > 0) {
            loop = false;
            //  3 分
            while (c > 0) {
                c--;
                temp -= 3;
                if (c >= 0 && temp == 0) {
                    loop = true;
                    break;
                } else if (temp < 0) {
                    c++;
                    temp += 3;
                    break;
                }
            }
            while (b > 0) {
                b--;
                temp -= 2;
                if (b >= 0 && temp == 0) {
                    loop = true;
                    break;
                } else if (temp < 0) {
                    b++;
                    temp += 2;
                    break;
                }
            }
            while (a > 0) {
                a--;
                temp -= 1;
                if (a >= 0 && temp == 0) {
                    loop = true;
                    break;
                } else if (temp < 0) {
                    a++;
                    temp += 1;
                    break;
                }
            }
            if (!loop) {
                return false;
            } else {
                temp = 6;
                n--;
            }
        }
        return true;
    }


    // test 1
    // in :   3, 5, 100,  10
    // out : 11


    /**
     * @param x 元/天
     * @param f 水果个数
     * @param d 元
     * @param p 水果售价
     * @return
     */
    public long solve(long x, long f, long d, long p) {
        long ans = 0;
        long temp = x + p;
        while (d > 0) {
            if (f > 0) {
                f--;
                d -= x;
            } else {
                d -= temp;
            }
            ans++;
        }

        return d == 0 ? ans : ans - 1;
    }
}
