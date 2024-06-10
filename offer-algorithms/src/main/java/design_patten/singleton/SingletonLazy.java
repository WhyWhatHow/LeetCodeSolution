package design_patten.singleton;

/**
 * @program: LeetCodeSolution
 * @description: 单例模式, 懒汉式
 * @author: WhyWhatHow
 * @create: 2020-05-17 13:50
 **/
public class SingletonLazy {
    //使用volatile 原因如下:
//    避免指令重排序
    private static   volatile SingletonLazy instance = null;
    private volatile SingletonLazy instanceNoS = null;

    SingletonLazy() {
    // jvm执行顺序:
//        1. 分配内存空间
//        2. init, 数据初始化
//        3. 为对象指向分配的内存空间
    }

    public SingletonLazy getInstance() {
        if (instance == null) {
            synchronized (SingletonLazy.class) {
                if (instance == null) {
                    instance = new SingletonLazy();
                }
            }
        }
        return instance;

    }
}
