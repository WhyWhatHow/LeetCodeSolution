package leetcode.algorithm.bfs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

/**
 * @program: LeetCodeSolution
 * @description: #
 * @author: WhyWhatHow
 **/

public class Solution_1345 {

    public static void main(String[] args) {
        Solution_1345 sol = new Solution_1345();
//        HashMap<Integer, Integer> map = new HashMap<>();
//        map.put(1, 1);
//        map.put(1, 2);
//        System.out.println(map.get(1));
        System.out.println(sol.minJumps(new int[]{7,7,2,1,7,7,7,3,4,1}));
        System.out.println("==================");
    }

    /**
     * bfs: 将 idx-1, idx+1, arr[i]==a[j] && i!=j  入队
     * key point: 不要重复入队, 比如 arr[i] ==arr[j] , 因为j 以入队, 切同类型的值已经处理, 所以需要避免大量无用操作.
     *
     * @param arr
     * @return
     */
    public int minJumps(int[] arr) {
        //init
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            if (i + 1 < arr.length && arr[i] == arr[i + 1] && i > 0 && arr[i] == arr[i - 1]) continue;
            map.computeIfAbsent(arr[i], k -> new ArrayList<>()).add(i);
        }
        boolean[] vis = new boolean[arr.length];

        LinkedList<int[]> q = new LinkedList<>(); // int[] idx, step
        q.add(new int[]{0, 0});
        vis[0] = true;
        int res = arr.length + 1;
        while (!q.isEmpty()) {
            int[] poll = q.poll();
            int idx = poll[0];
            int step = poll[1];
            // check
            if (idx == arr.length - 1) {
               res= step;break;
            }
            // add in queue
            if (idx + 1 < arr.length && !vis[idx + 1]) {
                q.add(new int[]{idx + 1, step + 1});
                vis[idx + 1] = true;
            }
            if (idx - 1 >= 0 && !vis[idx - 1]) {
                q.add(new int[]{idx - 1, step + 1});
                vis[idx - 1] = true;
            }


            ArrayList<Integer> list = map.get(arr[idx]);
            if (list != null) {
                for (Integer i : list) {
                    if (!vis[i] && idx != i) {
                        vis[i] = true;
                        q.add(new int[]{i, step + 1});
                    }
                }
                // #important : avoid more invalid ops about `add in queue`.
                map.remove(arr[idx]);
            }

        }
        return res;
    }

}


