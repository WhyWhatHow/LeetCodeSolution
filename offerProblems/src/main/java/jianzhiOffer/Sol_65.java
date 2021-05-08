package jianzhiOffer;

/**
 * @program: LeetCodeSolution
 * @description:
 * @author: WhyWhatHow
 * @create: 2020-05-22 08:10
 **/
public class Sol_65 {
    // 模拟计算机加法
    public int add(int a, int b) {
        // return a+b; // 模拟计算机 执行加法计算的流程.
        while (b != 0) {
//            计算个位
            int temp = a ^ b;// 异或运算 相同取0, 不同取1
            // 计算进位
            int up = (a & b) << 1;
            a = up;
            b = temp;
        }
        return a ;
    }

    public static void main(String[] args) {
        Sol_65 sol = new Sol_65();
    }
}
