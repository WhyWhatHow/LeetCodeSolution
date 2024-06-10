package interview;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @program: LeetCodeSolution
 * @description:
 * @author: WhyWhatHow
 * @create: 2020-10-28 10:26
 **/
public class TestSyncAndAtomInteger {
   static  int num= 0 ;
   static synchronized void add(){
         num++;
     }

    static  AtomicInteger anum =  new AtomicInteger();

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        for (int i = 0; i <10000 ; i++) {
            new Thread(()->{
                add();
            }).start();
        }
        while(Thread.activeCount()>2){
            Thread.yield();
        }
        long end= System.currentTimeMillis();
        System.out.println(num);
        System.out.println( end-start);
        System.out.println("=====================");



        long start2 = System.currentTimeMillis();
        for (int i = 0; i <10000; i++) {
            new Thread(()->{
                anum.incrementAndGet();
            }).start();
        }
        while(Thread.activeCount()>2){
            Thread.yield();
        }
        long end2= System.currentTimeMillis();
        System.out.println(anum.get());
        System.out.println( end2-start2);
    }


}
interface Test{
    void a();
}