package thread;

import java.io.InterruptedIOException;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @program: LeetCodeSolution
 * @description: 交替打印测试
 * @author: WhyWhatHow
 * @create: 2020-04-16 21:50
 **/
public class ThreadTest {
    AtomicInteger change = new AtomicInteger(0);
    ReentrantLock lock = new ReentrantLock();

    public static void main(String[] args) throws InterruptedIOException {
        ThreadTest test = new ThreadTest();
//        test.testVolatileSpinLock();
        System.out.println("---------------------");
//        test.testVolatileThreadYield();
        test.testReentrantlockAndCondition(50);
    }

    /**
     * AB 交替打印 spin
     */
    void testVolatileSpinLock() {
        new Thread(() -> {
            for (int i = 0; i < 50; i++) {
                while (change.get() % 2 != 0) {
                }
                lock.lock();
                change.getAndDecrement();
                System.out.print("A");
                lock.unlock();
            }
        }).start();
        new Thread(() -> {
            for (int i = 0; i < 50; i++) {
                while (change.get() % 2 == 0) {
                }
                lock.lock();
                change.getAndDecrement();
                System.out.print("B");
                lock.unlock();
            }
        }).start();

    }

    volatile int cnt = 0;

    // thread.yield() 实现AB交替打印
    void testVolatileThreadYield() {
        new Thread(() -> {
            for (int i = 0; i < 50; ) {
                if (cnt % 2 == 0) {
                    lock.lock();
                    i++;
                    cnt++;
                    System.out.print("A");
                    lock.unlock();
                }
//                else {
//                    Thread.yield();
//                }
            }
        }).start();
        new Thread(() -> {
            for (int i = 0; i < 50; ) {
                if (cnt % 2 == 1) {
                    lock.lock();
                    i++;
                    cnt++;
                    System.out.println("B");
                    lock.unlock();
                }
//                else {
//                    Thread.yield();
//                }

            }
        }).start();
    }
    // 测试 ReentrantLock 以及condition 实现

    Condition conA = lock.newCondition();
    Condition conB = lock.newCondition();

    void testReentrantlockAndCondition(int n) throws InterruptedIOException {
        new Thread(() -> {
            try {
                lock.lock();
                for (int i = 0; i < n; i++) {
                    System.out.print("A");
                    conB.signal();
                    conA.await();
                }
                conB.signal(); // 确保线程 threadB 可以结束,
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } finally {
                lock.unlock();
            }
        }).start();
        new Thread(() -> {
            try {
                lock.lock();
                for (int i = 0; i < n; i++) {

                    System.out.println("B");
                    conA.signal();
                    conB.await();
                }
                conA.signal();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } finally {
                lock.unlock();
            }

        }).start();

    }
}