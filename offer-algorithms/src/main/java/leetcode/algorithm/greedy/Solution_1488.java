package leetcode.algorithm.greedy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.TreeSet;

/**
 * @program: LeetCodeSolution
 * @description:
 * @author: WhyWhatHow
 **/

public class Solution_1488 {

    public static void main(String[] args) {
        Solution_1488 sol = new Solution_1488();

        TreeSet<Integer> set = new TreeSet<>();

        set.add(1);
        set.add(4);
        set.add(3);
        Integer ceiling = set.ceiling(2);
        System.out.println("==================");
//        int[] ints = sol.avoidFlood2(new int[]{
        int[] ints = sol.avoidFloodIn20251007(new int[]{
//                1, 2, 3, 4
                1, 2, 0, 0, 2, 1
//                1,0,1,0,2,0,2
//                1, 0, 2, 0, 2, 1
//                1, 2, 0, 2, 3, 0, 1
//                1, 0, 2, 3, 0, 1, 2
//                69, 0, 0, 0, 69
//                1, 0, 2, 0, 3, 0, 2, 0, 0, 0, 1, 2, 3
        });
        System.out.println(ints);

    }

    // greedy : 对于会发生flood 的lake,假设它的下雨天分别是day1,day2, 只需要在[day1+1,day2-1] 找到任意一个不下雨的天把其抽干即可,这里选择第一个>day1 且不下雨的天进行抽水.
    public int[] avoidFloodIn20251007(int[] rains) {
        int n = rains.length;
        int[] ans = new int[n];
        Arrays.fill(ans, -1);
        var set = new TreeSet<Integer>(); //  days
        HashMap<Integer, Integer> map = new HashMap<>(); // key : lake_num , val : day
        boolean yes = true;
        for (int i = 0; i < rains.length; i++) {
            if (rains[i] == 0) {
                set.add(i);
                continue;
            }
            if (map.containsKey(rains[i])) { // repeat -> if we can't handle it, no answer.
                Integer day = map.get(rains[i]);
                Integer idx = set.ceiling(day);
                if (idx == null) {
                    yes = false;
                    break;
                }
                set.remove(idx);
                ans[idx] = rains[i];

            }
            map.put(rains[i], i);
        }
        while (!set.isEmpty()) {
            ans[set.pollFirst()] = 1;
        }

        return yes ? ans : new int[]{};
    }


    public int[] avoidFlood2(int[] rains) {
        int[] ans = new int[rains.length];
        Arrays.fill(ans, -1);
        TreeSet<Integer> set = new TreeSet<>(); // val: rains[i] == 0
        HashMap<Integer, Integer> map = new HashMap<>(); // key : rains[i] ,val: i
        boolean finished = true;

        for (int i = 0; i < rains.length; i++) {
            if (rains[i] == 0) {
                set.add(i);
                continue;
            }
            if (map.containsKey(rains[i])) {
                Integer idx = set.ceiling(map.get(rains[i])); //
                if (idx == null) {  //
                    finished = false;
                    break;
                }
                ans[idx] = rains[i];
                set.remove(idx);
                //                map.remove(rains[i]); // don't need remove, cause it will be replaced soon.
            }
            map.put(rains[i], i);

        }
        while (!set.isEmpty()) {
            ans[set.pollFirst()] = 1;
        }
        return finished ? ans : new int[]{};

    }


    public int[] avoidFlood(int[] rains) {
        int[] ans = new int[rains.length];
        Arrays.fill(ans, -1);
        LinkedList<Integer> list = new LinkedList<>();
        LinkedList<Integer> zeroList = new LinkedList<>(); //  rains[i] == 0
        HashMap<Integer, Integer> map = new HashMap<>(); // key: rains[i] , value: i
        int cnt = 0;
        boolean finished = true;
//        1, 0, 2, 3, 0, 1, 2
        for (int i = 0; i < rains.length; i++) {
            if (rains[i] == 0) {
                if (map.isEmpty()) ans[i] = 1;
//                if (list.isEmpty()) ans[i] = 1;
                else {
                    zeroList.add(i);
                }
                continue;
            }
            if (map.containsKey(rains[i])) {  //
                int val = map.get(rains[i]);
                int[] pos = getPosition(zeroList, val);

                if (pos != null) {
                    Integer zeroI = zeroList.remove(pos[1]);
                    list.remove(rains[i]);
                    ans[zeroI] = rains[i];
                    map.remove(rains[i]);
                } else {
                    finished = false;
                    break;
                }
            } else {
                map.put(rains[i], i);
                list.add(rains[i]);
            }
        }

        // dry any lake
        while (!zeroList.isEmpty()) ans[zeroList.poll()] = 1;

        return finished ? ans : new int[]{};
    }

    // return the first index >= target
    private int[] getPosition(LinkedList<Integer> zeroList, int target) {
        for (int i = 0; i < zeroList.size(); i++) {

            if (target <= zeroList.get(i)) {
                return new int[]{zeroList.get(i), i};
            }
        }
        return null;
    }
}


