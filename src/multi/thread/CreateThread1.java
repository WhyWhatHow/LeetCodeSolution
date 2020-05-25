package multi.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * @program: LeetCodeSolution
 * @description:
 * @author: WhyWhatHow
 * @create: 2020-04-23 11:10
 **/
public class CreateThread1 {
    public static void main(String[] args) {
        Thread thread =new Thread(()->{
            for (int i = 0; i < 10; i++) {
                try {
                    Thread.sleep(500);
                    System.out.println("whh");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        thread.start();
        Thread tt =new Thread(new FutureTask<String>(new Callable<String>() {
            @Override
            public String call() throws Exception {
                return "future task, my call";
            }
        }))
                ;
        tt.start();
    }

}