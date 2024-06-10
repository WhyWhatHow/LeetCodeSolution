package leetcode.algorithm.demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @program: LeetCodeSolution
 * @description: #backtracking
 * @author: WhyWhatHow
 **/

public class Solution_090 {

    public static void main(String[] args) {
        Solution_090 sol = new Solution_090();
        List<List<Integer>> lists = sol.subsetsWithDup(new int[]{1, 2, 2});

        System.out.println("==================");
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {

        List res = new LinkedList();
        Arrays.sort(nums);
        LinkedList list = new LinkedList();
//        HashSet set = new HashSet();
        dfs(nums, res, list, 0);

//        res = (List) set.stream().collect(Collectors.toList());
//        dfs(nums, res, list, 0);
        return res;
    }

    private void dfs(int[] nums, List res, LinkedList<Integer> list, int start) {


        res.add(new ArrayList<>(list));
        for (int i = start; i < nums.length; i++) {
            // 处理重复元素：仅生成包含第一个重复元素的新子集，跳过后续重复元素
            if (i > start && nums[i] == nums[i - 1]) {
                continue;
            }

            list.add(nums[i]);
            dfs(nums, res, list, i + 1);
            list.pop();
        }
    }
}


