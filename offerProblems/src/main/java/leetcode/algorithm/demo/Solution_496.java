package leetcode.algorithm.demo;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;

/**
 * @program: LeetCodeSolution
 * @description:
 * @author: WhyWhatHow
 **/

public class Solution_496 {

    public static void main(String[] args) {
        Solution_496 sol = new Solution_496();
        System.out.println("==================");
//        int[] ints = sol.nextGreaterElement(new int[]{4, 1, 2}, new int[]{1, 3, 4, 2});
        int[] ints = sol.nextGreaterElement(new int[]{1, 3, 5, 2, 4}, new int[]{6, 5, 4, 3, 2, 1, 7});

        System.out.println(ints.toString());


    }

    // stack && hashmap -> o(n)
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] ans = new int[nums1.length];
        Arrays.fill(ans, -1);
        Stack<Integer> stack = new Stack<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        stack.push(nums2[0]);
        for (int i = 1; i < nums2.length; i++) {

            while (!stack.empty() && stack.peek() < nums2[i]) {
                Integer pop = stack.pop();
                map.put(pop, nums2[i]);
            }

            stack.push(nums2[i]);
        }
        int cnt = 0;
        for (int i : nums1) {
            ans[cnt++] = map.getOrDefault(i, -1);

        }
        return ans;
    }

    //  hash & n2
    public int[] nextGreaterElement2(int[] nums1, int[] nums2) {
        int[] ans = new int[nums1.length];
        Arrays.fill(ans, -1);
        int cnt = 0;
        HashMap<Integer, Integer> map = new HashMap<>(); // store
        for (int i = 0; i < nums2.length; i++) {
            map.put(nums2[i], i);
        }
        Stack<Integer> stack = new Stack<>();
        for (int num : nums1) {
            Integer pos = map.get(num);
//            stack.push(num);
            for (int i = pos + 1; i < nums2.length; i++) {
                if (nums2[i] > num) {
                    ans[cnt] = nums2[i];
                    break;
                }
            }
            cnt++;

        }
        return ans;

    }

}
