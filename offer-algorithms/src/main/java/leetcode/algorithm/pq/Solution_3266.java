package leetcode.algorithm.pq;

import java.util.PriorityQueue;

/**
 * @program: LeetCodeSolution
 * @description: #
 * @author: WhyWhatHow
 **/

public class Solution_3266 {

    public static void main(String[] args) {
        Solution_3266 sol = new Solution_3266();
        System.out.println(sol.pow(2, 10, sol.mod));
        ;
        System.out.println(sol.getFinalState(new int[]{
                        66307295, 441787703, 589039035, 322281864
//                        2, 1, 3, 5, 6
                },
                900900704,
                641725
//                5, 2
        ));
        System.out.println("==================");
    }

    int mod = 1000_000_007;

    /**
     * @param nums
     * @param k
     * @param multiplier
     * @return
     */
    public int[] getFinalState(int[] nums, int k, int multiplier) {
        if (multiplier == 1) return nums;

        PriorityQueue<long[]> pq = new PriorityQueue<>((a, b) -> { // int[] {val, idx  }
            if (a[0] != b[0]) return Long.compare(a[0], b[0]);
            else return Long.compare(a[1], b[1]);
        });

        // init pq and find max val in nums
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            pq.add(new long[]{nums[i], i});
            if (nums[i] > nums[max]) max = i;
        }

        // check k is big enough
        boolean finded = false; // check k is big enough.
        while (k-- > 0) {
            long[] polled = pq.poll();
            long val = polled[0] * multiplier;
            long idx = polled[1];
            pq.add(new long[]{val, idx});

            if (idx == max) {
                finded = true;
                break;
            }
        }

        int n = k / nums.length;
        k %= nums.length;

        int cnt = 0;
        while (!pq.isEmpty()) {
            long[] a = pq.poll();
            long val = a[0];
            if (val >= mod) val %= mod;
            if (cnt < k) {
                val = finded ? val * pow(multiplier, n + 1, mod) : val;
            } else {
                val = finded ? val * pow(multiplier, n, mod) : val;
            }
            if (val > mod) val %= mod;
            nums[(int) a[1]] = (int) val;
            cnt++;
        }
        return nums;
    }

    long pow(int a, int n, int mod) {
        long res = 1;
        long base = a;
        while (n != 0) {
            if ((n & 1) != 0) { // odd
                res *= base;
                if (res >= mod) res %= mod;
            }
            base *= base;
            if (base >= mod) base %= mod;
            n /= 2;
        }
        return res;
    }
}


