package leetcode.algorithm.demo;

import java.util.LinkedList;
import java.util.List;

/**
 * @program: LeetCodeSolution
 * @description:
 * @author: WhyWhatHow
 **/

public class Solution_216 {

    public static void main(String[] args) {
        Solution_216 sol = new Solution_216();
        System.out.println("==================");
        List<List<Integer>> lists = sol.combinationSum3(9, 45);
        lists.forEach(System.out::println);
    }

    boolean[] vis = new boolean[60];

    public List<List<Integer>> combinationSum3(int k, int n) {
        List res = new LinkedList<List>();

        LinkedList<Integer> tempList = new LinkedList<Integer>();
        dfs(1, k, n, tempList, res);
        return res;
    }

    void dfs(int start, int k, int n, LinkedList<Integer> tempList, List res) {
        if (n < 0) { // over value
            return;
        }
        if (tempList.size() == k && n == 0) {
            res.add(new LinkedList<>(tempList));
            return;
        }
        for (int i = start; i <= 9; i++) {
            tempList.push(i);
            n -= i;
            dfs(i + 1, k, n, tempList, res);
            Integer pop = tempList.pop();
            n += i;
        }
    }
}


