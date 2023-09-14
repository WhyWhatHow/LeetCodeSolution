package leetcode.algorithm.demo;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @program: LeetCodeSolution
 * @description:
 * @author: WhyWhatHow
 **/

public class Solution_40 {

    public static void main(String[] args) {
        Solution_40 sol = new Solution_40();
        System.out.println("==================");
        List<List<Integer>> lists = sol.combinationSum2(new int[]{10, 1, 2, 7, 6, 1, 5}, 8);
        lists.forEach(System.out::println);
//[2,5,2,1,2]
//5
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List res = new LinkedList();
        LinkedList<Integer> tempList = new LinkedList<>();
        Arrays.sort(candidates);
        boolean used[] = new boolean[candidates.length];
        dfs(used, candidates, res, tempList, target, 0, 0);

        return res;
    }

    private void dfs(boolean[] used, int[] candidates, List res, LinkedList<Integer> tempList, int target, int start, int sum) {
        if (target == sum) {
            res.add(new LinkedList<>(tempList));
            return;
        }

        for (int i = start; i < candidates.length && sum + candidates[i] <= target; i++) {

            // remove same element in same level
            if (i > 0 && candidates[i] == candidates[i - 1]  && !used[i - 1]) {
                continue;
            }

            used[i] = true;
            sum += candidates[i];
            tempList.push(candidates[i]);
            dfs(used, candidates, res, tempList, target, i +1, sum);
            sum -= candidates[i];
            used[i] = false;
            tempList.pop();
        }
    }

}


