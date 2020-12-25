package juc;

import java.util.concurrent.*;

/**
 * @program: LeetCodeSolution
 * @description:
 * @author: WhyWhatHow
 * @create: 2020-11-10 11:40
 **/
public class ThreadPoolDemo {
    public static void main(String[] args) {
        BlockingQueue<Runnable> blockingQueue = new ArrayBlockingQueue(10);
        ExecutorService executorService = Executors.newFixedThreadPool(15);
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(2,4,2, TimeUnit.SECONDS, blockingQueue );

    }
}
