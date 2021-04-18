package leetcode.algorithm;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * @program: LeetCodeSolution
 * @description:
 * @author: WhyWhatHow
 * @create: 2020-05-07 12:09
 **/

public class Solution_demo1 {
    public int[] twoSum(int[] nums, int target) {
//        Arrays.sort(nums);

        HashMap<Integer, Integer> map = new HashMap();

        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], nums[i]);
        }
        for (int i = 0; i < nums.length; i++) {
            int temp = target - nums[i];
            if (map.containsKey(temp)) {
                Integer idx = map.get(temp);
                if (idx == i) {
                    continue;

                }
                return new int[]{i, idx};
            }
        }
        return null;
    }

    public static void main(String[] args) {
        Solution_demo1 sol = new Solution_demo1();
//        sol.twoSum(new int[]{3, 2, 4}, 6);
        List<List<Integer>> lists = sol.threeSum(new int[]{-1, 0, 1, 2, -1, -4, -2, -3, 3, 0, 4});
//        List<List<Integer>> lists = sol.threeSum(new int[]{-1,0,1,2,-1,-4});
        System.out.println(lists.size());
        lists.forEach(x -> System.out.println(x.toString()));
        System.out.println("==================");
    }

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> list = new LinkedList<>();
        if (nums.length <= 2 || nums == null) {
            return list;
        }
        Arrays.sort(nums);
        HashMap<Integer, Boolean> visMap = new HashMap<Integer, Boolean>();
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < nums.length - 1; i++) {
            visMap.clear();// 去重
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue; //去重 原因: 两节点值相同,处理过了
            }
            for (int j = i + 1; j < nums.length - 1; j++) {
                int temp = nums[i] + nums[j];
                Integer loc = map.getOrDefault(-temp, -1);
                if (loc != -1 && i < loc && j < loc && !visMap.containsKey(nums[loc])) { // 保证下标不同
                    LinkedList<Integer> tempList = new LinkedList<>();
                    tempList.add(nums[i]);
                    tempList.add(nums[j]);
                    tempList.add(nums[loc]);
                    list.add(tempList);
                    visMap.put(nums[loc],true);
                }
            }
        }
        return list;

    }
}


