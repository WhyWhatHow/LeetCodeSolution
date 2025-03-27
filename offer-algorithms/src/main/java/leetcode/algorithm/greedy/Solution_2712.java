package leetcode.algorithm.greedy

        ;

/**
 * @program: LeetCodeSolution
 * @description: #
 * @author: WhyWhatHow
 **/

public class Solution_2712 {

    public static void main(String[] args) {
        Solution_2712 sol = new Solution_2712();
        System.out.println(sol.minimumCost(
                "0011"
//                "100001"
        ));
        System.out.println("==================");
    }

    public long minimumCost(String s) {
        char[] cs = s.toCharArray();
        int n = cs.length;
        int mid = n / 2;

        int l = mid - 1;
        int cnt = 0;
        long ans = 0;
        // 翻转偶数次==> 不翻转, 奇数次-> change
        while (l >= 0) {
            if (((cnt & 1) == 0 && cs[l] != cs[mid]) // 偶数次更新, 原值
                    || ((cnt & 1) == 1 && cs[l] == cs[mid])) {
                cnt++;
                ans += l + 1;
            }
            l--;
        }
        int r = mid + 1;
        cnt = 0;
        while (r <= n - 1) {
            if (((cnt & 1) == 0 && cs[r] != cs[mid]) // 偶数次更新, 原值
                    || ((cnt & 1) == 1 && cs[r] == cs[mid])) {
                cnt++;
                ans += n - r;
            }
            r++;
        }
        return ans;

    }
}


