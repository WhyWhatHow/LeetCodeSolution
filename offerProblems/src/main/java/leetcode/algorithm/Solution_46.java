package leetcode.algorithm;

import java.util.*;

/**
 * @program: LeetCodeSolution
 * @description:
 * @author: WhyWhatHow
 * @create: 2020-05-07 12:09
 **/

public class Solution_46 {
    List<List<Integer>> resList = new LinkedList();
    int[] temp;

    /**
     * 节点交换
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> permute1(int[] nums) {
        if (nums.length == 1) {
            LinkedList<Integer> list = new LinkedList<>();
            list.push(nums[0]);
            resList.add(list);
            return resList;
        }
        temp = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            temp[i] = nums[i];
        }
        dfs(0, nums);
        return resList;
    }

    private void dfs(int x, int[] nums) {
        if (x == nums.length - 1) {
            List list = new LinkedList();
            for (int i : temp) {
                list.add(i);
            }
            resList.add(list);
            return;
        }
        HashSet<Integer> set = new HashSet<>();
        for (int i = x; i < temp.length; i++) {
            if (set.contains(temp[i])) {
                continue;
            }
            set.add(temp[i]);
            swap(i, x);
            dfs(x + 1, nums);
            swap(i, x);
        }
    }

    private void swap(int i, int x) {
        int temps = temp[i];
        temp[i] = temp[x];
        temp[x] = temps;
    }

    /**
     * 回溯,+ 打标记
     *  以[1,2,3] 数组为例:
     *   一次访问 1,2,3
     *      访问1: 1->2->3: vis{ true, ->true, ->true }
     *      访问2; 1->3->2:
     *          3: 2->1->3:
     *          4: 2->3->1;
     *          5: 3->1->2:
     *          6: 3->2->1;
     * @param nums
     * @return
     */
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> resList = new LinkedList<>();
        if (nums.length == 0) {
            return resList;
        }
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
            if (vis[i]) {
                continue;
            }
            vis[i] = true;
            list.add(nums[i]);
            dfs(x + 1, nums, vis, list, resList);
            vis[i] = false;
            list.remove(list.size() - 1);
        }
    }

    public static void main(String[] args) {
        Solution_46 sol = new Solution_46();
        List<List<Integer>> permute = sol.permute(new int[]{
                1, 2, 3
        });
        System.out.println("==================");
    }
}


