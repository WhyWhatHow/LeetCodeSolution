package Lock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @program: LeetCodeSolution
 * @description:
 * @author: WhyWhatHow
 * @create: 2021-06-02 23:12
 **/
public class ReentrantLockDemo {

    private static volatile int i = 0;
    public static void main(String[] args) {
        ReentrantLock lock = new ReentrantLock(true);
//        for (int j = 0  ; j< 10 ; j++){
//            System.out.println(j+"===================");
//        new Thread(()->{
        lock.lock();
        i++;
        lock.unlock();
//        }).start();;
//            System.out.println("jjjjj==============");
//        }
//        String str = "hello, whywhathow ";
//        String upt = "hello, qq" ;
//        AtomicReference<Object> atom = new AtomicReference<>();
//        atom.set(str);
//        boolean b = atom.compareAndSet(str, upt);
//        System.out.println(str);
//        System.out.println(upt);
//        System.out.println(atom.get());
//        System.out.println(b);

    }

}
