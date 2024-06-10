package juc;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @program: LeetCodeSolution
 * @description:
 * @author: WhyWhatHow
 * @create: 2020-11-10 11:24
 **/

class MyThread implements Callable<Integer> {

    @Override
    public Integer call() throws Exception {
        System.out.println("callable...");
        Thread.sleep(2000);
        return 1024;
    }
}

public class CallableDemo {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask<Integer> futureTask = new FutureTask<>(new MyThread());
        new Thread(futureTask, "A").start();
        new Thread(futureTask, "B").start(); //如果是同一个task，即使多个线程，也只进call()一次
        System.out.println(Thread.currentThread().getName() + "...");
        Integer result = futureTask.get();  //获取callable线程的计算结果，如果没有完成计算，会导致堵塞，直到计算完成
        System.out.println("result：" + result);
    }
}