package jianzhiOffer;

import java.util.HashMap;

/**
 * @program: LeetCodeSolution
 * @description:
 * @author: WhyWhatHow
 * @create: 2020-05-22 08:10
 **/
public class Sol_56_1 {
    /**
     * 利用异或 位运算解题,
     * 异或:相同取0, 不同取1  : a^0=a,a^a=0,a^b=b^a
     * 按位与: 两者都为1时为1, 其他情况取0
     * 以 [3,3,4,4,1,6] 为例说明
     * 1.异或数组后的结果是 n= 1^6 =7,
     * 即 x^y , 其中, x=1  (001)和 y=6 (110)
     * 在某一位中不同(即表明n在这一位表示为1
     * ==> 即寻找 n的二进制表示中 中第一次出现1的位置 -> 按位与运算判断),
     * 2.设 m = 1, 依次左移一位来判断1,2,4,8... 第一次出现不同的下标
     * 3. 算x, 和y 的值,  m 表示 在某一位x 和y不同的一位
     * )1. (num&m)==0 -> x=x^num;
     * )2. (num&m)==1 -> y=y^num;
     *
     * @param nums
     * @return
     */
    public int[] singleNumbers(int[] nums) {
        int n = 0, x = 0, y = 0, m = 1;
        for (int num : nums) {
            n ^= num;
        }
        // 从左往右读,找到n 中第一个1出现的位置
        while ((n & m) == 0) {
            m = m << 1;
        }
        for (int num : nums) {
            if ((num & m) == 0) {
                x = x ^ num;
            } else {
                y = y ^ num;
            }
        }
        return new int[]{x,y};
    }

    public static void main(String[] args) {
        Sol_56_1 sol = new Sol_56_1();

        System.out.println("=======");
    }
}
