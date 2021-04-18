package leetcode.algorithm;

import java.util.ArrayList;

import java.util.LinkedList;
import java.util.List;

/**
 * @program: LeetCodeSolution
 * @description:
 * @author: WhyWhatHow
 * @create: 2020-05-07 12:09
 **/

public class Solution_39 {

    List<List<Integer>> ans = new LinkedList<>();
    LinkedList<Integer> list = new LinkedList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if (candidates.length == 0 || candidates == null) {
            return ans;
        }
//        for (int i = 0; i < candidates.length; i++) {
//            dfs(i,candidates,target);
//        }
//        dfs(0, candidates, target);
        dfs(0, candidates, target);
        return ans;
    }

    /**
     *                     7
     *   -2 (5) |                     -3(4) |    -6(1) |    -7(0)
     *   -2(3),         -3(2),-6(-1),-7(-2) | -3(1),...| -6(-5) |     结束
     *   -2(1),-3(0),..|-3(-1),...| ...|...|...
     *   -2(-1)...|end |...|
     * @param begin 处理target 的开始位置
     * @param nums
     * @param target
     * 自己动手画一下,就明白了,
     */
    private void dfs(int begin, int[] nums, int target) {
        if (target == 0) {
            ans.add(new LinkedList<>(list));
            return;
        }


        for (int i = begin; i < nums.length; i++) {
            int temp = target - nums[i];
            if (0 <= temp) {
                list.add(nums[i]);
                // begin =i : 目的是为了去重(原因是,不加begin,会有重复:重复的原因 -存在大量的重复删除操作( -3,然后-2 ,是不应该存在的))
                dfs(i, nums, temp);
                list.removeLast();
            }
        }

    }
//
//    private void dfs(int idx, int[] candidates, int target) {
//        // 递归出口
//        if (target <= 0 || idx == candidates.length) {
//            if (target == 0) {
//                ans.add(new ArrayList<>(list));
//            }
//            return;
//        }
//        for (int i = 0; i < candidates.length; i++) {
//            // 状态加
//            list.add(candidates[i]);
//            dfs(i , candidates, target - candidates[i]);
//            // 回复状态
//            list.removeLast();
//            dfs(idx, candidates, target);
//        }
//
//    }

    public static void main(String[] args) {
        Solution_39 sol = new Solution_39();
        List<List<Integer>> lists = sol.combinationSum(new int[]{2, 3, 6, 7}, 7);
//        List<List<Integer>> lists = sol.combinationSum(new int[]{2, 3, 5}, 8);

        System.out.println(lists.size());
        lists.forEach(x -> System.out.println(x.toString()));


        System.out.println("==================");
    }
}


