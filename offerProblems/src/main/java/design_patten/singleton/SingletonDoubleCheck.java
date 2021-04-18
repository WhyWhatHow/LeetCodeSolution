package design_patten.singleton;

/**
 * @program: LeetCodeSolution
 * @description:
 * @author: WhyWhatHow
 * @create: 2021-03-10 09:34
 **/
public class SingletonDoubleCheck {

    private volatile SingletonDoubleCheck instance=null;

    public SingletonDoubleCheck getInstance() {
        if (instance == null) {
            synchronized (this) {
                if (instance == null) {
                    instance = new SingletonDoubleCheck();
                }
            }
        }
        return instance;
    }

    private SingletonDoubleCheck() {
    }
}
