package leetcode.algorithm;

/**
 * @program: LeetCodeSolution
 * @description:
 * @author: WhyWhatHow
 * @create: 2020-05-07 12:09
 **/

public class Solution_268 {
    /**
     * 采用求和方式解决, 0-n 的和 放在0-n-1个元素中.
     * 假设n =4, 切nums[]= [0,1,2,3]
     * 缺少的数字是4 (0+1+2+3+4)-(0+1+2+3)= (0+1+2+3)+4-(0+1+2+3)=0-0+1-1+2-2+3-3+4 =4;
     *  若 nums[]= [3,2,1,0 ] 同理,结过是一样的.不过 我还是喜欢打表.
     * @param nums
     * @return
     */
    public int missingNumber(int[] nums) {
        // 不考虑空间, 打表, 考虑空间 o(1) 求和 然后减去.
        int res = nums.length;

        for (int i = 0; i < nums.length; i++) {
            res += (i - nums[i]);
        }
        return res;

    }

    public static void main(String[] args) {
        Solution_268 sol = new Solution_268();
        System.out.println("==================");
    }
}


