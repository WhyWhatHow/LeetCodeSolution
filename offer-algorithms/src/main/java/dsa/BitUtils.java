package dsa;

public class BitUtils {
    
    /**
     * 获取整数的第i位bit值 (从右往左数，从0开始)
     * @param num 整数
     * @param i 位索引 (从0开始)
     * @return 第i位的bit值 (0或1)
     */
    public static int getBitAt(int num, int i) {
        return (num >> i) & 1;
    }
    
    /**
     * 获取整数的第i位bit值 (从左往右数，从0开始，以32位整数为例)
     * @param num 整数
     * @param i 位索引 (从0开始)
     * @return 第i位的bit值 (0或1)
     */
    public static int getBitAtFromLeft(int num, int i) {
        return (num >> (31 - i)) & 1;
    }
    
    // 测试方法
    public static void main(String[] args) {
        int num = 10; // 二进制表示为 1010
        System.out.println("数字 " + num + " 的二进制表示: " + Integer.toBinaryString(num));
        
        for (int i = 0; i < 4; i++) {
            System.out.println("第 " + i + " 位的bit值: " + getBitAt(num, i));
        }
    }
}