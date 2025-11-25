package leetcode.algorithm.dfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @program: LeetCodeSolution
 * @description: #
 * @author: WhyWhatHow
 **/

public class Solution_39 {

    public static void main(String[] args) {
        Solution_39 sol = new Solution_39();
        System.out.println(sol.combinationSum(new int[]{2, 3, 6, 7}, 7));
        System.out.println("==================");
    }

    List<List<Integer>> resList = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        var list = new ArrayList<Integer>(); // store every candidate we chose.
        dfs(candidates, list, 0, target);
        return resList;
    }

    void dfs(int[] nums, List<Integer> list, int st, int tar) {
        if (tar == 0) {
            resList.add(new ArrayList<>(list));
            return;
        }
        for (int i = st; i < nums.length; i++) {
            if (nums[i] >tar  ) break;
            list.add(nums[i]);
            dfs(nums, list, i, tar - nums[i]);
            list.removeLast();
        }
    }

}


