package leetcode.algorithm.math;

/**
 * @program: LeetCodeSolution
 * @description: #math
 * @author: WhyWhatHow
 **/

public class Solution_1017 {

    public static void main(String[] args) {
        Solution_1017 sol = new Solution_1017();
        sol.baseNeg2(2);
        for (int i = 0; i < 10; i++) {
            System.out.println(sol.baseNeg2(i));
        }
        System.out.println("==================");
    }

    /***
     * example: k= -2
     * 3 / k  = -1 ... 1
     * -1 / k =  0 ... -1  <==>(-2+1)
     *           1 ... 1
     * 1 / k  =  0 ... 1
     * @param n
     * @return
     */
    public String baseNeg2(int n) {
        if (n == 0 ) return "0";
        StringBuilder builder = new StringBuilder();
        //余数 ,  商
        int remain, division;
        int k = -2;
        while (n != 0) {
            division = n / k;
            remain = n % k;
            if (remain < 0) { // 余数为0 的情况,  remain+2 <==> division+1 ( division 为 -2 的商, remain 要+2 ==> division - (-1) )
                remain += 2;
                division++;
            }
            builder.append(remain);
            n = division;
        }
        return builder.reverse().toString();

    }


}


