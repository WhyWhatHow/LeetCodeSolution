package design_patten.singleton;

import sun.security.jca.GetInstance;

/**
 * @program: LeetCodeSolution
 * @description:
 * @author: WhyWhatHow
 * @create: 2021-03-10 11:36
 **/
public class Singleton5 {
    int val ;
    private static class SingletonHolder{
     static final Singleton5 instance = new Singleton5();
    }
    public   Singleton5 getInstance(){
        return SingletonHolder.instance;
    }

}
