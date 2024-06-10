package leetcode.algorithm;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @program: LeetCodeSolution
 * @description:
 * @author: WhyWhatHow

 **/

public class Solution_146 {

    public static void main(String[] args) {
        Solution_146 sol = new Solution_146();
        System.out.println("==================");
        LRUCache lRUCache = new LRUCache(2);
        lRUCache.put(1, 1); // 缓存是 {1=1}
        System.out.println(lRUCache.keySet());
        lRUCache.put(2, 2); // 缓存是 {1=1, 2=2}

        System.out.println(lRUCache.keySet());
        lRUCache.get(1);    // 返回 1

        System.out.println(lRUCache.keySet());
        lRUCache.put(3, 3); // 该操作会使得关键字 2 作废，缓存是 {1=1, 3=3}

        System.out.println(lRUCache.keySet());
        lRUCache.get(2);    // 返回 -1 (未找到)

        System.out.println(lRUCache.keySet());
        lRUCache.put(4, 4); // 该操作会使得关键字 1 作废，缓存是 {4=4, 3=3}

        System.out.println(lRUCache.keySet());
        lRUCache.get(1);    // 返回 -1 (未找到)

        System.out.println(lRUCache.keySet());
        lRUCache.get(3);    // 返回 3

        System.out.println(lRUCache.keySet());
        lRUCache.get(4);    // 返回 4

        System.out.println(lRUCache.keySet());

    }
}


class LRUCache  extends  LinkedHashMap{
    int capacity;
    public LRUCache(int capacity) {

        super(capacity,0.75f,false);
//        super(capacity,0.75f,true);

        this.capacity = capacity;
    }

    public int get(int key) {
         return (int) super.getOrDefault(key, -1);
//        if (super.containsValue(key)) {
//            this.remove(key);
//            this.put(key, key);
//            return key ;
//        }
//        return -1;
    }

    public void put(int key, int value) {
        super.put(key,value);
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry eldest) {
        return size()>capacity;
    }


}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */