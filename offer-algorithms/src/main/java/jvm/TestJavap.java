package jvm;

/**
 * @program: LeetCodeSolution
 * @description: 测试javap 指令
 * @author: WhyWhatHow
 * @create: 2021-08-06 16:14
 **/
public class TestJavap {
    /***
     * 字段描述符:
     * https://docs.oracle.com/javase/specs/jvms/se8/html/jvms-4.html#jvms-4.3.2
     * FieldType term   Type    Interpretation
     * B                bytesigned  byte
     * C                char        Unicode character code point in the Basic Multilingual Plane, encoded with UTF-16
     * D                double      double-precision floating-point value
     * F                float       single-precision floating-point value
     * I                int         integer
     * J                long        long integer
     * LClassName;      reference   an instance of class ClassName
     * S                short       signed short
     * Z                boolean     true  or false
     * [                reference   one array dimension
     *
     * ===============================
     * 方法描述符: https://docs.oracle.com/javase/specs/jvms/se8/html/jvms-4.html#jvms-4.3.3
     * Object m(int i, double d, Thread t) {...}
     * ->
     *  (IDLjava/lang/Thread;)Ljava/lang/Object;
     * @param args
     */
    public static void main(String[] args) {
        int  x= 5;
        int y = 2;
        int z = x-y;
        System.out.println(z);
    }
}
