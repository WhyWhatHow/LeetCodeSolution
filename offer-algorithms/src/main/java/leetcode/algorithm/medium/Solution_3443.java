package leetcode.algorithm.medium;

/**
 * @program: LeetCodeSolution
 * @description: #
 * @author: WhyWhatHow
 **/

public class Solution_3443 {

    public static void main(String[] args) {
        Solution_3443 sol = new Solution_3443();
        System.out.println(sol.maxDistance(
                "NWSE", 1
//                "NSWWEW", 3
        ));

        System.out.println("==================");
    }


    /**
     * 所谓曼哈顿距离, 即|x|+|y| 两者相互独立. 所以可以分开考虑
     * 假设场景a: w:a= 2,E: b=5,k为可以修改的次数, 那么最大值就是 (5-2) +2k?
     * 不对,  如果k<=2, 当前情况成立, 但当k>2, 是不是少掉了部分值呢? k所需处理的部分变小了.
     * 那么应该是什么呢? 假设这个值是d = min(2,5,k) = min(a,b,k)
     * 有题意分析知,|x||y|相互独立,所以先处理x, 先处理y 没有任何区别. 所以 你想如何处理都行.
     * 所以最大值就是在每一次操作过程中,分别对x轴y轴进行处理, 将其结果加和即可得到最大值.
     * @param s
     * @param k
     * @return
     */
    public int maxDistance(String s, int k) {
        char[] cs = s.toCharArray();
        int[] a = new int[4]; // nswe
        int res = 0;
        for (char c : cs) {
            if (c == 'N') a[0]++; // n+s =3
            if (c == 'S') a[3]++;
            if (c == 'W') a[1]++;
            if (c == 'E') a[2]++;

            int d = Math.min(a[0], a[3]);
            d = Math.min(d, k);
            int tmp = k;
            int ans = handle(a[0], a[3], k) + handle(a[1], a[2], tmp - d);
            res = Math.max(res, ans);
        }

        return res;
    }

    private int handle(int a, int b, int k) {
        int d = Math.min(Math.min(a, b), k);
        return Math.abs(a - b) + d * 2;
    }

}


