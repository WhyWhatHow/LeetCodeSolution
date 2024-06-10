package leetcode.algorithm;

/**
 * @program: LeetCodeSolution
 * @description:
 * @author: WhyWhatHow
 * @create: 2020-05-07 12:09
 **/

public class Solution_238 {
    public int[] productExceptSelf(int[] nums) {
        int ans[] = new int[nums.length];
        int all = 1;
        boolean checkZero = false; // 判断是否有0元素
        int cnt = 0; // 统计 0 的个数.
        for (int num : nums) {
            if (num != 0) {
                all *= num;
            } else {
                cnt++;
                checkZero = true;
            }
        }
        // 排除 {0,0} 集合
        if (2<=cnt)
            return ans;
        for (int i = 0; i < ans.length; i++) {
            if (checkZero) {
                if (nums[i] == 0) {
                    ans[i] = all;
                } else
                    ans[i] = 0;
            } else {
                ans[i] = all / nums[i];
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution_238 sol = new Solution_238();
        int[] ints = sol.productExceptSelf(new int[]
                {
//                2,3,0,0
//                        1,0
//                    0,0
//                -1,1,0,-3,3
//                        0, 4, 0
                }

        );
        for (int anInt : ints) {
            System.out.print(anInt+",");
        }
        System.out.println("==================");
    }
}


