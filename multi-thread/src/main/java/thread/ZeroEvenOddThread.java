package thread;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @program: LeetCodeSolution
 * @description:
 * @author: WhyWhatHow
 * @create: 2024-04-13 22:23
 **/
public class ZeroEvenOddThread {
    public static void main(String[] args) throws InterruptedException {
        ZeroEvenOddThread test = new ZeroEvenOddThread();
        int n =2 ;
        new Thread(()->{
                test.zero(n);
        }).start();
        new Thread(()-> test.even(2)).start();
        new Thread(()->test.odd(2)).start();

    }



    // don't need wolatile, case class.zero
    volatile boolean zero = false;
    volatile boolean odded = true;
    ReentrantLock lock = new ReentrantLock();

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void zero(int n ) {
        for (int i = 1; i < n + 1;) {
            if (zero) {
                lock.lock();
                System.out.print("0");
//                printNumber.accept(0);
                i++;
                zero = false;
                lock.unlock();
            } else {
                Thread.yield();
            }
        }
    }

    public void even(int n)  {
        for (int i = 1; i < n + 1;) {
            if (!odded) {
//                synchronized (this) {
                lock.lock();
                zero = true;
                Thread.yield();
                System.out.print(i);
//                printNumber.accept(i);
                i++;
                odded = true;
                lock.unlock();
//                }
            } else {
                Thread.yield();
            }
        }
    }

    public void odd(int n )  {
        for (int i = 1; i < n + 1;) {
            if (odded) {
                lock.lock();
                zero = true;
                Thread.yield();
                System.out.print(i);
//                printNumber.accept(i);
                i++;
                odded = false;
                lock.unlock();
            } else {
                Thread.yield();
            }
        }
    }
}


class ZeroEvenOdd {
    private int n;
    private volatile int state = 0; // 0: printZero, 1: printEven, 2: printOdd

    public ZeroEvenOdd(int n) {
        this.n = n;
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void zero() throws InterruptedException {
        for (int i = 0; i < n; i++) {
            while (state != 0) {
                Thread.yield(); // 等待状态为0
            }
            System.out.print(0);
            if (i % 2 == 0) {
                state = 1;
            } else {
                state = 2;
            }
        }
    }

    public void even() throws InterruptedException {
        for (int i = 2; i <= n; i += 2) {
            while (state != 1) {
                Thread.yield(); // 等待状态为1
            }
            System.out.print(i);
            state = 0;
        }
    }

    public void odd() throws InterruptedException {
        for (int i = 1; i <= n; i += 2) {
            while (state != 2) {
                Thread.yield(); // 等待状态为2
            }
            System.out.print(i);
            state = 0;
        }
    }
}

class Main {
    public static void main(String[] args) {
        int n = 5;
        ZeroEvenOdd zeroEvenOdd = new ZeroEvenOdd(n);
        Thread t1 = new Thread(() -> {
            try {
                zeroEvenOdd.zero();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        Thread t2 = new Thread(() -> {
            try {
                zeroEvenOdd.even();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        Thread t3 = new Thread(() -> {
            try {
                zeroEvenOdd.odd();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        t1.start();
        t2.start();
        t3.start();
    }
}
