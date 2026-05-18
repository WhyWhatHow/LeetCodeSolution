package leetcode.algorithm.bfs;

import java.util.*;

/**
 * @program: LeetCodeSolution
 * @description: #
 * @author: WhyWhatHow
 **/

public class Solution_1345 {

    public static void main(String[] args) {
        Solution_1345 sol = new Solution_1345();
//        HashMap<Integer, Integer> map = new HashMap<>();
//
//        map.put(1, 1);
//        map.put(1, 2);
//        System.out.println(map.get(1));
        System.out.println(sol.minJumps20260518(
//                new int[]{7,7,2,1,7,7,7,3,4,1}
//                new int[]{100,-23,-23,404,100,23,23,23,3,404}
                new int[]{}
        ));
        System.out.println("==================");
    }

    // use bfs
    public int minJumps20260518(int[] arr) {
        int n = arr.length;

        // use map to store the elements have same val.
        var map = new HashMap<Integer, Set<Integer>>(); // key : arr[i], val : list.of(i)
        for (int i = 0; i < n; i++) {
            // opt
            map.computeIfAbsent(arr[i], k -> new TreeSet<>()).add(i);
        }

        var q = new ArrayDeque<int[]>(); // i , cnt
        q.add(new int[]{0, 0});
        boolean[] v = new boolean[n];
        v[0] = true;
        while (!q.isEmpty()) {
            var a = q.poll();
            int cnt = a[1], i = a[0];
            if (i == n - 1)
                return cnt;

            // handle i+1, i-1 #opt
            for (var j : new int[]{i - 1, i + 1}) {
                if (j >= 0 && j < n && !v[j]) {
                    q.add(new int[]{j, cnt + 1});
                    v[j] = true;
                }
            }

            // handle set have same val
            var set = map.getOrDefault(arr[i], new TreeSet<>());
            for (var j : set) {
                if (!v[j]) {
                    q.add(new int[]{j, cnt + 1});
                    v[j] = true;
                }
            }

            map.remove(arr[i]);
        }
        return -1;

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
                res = step;
                break;
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


