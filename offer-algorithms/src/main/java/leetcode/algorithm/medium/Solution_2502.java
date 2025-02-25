package leetcode.algorithm.medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @program: LeetCodeSolution
 * @description: #
 * @author: WhyWhatHow
 **/

public class Solution_2502 {

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>(3);
        Solution_2502 sol = new Solution_2502();
        Allocator allocator = new Allocator(5);
        allocator.allocate(5, 8);
        ///////////////////////////////
//        Allocator loc = new Allocator(10); // 初始化一个大小为 10 的内存数组，所有内存单元都是空闲的。
//        loc.allocate(1, 1); // 最左侧的块的第一个下标是 0 。内存数组变为 [1, , , , , , , , , ]。返回 0 。
//        loc.allocate(1, 2); // 最左侧的块的第一个下标是 1 。内存数组变为 [1,2, , , , , , , , ]。返回 1 。
//        loc.allocate(1, 3); // 最左侧的块的第一个下标是 2 。内存数组变为 [1,2,3, , , , , , , ]。返回 2 。
//        loc.freeMemory(2); // 释放 mID 为 2 的所有内存单元。内存数组变为 [1, ,3, , , , , , , ] 。返回 1 ，因为只有 1 个 mID 为 2 的内存单元。
//        loc.allocate(3, 4); // 最左侧的块的第一个下标是 3 。内存数组变为 [1, ,3,4,4,4, , , , ]。返回 3 。
//        loc.allocate(1, 1); // 最左侧的块的第一个下标是 1 。内存数组变为 [1,1,3,4,4,4, , , , ]。返回 1 。
//        loc.allocate(1, 1); // 最左侧的块的第一个下标是 6 。内存数组变为 [1,1,3,4,4,4,1, , , ]。返回 6 。
//        loc.freeMemory(1); // 释放 mID 为 1 的所有内存单元。内存数组变为 [ , ,3,4,4,4, , , , ] 。返回 3 ，因为有 3 个 mID 为 1 的内存单元。
//        loc.allocate(10, 2); // 无法找出长度为 10 个连续空闲内存单元的空闲块，所有返回 -1 。
//        loc.freeMemory(7); // 释放 mID 为 7 的所有内存单元。内存数组保持原状，因为不存在 mID 为 7 的内存单元。返回 0 。

        System.out.println("==================");
    }


}

class Allocator {
    int[] mem;
    // 维护freeSpace 的最大空间
    PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> // int[]=>{startId, len}
    {
        if (a[0] != b[0]) return a[0] - b[0];
        else if (a[1] != b[1]) return b[1] - a[1];
        else return 0;
    });


    public Allocator(int n) {
        mem = new int[n];
        pq.add(new int[]{0, n});
    }

    List<int[]> tmpList = new LinkedList<>();

    public int allocate(int size, int mID) {
        // find idx can handle this
        boolean yes = false;
        while (!pq.isEmpty()) {
            if (pq.peek()[1] >= size) {
                yes = true;
                break;
            }
            tmpList.add(pq.poll());
        }
        if (!yes) {
            while (!tmpList.isEmpty()) {
                pq.add(tmpList.removeLast());
            }
            return -1;
        }
        //
        int[] peek = pq.poll();
        int st = peek[0];
        for (int i = st; i < st + size; i++) {
            mem[i] = mID;
        }


        pq.add(new int[]{st + size, peek[1] - size});
        while (!tmpList.isEmpty()) {
            pq.add(tmpList.removeLast());
        }
        return st;
    }

    public int freeMemory(int mID) {
        int len = 0;
        // clean
        for (int i = 0; i < mem.length; i++) {
            if (mem[i] == mID) {
                mem[i] = 0;
                len++;
            }
        }
        pq.clear();
        int st = -1, cnt = 0;
        for (int i = 0; i < mem.length; i++) {
            if (mem[i] == 0) {
                if (st == -1) st = i;
                cnt++;
            } else {
                if (st == -1) continue;
                pq.add(new int[]{st, cnt});
                st = -1;
                cnt = 0;
            }
        }
        if (st != -1) pq.add(new int[]{st, cnt});

        return len;


    }
}

/**
 * Your Allocator object will be instantiated and called as such:
 * Allocator obj = new Allocator(n);
 * int param_1 = obj.allocate(size,mID);
 * int param_2 = obj.freeMemory(mID);
 */