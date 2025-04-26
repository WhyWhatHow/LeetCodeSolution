package leetcode.algorithm.window;

/**
 * @program: LeetCodeSolution
 * @description: #
 * @author: WhyWhatHow
 **/

public class Solution_2444 {

    public static void main(String[] args) {
        Solution_2444 sol = new Solution_2444();
        System.out.println(sol.countSubarrays(new int[]{
//                        1, 3, 5, 2, 7, 5
                        1, 1, 1, 1
                },
                1, 1
//                1, 5
        ));
        System.out.println("==================");
    }

    /**
     * 假设 区间 [l, r] 中满足题目要求, 即[l,r] nums[i] <=max and nums[i]  >=min,
     * 那么在区间[l,r] 范围内有多少个合理的数组呢?
     * 假设 minI 表示 min(lastMinXPos, lastMaxPos) 的左端点 , 也就是说 [minI,r] 满足题意.
     * 在 [minI,r] 可以构成的数组有多少呢?  是不是需要minI 像左移动一位 minI-1, 判断[minI-1,r] 是否符合.
     * 进一步思考是不是可以优化这个判断逻辑, 如果我提前知道 上一次不满足的下标是否就可以直接 计算呢? 答案是可以的.
     * 假设到某一个位置j =>[j+1,r]满足题意, 但是[j,r] 不满足题意
     * 则 会有 minI-j 个合理的子数组.
     * 所以我们只需枚举右端点,找到合适的即可.
     *
     * @param nums
     * @param minK
     * @param maxK
     * @return
     */
    public long countSubarrays(int[] nums, int minK, int maxK) {
        long cnt = 0;
        int lastMinPos = -1;
        int lastMaxPos = -1; //
        int lastIdx = -1; //
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > maxK || nums[i] < minK) {
                lastIdx = i;
                lastMaxPos = -1;
                lastMinPos = -1;
                continue;
            }
            if (nums[i] == maxK) lastMaxPos = i;
            if (nums[i] == minK) lastMinPos = i;
            if (lastMinPos != -1 && lastMaxPos != -1) {
                int l = Math.min(lastMinPos, lastMaxPos);
                if (lastIdx != -1)
                    cnt += l - lastIdx ;
                else
                    cnt += l + 1;
            }
        }
        return cnt;
    }
}


