package design_patten.singleton;

import java.util.concurrent.ThreadPoolExecutor;

/**
 * @program: LeetCodeSolution
 * @description:
 * @author: WhyWhatHow
 * @create: 2021-03-10 11:00
 **/
public class Main {
    public static void main(String[] args) {
        for(int i= 0 ; i<100;i++){
            new  Thread(()->{
                printInstanceDetailSingletonLazy();
//                printInstanceDetailSingleton5();
            },"thread"+i).start();
        }
    }

    private static void printInstanceDetailSingletonLazy() {
        String name = Thread.currentThread().getName();
        SingletonLazy inSingleton = new SingletonLazy().getInstance();
        System.out.println(name+": "+inSingleton);
    }
        // 内部类实现
    private static void printInstanceDetailSingleton5() {
        String name = Thread.currentThread().getName();
        Singleton5 instance = new Singleton5().getInstance();
        System.out.println(name+": "+instance);
    }
}
