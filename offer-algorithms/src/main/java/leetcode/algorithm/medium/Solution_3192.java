package leetcode.algorithm.medium;

/**
 * @program: LeetCodeSolution
 * @description: #
 * @author: WhyWhatHow
 **/

public class Solution_3192 {

    public static void main(String[] args) {
        Solution_3192 sol = new Solution_3192();
        System.out.println("==================");
    }

    /**
     * set x = =nums [i]
     * x =0, 变一次 x=1 , 两次 x =0 ;
     * 所有x=0的多需要 , 是不是意味着需要 0->n的范围遍历一次呢 ?
     * 这个示例中, 欺负老实人哦, 实际上,跟从0开始处理没有区别的(也许这题不给示例解析,会更方便解题)
      >      * 选择下标 i = 1 执行操作，得到 nums = [0,0,0,1,0] 。
             * 选择下标 i = 0 执行操作，得到 nums = [1,1,1,0,1] 。
             * 选择下标 i = 4 执行操作，得到 nums = [1,1,1,0,0] 。
             * 选择下标 i = 3 执行操作，得到 nums = [1,1,1,1,1] 。
     * 有题意知, 需要 x =0 -> x=1, 问题在于需不需要统计x 之前的遍历次数,或者说在经历了k轮遍历后,x 是否还是需要改变.
     * 即 con_1: x ==0 && k is odd  , 等价于 x =1
     *    con_2: x ==0 && k is even ,      x= 0, 需要改变,所以 k++
     *    con_3: x ==1 && k is odd  ,      x =0, k++
     *    con_4: x ==1 && k is even ,      x=1
     *  return k 即可.
     *
     * @param nums
     * @return
     */
    public int minOperations(int[] nums) {
        int cnt = 0;
        boolean changed = false;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0 && !changed) {
                cnt++;
                changed = true;
            } else if (nums[i] == 1 && changed) {
                cnt++;
                changed = false;
            }
        }
        return cnt;
    }
}


