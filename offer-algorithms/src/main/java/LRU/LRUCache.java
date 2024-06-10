package LRU;

import java.util.Hashtable;
import java.util.Map;

/**
 * @description: hashMap实现, 使用hashmap 的目的是为了将查询节点的时间复杂度从o(n)降o(1)
 * @author: WhyWhatHow
 * @create: 2020-05-03 09:29
 **/
class DLinkedNode {
    String key;
    int value;
    DLinkedNode pre;
    DLinkedNode post;

    @Override
    public String toString() {
        return "DLinkedNode{" +
                "key='" + key + '\'' +
                ", value=" + value ;
    }
}

public class LRUCache {

    private Hashtable<String, DLinkedNode>
            cache = new Hashtable<String, DLinkedNode>();
    private int count;
    private int capacity;
    private DLinkedNode head, tail;

    public LRUCache(int capacity) {
        this.count = 0;
        this.capacity = capacity;

        head = new DLinkedNode();
        head.pre = null;

        tail = new DLinkedNode();
        tail.post = null;

        head.post = tail;
        tail.pre = head;
    }

    void travel() {
        System.out.println("==============================");
        for (Map.Entry<String, DLinkedNode> entry : cache.entrySet()) {

            String key = entry.getKey();
            DLinkedNode value = entry.getValue();
            System.out.println(key + ", " + value);
        }
        System.out.println("========================");
    }

    public int get(String key) {

        DLinkedNode node = cache.get(key);
        if (node == null) {
            return -1; // should raise exception here.
        }

        // move the accessed node to the head;
        this.moveToHead(node);

        return node.value;
    }

    /**
     * 1. 查询是否存在当前元素
     * 1.1. 不存在,判断容量是否满
     * 1.1.1 容量满,则删除末尾元素,再添加元素
     * 1.1.2 容量不满,则直接添加
     * 1.2 存在,则移动到队首位置
     *
     * @param key
     * @param value
     */
    public void set(String key, int value) {
        DLinkedNode node = cache.get(key);

        if (node == null) {
            // 不存在当前节点
            DLinkedNode newNode = new DLinkedNode();
            newNode.key = key;
            newNode.value = value;

            this.cache.put(key, newNode);
            this.addNode(newNode);

            ++count;
            // 队列已满
            if (count > capacity) {
                // pop the tail
                DLinkedNode tail = this.popTail();
                this.cache.remove(tail.key);
                --count;
            }
        } else {
            // update the value.
            node.value = value;
            this.moveToHead(node);
        }
    }

    /**
     * Always add the new node right after head;
     */
    private void addNode(DLinkedNode node) {
        node.pre = head;
        node.post = head.post;

        head.post.pre = node;
        head.post = node;
    }

    /**
     * Remove an existing node from the linked list.
     */
    private void removeNode(DLinkedNode node) {
        DLinkedNode pre = node.pre;
        DLinkedNode post = node.post;

        pre.post = post;
        post.pre = pre;
    }

    /**
     * Move certain node in between to the head.
     */
    private void moveToHead(DLinkedNode node) {
        this.removeNode(node);
        this.addNode(node);
    }

    // pop the current tail.
    private DLinkedNode popTail() {
        DLinkedNode res = tail.pre;
        this.removeNode(res);
        return res;
    }

    public static void main(String[] args) {
        LRUCache lru = new LRUCache(3);
        lru.set("key1", 7);
        lru.travel();
        lru.set("key2", 0);
        lru.travel();
        lru.set("key3", 1);
        lru.travel();
        lru.set("key10", 0);
        lru.travel();
        lru.set("key4", 2);
        lru.travel();
        int key2 = lru.get("key2");
        lru.set("key5", 3);
        lru.travel();
        int key3 = lru.get("key2");
        System.out.println("======================");
        System.out.println(key2 + " ," + key3);
        System.out.println("======================");
        lru.set("key6", 4);
        lru.travel();
    }
}