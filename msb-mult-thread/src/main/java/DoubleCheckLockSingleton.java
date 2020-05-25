/**
 * @program: LeetCodeSolution
 * @description: 双重锁单例 check
 * @author: WhyWhatHow
 * @create: 2020-04-23 15:40
 **/
public class DoubleCheckLockSingleton {
    private static volatile DoubleCheckLockSingleton instance;

    public static DoubleCheckLockSingleton getInstance() {

        if (instance == null) {
            synchronized (DoubleCheckLockSingleton.class) {
                if (instance == null) {
                    instance = new DoubleCheckLockSingleton();
                }
            }
        }
        return instance;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                DoubleCheckLockSingleton instance = DoubleCheckLockSingleton.getInstance();
                System.out.println(instance);
            }).start();
        }
//        DoubleCheckLockSingleton instance = DoubleCheckLockSingleton.getInstance();
//        System.out.println(instance);
    }
}
