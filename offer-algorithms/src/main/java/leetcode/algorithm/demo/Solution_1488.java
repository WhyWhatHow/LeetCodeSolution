package leetcode.algorithm.demo;

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
        int[] ints = sol.avoidFlood2(new int[]{
//                1, 2, 3, 4
//                1, 2, 0, 0, 2, 1
//                1,0,1,0,2,0,2
//                1, 0, 2, 0, 2, 1
//                1, 2, 0, 2, 3, 0, 1
//                1, 0, 2, 3, 0, 1, 2
//                69, 0, 0, 0, 69
                1, 0, 2, 0, 3, 0, 2, 0, 0, 0, 1, 2, 3
        });
        System.out.println(ints);

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


