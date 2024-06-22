package leetcode.algorithm.dfs;

import java.util.HashSet;

/**
 * @program: LeetCodeSolution
 * @description: # dfs
 * @author: WhyWhatHow
 **/

public class Solution_1306 {

    public static void main(String[] args) {
        Solution_1306 sol = new Solution_1306();
        System.out.println(sol.canReach(new int[]{
//                        4, 2, 3, 0, 3, 1, 2
                        3, 0, 2, 1, 2
                },
//                5
//                0
                2
        ));
        System.out.println("==================");
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


