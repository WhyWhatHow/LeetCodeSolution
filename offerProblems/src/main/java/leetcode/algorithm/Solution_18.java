package leetcode.algorithm;

import java.util.*;

/**
 * @program: LeetCodeSolution
 * @description:
 * @author: WhyWhatHow
 * @create: 2020-05-07 12:09
 **/

public class Solution_18 {

    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> lists = new LinkedList<>();
        if (nums.length < 4 || nums == null) {
            return lists;
        }
        Arrays.sort(nums);
        HashMap<Integer, Boolean> visMap = new HashMap<>(); // 值+访问标记位
        HashMap<Integer, Integer> map = new HashMap<>();// 值+ 下标
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < nums.length - 1; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            for (int j = i + 1; j < nums.length - 1; j++) {
                visMap.clear();
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                for (int k = j + 1; k < nums.length; k++) {
                    int temp = target - nums[i] - nums[j] - nums[k];
                    Integer loc = map.getOrDefault(temp, -1);// 获取节点下标
                    if (loc != -1 && i < loc && j < loc && k < loc
                            && !visMap.containsKey(temp)
                    ) {
                        // 生成节点
                        ArrayList<Integer> list = new ArrayList<>();
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[k]);
                        list.add(temp);
                        lists.add(list);
                        // 标记访问过
                        visMap.put(temp, true);
                    }

                }
            }
        }
        return lists;
    }

    public static void main(String[] args) {
        Solution_18 sol = new Solution_18();
//        List<List<Integer>> lists = sol.fourSum(new int[]{1,0,-1,0,-2,2}, 0);

        List<List<Integer>> lists = sol.fourSum(new int[]{-2, -1, -1, 1, 1, 2, 2}, 0);

//        List<List<Integer>> lists = sol.fourSum(new int[]{2, 2,2, 2, 2}, 8);

        System.out.println(lists.size());
        lists.forEach(x -> System.out.println(x.toString()));

        System.out.println("==================");
    }
}


