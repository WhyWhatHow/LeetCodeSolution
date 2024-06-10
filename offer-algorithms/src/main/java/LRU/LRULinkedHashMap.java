package LRU;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @program: LeetCodeSolution
 * @description: lru算法 通过linkedhashmap 实现查找o(1),增删o(1)的复杂度
 * @author: WhyWhatHow
 * @create: 2021-01-08 13:37
 **/
public class LRULinkedHashMap<T> extends LinkedHashMap<T, T> {
    private Integer len;
    public LRULinkedHashMap(int initialCapacity,
                            float loadFactor,
                            boolean accessOrder) {
        super(initialCapacity, loadFactor, accessOrder);
    }
    public Integer getLen() {
        return len;
    }
    public void setLen(Integer len) {
        this.len = len;
    }
    @Override
    protected boolean removeEldestEntry(Map.Entry<T, T> eldest) {
        return this.len < this.size();
    }
    @Override
    public T put(T key, T val){
        T put = super.put(key, val);
        return put;
    }
    @Override
    public T get(Object key){
        T t = super.get(key);
        return t;
    }

    void travel() {
        this.keySet().forEach(System.out::print);
    }
    /**
     * lru 算法描述:
     * 1.在固定的容量下 即链表长度 假设
     */
    public static void main(String[] args) {
        Integer[] a = new Integer[]{7, 0, 1, 2, 0, 3, 0, 4, 2, 3, 0, 3, 2, 1, 2, 0, 1, 7, 0, 1};
        LRULinkedHashMap<Integer> lruDemo = new LRULinkedHashMap<Integer>(16, 0.75f, true);
        lruDemo.setLen(3);
        for (Integer integer : a) {
            lruDemo.put(integer, 1);
            System.out.print("insert: " + integer + " ;  now : ");
            lruDemo.travel();
            System.out.println();
        }
    }


}
