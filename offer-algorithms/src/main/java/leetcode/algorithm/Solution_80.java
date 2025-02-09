package leetcode.algorithm;

/**
 * @program: LeetCodeSolution
 * @description:
 * @author: WhyWhatHow
 * @create: 2020-05-07 12:09
 **/

public class Solution_80 {

    /**
     * much easy to think
     * @param nums
     * @return
     */
    public int removeDuplicatesNew(int[] nums) {
        int cur = 0;
        int cnt = 0;
        for (int i = 0; i <= nums.length; i++) {
            if (i == 0) cnt++;
            else if (i < nums.length && i > 0 && nums[i] == nums[i - 1]) cnt++;
            else {
                int time = cnt >= 2 ? 2 : cnt;
                while (--time >= 0) {
                    nums[cur++] = nums[i - 1];
                }
                cnt = 1;
            }
        }
        return cur;
    }


    /**
     * 最多两个相同元素
     *
     * @param nums
     * @return
     */
    public int removeDuplicates(int[] nums) {
        // 0,1,1,2,2,2,3,3,
        int cnt = 0;// 用于统计元素重复出现的次数
        int cur = 1;//下标 为1, nums[0] 一定存在
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                cnt++;
            } else {
                cnt = 0;
            }
            if (cnt < 2) {
                nums[cur++] = nums[i];
            }
        }
//        for (int i = 0; i < cur; i++) {
//            System.out.print(nums[i] + ",");
//        }
//        System.out.println();
        return cur;

    }


    public static void main(String[] args) {
        Solution_80 sol = new Solution_80();
        int i = sol.removeDuplicates(new int[]
//                {1, 1, 1, 2, 2, 3}
                        {0, 0, 1, 1, 1, 1, 2, 3, 3}
//                        {1,1,1,1,1}
        );
        int ii = sol.removeDuplicatesNew(new int[]
//                {1, 1, 1, 2, 2, 3}
                        {0, 0, 1, 1, 1, 1, 2, 3, 3}
//                        {1,1,1,1,1}
        );
        System.out.println(i);
        System.out.println("==================");
    }
}


