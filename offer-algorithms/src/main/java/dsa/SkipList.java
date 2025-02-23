package dsa;

import java.util.Random;

/**
 * 跳表（SkipList）完整实现
 */
class SkipListNode {
    int value;
    SkipListNode[] next; // 每层的后继节点指针数组

    public SkipListNode(int value, int level) {
        this.value = value;
        this.next = new SkipListNode[level + 1]; // 包含从0到level的层级
    }
}

public class SkipList {
    private static final double P = 0.5;
    private static final int MAX_LEVEL = 16;    // 最大允许层数
    private SkipListNode head = new SkipListNode(Integer.MIN_VALUE, MAX_LEVEL); // 头节点（哑节点）
    private Random random = new Random();

    int getLevel() {
        int level = 0;
        while (level < MAX_LEVEL && random.nextDouble() < P) level++;
        return level;
    }

    boolean search(int target) {
        SkipListNode cur = head;
        for (int i = cur.next.length - 1; i >= 0; i--) {
//            in Level_i , go to  <target 
            while (cur.next[i] != null && cur.next[i].value < target) cur = cur.next[i];
        }
        // <target max, 
        cur = cur.next[0];
        return cur == null && cur.value == target;
    }

    void insert(int num) {
        SkipListNode cur = head;
        int level = getLevel();
        SkipListNode node = new SkipListNode(num, level);
        for (int i = cur.next.length - 1; i >= 0; i--) {
            // in level i ,go to <num
            while (cur.next[i] != null && cur.next[i].value < num) cur = cur.next[i];
            if (i > level) continue;
            // add node to level
            node.next[i] = cur.next[i];
            cur.next[i] = node;
        }

    }

    boolean delete(int num) {
        SkipListNode cur = head;
        boolean yes = false;
        SkipListNode tmp;
        for (int i = cur.next.length - 1; i >= 0; i--) {
            // in level_i , goto max position  < num
            while (cur.next[i] != null && cur.next[i].value < num) cur = cur.next[i];

            if (cur.next[i] != null && cur.next[i].value == num) {
                yes = true;
                tmp = cur.next[i];
                cur.next[i] = tmp.next[i];
            }

        }
        return yes;
    }

    /**
     * 打印跳表结构（调试用）
     */
    public void display() {
        System.out.println("\n***** Skip List *****");
        for (int i = MAX_LEVEL; i >= 0; i--) {
            if(head.next[i]==null) continue;
            System.out.print("Level " + i + ": ");
            SkipListNode node = head.next[i];
            while (node != null) {
                System.out.print(node.value + " ");
                node = node.next[i];
            }
            System.out.println();
        }
    }

    /**
     * 测试用例
     */
    public static void main(String[] args) {
        SkipList skipList = new SkipList();

        // 插入测试
        for (int i = 0; i < 20; i++) {
            skipList.insert(i);
            skipList.display();
        }
        // 搜索测试
        System.out.println("\nSearch 6: " + skipList.search(6)); // true
        System.out.println("Search 8: " + skipList.search(8));   // false

        // 删除测试
        System.out.println("\nDelete 6: " + skipList.delete(6)); // true
        System.out.println("Delete 5: " + skipList.delete(5));   // false
        skipList.display();
    }


}