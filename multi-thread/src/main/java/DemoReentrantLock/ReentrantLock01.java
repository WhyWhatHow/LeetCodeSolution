package DemoReentrantLock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @program: LeetCodeSolution
 * @description:
 * @author: WhyWhatHow
 * @create: 2020-04-29 09:37
 **/
public class ReentrantLock01 {
    Lock lock = new ReentrantLock();
    synchronized void m1() {
        // 锁住当前对象
        for(int i=0; i<10; i++) {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } System.out.println(i);
            if(i == 2) {
//                synchronized 可重入
                m2();
            }
        }
    }
    synchronized void m2() {
        System.out.println("m2 ...");
    }

    public static void main(String[] args) throws InterruptedException {
//        testSynchroized();
    }

    private static void testSynchroized() throws InterruptedException {
        ReentrantLock01 rl  =new ReentrantLock01();
        new Thread(rl::m1).start();
        TimeUnit.SECONDS.sleep(1);
        new Thread(rl::m2).start();
    }
}
