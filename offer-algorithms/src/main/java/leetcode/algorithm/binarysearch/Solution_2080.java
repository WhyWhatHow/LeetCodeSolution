package leetcode.algorithm.binarysearch;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.TreeMap;

/**
 * @program: LeetCodeSolution
 * @description: #
 * @author: WhyWhatHow
 **/

public class Solution_2080 {

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>(3);
        Solution_2080 sol = new Solution_2080();
//        [[[1,1,1,2,2]],[0,1,2],[0,2,1],[3,3,2],[2,2,1]]
        RangeFreqQuery r = new RangeFreqQuery(new int[]{
                1, 1, 1, 2, 2
        });
        r.query(0, 1, 2);
        r.query(0, 2, 1);
        r.query(3, 3, 2);
        r.query(2, 2, 1);
        System.out.println("==================");
    }


}

class RangeFreqQuery {

    HashMap<Integer, ArrayList<Integer>> map = new HashMap<>(); // {key :queryValue, value: list[] of index , asc)

    public RangeFreqQuery(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int finalI = i;
            map.compute(arr[i], (k, v) -> {
                if (v == null) {
                    ArrayList<Integer> list = new ArrayList<>();
                    list.add(finalI);
                    v = list;
                } else {
                    v.add(finalI);
                }
                return v;
            });
        }
    }


    public int query(int left, int right, int value) {
        ArrayList<Integer> list = map.get(value);
        if (list == null || list.size() == 0) return 0;
        // search(left-1) means `<=left-1`'s maxVal, maxVal+1 ==means `>=left`'s min value.
        int ll = search(list, left-1 )+1;
        int rr = search(list, right);
        if(ll<0 || rr<0) return 0 ;
        return rr - ll + 1;
    }

    // ps:  <target == <= target-1;
    // Return val <=target  index
    private int search(ArrayList<Integer> list, int target) {
        int l = 0, r = list.size() - 1;
        int mid, res = -1;
        while (l <= r) {
            mid = l + (r - l) / 2;
            if (list.get(mid) <= target) {
                l = mid + 1;
                res = mid;
            } else {
                r = mid - 1;
            }
        }
        return res;
    }
}

class RangeFreqQueryTreeMap {
    HashMap<Integer, TreeMap<Integer, Integer>> map = new HashMap<>(); // {key :queryValue, value: list[] of index , asc)

    public RangeFreqQueryTreeMap(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int finalI = i;
            map.compute(arr[i], (k, v) -> {
                if (v == null) {
                    TreeMap<Integer, Integer> map = new TreeMap<>();
                    map.put(finalI, 1);
                    v = map;
                } else {
                    v.put(finalI, v.size() + 1);
                }
                return v;
            });
        }
    }

    public int query(int left, int right, int value) {
        TreeMap<Integer, Integer> mm = map.get(value);
        if (mm == null || mm.size() == 0) return 0;
        Integer ck = mm.ceilingKey(left);
        if (ck == null || ck > right) return 0;
        Integer l = mm.get(ck);
        Integer fk = mm.floorKey(right);
        if (fk == null || fk < left) return 0;
        Integer r = mm.get(fk);
        return r - l + 1;

    }
}
