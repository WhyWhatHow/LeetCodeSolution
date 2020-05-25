package LRU;

import java.util.LinkedList;

/**
 * @program: JUC
 * @description: lru 链表实现,set复杂度 o(n)
 * @author: WhyWhatHow
 * @create: 2020-05-03 07:09
 **/
public class DemoLRU<T> {
    /**
     * lru算法实现： 最近最短时间内未被访问的数据被淘汰
     */
    private LinkedList<T> list = new LinkedList();
//    private T first, last;
    private final static Integer MAX = 3;

    private T get() {
        return list.getFirst();
    }

    private T remove() {
        return list.removeLast();
    }

    private void set(T t) {
        int size = list.size();
        // 判断插入元素是否在链表中， 是则移动元素，
        int index = list.indexOf(t);
        if( index!=-1 ){
            // 移动元素
            list.remove(index);
            list.addFirst(t);
            return  ;
        }
        // 判断链表是否已满，满，删除末尾元素
        if(list.size()==MAX){
           list.removeLast();
        }
        // 不满，则末尾淘汰
        list.addFirst(t);
    }
    private void travel(){
        for (T t : list) {
            System.out.print(t+",");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Integer[] a= new Integer[]{7,0,1,2,0,3,0,4};
        DemoLRU<Integer> lru =new DemoLRU<>();
        for(int i = 0; i< a.length;i++){
            lru.set(a[i]);
            lru.travel();
        }
    }
}
