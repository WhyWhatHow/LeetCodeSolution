package jianzhioffer;

import java.util.Arrays;

/**
 * @program: LeetCodeSolution
 * @description:
 * @author: WhyWhatHow
 * @create: 2020-05-22 08:10
 **/
public class Sol_40 {

    public int  [] getLeastNumbers(int[] arr, int k) {
        if (arr.length==0) {
            return arr;
        }
        Arrays.sort(arr);

        return Arrays.copyOfRange(arr,0, k);

    }
    public static void main(String[] args) {
        Sol_40 sol =new Sol_40();
    }
}
