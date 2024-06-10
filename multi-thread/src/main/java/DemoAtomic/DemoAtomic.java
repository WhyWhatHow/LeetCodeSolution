package DemoAtomic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.LongAdder;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @program: LeetCodeSolution
 * @description:
 * @author: WhyWhatHow
 * @create: 2020-04-28 22:27
 **/
class DemoAtomicInteger {


    AtomicInteger count = new AtomicInteger();

    void m() {
        for (int i = 0; i < 10000; i++) {
            count.incrementAndGet();
        }
    }

    public static void main(String[] args) {
        int[] a= new int[]{0};
        boolean a1 = isA(a);
        System.out.println(a1);

                DemoAtomicInteger t = new DemoAtomicInteger();
        List<Thread> threads;
        threads = new ArrayList<Thread>();
        for (int i = 0; i < 10; i++) {
            threads.add(new Thread(t::m, "thread-" + i));
        }
        threads.forEach((o) -> o.start());
        for (Thread o : threads) {
            try {
                o.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(t.count);

        LongAdder longAdder =new LongAdder();
//        ReentrantLock01
    }


    private static boolean isA(int[] numbers) {
        boolean[] vis = new boolean[14];
        int max, min, x;
        if(numbers.length<5){
            return false ;
        }
        max = min = numbers[0];

        for (int i = 0; i < numbers.length; i++) {
            x = numbers[i];
            if (x == 0) {
                continue;
            }
            if (vis[x] == true && x != 0) {
                return false; // 3 3
            } else {
                vis[x] = true;
            }
        }
        for (int i= 1 ; i< 14;i++){
            if(vis[i]){
                min =i;
                break;
            }
        }
        for(int i= 13 ;i>=1; i--){
            if(vis[i]){
                max=i ;
                break;
            }
        }
        return max-min<5;

    }

}
