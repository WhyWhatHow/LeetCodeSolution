package leetcode.algorithm.dfs;

import java.util.ArrayList;
import java.util.HashSet;

/**
 * @program: LeetCodeSolution
 * @description: # dfs
 * @author: WhyWhatHow
 **/

public class Solution_1306 {

    public static void main(String[] args) {
        Solution_1306 sol = new Solution_1306();
        System.out.println(sol.canReach20260517(
//                new int[]{
////                        4, 2, 3, 0, 3, 1, 2
//                        3, 0, 2, 1, 2
//                },
////                5
////                0
//                2
                new int[]{4, 2, 3, 0, 3, 1, 2},
                5
        ));
        System.out.println("==================");
    }


    public boolean canReach20260517(int[] arr, int start) {

        int n = arr.length;
        boolean[] v = new boolean[n];
        var q = new ArrayList<Integer>();
        q.add(start);
        v[start] = true;
        if (arr[start] == 0) return true;
        while (!q.isEmpty()) {
            var i = q.removeFirst();
            // i+arr[i]
            int r = i + arr[i];
            if (r < n && !v[r]) {
                if (arr[r] == 0)
                    return true;
                q.add(r);
                v[r] = true;
            }
            // i-arr[i]
            int l = i - arr[i];
            if (l >= 0 && !v[l]) {
                if (arr[l] == 0)
                    return true;
                q.add(l);
                v[l] = true;
            }
        }
        return false;
    }

    boolean res = false;

    public boolean canReach(int[] arr, int start) {
        HashSet<Integer> set = new HashSet<>();
        set.add(start);
        dfs(arr, start, set);
        return res;
    }

    private void dfs(int[] arr, int start, HashSet<Integer> set) {
        // boarder check
        if (start < 0 || start >= arr.length)
            return;

        if (arr[start] == 0) {
            res = true;
            return;
        }
        if (res) return;

        //
        int right = start + arr[start];
        int left = start - arr[start];
        if (!set.contains(right)) {
            set.add(right);
            dfs(arr, right, set);
            set.remove(right);
        }
        if (!set.contains(left)) {
            set.add(left);
            dfs(arr, left, set);
            set.remove(left);
        }
    }

}


