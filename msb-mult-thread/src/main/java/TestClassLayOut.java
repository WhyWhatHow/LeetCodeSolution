import org.openjdk.jol.info.ClassLayout;

import java.util.Date;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @program: LeetCodeSolution
 * @description:
 * @author: WhyWhatHow
 * @create: 2020-04-16 21:50
 **/

class User{
    int age ;
    String name;
    double price ;
    Date birthday;
    Long  aaa;
    float nnn;
}

public class TestClassLayOut {
    public static void main(String[] args) {
        // 测试 object 成员变量
//         o = new Object();
//        AtomicInteger o  =new AtomicInteger();
//        System.out.println(ClassLayout.parseInstance(o).toPrintable());
//        synchronized (o){
//            System.out.println(ClassLayout.parseInstance(o).toPrintable());
//
//        }

        // 测试USer 对象
        System.out.println("====================================");
        User user = new User();
        System.out.println(ClassLayout.parseInstance(user).toPrintable());
    }
}
