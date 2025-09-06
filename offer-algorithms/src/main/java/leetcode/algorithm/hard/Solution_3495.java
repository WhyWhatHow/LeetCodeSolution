package leetcode.algorithm.hard;

/**
 * @program: LeetCodeSolution
 * @description: #
 * @author: WhyWhatHow
 **/

public class Solution_3495 {

    public static void main(String[] args) {
        Solution_3495 sol = new Solution_3495();
        System.out.println(Integer.MAX_VALUE > 1000_000_000l);
        System.out.println(Long.MAX_VALUE > 1000_000_000_000_000_000l);
        System.out.println(sol.minOperations(new int[][]{
                {1, 5}
        }));
//        for (int i = 0; i < 100; i++)
//            System.out.println(i + " : " + ((Integer.toBinaryString(i).length() + 1) / 2));
        System.out.println("==================");
    }

    /**
     * @param queries
     * @return
     */
    public long minOperations(int[][] queries) {
        long res = 0;
        for (int[] a : queries) {
            // [l,r] = f[r] - f[l-1]
            // 1次可以操作两个数. 所以要/2
            res += Math.ceilDiv(f(a[1]) - f(a[0] - 1), 2);
        }
        return res;
    }


    // f[i] means [0,i] range, 将数组变为0的最小操作数
    private long f(int x) {
        long res = 0;
        long r = 1;
        long p = 1;
        long l = 1;
        int i = 1; // 表示 /4 后结果等于0的次数.
        while (p <= x) {
            r = Math.min(p * 4 - 1, x);
            long cnt = r - l + 1;
            res += cnt * i;
            p *= 4;
            l = p;
            i++;
        }
        return res;
    }
}


