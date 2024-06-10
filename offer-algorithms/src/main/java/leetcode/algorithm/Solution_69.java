package leetcode.algorithm;

/**
 * @program: LeetCodeSolution
 * @description:
 * @author: WhyWhatHow
 * @create: 2020-05-07 12:09
 **/

public class Solution_69 {
    // 求sqrt Math.sqrt
    public int mySqrt1(int x) {
        double floor = Math.floor(Math.sqrt(x));
        return (int) floor;
    }

    public int mySqrt(int x) {
        int l = 0, r = x, mid = -1, ans = 0;
        while (l <= r) {
            mid = (r - l) >> 1;
            mid += l;
//            mid = l + (r - l) / 2;
            // 傻狗行为, (mid* mid) 越界了
//   if ((long) (mid * mid) <= x) {
            if ((long) mid * mid <= x) {
                ans = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }

        }
        return ans;
    }

    public int mySqrt2(int x) {
        int l = 0, r = x, ans = -1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if ((long) mid * mid <= x) {
                ans = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution_69 sol = new Solution_69();

        int ii = sol.mySqrt(2147395599);

        System.out.println("==================" + ii);
        int i = sol.mySqrt(8);
        System.out.println(i);
    }
}


