package design_patten;

/**
 * @program: LeetCodeSolution
 * @description:
 * @author: WhyWhatHow
 * @create: 2020-05-17 14:04
 **/
public class SingletonStatic {

    SingletonStatic getInstance(){
        return Inner.instance;
    }
    private static  class Inner {
        static SingletonStatic instance =new SingletonStatic();

    }
}
