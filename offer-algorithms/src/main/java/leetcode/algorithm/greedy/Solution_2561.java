package leetcode.algorithm.greedy;

import java.util.*;

/**
 * @program: LeetCodeSolution
 * @description: #
 * @author: WhyWhatHow
 **/

public class Solution_2561 {

    public static void main(String[] args) {
        Solution_2561 sol = new Solution_2561();
        sol.minCost(new int[]{
                4, 2, 2, 2
        }, new int[]{
                1, 1, 4, 2
        });
        System.out.println("==================");
    }

    // 分析: 有题意知道, ab交换后,元素相同, 也就是说, ab中某一值的元素数量要是偶数, 奇数 不符题意,Return -1;
    // 如何让交换的代价最小呢?
    // method_1: (min_a, max_b) 为一组去交换,每一次结果最小的选择.
    // method_2: 交换 两次, 假设ab数组中最小的是mn, 每一次都在交换mn, 不过需要交换两次.
    // step_1: 去处掉a,b 公用的元素.
//     用一个map维护, a的元素++, b的元素--. 遍历后map的某一entry如下: val>0 , 说明是a中元素, val<0 , 说明是b中元素. 还原即可.

    public long minCost(int[] a, int[] b) {
        HashMap<Integer, Integer> map = new HashMap<>(); // k: num, v: cnt
        for (int i = 0; i < a.length; i++) {
            map.compute(a[i], (k, v) -> v == null ? 1 : v + 1); //
            map.compute(b[i], (k, v) -> v == null ? -1 : v - 1);
        }

        int mn = Integer.MAX_VALUE;
        var alist = new ArrayList<Integer>();
        var blist = new ArrayList<Integer>();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            Integer k = entry.getKey();
            Integer v = entry.getValue();
            mn = Math.min(mn, k);
            if ((v & 1) == 1) return -1;

            if (v > 0) {
                for (Integer i = 0; i < v / 2; i++) {
                    alist.add(k);
                }
            } else {
                for (Integer i = 0; i < -v / 2; i++) {
                    blist.add(k);
                }
            }
        }

        long res = 0;
        alist.sort(Integer::compareTo);
        blist.sort(Collections.reverseOrder());

        for (int i = 0; i < alist.size(); i++) {
            int tmp = Math.min(alist.get(i), blist.get(i));
            res += Math.min(tmp, 2 * mn);
        }
        return res;

    }


    private void fillPQ(int[] a, int[] b, PriorityQueue<Integer> minpq, PriorityQueue<Integer> maxpq) {


    }

    // 判断nums 之和 是否是 奇数, 如果是奇数 true
    private boolean checkSum(int[] nums) {
        long sum = 0;
        for (int num : nums) {
            sum += num;
        }
        return (sum & 1) == 1;
    }
}


