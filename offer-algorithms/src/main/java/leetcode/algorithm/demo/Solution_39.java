package leetcode.algorithm.demo;

import java.util.*;

/**
 * @program: LeetCodeSolution
 * @description:
 * @author: WhyWhatHow
 **/

public class Solution_39 {

    public static void main(String[] args) {
        Solution_39 sol = new Solution_39();
        System.out.println("==================");
        HashMap<Integer, Integer> map = new HashMap<>();
//        List<List<Integer>> lists = sol.combinationSum(new int[]{2, 3, 6, 7}, 7);
//
//        List<List<Integer>> lists = sol.combinationSum(new int[]{8, 7, 4, 3}, 11);

        List<List<Integer>> lists = sol.combinationSum(new int[]{3, 2, 6, 7}, 11);
        lists.forEach(System.out::println);
    }


    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List res = new LinkedList();
        Arrays.sort(candidates);
        LinkedList tempList = new LinkedList<Integer>();
        dfs(candidates, target, tempList, res, 0);
        return res;
    }


    private void dfs(int[] candidates, int target, LinkedList tempList, List res, int start) {
        if (target < 0) return;  // over value
        if (target == 0) {
            res.add(new ArrayList<Integer>(tempList));
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            target -= candidates[i];
            tempList.push(candidates[i]);
            dfs(candidates, target, tempList, res, i);
            target += candidates[i];
            tempList.pop();
        }
    }

    private boolean check2(List<ArrayList<Integer>> res, LinkedList<Integer> tempList) {
        if (res.size() == 0) {
            return false;
        }
        for (ArrayList<Integer> list : res) {
            if (list.size() == tempList.size()) {
                return true;
            }
        }
        return false;
    }

}