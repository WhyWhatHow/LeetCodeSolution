package jianzhioffer;

/**
 * @program: LeetCodeSolution
 * @description:
 * @author: WhyWhatHow
 * @create: 2020-05-22 08:10
 **/
public class Sol_11 {
    public int minArray(int[] numbers) {
        int min=Integer.MAX_VALUE;
        for (int number : numbers) {
            min= Math.min(min,number);
        }
        return min;
    }
    public static void main(String[] args) {
        Sol_11 sol =new Sol_11();
    }
}
