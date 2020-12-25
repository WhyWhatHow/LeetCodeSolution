package DemoThreadLocal;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @program: LeetCodeSolution
 * @description:
 * @author: WhyWhatHow
 * @create: 2020-04-28 17:57
 **/
public class DemoThreadLocal01 {
    public static void main(String[] args) {
        AtomicInteger integer =new AtomicInteger();
        int i = integer.incrementAndGet();
        System.out.println(i);
        ThreadLocal<User> local = new ThreadLocal<>();
        Thread thread = new Thread(() -> {
            for (int j = 0; j < 10; j++) {
                local.set(new User(Thread.currentThread().getName()+"j: "+j));

            }
            System.out.println(local.get());
            System.gc();
            try {
                Thread.sleep(4000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(local.get() + "after");
//            while (true){}
        });
        thread.start();

        System.out.println("main: " + local.get());
        System.out.println( "end ");
//        while(true){}
//        local.set(new User());
//        System.out.println(local.get()+"before");
//        System.gc();
//        System.out.println(local.get());
//        local.remove();
//        System.out.println(local.get());
//         Thread :
//             threadlocals(Map.class):  key threadLocal, value : Object

    }


}

class User {
    String name = "whywhathow";

    public User() {
    }

    public User(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                '}';
    }
}
