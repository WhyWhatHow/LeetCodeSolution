package LRU;

/**
 * @program: JUC
 * // TODO: 2021/1/8
 * @description: lru 链表实现,put(T t), get(T t) o(1)
 * @author: WhyWhatHow
 * @create: 2020-05-03 07:09
 **/
public class DemoLRUHashMap<T> {
    /**
     * lru算法实现： 最近最短时间内未被访问的数据被淘汰
     */
    private final static Integer MAX = 3;

    class Node<K, V> {
        K key;
        V value;
        Node<K, V> prev;
        Node<K, V> next;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
            this.prev = this.next = null;
        }

        public Node() {
            this.prev = this.next = null;
        }
    }

    public static void main(String[] args) {
        Integer[] a = new Integer[]{7, 0, 1, 0, 2, 0, 3, 0, 4};
        DemoLRUHashMap<Integer> lru = new DemoLRUHashMap<>();
        for (int i = 0; i < a.length; i++) {

        }
    }
}
