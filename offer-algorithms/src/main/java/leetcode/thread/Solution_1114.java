package leetcode.thread;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @program: LeetCodeSolution
 * @description:
 * @author: WhyWhatHow
 * @create: 2020-05-07 07:11
 **/
public class Solution_1114 {
    ReentrantLock lock = new ReentrantLock();
    Condition condition = lock.newCondition();
    Condition condition2 = lock.newCondition();
    int  num = 0;

    CountDownLatch lactch = new CountDownLatch(1);

    CountDownLatch lactch2 = new CountDownLatch(1);
    public void first(Runnable printFirst) throws InterruptedException {
        // printFirst.run() outputs "first". Do not change or remove this line.
        try {

            lock.lock();
            printFirst.run();
            num =2;
            condition.signal();
        } finally {
            lock.unlock();
        }
    }

    public void second(Runnable printSecond) throws InterruptedException {
//        LockSupport.park();
        try {
            lock.lock();
            while (num!=2){
                condition.await();
            }
            printSecond.run();
            num =3 ;
            condition2.signal();
        } finally {


            lock.unlock();
        }
    }

    public void third(Runnable printThird) throws InterruptedException {

        // printThird.run() outputs "third". Do not change or remove this line.
        try {
            lock.lock();
            while (num!=3) {
                condition2.await();
            }

            printThird.run();
        } finally {
            lock.unlock();
        }
    }

}
