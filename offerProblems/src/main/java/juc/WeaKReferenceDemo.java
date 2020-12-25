package juc;

import java.lang.ref.WeakReference;
import java.util.concurrent.TimeUnit;

/**
 * @program: LeetCodeSolution
 * @description:
 * @author: WhyWhatHow
 * @create: 2020-11-12 15:10
 **/
public class WeaKReferenceDemo {
    public static void main(String[] args) throws InterruptedException {

        Object o1 = new Object();
        WeakReference<Object> weakReference = new WeakReference<>(o1);
        System.out.println(o1);

        System.out.println(weakReference.get());
        o1 = null;
        System.gc();
        System.out.println(o1);
        System.out.println(weakReference.get());
//        Thread.sleep(Integer.MAX_VALUE);
    }
    }
