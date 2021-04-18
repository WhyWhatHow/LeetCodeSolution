package leetcode.algorithm;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @program: LeetCodeSolution
 * @description:
 * @author: WhyWhatHow
 * @create: 2020-05-07 12:09
 **/

public class Solution_40 {
    List<List<Integer>> ans = new LinkedList<>();
    LinkedList<Integer> list = new LinkedList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        boolean vis[] = new boolean[candidates.length];
        if (candidates.length == 0 || candidates == null) {
            return ans;
        }
        Arrays.sort(candidates);
//        for (int i = 0; i < candidates.length; i++) {
//            dfs(i,candidates,target);
//        }
//        dfs(0, candidates, target);
        dfs(0, candidates, target, vis);
        return ans;
    }

    private void dfs(int begin, int[] nums, int target, boolean[] vis) {
        if (target == 0) {
            ans.add(new LinkedList<>(list));
            return;
        }
        for (int i = begin; i < nums.length; i++) {
            if (i > begin && nums[i] == nums[i - 1]) continue;
            int temp = target - nums[i];
//            if (temp < 0) break;
            if (temp >= 0) {
                list.add(nums[i]);
//                vis[i] = true;
                dfs(i + 1, nums, temp, vis);
                list.removeLast();
//                vis[i] = false;
            }

        }
    }

    public static void main(String[] args) {
        Solution_40 sol = new Solution_40();
        List<List<Integer>> lists = sol.combinationSum2(new int[]{10, 1, 2, 7, 6, 1, 5}, 8);
        //        List<List<Integer>> lists = sol.combinationSum(new int[]{2, 3, 5}, 8);

        System.out.println(lists.size());
        lists.forEach(x -> System.out.println(x.toString()));


        System.out.println("==================");
    }
}


