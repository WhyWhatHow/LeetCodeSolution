package leetcode.algorithm;

/**
 * @program: LeetCodeSolution
 * @description:
 * @author: WhyWhatHow
 * @create: 2020-05-07 12:09
 **/

public class Solution_80 {

    /**
     *  最多两个相同元素
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
                nums[cur++]=nums[i];
            }
        }
//        for (int i = 0; i < cur; i++) {
//            System.out.print(nums[i] + ",");
//        }
//        System.out.println();
        return cur;

    }

    //    public int removeDuplicates(int[] nums) {
//        if (nums == null || nums.length == 0) {
//            return 0;
//        }
//        int cnt = 0;
//        for (int i = 0; i < nums.length - 2; ) {
//            // 排除如1,1, 2,2,3 的类型
//            //1  去重
//            if (nums[i] == nums[i + 1]) {
//                int idx = i + 1;
//                //1.1 计算 有多少个nums[i]
//                for (int j = idx; j < nums.length - 1; j++) {
//                    if (nums[j] != nums[j + 1]) {
//                        idx = j;// 找到一下个 元素 与前一个元素不等的值
//                        break;
//                    }
//                }
//                int diff = idx - i;// 差值 ,  eg1 : 1,1,2 diff =1 ; eg2: 1,1,1, diff =2
//                if (diff < 2) { //不需要去重.
//                    cnt = i = idx + 1;
//                } else { //需要去重.
//                    cnt = i + 2;
//                    nums[cnt] = nums[idx + 1];
//                    i = idx + 1;
//                }
//
//            } else {
//                cnt++;
//            }
//        }
//        return cnt + 1;
//    }

    public static void main(String[] args) {
        Solution_80 sol = new Solution_80();
        int i = sol.removeDuplicates(new int[]
//                {1, 1, 1, 2, 2, 3}
                        {0, 0, 1, 1, 1, 1, 2, 3, 3}
//                        {1,1,1,1,1}
        );
        System.out.println(i);
        System.out.println("==================");
    }
}


