package leetcode.algorithm.demo;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @program: LeetCodeSolution
 * @description:
 * @author: WhyWhatHow
 **/

public class Solution_857 {

    public static void main(String[] args) {
        Solution_857 sol = new Solution_857();
        System.out.println(sol.mincostToHireWorkers(new int[]{
//                        10, 20, 5
                        3, 1, 10, 10, 1
                }, new int[]{
//                        70, 50, 30
                        4, 8, 2, 2, 7
                },
//                2
                3
        ));
        System.out.println("==================");
    }

    /**
     * 计算雇佣k个员工的工资的最低花费.
     * 思路如下:  W-> wage , Q->quality
     * 假设k个员工 总的工作质量是Tq, 总的工作花费是Tc
     * 每个员工(假设是员工k)的 单位质量的花费是, (double)Wk/Qk
     * 员工k : Hk = (Tc/Tq)*Qk
     *        Hk >= Wk 所以Tc>=Tq*(Wk/Qk)
     * 也就是说, 只有Wk/Qk 最小, 以及Tq 最小的时候, 才可能出现雇佣员工的最小值
     * Target:
     *  Tq  越来越小 -> 大顶堆(用来统计 quality, 去掉最大值,保证前k个小)
     *  Wk/Qk  小 -> 升序排列 (下标也好,重新计算也好)
     * Step:
     * 1. 计算 每个员工单位质量的花费, 并按照升序进行排序
     * 2. 从第K个下标开始, 不断减少Tq的值即可.
     *
     * Question:
     * 如何保证Wk >Wk-1 呢?
     * @param quality
     * @param wage
     * @param k
     * @return
     */
    public double mincostToHireWorkers(int[] quality, int[] wage, int k) {
        int n = wage.length;
        Integer[] ids = new Integer[n]; // 存放元素下标
        for (int i = 0; i < ids.length; i++) {
            ids[i] = i;
        }


        // 计算 性价比 r = w/q , 升序 统计 下标 #awsome
        Arrays.sort(ids, (a, b) -> {
            // hint : 需要将数组定义为Integer[] 而不是 int[]
            return wage[a] * quality[b] - wage[b] * quality[a];
        });

        double res = 1e9;
        double tw = 0; // k个人总 所有的wage
        double tq = 0;  // k个人的总 quality
        // pq 记录 quality 的max heap
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> {
            return b - a;
        });

        // init k-1 tq
        for (int i = 0; i < k - 1; i++) {
            tq += quality[ids[i]];
            pq.add(quality[ids[i]]);
        }

        // handle k-1 -> n
        for (int i = k - 1; i < n; i++) {
            int idx = ids[i];
            tq += quality[idx];
            tw = tq * ((double) wage[idx] / quality[idx]);// 统计总的 // 精度问题

            pq.add(quality[idx]);

            tq -= pq.poll(); // 去掉前k个里面的最大的
            res = Math.min(tw, res);
        }

        return res;

    }


}


