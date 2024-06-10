package leetcode.algorithm.demo;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * @program: LeetCodeSolution
 * @description:
 * @author: WhyWhatHow
 **/

public class Solution_1146 {

    public static void main(String[] args) {
        Solution_1146 sol = new Solution_1146();
        ArrayList list = new ArrayList(2);
        int[] arr;
        arr = new int[4];
        for (int i = 0; i < 2; i++) {
            list.add(0);
            System.out.println(arr[i]);
        }
        list.add(1, 18);
        list.add(0, 20);

        System.out.println("---------------");
        SnapshotArray snapshotArray = new SnapshotArray(2);
        int snap = snapshotArray.snap();
        snapshotArray.set(1, 17);
        snapshotArray.set(0, 20);
        snapshotArray.snap();
        snapshotArray.snap();
        snapshotArray.snap();


        System.out.println("==================");
    }


}


class SnapshotArray {
    // map : 数组下标,index
    // 一 0 为例:
//            0: 第一次操作 0, 0
//              : 第二次: 5, 10
//              : 第三次: 10, 6
    // int[] =>  {snapID, val }

    HashMap<Integer, ArrayList<int[]>> map = new HashMap<>();
    int cnt = 0;
    boolean added = true;

    //    HashMap<Integer,>
    public SnapshotArray(int length) {

        for (int i = 0; i < length; i++) {
            ArrayList<int[]> list = new ArrayList();
            list.add(new int[]{0, 0});
            map.put(i, list);
        }
    }

    public void set(int index, int val) {
        ArrayList<int[]> list = map.get(index);
        list.add(new int[]{cnt, val});
        map.put(index, list);
        added = true;
    }

    public int snap() {
        added = false;
        cnt++;
        return cnt - 1;
    }

    public int get(int index, int snap_id) {
        ArrayList<int[]> list = map.get(index);
        // 找到第一个<= snap_id 的int[]
        int r = list.size() - 1;
        int l = 0, mid;
        int resVal = -1;
        // [l,r]
        while (l <= r) {
            mid = l + ((r - l) >>> 2); // 越界
            if (list.get(mid)[0] <= snap_id) {
                resVal = list.get(mid)[1];

                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }


        return resVal;
    }

}

//
//class SnapshotArray {
//
//    ArrayList<int[]> list = new ArrayList<>();
//    int[] curArr;
//    int[] snapArr; // 存放的snapArr
//    int[] num = new int[50000]; // 记录修改的snap
//    boolean added = true;
//    int cur = 0; // 当前修改数组 snapArr 的下标
//    int cnt = 0;  // num 数组下标
//    int before = 0; // 上一次修改的下标
//
//    public SnapshotArray(int length) {
//        curArr = new int[length];
////            curList = new ArrayList(length);
////            list.add(curList);
//    }
//
//    public void set(int index, int val) {
//        curArr[index] = val;
//        added = true;
//    }
//
//    public int snap() {
//        if (added) { // added-> store arr
//            snapArr = Arrays.copyOf(curArr, curArr.length);
//            list.add(snapArr);
//            added = false;
//            num[cnt] = cur;
//            before = cur;
//            cur++;
//        } else { // -> num[]
//            num[cnt] = before;
//        }
//        cnt++;
//        return cnt - 1;
//    }
//
//    public int get(int index, int snap_id) {
//        int id = num[snap_id];
//        return list.get(id)[index];
//    }
//
//}


