package leetcode.algorithm.weekly;

/**
 * @program: LeetCodeSolution
 * @description:
 * @author: WhyWhatHow
 * @create: 2025-12-07 10:29
 **/
public class Weekly_482 {
    public static void main(String[] args) {
        Weekly_482 sol = new Weekly_482();
//        System.out.println(sol.maximumScore(new int[]{-7, -5, 3}));
        System.out.println(Long.MAX_VALUE);
        System.out.println(sol.minAllOneMultiple(7095));
        System.out.println("---------------------");

    }



    public int minAllOneMultiple(int k) {
        long t = 1;
        int cnt = 1;
        int max = 1000_000;
        if (k % 2 == 0 || k % 5 == 0) return -1;
        while (t % k != 0 && cnt < max) {
            t = t * 10 + 1;
            t %= k;
            cnt++;
        }
        return cnt < max ? cnt : -1;
    }

    // use costBoth < cost1+cost2
    public long minimumCost(int cost1, int cost2, int costBoth, int need1, int need2) {
        long c = cost1, cc = cost2;
        long p = c * need1;
        long pp = cc * need2;
        long max = c * need1 + need2 * cc;
        if (costBoth >= c + cc) return max;
        int min = Math.min(need1, need2);

        long tmp = (long) costBoth * min + c * (need1 - min) + cc * (need2 - min);
        // 只用costboth
        return Math.min(Math.min(tmp, max), (long) costBoth * Math.max(need1, need2));

    }

    public long maximumScore(int[] nums) {
        int n = nums.length;
        long[] ps = new long[n + 1];
        for (int i = 0; i < nums.length; i++) {
            ps[i + 1] = ps[i] + nums[i];
        }
        int[] ms = new int[n + 1]; // [i+1,n) min val
        ms[n] = Integer.MAX_VALUE;
        for (int i = nums.length - 1; i >= 0; i--) {
            ms[i] = Math.min(ms[i + 1], nums[i]);
        }

        long res = Long.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            res = Math.max(res, ps[i + 1] - ms[i + 1]);
        }
        return res;
    }
}
 