package juc;

/**
 * @program: LeetCodeSolution
 * @description:
 * @author: WhyWhatHow
 * @create: 2020-11-09 14:27
 **/

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicStampedReference;
import java.util.concurrent.locks.LockSupport;

/**
 * ABA问题的解决     AtomicStampedReference
 */
public class ABADemo {

    static AtomicReference<Integer> atomicReference = new AtomicReference<>(100);
    static AtomicStampedReference<Integer> atomicStampedReference = new AtomicStampedReference<>(100, 1);

    static AtomicReference<Integer > integerRef =new AtomicReference<>(200);
    static AtomicStampedReference<Integer> stempRef = new AtomicStampedReference<>(200, 1);
    static  void testABA(){
        Thread t2 = new Thread(() -> {

            // 保证 线程一执行 ,保证不了
//                Thread.sleep(1000);
            LockSupport.park();
            System.out.println(Thread.currentThread().getName()+": integerRef val="+integerRef.compareAndSet(200, 2020) + "\n " + integerRef.get());
//            System.out.println(integerRef.getAndSet());
            }, "t2");
        // 阻塞
        new Thread(()->{

            boolean b = integerRef.compareAndSet(200, 201);
            System.out.println(" 1 change" + b);
            boolean b1 = integerRef.compareAndSet(201, 200);
            System.out.println("2 change" + b1);
            System.out.println(integerRef.get());
            System.out.println(integerRef.getAndSet(201));
            System.out.println(integerRef.getAndSet(200));
            LockSupport.unpark(t2);
        },"t1").start();
        t2.start();;
        stempRef.getStamp();
//        stempRef.compareAndSet(,);

    }

    public static void main(String[] args) {
//        testABA();
        testABAAndSolution();
    }

    /**
     *1 测试ABA 问题  最初设置 atomic :100 ,
     *   伪代码:
     *     1. atomicReference <Integer> ar = 100 ;
     *1    Thread t1:
     *          1.     ar.compareAndSet(100,101); true
     *          2.     ar.compareAndSet(101,100): true
     *     Thread t2:
     *          1. ar.compareAndSet(100,2019) right
     *  问题:若初始化100->200, 101->201 ,compareAndSet(200,201) 的结果false
     *   猜测:问题是由于 Integer 有一个cache[-128,127],所以 compareAndSet(100,101)可以成功,而200,201 不可以
     *   解决方法 :ar.getAndSet(200,201) will be success.
     *    测试案例参见 testABA()
     */
    private static void testABAAndSolution() {
        System.out.println("-----------------ABA问题的产生--------------------");
        new Thread("t1"){
            @Override
            public void run() {

                atomicReference.compareAndSet(100, 101);
                System.out.println("1st : "+atomicReference.get());
                atomicReference.compareAndSet(101, 100);
             System.out.println("1st : "+atomicReference.get());
            }
        }.start();

        new Thread("t2"){
            @Override
            public void run() {
                try {
                    //线程t2休眠1秒钟,确保t1完成一次ABA操作
                    sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(atomicReference.compareAndSet(100, 1010) + "\t" + atomicReference.get());
            }
        }.start();

        try {
            Thread.sleep(1000);      } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("-----------------ABA问题的解决--------------------");

        new Thread("t3"){
            @Override
            public void run() {
                int stamp = atomicStampedReference.getStamp();
                System.out.println(getName() + "\t第一次版本号：" + stamp);
                try {
                    //t3线程休眠1秒中,确保t4也拿到初始的版本号
                    sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                atomicStampedReference.compareAndSet(100, 101, atomicStampedReference.getStamp(), atomicStampedReference.getStamp() + 1);
                System.out.println(getName() + "\t第二次版本号：" + atomicStampedReference.getStamp());
                atomicStampedReference.compareAndSet(101, 100, atomicStampedReference.getStamp(), atomicStampedReference.getStamp() + 1);
                System.out.println(getName() + "\t第三次版本号：" + atomicStampedReference.getStamp());
            }
        }.start();

        new Thread("t4"){
            @Override
            public void run() {
                int stamp = atomicStampedReference.getStamp();
                System.out.println(getName() + "\t第一次版本号：" + stamp);
                try {
                    //t4线程休眠3秒中,确保t3完成一次ABA操作
                    sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                boolean result = atomicStampedReference.compareAndSet(100, 2020, stamp, stamp + 1);
                System.out.println(getName() + "\t是否修改成功," + result + "\t当前最新实际版本号：" + atomicStampedReference.getStamp());
                System.out.println(getName() + "\t当前实际最新值：" + atomicStampedReference.getReference());
            }
        }.start();
    }
    void testCas(){
        System.out.println("neilo --start --");
        AtomicInteger atomicInteger= new AtomicInteger();
        atomicInteger.compareAndSet(0,100   );
        System.out.println("neilo--end");
    }
}
