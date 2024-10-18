package leetcode.algorithm.medium;

/**
 * @program: LeetCodeSolution
 * @description: #
 * @author: WhyWhatHow
 **/

public class Solution_1529 {

    public static void main(String[] args) {
        Solution_1529 sol = new Solution_1529();
        System.out.println("==================");
    }

    /**
     * 翻转一次, 改变, 两次,还原.
     * '0000'->target
     * 以target '0111' 为例,
     * idx_0: 两者相同,跳过
     * idx_1: 0,1 需要翻转 记为1次
     * idx_2: 以翻转, 不需要改变.
     * idx_3: 已翻转, 不要改变
     * ans = 1 ;
     * @param target
     * @return
     */
    public int minFlips(String target) {
        int cnt = 0;
        boolean changed = false;
        char[] cs = target.toCharArray();
        for (char c : cs) {
            if (c == '0' && changed) {
                changed = false;
                cnt++;
            } else if (c == '1' && !changed) {
                cnt++;
                changed = true;
            }
        }
        return cnt;
    }

}


