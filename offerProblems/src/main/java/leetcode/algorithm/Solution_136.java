package leetcode.algorithm;

import java.util.*;

/**
 * @program: LeetCodeSolution
 * @description:
 * @author: WhyWhatHow

 **/
public class Solution_136 {

    public int singleNumberC(int[] nums) {
        if (nums.length == 0 || nums == null) {
            return 0;
        }
        long all = 0;
        long now = 0;
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (!set.contains(nums[i])) {
                set.add(nums[i]);
                all += nums[i];
            }
            now += nums[i];
        }
        all *= 3;
        return (int) ((all-now)/2);
    }

    public int singleNumberA(int[] nums) {
//        数组中的全部元素的异或运算结果即为数组中只出现一次的数字。
        int ans = 0;
        for (int num : nums) {
            ans ^= num;
        }
        return ans;
    }

    public int singleNumberB(int[] nums) {
//       3(a+b+c)-(a+a+a+b+b+b+c)=2c
        long now = 0;
        long fu = 0;
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            now += num;
            set.add(num);
        }
        for (Integer integer : set) {
            fu += integer;
        }
        return (int) ((3 * fu - now) >> 1);
    }

    public int singleNumber(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            Integer integer = map.get(num);
            if (integer == null) {
                map.put(num, 1);
            } else {
                map.put(num, integer + 1);
            }
        }
        int ans = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            Integer value = entry.getValue();
            System.out.println(entry.getKey() + " ," + entry.getValue());
            if (value == 1) {
                ans = entry.getKey();
                break;
            }
        }
        return ans;

    }

    public List<Integer> singleNumber260(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            Integer integer = map.get(num);
            if (integer == null) {
                map.put(num, 1);
            } else {
                map.put(num, integer + 1);
            }
        }
        int ans = 0;
        LinkedList<Integer> list = new LinkedList<>();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            Integer value = entry.getValue();
            System.out.println(entry.getKey() + " ," + entry.getValue());
            if (value == 1) {
                ans = entry.getKey();
                list.add(ans);
            }
        }
        return list;

    }

    public static void main(String[] args) {
        Solution_136 sol = new Solution_136();
        sol.singleNumber(new int[]{4, 1, 2, 1, 2});
        int i = sol.singleNumberB(new int[]{43, 16, 45, 89, 45, -2147483648, 45, 2147483646, -2147483647, -2147483648, 43, 2147483647, -2147483646, -2147483648, 89, -2147483646, 89, -2147483646, -2147483647, 2147483646, -2147483647, 16, 16, 2147483646, 43});

//        System.out.println( sol.isValid("()"));
    }
}
