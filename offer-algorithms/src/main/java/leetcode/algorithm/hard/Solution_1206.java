package leetcode.algorithm.hard;

import java.util.ArrayList;
import java.util.Random;

/**
 * @program: LeetCodeSolution
 * @description: #
 * @author: WhyWhatHow
 **/

public class Solution_1206 {

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>(3);
        Solution_1206 sol = new Solution_1206();

        Skiplist sl = new Skiplist();
        sl.add(1);
        sl.add(2);
        sl.add(3);
        sl.search(0);
        sl.add(4);
        sl.search(1);   // 返回 true
        sl.erase(0);    // 返回 false，0 不在跳表中
        sl.erase(1);    // 返回 true
        sl.search(1);
        System.out.println("==================");
    }


}

class SkiplistNode {

    SkiplistNode[] next;// 每一层下一个节点指针
    Integer value;

    public SkiplistNode( int value,int level) {
        this.value = value;
        this.next = new SkiplistNode[level + 1]; // start at 0
    }
}

class Skiplist {
    static final double P = 0.5;
    static final int MAX_LEVEL = 16; //
    SkiplistNode head = new SkiplistNode(Integer.MIN_VALUE, MAX_LEVEL);
    Random random = new Random();

    // count ever entry's maxlevel
    int getRandomLevel() {
        int level = 0;
        while (level < MAX_LEVEL && random.nextDouble() < P) {
            level++;
        }
        return level;
    }

    public Skiplist() {

    }

    public boolean search(int target) {
        SkiplistNode cur = head;
        // top -> bottom
        for (int i = cur.next.length - 1; i >= 0; i--) {
            // in level_i,  find <target  max position.
            while (cur.next[i] != null && cur.next[i].value < target) cur = cur.next[i];
            // else move level_i-1
        }

        // in level_0, check cur.next[0] == target .
        cur = cur.next[0];
        return cur != null && cur.value == target;
    }

    public void add(int num) {
        int newLevel = getRandomLevel();
        SkiplistNode cur = head;
        SkiplistNode node = new SkiplistNode( num,newLevel);
        for (int i = cur.next.length - 1; i >= 0; i--) {
            // level_i , <num  position
            while (cur.next[i] != null && cur.next[i].value < num) cur = cur.next[i];
            if (i > newLevel) continue;
            // In level_i , insert num;
            node.next[i] = cur.next[i];
            cur.next[i] = node;
        }
    }

    // remove first ele's value = num
    public boolean erase(int num) {
        boolean yes =false ;
        SkiplistNode cur = head;

        for (int i = cur.next.length - 1; i >= 0; i--) {

            while (cur.next[i] != null && cur.next[i].value < num) cur = cur.next[i];

            if (cur.next[i]!=null && cur.next[i].value == num) {
                yes =true;
                SkiplistNode tmp = cur.next[i];
                cur.next[i] =tmp.next[i];
            }
        }
        return yes;
    }
}