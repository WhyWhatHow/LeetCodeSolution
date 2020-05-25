package design_patten;

/**
 * @program: LeetCodeSolution
 * @description: 单例模式, 懒汉式
 * @author: WhyWhatHow
 * @create: 2020-05-17 13:50
 **/
public class SingletonLazy {
    //使用volatile 原因如下:
//    避免指令重排序
    private   volatile SingletonLazy instance = null;

    SingletonLazy() {
    // jvm执行顺序:
//        1. 分配内存空间
//        2. init, 数据初始化
//        3. 为对象指向分配的内存空间
    }

    public SingletonLazy getInstance() {
        if (instance == null) {
            synchronized (this) {
                if (instance == null) {
                    instance = new SingletonLazy();
                }
            }
        }
        return instance;

    }
}
