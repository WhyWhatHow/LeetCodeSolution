import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader;

/**
 * @program: LeetCodeSolution
 * @description:
 * @author: WhyWhatHow
 * @create: 2020-04-23 11:42
 **/
public class T1  implements  Runnable{
    private int count = 10;
    public synchronized void run() {
        count--;
        System.out.println(Thread.currentThread().getName() + " count = " +
                count);
    } public static void main(String[] args) {
        for(int i=0; i<5; i++) {
            T1 t = new T1();
            new Thread(t, "THREAD" + i).start();
        }
    }



}
