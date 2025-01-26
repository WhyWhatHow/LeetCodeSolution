package leetcode.algorithm.dfs;

import java.util.ArrayList;
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
        List<List<Integer>> lists = sol.combinationSum2Old(new int[]{10, 1, 2, 7, 6, 1, 5}, 8);
        List<List<Integer>> lists2 = sol.combinationSum2(new int[]{10, 1, 2, 7, 6, 1, 5}, 8);

        lists.forEach(System.out::println);
        System.out.println(";;;;;;;;;;;;;;;;;;;;;;;;;");
        lists2.forEach(System.out::println);

//[2,5,2,1,2]
//5
    }

    List<List<Integer>> reslist = new ArrayList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        dfs(0, 0, new LinkedList<Integer>(), target, candidates);
        return reslist;
    }

    private void dfs(int i, int sum, LinkedList<Integer> list, int target, int[] candidates) {
        if (sum == target) {
            reslist.add(new ArrayList<>(list));
            return;
        }
        for (int j = i; j < candidates.length && candidates[j] + sum <= target; j++) {
            if (j > i && candidates[j] == candidates[j - 1]) continue; // remove repeat number , only handle first element val =K .
            list.add(candidates[j]);
            dfs(j + 1, sum + candidates[j], list, target, candidates);
            list.removeLast();
        }
    }


    public List<List<Integer>> combinationSum2Old(int[] candidates, int target) {
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
            if (i > 0 && candidates[i] == candidates[i - 1] && !used[i - 1]) {
                continue;
            }

            used[i] = true;
            sum += candidates[i];
            tempList.push(candidates[i]);
            dfs(used, candidates, res, tempList, target, i + 1, sum);
            sum -= candidates[i];
            used[i] = false;
            tempList.pop();
        }
    }

}


