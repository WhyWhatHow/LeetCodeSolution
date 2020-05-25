package  design_patten;

import sun.nio.cs.SingleByte;

/**
 * @program: LeetCodeSolution
 * @description: 饿汉模式,类加载直接生成,保存在heap中
 * @author: WhyWhatHow
 * @create: 2020-05-17 13:47
 **/
public class Singleton {

    private static final  Singleton instance = new Singleton();
    public Singleton getInstance(){
        return this.getInstance();
    }
}
