package leetcode.algorithm.bfs;

import java.util.ArrayDeque;

/**
 * @program: LeetCodeSolution
 * @description: #
 * @author: WhyWhatHow
 **/

public class Solution_838 {

    public static void main(String[] args) {
        Solution_838 sol = new Solution_838();
        System.out.println(sol.pushDominoes(
                ".L.R...LR..L.."
//                "..R.."
        ));
        System.out.println("==================");
    }

    // 有点类似拓扑序, 按照时间序列处理每一个可以施加力的多米牌, 然后在每一妙  中对val 进行修改,避免 后一秒的影响到当前妙
    public String pushDominoes(String dominoes) {
        char[] cs = dominoes.toCharArray();
        int n = cs.length;
        int val = 1000_00;
        int[] f = new int[n];
//        int[] ls = new int[n]; // level
        boolean[] v = new boolean[n];
//        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
//            if (a[1] < b[1]) return a[1] - b[1];
//            else return a[0]-b[0];
//        }); // {idx, level }
        ArrayDeque<Integer> q = new ArrayDeque<>();
//        ArrayList
        for (int i = 0; i < cs.length; i++) {
            if (cs[i] != '.') {
                q.add(i);
            }
            if (cs[i] == 'L') f[i] = -val;
            if (cs[i] == 'R') f[i] = val;
        }
        while (!q.isEmpty()) {
            int size = q.size();
            for (int j = 0; j < size; j++) {
                Integer i = q.poll();
                if (v[i]) continue;
                v[i] = true;
                cs[i] = f[i] < 0 ? 'L' : cs[i];
                cs[i] = f[i] > 0 ? 'R' : cs[i];

                if (f[i] < 0 && i > 0 && !v[i - 1]) {
                    q.addLast(i - 1);
//                q.offer()
                    f[i - 1] -= val;
                }
                if (f[i] > 0 && i < n - 1 && !v[i + 1]) {
                    q.addLast(i + 1);
                    f[i + 1] += val;
                }
            }
            val --;

        }
        return String.valueOf(cs);
    }


}


