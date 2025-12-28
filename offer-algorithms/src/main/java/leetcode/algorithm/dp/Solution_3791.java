package leetcode.algorithm.dp;

import java.util.HashMap;

/**
 * @program: LeetCodeSolution
 * @description: #
 * @author: WhyWhatHow
 **/

public class Solution_3791 {

    public static void main(String[] args) {
        Solution_3791 sol = new Solution_3791();
        System.out.println("==================");


    }

    HashMap<Long, Long> map = new HashMap<>();

    // f(i,j,k) means 在第i个位置, 奇偶位数之和的差值是diff,
    // k 表示下一位是奇数or 偶数的情况下 的数字 数量.
    long genKey(int idx, int diff, int isOdd) {
        long res = (long) idx << 20 | (long) (diff + 200) << 1 | isOdd;
        return res;
    }

    public long countBalanced(long low, long high) {

        if (high < 11) return 0;
        low = Math.max(low, 11);
        char[] ls = String.valueOf(low).toCharArray();
        char[] hs = String.valueOf(high).toCharArray();
        int n = hs.length;
        return dfs(0, 0, 0, true, true, ls, hs);
//        long[][][] f = new long[n][n * n][2];
    }

    /**
     * @param idx         处理的位置
     * @param diff        奇偶项位数之和的差值, 奇数+ 偶数-
     * @param yes         判断当前位置是否是奇数or 偶数.
     * @param isLimitLow  前一个位置的值是否等于最小值.
     * @param isLimitHigh 前一个位置的值是否等于最大值.
     * @param ls
     * @param hs
     * @return
     */
    private long dfs(int idx, int diff, int yes, boolean isLimitLow, boolean isLimitHigh, char[] ls, char[] hs) {
        if (idx == hs.length)
            return diff == 0 ? 1 : 0;

        long key = genKey(idx, diff, yes);

        // 命中缓存 -> 为什么不用 limitHigh && limitLow 的情况, 因为可以被访问次数过低.
        // TODO [whywhathow] [2025/12/28]  [opt] 测试将isLimitLow && isLimitHigh 加入到key 中的情况是否可以通过.
        if (!isLimitHigh && !isLimitLow && map.containsKey(key))
            return map.get(key);

        long res = 0;


        // 对于ls 数组而言, 开始的位置是zeroIdx, 当 idx< zeroIdx, 情况, 可以默认位前导零的情况.
        int zeroIdx = hs.length - ls.length;

        // 确定上下界
        int low = isLimitLow && idx >= zeroIdx ? ls[idx - zeroIdx] - '0' : 0;
        int hi = isLimitHigh ? hs[idx] - '0' : 9;

        int i = low;
        // 处理前导零的情况.
        if (isLimitLow && idx < zeroIdx) {
            res += dfs(idx + 1, diff, yes, true, false, ls, hs);
            i = 1;
        }


        for (; i <= hi; i++) {
            int t = yes == 1 ? i : -i;
            res += dfs(idx + 1, diff + t, 1 - yes,
                    isLimitLow && i == low, isLimitHigh && i == hi, ls, hs);
        }
        if (!isLimitHigh && !isLimitLow) map.put(key, res);
        return res;
    }

    private long dfs(int i, int diff, int parity, boolean limitLow, boolean limitHigh, char[] lowS, char[] highS, long[][][] memo) {
        int n = highS.length;

        // Base Case: 填完了所有位
        if (i == n) {
            // 如果 diff 等于偏移量，说明 sum(奇) - sum(偶) == 0，即平衡
            return diff == n / 2 * 9 ? 1 : 0;
        }

        // 记忆化剪枝：如果当前状态之前算过，且没有上下界限制（通用状态），直接返回
        if (!limitLow && !limitHigh && memo[i][diff][parity] > 0) {
            return memo[i][diff][parity] - 1;
        }

        // 计算当前位能填的数字范围 [lo, hi]
        int diffLH = n - lowS.length; // low 和 high 的长度差
        // 确定下界 lo：
        // 如果受 limitLow 限制，且当前位 i 已经进入了 low 的有效范围内，则下界为 lowS 对应位；否则为 0
        int lo = limitLow && i >= diffLH ? lowS[i - diffLH] - '0' : 0;
        // 确定上界 hi：
        // 如果受 limitHigh 限制，则上界为 highS[i]；否则为 9
        int hi = limitHigh ? highS[i] - '0' : 9;

        long res = 0;
        int d = lo;

        // --- 处理前导零/长度差异的关键逻辑 ---
        // 如果当前受 low 限制（意味着还在填前缀），且 i 还在长度差范围内（即 low 比 high 短，还没到 low 的最高位）
        // 这时我们可以选择“不填数字”（相当于填前导零），从而生成位数比 high 短的数字。
        if (limitLow && i < diffLH) {
            // 递归调用：位置 +1，diff 不变，parity 不变（重要！因为这里填的是虚拟前导零，下一位才是真正的第 1 位/奇数位）
            // limitLow 保持 true，limitHigh 变为 false（因为填了前导零，生成的数肯定比 high 小）
            res = dfs(i + 1, diff, parity, true, false, lowS, highS, memo);

            // 既然这一步处理了“填前导零”的情况，那么接下来的循环就要从 1 开始填（填非零数字）
            d = 1;
        }

        // --- 枚举当前位填的数字 d ---
        for (; d <= hi; d++) {
            // 计算新的 diff：
            // 如果 parity > 0 (奇数位)，diff 加上 d
            // 如果 parity == 0 (偶数位)，diff 减去 d
            // 下一层递归：位置 +1，parity 翻转 (parity ^ 1)
            res += dfs(i + 1,
                    diff + (parity > 0 ? d : -d),
                    parity ^ 1,
                    limitLow && d == lo,
                    limitHigh && d == hi,
                    lowS, highS, memo);
        }

        // 记录结果到 memo
        if (!limitLow && !limitHigh) {
            memo[i][diff][parity] = res + 1; // +1 是为了区分默认值 0
        }
        return res;
    }
}


