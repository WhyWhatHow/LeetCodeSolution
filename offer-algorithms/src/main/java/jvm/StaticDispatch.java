package jvm;

import java.util.Random;

/**
 * @program: LeetCodeSolution
 * @description:
 * @create: 2021-07-27 20:04
 * 方法静态分派演示
 * @author zzm
 */
public class StaticDispatch {
    static abstract class Human {
    }
    static class Man extends Human {
    }
    static class Woman extends Human {
    }
    public void sayHello(Human guy) {
        System.out.println("hello,guy!");
    }
    public void sayHello(Man guy) {
        System.out.println("hello,gentleman!");
    }
    public void sayHello(Woman guy) {
        System.out.println("hello,lady!");
    }
    public static void main(String[] args) {
//        testHuman(); // 编译时, man, woman 类型已经确定,为Human
        testHuman2();// 编译时,不能确定human 的类型, sr.sayhello() 也进行了强制类型转化, 所以,运行时 确定
    }

    /**
     * 一个非同凡响的测试,
     * static 在java 编译阶段已经确定了 实参类型, 所以输出是hello,guy
     * Human : 静态类型
     * Man: 实际类型 , 运行时确定
     * 静态类型的变化仅仅在使用时发生，变量本身的静态类型不会被改变，并且最终的静态类型是在编译期可知的
     *
     */
    private static void testHuman() {
        Human man = new Man();
        Human woman = new Woman();
        StaticDispatch sr = new StaticDispatch();
        sr.sayHello(man);
        sr.sayHello(woman);
    }
    private static void testHuman2() {
        Human human = new Random().nextBoolean()?new Man():new Woman();
        StaticDispatch sr = new StaticDispatch();
        sr.sayHello((Man) human);
//        sr.sayHello((Woman) human);
    }


}