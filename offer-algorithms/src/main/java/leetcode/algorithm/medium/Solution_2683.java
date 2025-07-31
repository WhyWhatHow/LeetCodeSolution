package leetcode.algorithm.medium;

/**
 * @program: LeetCodeSolution
 * @description: #
 * @author: WhyWhatHow
 **/

public class Solution_2683 {

    public static void main(String[] args) {
        Solution_2683 sol = new Solution_2683();

        System.out.println("==================");
    }

    /**
     * hint : 异或可以去括号, 不改变优先级.
     * 设初始数组是a, 目标数组是b,根据题意可得
     * b0 = a0 ^ a1
     * b1 = a1 ^ a2
     * ....
     * bn = an ^a0
     * b0 ^ b1 ^ b2 ^...^bn = (a0 ^ a1) ^ (a1 ^ a2) ^(a2 ^a3) ^ ...^(an ^ a0)
     * = 0
     * 也就是说,我们只需要判断b数组的异或和是否为0即可.
     *
     * @param derived
     * @return
     */
    public boolean doesValidArrayExist(int[] derived) {
        int sum = derived[0];
        for (int i = 1; i < derived.length; i++) {
            sum ^= derived[i];
        }
        return sum == 0;
//        int[] os = new int[derived.length];
//
//        // check os[0] = 0 , os[0] =1 ;
//        return check(os, 0, derived) || check(os, 1, derived);
    }

    // 还原之前的origin 数组,再判断是否可以合成derived 数组.
    private boolean check(int[] os, int val, int[] derived) {
        os[0] = val;
        int n = derived.length;
        boolean check = true;
        os[n - 1] = derived[n - 1] == 0 ? os[0] : 1 - os[0];
        for (int i = 0; i < derived.length - 1; i++) {
            os[i + 1] = derived[i] == 0 ? os[i] : 1 - os[i];
        }
        // check
        for (int i = 0; i < derived.length - 1; i++) {
            if (derived[i] != (os[i] ^ os[i + 1])) {
                check = false;
                break;
            }
        }
        return check && derived[n - 1] == (os[0] ^ os[n - 1]);
    }
}


