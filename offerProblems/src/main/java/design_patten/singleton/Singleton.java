package design_patten.singleton;

/**
 * @program: LeetCodeSolution
 * @description: 饿汉模式,类加载直接生成,保存在heap中
 * @author: WhyWhatHow
 * @create: 2020-05-17 13:47
 **/
// 优点 : static 关键字, 类启动时创建, 但是,程序不能控制类创建的时间
//public class Singleton {
//    private static final  Singleton instance = new Singleton();
//    public Singleton getInstance(){
//        return this.getInstance();
//    }
//}
//是否 Lazy 初始化：是
//
//是否多线程安全：否
//
//实现难度：易
public   class  Singleton{

    private  static  final Singleton  SINGLETON =new Singleton() ;

    public  Singleton getInstance(){
        return SINGLETON;
    }
}
