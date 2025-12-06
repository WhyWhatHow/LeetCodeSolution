package leetcode.algorithm.dp;

import java.util.TreeMap;

/**
 * @program: LeetCodeSolution
 * @description: #
 * @author: WhyWhatHow
 **/

public class Solution_3578 {

    public static void main(String[] args) {
        Solution_3578 sol = new Solution_3578();
        System.out.println("==================");
    }

    int mod = 1000_000_007;

    /**
     * f[i] means [0,i) range all methods.
     * f[i] = sum(f[j])  j belong to [j,i] window with condition max -min <=k
     * 为了让 区间找到最大值,最小的速度快一些, 选择用treemap
     */
    public int countPartitions(int[] nums, int k) {
        int n = nums.length;
        long[] f = new long[n + 1];
        f[0] = 1; // why  前0个元素有一种分割方案, 空数组.
        long[] ss = new long[n + 2]; // ss[i+1] means [0,i] range in array f sum . ss[i+1] = ss[i] + f[i],
        // sum([j,i]) = ss[i+1] -ss[j]
        ss[1] = 1; //f[0]

        int left = 0;
        var map = new TreeMap<Integer, Integer>(); // key : nums[i], val: cnt
        for (int i = 0; i < n; i++) {
            map.compute(nums[i], (kk, v) -> v == null ? 1 : v + 1);

            // when [left ,i ] range , max -min >k
            while (map.lastKey() - map.firstKey() > k) {
                Integer val = map.compute(nums[left], (kk, v) -> v - 1);
                if (val <= 0) map.remove(nums[left]);
                left++;
            }
            // f[i+1] = f[left]+...+f[i] ==> ss[i+1]-ss[left]
            f[i + 1] = (ss[i + 1] - ss[left] + mod) % mod;
            // update pre_sum
            ss[i + 2] = ss[i + 1] + f[i + 1] % mod;



        }
        return (int) f[n];
    }


//    /**
//     * LeetCode 3578: 统计极差最大为 K 的分割方式数
//     * <p>
//     * 解题思路:
//     * 1. DP定义: f[i] = 前i个元素的合法分割方案数
//     * 2. 状态转移: f[i] = sum(f[j-1]), 其中[j,i]这段的极差 <= k
//     * 3. 优化: 使用滑动窗口 + TreeMap维护区间最值 + 前缀和优化区间求和
//     */
//    public int countPartitionsBYAI(int[] nums, int k) {
//        final int MOD = 1_000_000_007;
//        int n = nums.length;
//
//        // f[i] 表示前 i 个元素的合法分割方案数
//        long[] f = new long[n + 1];
//        f[0] = 1;  // 边界: 空数组有1种分割方式
//
//        // sum[i] 表示 f[0] + f[1] + ... + f[i-1] 的前缀和
//        // 用于 O(1) 计算区间和
//        long[] sum = new long[n + 2];
//        sum[1] = 1;  // sum[1] = f[0] = 1
//
//        // TreeMap 维护滑动窗口内的元素及其出现次数
//        // key: 元素值, value: 出现次数
//        TreeMap<Integer, Integer> window = new TreeMap<>();
//
//        int left = 0;  // 滑动窗口的左边界
//
//        // 遍历每个位置作为右端点
//        for (int i = 0; i < n; i++) {
//            // 步骤1: 将 nums[i] 加入窗口
//            window.put(nums[i], window.getOrDefault(nums[i], 0) + 1);
//
//            // 步骤2: 收缩窗口,保持极差 <= k
//            // TreeMap.firstKey() 返回最小值, lastKey() 返回最大值
//            while (left <= i && window.lastKey() - window.firstKey() > k) {
//                // 移除窗口左端元素
//                int leftVal = nums[left];
//                int count = window.get(leftVal);
//
//                if (count == 1) {
//                    window.remove(leftVal);  // 出现次数为1,直接删除
//                } else {
//                    window.put(leftVal, count - 1);  // 出现次数减1
//                }
//
//                left++;  // 左边界右移
//            }
//
//            // 步骤3: 现在 [left, i] 是以 i 为右端点的最长合法区间
//            // f[i+1] 可以从所有 f[left], f[left+1], ..., f[i] 转移过来
//            // 使用前缀和快速计算: f[left] + ... + f[i] = sum[i+1] - sum[left]
//            f[i + 1] = (sum[i + 1] - sum[left] + MOD) % MOD;
//
//            // 步骤4: 更新前缀和
//            sum[i + 2] = (sum[i + 1] + f[i + 1]) % MOD;
//        }
//
//        return (int) f[n];
//    }
//
//
//    // ============ 测试和演示代码 ============
//
//    public static void main(String[] args) {
//        var sol = new Solution_3578();
//
//        System.out.println("╔═══════════════════════════════════════╗");
//        System.out.println("║  LeetCode 3578 - TreeMap 解法演示    ║");
//        System.out.println("╚═══════════════════════════════════════╝\n");
//
//        // 测试用例 1
//        testCase(sol, new int[]{1, 3, 3, 5}, 2, 4);
//
//        // 测试用例 2
//        testCase(sol, new int[]{9, 2, 4, 1, 6}, 4, -1);
//
//        // 测试用例 3
//        testCase(sol, new int[]{1, 2, 3, 4, 5}, 1, 5);
//
//        // 详细演示
//        System.out.println("\n" + "=".repeat(60));
//        System.out.println("详细演示: nums = [1, 3, 3, 5], k = 2");
//        System.out.println("=".repeat(60) + "\n");
//        demonstrateDetailedProcess(new int[]{1, 3, 3, 5}, 2);
//    }
//
//    private static void testCase(Solution_3578 sol, int[] nums, int k, int expected) {
//        System.out.println("测试用例:");
//        System.out.println("  输入: nums = " + Arrays.toString(nums) + ", k = " + k);
//
//        long start = System.nanoTime();
//        int result = sol.countPartitionsBYAI(nums, k);
//        long end = System.nanoTime();
//
//        System.out.println("  输出: " + result);
//        if (expected != -1) {
//            System.out.println("  预期: " + expected + " " +
//                    (result == expected ? "✓" : "✗"));
//        }
//        System.out.println("  耗时: " + (end - start) / 1000.0 + " μs\n");
//    }
//
//    private static void demonstrateDetailedProcess(int[] nums, int k) {
//        final int MOD = 1_000_000_007;
//        int n = nums.length;
//
//        long[] f = new long[n + 1];
//        f[0] = 1;
//
//        long[] sum = new long[n + 2];
//        sum[1] = 1;
//
//        TreeMap<Integer, Integer> window = new TreeMap<>();
//        int left = 0;
//
//        System.out.println("初始状态: f[0] = 1, sum[1] = 1\n");
//
//        for (int i = 0; i < n; i++) {
//            System.out.println("┌─ 第 " + (i + 1) + " 步 ─────────────────────────");
//            System.out.println("│ 处理位置 i = " + i + ", nums[" + i + "] = " + nums[i]);
//
//            // 加入窗口
//            window.put(nums[i], window.getOrDefault(nums[i], 0) + 1);
//            System.out.println("│ 加入窗口后: " + formatWindow(window));
//
//            // 收缩窗口
//            boolean shrunk = false;
//            while (left <= i && window.lastKey() - window.firstKey() > k) {
//                if (!shrunk) {
//                    System.out.println("│");
//                    System.out.println("│ 窗口极差 = " + window.lastKey() + " - " +
//                            window.firstKey() + " = " +
//                            (window.lastKey() - window.firstKey()) + " > " + k);
//                    System.out.println("│ 需要收缩窗口:");
//                    shrunk = true;
//                }
//
//                int leftVal = nums[left];
//                int count = window.get(leftVal);
//
//                System.out.println("│   移除 nums[" + left + "] = " + leftVal);
//
//                if (count == 1) {
//                    window.remove(leftVal);
//                } else {
//                    window.put(leftVal, count - 1);
//                }
//
//                left++;
//            }
//
//            // 显示最终窗口
//            if (shrunk) {
//                System.out.println("│ 收缩后窗口: " + formatWindow(window));
//            }
//
//            System.out.println("│");
//            System.out.println("│ 最终窗口: [" + left + ", " + i + "] = " +
//                    formatArray(nums, left, i));
//            System.out.println("│ 窗口极差: " + (window.lastKey() - window.firstKey()) +
//                    " ≤ " + k + " ✓");
//
//            // 计算 f[i+1]
//            System.out.println("│");
//            System.out.println("│ 计算 f[" + (i + 1) + "]:");
//            System.out.println("│   需要累加: f[" + left + "] + f[" + (left + 1) +
//                    "] + ... + f[" + i + "]");
//            System.out.println("│   使用前缀和: sum[" + (i + 1) + "] - sum[" + left + "]");
//            System.out.println("│              = " + sum[i + 1] + " - " + sum[left]);
//
//            f[i + 1] = (sum[i + 1] - sum[left] + MOD) % MOD;
//            sum[i + 2] = (sum[i + 1] + f[i + 1]) % MOD;
//
//            System.out.println("│   => f[" + (i + 1) + "] = " + f[i + 1]);
//            System.out.println("│   => sum[" + (i + 2) + "] = " + sum[i + 2]);
//            System.out.println("└" + "─".repeat(40) + "\n");
//        }
//
//        System.out.println("最终答案: f[" + n + "] = " + f[n]);
//
//        // 显示完整的 f 数组
//        System.out.println("\n完整 DP 表:");
//        System.out.println("┌─────┬─────────────────┬────────┐");
//        System.out.println("│  i  │   nums[0..i-1]  │  f[i]  │");
//        System.out.println("├─────┼─────────────────┼────────┤");
//        for (int i = 0; i <= n; i++) {
//            String numsStr = i == 0 ? "[]" : Arrays.toString(Arrays.copyOfRange(nums, 0, i));
//            System.out.printf("│ %3d │ %-15s │ %6d │%n", i, numsStr, f[i]);
//        }
//        System.out.println("└─────┴─────────────────┴────────┘");
//    }
//
//    @NotNull
//    private static String formatWindow(TreeMap<Integer, Integer> window) {
//        if (window.isEmpty()) return "[]";
//
//        List<String> items = new ArrayList<>();
//        for (Map.Entry<Integer, Integer> entry : window.entrySet()) {
//            items.add(entry.getKey() + "×" + entry.getValue());
//        }
//        return "{" + String.join(", ", items) + "}";
//    }
//
//    private static String formatArray(int[] nums, int left, int right) {
//        List<String> items = new ArrayList<>();
//        for (int i = left; i <= right; i++) {
//            items.add(String.valueOf(nums[i]));
//        }
//        return "[" + String.join(", ", items) + "]";
//    }

/*
═══════════════════════════════════════════════════════════════
                        核心思路总结
═══════════════════════════════════════════════════════════════

1. 动态规划定义
   ─────────────
   f[i] = 前 i 个元素有多少种合法分割方案

   状态转移:
   f[i] = Σ f[j-1]  (其中 [j, i] 这段的极差 ≤ k)

2. 为什么要累加?
   ────────────
   枚举"最后一段"的起始位置 j:
   - 如果最后一段从 j 开始 → 前面有 f[j-1] 种方案
   - 不同的 j 对应不同的分割方式
   - 所以要累加所有合法的 j

3. 三重优化
   ────────
   优化1 - 滑动窗口:
   · left 指针只前进不后退
   · 每个元素最多访问 2 次
   · 时间: O(n²) → O(n)

   优化2 - TreeMap 维护最值:
   · firstKey() 获取窗口最小值 O(log n)
   · lastKey() 获取窗口最大值 O(log n)
   · 时间: O(n) → O(n log n)

   优化3 - 前缀和:
   · 区间求和 f[left] + ... + f[i]
   · 从 O(n) 优化到 O(1)
   · 使用公式: sum[i+1] - sum[left]

4. 复杂度分析
   ──────────
   时间: O(n log n)  - TreeMap 操作
   空间: O(n)         - DP 数组 + TreeMap

   可以通过大部分测试用例,如果还超时可以用单调队列优化到 O(n)

5. TreeMap vs 单调队列
   ────────────────
   TreeMap:
   ✓ 代码简单易懂
   ✓ 适合值域大的情况
   ✗ O(n log n) 复杂度

   单调队列:
   ✓ O(n) 严格最优
   ✗ 代码稍复杂
   ✗ 需要理解单调队列原理

═══════════════════════════════════════════════════════════════
*/
}


