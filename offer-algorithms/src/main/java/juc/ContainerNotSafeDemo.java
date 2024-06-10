package juc;

/**
 * @program: LeetCodeSolution
 * @description:
 * @author: WhyWhatHow
 * @create: 2020-11-09 15:31
 **/

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * 集合类不安全问题
 */
public class ContainerNotSafeDemo {

    public static void main(String[] args) {
        //Map<String, String> map = new HashMap<>();
        //Map<String, String> map = Collections.synchronizedMap(new HashMap<>());
        Map<String, String> map;
        List<Object> objects = Collections.synchronizedList(new ArrayList<>()
        );
        objects.add(1);
//        ArrayBlockingQueue
//        HashSet
        map = new ConcurrentHashMap<>();
        for (int i = 0; i < 30; i++) {
            new Thread(String.valueOf(i)){
                @Override
                public void run() {
                    map.put(getName(), UUID.randomUUID().toString().substring(0 ,8));
                    System.out.println(map);
                }
            }.start();
        }
    }

    public static void setNotSafe() {
        //Set<String> set = new HashSet<>();
        //Set<String> set = Collections.synchronizedSet(new HashSet<>());
        Set<String> set = new CopyOnWriteArraySet<>();
        for (int i = 0; i < 30; i++) {
            new Thread(String.valueOf(i)){
                @Override
                public void run() {
                    set.add(UUID.randomUUID().toString().substring(0, 8));
                    System.out.println(getName() + "\t" + set);
                }
            }.start();
        }

        /**
         *
         * private final CopyOnWriteArrayList<E> al;
         * public CopyOnWriteArraySet() {
         *    al = new CopyOnWriteArrayList<E>();
         * }
         */


        /**
         * HashSet底层是HashMap
         *  public HashSet() {
         *     map = new HashMap<>();
         *  }
         * 那为什么map要传键和值两个参数,而HashSet只需要一个参数
         * 因为HashSet的add方法,把要传入的值作为键,而值是一个名为PRESENT的Object类型静态常量
         *  public boolean add(E e) {
         *     return map.put(e, PRESENT)==null;
         *  }
         *  private static final Object PRESENT = new Object();
         *
         *
         */
        new HashSet<>().add("a");
    }

    public static void listNotSafe() {
        //List<String> list = new ArrayList<>();
        //List<String> list = new Vector<>();
        //List<String> list = Collections.synchronizedList(new ArrayList<>());
        List<String> list = new CopyOnWriteArrayList<>();

        for (int i = 0; i < 30; i++) {
            new Thread(String.valueOf(i)){
                @Override
                public void run() {
                    list.add(UUID.randomUUID().toString().substring(0,8));
                    System.out.println(list);
                }
            }.start();
        }

        /**
         *  1.故障现象
         *      java.util.ConcurrentModificationException
         *  2.导致原因
         *      并发争抢修改导致,参考花名册签名,一个人正在写,另一个同学过来抢,导致数据不一致异常
         *  3.解决方案
         *      3.1 new Vector<>();
         *      3.2 Collections.synchronizedList(new ArrayList<>());
         *      3.3 new CopyOnWriteArrayList<>()
         *  4.优化建议
         */

    }

}


