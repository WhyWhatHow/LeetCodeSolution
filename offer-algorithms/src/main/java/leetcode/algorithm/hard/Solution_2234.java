package leetcode.algorithm.hard;

import java.util.Arrays;

/**
 * @program: LeetCodeSolution
 * @description: #
 * @author: WhyWhatHow
 **/

public class Solution_2234 {

    public static void main(String[] args) {
        Solution_2234 sol = new Solution_2234();
        System.out.println(sol.maximumBeautyNew(new int[]{40742, 74654, 22547, 18738, 52156, 33325, 86828, 63276, 72224, 65874, 8268, 91224, 25184, 28, 69428, 87064, 65696,
                        77466, 90050, 22475, 19437, 68830, 56168, 66104, 86866, 58547, 66885, 84417, 13027, 58683, 76544, 49343, 10813, 58444, 16356, 34161, 19927, 5397,
                        16403, 71540, 21620, 37374, 49807, 417, 39043, 38812, 28248, 71870, 42961, 40649, 94016, 19887, 84, 89541, 10629, 73203, 14892, 97132, 62660, 2370,
                        5380, 39769, 94599, 86931, 83186, 20501, 44885, 26943, 77669, 77891, 66153, 98865, 32787,
                        97342, 68662, 82740, 78887, 47815, 42860, 30637, 60297, 71183, 26976, 7776, 2269, 29377, 23165, 99864, 53895, 87432, 24455, 72667, 52752, 59991},
                3119579236l,
                100000,
                18353,
                74100));
        System.out.println("==================");
    }

    /**
     * 先倒满, 然后在处理.
     */
    public long maximumBeautyNew(int[] flowers, long newFlowers, int target, int full, int partial) {
        int n = flowers.length;
        long lefts = newFlowers - (long) n * target;
        for (int i = 0; i < n; i++) {
            flowers[i] = Math.min(flowers[i], target);
            lefts += flowers[i]; // 只处理newFlowers  - n* target
        }
        if (lefts == newFlowers) return (long) n * full;
        if (lefts >= 0) return Math.max((long) n * full, (long) (n - 1) * full + (long)(target - 1) * partial);

        Arrays.sort(flowers);

        long res = 0;
        long preSum = 0;
        int j = 0;
        // assume [i,n) flowers[i] == target. && lefts>=0;
        for (int i = 1; i < n; i++) {
            lefts += target - flowers[i - 1];
            if (lefts < 0) continue;

            //[0,j] 中可以种 flowers[j]朵花
            while (j < i && (long) flowers[j] * j <= preSum + lefts) {
                preSum += flowers[j];
                j++;
            }

            long avg = (preSum + lefts) / j;
            long total = avg * partial + (long) (n - i) * full;
            res = Math.max(res, total);

        }
        return res;
    }


    /**
     * 要最大, 要么增大 ≥target 花坛数量, 要么 增大minVal * partial.
     *
     * @param flowers
     * @param newFlowers
     * @param target
     * @param full
     * @param partial
     * @return
     */
    public long maximumBeauty(int[] flowers, long newFlowers, int target, int full, int partial) {
        int n = flowers.length;
        // if 全部种满, 剩余的花
        long leftFlowers = newFlowers - (long) target * n;
        for (int i = 0; i < n; i++) {
            flowers[i] = Math.min(flowers[i], target);
            leftFlowers += flowers[i];
        }

        if (leftFlowers == newFlowers) { // 全部种满, 不需要种花.
            return (long) n * full;
        }
        if (leftFlowers >= 0) { // 可以种满, (两种, n-1 种满+ target-1, 全部种满)
            return Math.max((long) n * full, (n - 1) * full + (target - 1) * partial);
        }

        Arrays.sort(flowers);

        long preSum = 0; // prefix sum ,前缀和,
        int j = 0;
        long res = 0;
        for (int i = 1; i <= n; i++) {
            leftFlowers += target - flowers[i - 1];
            if (leftFlowers < 0) continue; //

            while (j < i && (long) flowers[j] * j <= preSum + leftFlowers) {
                preSum += flowers[j];
                j++;
            }

            long avg = (leftFlowers + preSum) / j;
            long total = avg * partial + (long) (n - i) * full;
            res = Math.max(res, total);
        }

        return res;
    }
}


