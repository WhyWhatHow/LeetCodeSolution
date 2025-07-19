package leetcode.algorithm.pq;

import java.util.PriorityQueue;

/**
 * @program: LeetCodeSolution
 * @description: #
 * @author: WhyWhatHow
 **/

public class Solution_703 {

    public static void main(String[] args) {
        Solution_703 sol = new Solution_703();
        KthLargest kthLargest = new KthLargest(3, new int[]{4, 5, 8, 2});
        kthLargest.add(3); // 返回 4
        System.out.println(kthLargest.add(3)); // 返回 4
        kthLargest.add(5); // 返回 5
        System.out.println(kthLargest.add(5)); // 返回 5
        kthLargest.add(10); // 返回 5
        System.out.println(kthLargest.add(10)); // 返回 5
        kthLargest.add(9); // 返回 8
        System.out.println(kthLargest.add(9)); // 返回 8
        kthLargest.add(4); // 返回 8
        System.out.println(kthLargest.add(4)); // 返回 8
        System.out.println("==================");
    }


}


class KthLargest {

    PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
    PriorityQueue<Integer> minpq = new PriorityQueue<>(); // 维护前k个最大元素.
    int k;

    //    TreeMap<Integer,Integer> set =new TreeMap<>((a, b)->b-a);
    public KthLargest(int k, int[] nums) {
        this.k = k;
        for (int num : nums) {
            pq.add(num);
        }
        int cnt = 0;
        while (!pq.isEmpty() &&++cnt <= k) {
            minpq.add(pq.poll());
        }
//        System.out.println(minpq.size());
    }

    public int add(int val) {
        if(minpq.size() < k ) {
            minpq.add(val);
            return minpq.peek();
        }
        if (val > minpq.peek()) {
            minpq.add(val);
            Integer cur = minpq.poll();
            pq.add(cur);
            return minpq.peek();
        } else {
            pq.add(val);
            return minpq.peek();
        }
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */