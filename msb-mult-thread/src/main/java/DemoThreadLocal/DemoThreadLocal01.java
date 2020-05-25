package DemoThreadLocal;

import java.lang.ref.PhantomReference;
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

        Thread t1 = new Thread(() -> {
            System.out.println("aaa");
        });

        //// TODO: 2020/4/28  spring transactional
        local.set(new User());
        local.remove();
//         Thread :
//             threadlocals(Map.class):  key threadLocal, value : Object

    }


}

class User {
    String name = "whywhathow";
}
