package leetcode.algorithm.dfs;

import java.util.*;

/**
 * @program: LeetCodeSolution
 * @description:
 * @author: WhyWhatHow
 * @create: 2020-05-07 12:09
 **/

public class Solution_47 {
    List<List<Integer>> res;

    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        res = new LinkedList<>();
        boolean[] vis = new boolean[nums.length];
        ArrayList<Integer> list = new ArrayList<>(nums.length);
        for (int n : nums) {
            list.add(n);
        }
        dfs(0, nums, vis, list );
        return res;

    }

    // dfs(i), means i position's filled element.
    private void dfs(int i, int[] nums, boolean[] vis, ArrayList<Integer> list) {
        if (i == nums.length) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int j = 0; j < nums.length; j++) {
            if (vis[j]) continue; //
            if (j > 0 && nums[j] == nums[j - 1] && !vis[j - 1]) continue;
            list.set(i, nums[j]);
            vis[j] = true;
            dfs(i + 1, nums, vis, list);
//            list.remove(i); // use remove() make arrayList shorter
            vis[j] = false;
        }
    }

    /**
     * 加一个 hashset 去掉重复排序的东西, 不成立
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> permuteUniqueOld(int[] nums) {
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
//        List<List<Integer>> lists = sol.permuteUniqueBetter(new int[]{
//                1, 1, 2
////        3,3,0,3
//        });
        List<List<Integer>> list2 = sol.permuteUnique(new int[]{
                1, 1, 2
//        3,3,0,3
        });
        System.out.println("==================");
    }

    /**
     * dfs better, 不需要其他的一些乱七八糟的判断. 貌似写了这段时间的代码确实是有进步的.nice!
     */
    List resList = new LinkedList<List>();
    LinkedList<Integer> list = new LinkedList<>();

    public List<List<Integer>> permuteUniqueBetter(int[] nums) {

        boolean[] vis = new boolean[nums.length];
        dfs(nums, vis);
        return resList;
    }

    void dfs(int[] nums, boolean[] vis) {
        if (list.size() == nums.length) {
            resList.add(new LinkedList(list));
            return;
        }
        HashSet<Integer> set = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            if (!vis[i] && !set.contains(nums[i])) {
                vis[i] = true;
                set.add(nums[i]);
                list.addLast(nums[i]);

                dfs(nums, vis);

                vis[i] = false;
                list.removeLast();
            }
        }
    }

}


