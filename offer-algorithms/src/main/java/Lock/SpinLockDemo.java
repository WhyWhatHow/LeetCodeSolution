package Lock;

import java.util.concurrent.atomic.AtomicReference;

/**
 * @program: LeetCodeSolution
 * @description: 自制自旋锁
 * @author: WhyWhatHow
 * @create: 2020-10-28 11:19
 **/
public class SpinLockDemo {
    AtomicReference<Thread> atomicReference =new AtomicReference<>();
    void lock(){
        Thread thread = Thread.currentThread();
        // 更新锁状态, 无锁->持有锁
        while(!atomicReference.compareAndSet(null,thread)){}
    }
    void unlock(){
        Thread thread = Thread.currentThread();
        atomicReference.compareAndSet(thread,null);
    }

    public static void main(String[] args) {
        SpinLockDemo demo =new SpinLockDemo();
        int[] num ={0} ;
        for (int i = 0; i < 100; i++) {
            new Thread(()->{
                demo.lock();
                num[0]++;
                demo.unlock();
            }).start();
        }

        while(Thread.activeCount()>2){
            Thread.yield();
        }
        System.out.println(num[0]);
    }
}
