package leetcode.algorithm;

import sun.misc.Queue;

import java.util.*;

/**
 * @program: LeetCodeSolution
 * @description:
 * @author: WhyWhatHow
 * @create: 2020-05-07 12:09
 **/

public class Solution_169 {
    static class Pair {
        int val, num;

        public Pair(int a, int b) {
            val = a;
            num = b;
        }

        public Pair() {
        }
    }

    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        PriorityQueue<Pair> queue = new PriorityQueue<>(new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2) {
                return o2.num - o1.num;
            }
        });
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (map.containsKey(num)) {
                Integer integer = map.get(num);
                map.put(num,integer+1);
            }else{
                map.put(num, 1);
            }
//            map.put(num, map.getOrDefault(nums, 1) + 1);
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            queue.add(new Pair(entry.getKey(), entry.getValue()));
        }
        Pair peek = queue.peek();
        return peek.val;
    }

    public static void main(String[] args) {
        Solution_169 sol = new Solution_169();
        PriorityQueue<Pair> queue = new PriorityQueue<>(new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2) {
                if (o1.num != o2.num)
                    return o1.num - o2.num;
                return 0;
            }
        });
        queue.add(new Pair(1,2));
        queue.add(new Pair(2,3 ));
        queue.peek();
        int i = sol.majorityElement(new int[]{2, 2, 1, 1, 1, 2, 2});
        System.out.println("==================" + i);
    }
}


