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

public class Solution_47 {
    /**
     * 加一个 hashset 去掉重复排序的东西, 不成立
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> resList = new LinkedList<>();
        if (nums.length == 0) {
            return resList;
        }
        Arrays.sort(nums);
        boolean[] vis = new boolean[nums.length];
        List<Integer> list = new LinkedList<>();// 模拟栈, 弹出最后一个访问的元素
        dfs(0, nums, vis, list, resList);
        return resList;
    }

    private void dfs(int x, int[] nums, boolean[] vis, List<Integer> list, List<List<Integer>> resList) {
        if (x == nums.length) {
            resList.add(new LinkedList<>(list));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            //1. 去重 只处理第一个节点,
            if (i > 0 && nums[i] == nums[i - 1] && !vis[i - 1]) {// 只处理第一次出现的节点值, 1,1,2 只处理第一个1
                continue;
            }
            if (vis[i]) {
                continue;
            }//2. 标记元素,避免重复加入队列
            vis[i] = true;
            list.add(nums[i]);
            dfs(x + 1, nums, vis, list, resList);
            list.remove(list.size() - 1);// 移除队尾元素
            vis[i] = false;
        }
    }

    public static void main(String[] args) {
        Solution_47 sol = new Solution_47();
        List<List<Integer>> lists = sol.permuteUnique(new int[]{
//                1, 1, 2
        3,3,0,3
        });
        System.out.println("==================");
    }
}


