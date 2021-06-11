package jianzhiOffer;

import java.util.HashMap;

/**
 * @program: LeetCodeSolution
 * @description:
 * @author: WhyWhatHow
 * @create: 2020-05-22 08:10
 **/
public class Sol_57_1 {

    public int[] twoSum(int[] nums, int target) {
        if (nums == null || nums.length < 2) {
            return new int[2];
        }
        int[] ans = new int[2];
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int temp = target - nums[i];
            if (map.containsKey(temp)) {
                Integer idx = map.get(temp);
                if (idx != i) {
                    ans[0] = nums[i];
                    ans[1] = temp;
                    break;
                }
            }
            map.put(nums[i], i);
        }
        return ans;

    }
    public static void main(String[] args) {
        Sol_57_1 sol =new Sol_57_1();
        System.out.println("=======");
    }
}
