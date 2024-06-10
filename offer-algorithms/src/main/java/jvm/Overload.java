package jvm;

import java.io.Serializable;

/**
 * @program: LeetCodeSolution
 * @description:
 * @author: WhyWhatHow
 * @create: 2021-07-27 20:22
 **/

public class Overload {
//    public static void sayHello(Object arg) {
//        System.out.println("hello Object");
//    }
//    public static void sayHello(int arg) {
//        System.out.println("hello int");
//    }
    public static void sayHello(Integer arg) {
        System.out.println("hello integer");
    }
//    public static void sayHello(long arg) {
//        System.out.println("hello long");
//    }
//    public static void sayHello(Character arg) {
//        System.out.println("hello Character");
//    }
//    public static void sayHello(char arg) {
//        System.out.println("hello char");
//    }
//    public static void sayHello(char... arg) {
//        System.out.println("hello char ...");
//    }
    public static void sayHello(Serializable arg) {
        System.out.println("hello Serializable");
    }

    /**
     * 大致路径: 基本数据类型-> 封装类-> 继承的接口-> Object->args(Ps: Integer 是不会输出的)
     *  依次注销输出类型, 看'a' 的重载路程: char-> int ->long->character->serializable->object-> args->
     * @param args
     */
    public static void main(String[] args) {
        sayHello('a');
    }
}
