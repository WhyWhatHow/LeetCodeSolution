package leetcode.algorithm.window;

import java.util.HashMap;
import java.util.PriorityQueue;

/**
 * @program: LeetCodeSolution
 * @description: #
 * @author: WhyWhatHow
 **/
public class Solution_480 {

    public static void main(String[] args) {
        Solution_480 sol = new Solution_480();//
        System.out.println(sol.medianSlidingWindow(
//                new int[]{1, 3, -1, -3, 5, 3, 6, 7},
//                3
                new int[]{1,4,2,3},
                4
        ));
        System.out.println("==================");
    }


    public double[] medianSlidingWindow(int[] nums, int k) {
        int len = nums.length - k + 1;
        double[] rs = new double[len];
        LazyHeap heap = new LazyHeap(k);
        int cnt = 0;
        for (int i = 0; i < nums.length; i++) {

            heap.add(nums[i]);
            if (i >= k - 1) {
                rs[cnt++] = heap.getMidVal();
                // remove map
                heap.remove(nums[i - k + 1]);
            }

        }
        return rs;
    }


}


class LazyHeap {

    // del element map
    HashMap<Integer, Integer> map = new HashMap<Integer, Integer>(); // key: del_ele, val :cnt
    // 将小的数据放在maxpq, 大的数据放进minpq
    PriorityQueue<Integer> maxpq = new PriorityQueue<>((a, b) -> Integer.compare(b, a));
//    PriorityQueue<Integer> maxpq = new PriorityQueue<Integer>((a, b) -> b - a);// k &1 ==1 ,  len: (k+1)/2
    PriorityQueue<Integer> minpq = new PriorityQueue<Integer>();
    int maxpqsize;
    int minpqsize;
    int k;

    LazyHeap(int k) {
        this.k = k;
    }

    void add(int x) {
        if (maxpq.isEmpty() || maxpq.peek() >= x) {
            maxpq.add(x);
            maxpqsize++;
        } else {
            minpqsize++;
            minpq.add(x);
        }

        reBalance();
    }

    void remove(int x) {
        map.compute(x, (kk, v) -> v == null ? 1 : v + 1);
        // update maxpqsize , and minpqsize

        if (!maxpq.isEmpty() && maxpq.peek() >= x) {
            maxpqsize--;
        } else {
            minpqsize--;
        }
        reBalance();

    }

    double getMidVal() {
        doRemove(maxpq);
        doRemove(minpq);

        double res = 1.0d;
        if ((k & 1) == 1) { //odd
            res = maxpq.peek();
        } else {
            res = res * ((long)maxpq.peek() + minpq.peek()) / 2.0d;
        }
        return res;
    }

    void doRemove(PriorityQueue<Integer> pq) {
        while (!pq.isEmpty()) {
            Integer key = pq.peek();
            if (!map.containsKey(key)) {
                break;
            }
            pq.poll();
            Integer v = map.merge(key, -1, Integer::sum);
            if (v == 0)
                map.remove(key);

        }
    }

    private void reBalance() {
        if (maxpqsize > minpqsize + 1) {
            minpq.add(maxpq.poll());
            minpqsize++;
            maxpqsize--;
            doRemove(maxpq);
        }
        if (minpqsize  > maxpqsize) {
            maxpq.add(minpq.poll());
            maxpqsize++;
            minpqsize--;
            doRemove(minpq);
        }
    }
}
