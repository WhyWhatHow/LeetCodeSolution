package jvm;

/**
 * @program: LeetCodeSolution
 * @description:
 * @author: WhyWhatHow
 * @create: 2020-11-12 12:48
 **/
public class HeapSize {
    public static void main(String[] args) {
//        byte[] bytes = new byte[20* 1024*1024];

        long totalMemory = Runtime.getRuntime().totalMemory();
        Runtime.getRuntime().gc();
        long maxMemory = Runtime.getRuntime().maxMemory();
        System.out.println("TOTAL_MEMORY：" + totalMemory + "字节");
        System.out.println("MAX_MEMORY：" + maxMemory + "字节");


    }
}
