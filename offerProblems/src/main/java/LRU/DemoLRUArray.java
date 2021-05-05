package LRU;

/**
 * @program: JUC
 * @description: lru 数组实现,set复杂度 o(n)
 * @author: WhyWhatHow
 * @create: 2020-05-03 07:09
 **/
public class DemoLRUArray {

    /**
     * lru算法实现： 最近最短时间内未被访问的数据被淘汰
     */
    private Object[] list = new Object[MAX];

    private Integer size = 0;
    private final static Integer MAX = 3;

    /**
     * 查找元素, 需要重写T的equals方法
     *
     * @param t
     * @return
     */
    private int get(Object t) {
        for (int i = 0; i < list.length; i++) {
            if (t.equals(list[i])) {
                return i;
            }
        }
        return -1;
    }

    private void remove(int index) {
        for(int i = index; i>0; i--){
            list[i]=list[i-1];
        }
    }

    private void set(Object t) {
        int length = list.length;
        // 判断插入元素是否在链表中， 是则移动元素，
        int index = this.get(t);
        if (index != -1) {
            // 移动元素
            this.remove(index);
            list[0] = t;
            return;
        }
        // 判断链表是否已满，满，删除末尾元素,队列大小不变
        if (size == MAX) {
            this.remove(MAX-1);
            list[0] = t;
            return;
        } else {
            // 不满则插入
            this.remove(size);
            size++;
            list[0] = t;
            return;
        }

    }

    private void travel() {
        for (Object t : list) {
            System.out.print(t + ",");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Integer[] a = new Integer[]{7, 0, 1, 2, 0, 3, 0, 4,2,3,0,3,2,1,2,0,1,7,0,1};
        DemoLRUArray lru =new DemoLRUArray();

        for (int i = 0; i < a.length; i++) {
            lru.set(a[i]);
            System.out.print("add "+ a[i]+": ");
            lru.travel();
        }
    }
}
