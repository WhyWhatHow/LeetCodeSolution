package leetcode.algorithm.design;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * @program: LeetCodeSolution
 * @description: #
 * @author: WhyWhatHow
 **/

public class Solution_3508 {

    public static void main(String[] args) {
        Solution_3508 sol = new Solution_3508();
        Router router = new Router(2);
        router.addPacket(4, 2, 1);
//        router.forwardPacket();
//        router.addPacket(3,2,1);
        router.getCount(2, 3, 3);
//        Router router = new Router(3); // 初始化路由器，内存限制为 3。
//        router.addPacket(1, 4, 90); // 数据包被添加，返回 True。
//        router.addPacket(2, 5, 90); // 数据包被添加，返回 True。
//        router.addPacket(1, 4, 90); // 这是一个重复数据包，返回 False。
//        router.addPacket(3, 5, 95); // 数据包被添加，返回 True。
//        router.addPacket(4, 5, 105); // 数据包被添加，[1, 4, 90] 被移除，因为数据包数量超过限制，返回 True。
//        router.forwardPacket(); // 转发数据包 [2, 5, 90] 并将其从路由器中移除。
//        router.addPacket(5, 2, 110); // 数据包被添加，返回 True。
//        router.getCount(5, 100, 110); // 唯一目标地址为 5 且时间在 [100, 110] 范围内的数据包是 [4, 5, 105]，返回 1。
        System.out.println("==================");
    }


}


class Router {
    HashMap<Integer, Integer> map = new HashMap<>(); // key : source<<14| destination  , val : timestamp

    //对于 addPacket 的查询会按照 timestamp 的递增顺序进行。 递增, 直接ArrayList+ binarysearch就解决了.
    HashMap<Integer, ArrayList<Integer>> dmap = new HashMap<>(); // key : destination, val:{ timestamp ,cnt };
    ArrayDeque<int[]> q = new ArrayDeque<int[]>();
    int memoryLimit;

    public Router(int memoryLimit) {
        this.memoryLimit = memoryLimit;// top
    }

    public boolean addPacket(int source, int destination, int timestamp) {
        // check key
        int key = (source << 14) | destination;
        // check map has same packet
        if (map.getOrDefault(key, -1) == timestamp) {
            return false;
        }
        if (q.size() >= memoryLimit) forwardPacket();
        return doAdd(source, destination, timestamp, key);
//        if (q.size() < memoryLimit) {
//            // add package
//            return doAdd(source, destination, timestamp, key);
//        } else {
//            forwardPacket();
//            return doAdd(source, destination, timestamp, key);
//        }
    }

    private boolean doAdd(int source, int destination, int timestamp, int key) {

        q.add(new int[]{source, destination, timestamp});
        map.put(key, timestamp);

        // add to destinationMap
        var list = dmap.getOrDefault(destination, new ArrayList<>());
        list.add(timestamp);
        dmap.put(destination, list);
        return true;
    }

    public int[] forwardPacket() {
        if (q.isEmpty()) return new int[0];
        int[] ints = q.pop();
        int key = (ints[0] << 14) | ints[1];
        if (map.getOrDefault(key, -1) == ints[2]) {
            map.remove(key);
        }
        // remove destinationMap
        var list = dmap.get(ints[1]);
        int i = binarySearch(list, ints[2]);
        list.remove(i);
        dmap.put(ints[1], list);
        return ints;
    }

    // return idx of list.
    private int binarySearch(ArrayList<Integer> list, int tar) {
        int l = 0, r = list.size() - 1;
        int res = -1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (list.get(mid) == tar) {
                res = mid;
                break;
            } else if (list.get(mid) > tar) {
                r = mid - 1;
            } else l = mid + 1;
        }
        return res;
    }

    public int getCount(int destination, int startTime, int endTime) {
        ArrayList<Integer> list = dmap.get(destination);
        if (list == null || list.isEmpty()) return 0;
        // find >=startTime  1st ==> <=startTime+1,
        int l = ceilSearch(list, startTime);
        if (l == -1) return 0;
        int r = floorSearch(list, endTime);
        return r - l + 1;
    }

    // return 1st >=tar , index
    private int ceilSearch(ArrayList<Integer> list, int tar) {
        int l = 0, r = list.size() - 1;
        int res = -1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            int mv = list.get(mid);
            if (mv >= tar) {
                res = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return res;
    }

    private int floorSearch(ArrayList<Integer> list, int tar) {
        int l = 0, r = list.size() - 1;
        int res = -1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            int mv = list.get(mid);
            if (mv <= tar) {
                res = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return res;
    }
}

/**
 * Your Router object will be instantiated and called as such:
 * Router obj = new Router(memoryLimit);
 * boolean param_1 = obj.addPacket(source,destination,timestamp);
 * int[] param_2 = obj.forwardPacket();
 * int param_3 = obj.getCount(destination,startTime,endTime);
 */