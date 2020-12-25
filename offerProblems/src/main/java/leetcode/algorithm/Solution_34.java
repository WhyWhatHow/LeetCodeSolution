package leetcode.algorithm;

import java.util.HashMap;

/**
 * @program: LeetCodeSolution
 * @description:
 * @author: WhyWhatHow
 * @create: 2020-05-07 12:09
 **/

public class Solution_34 {
    int binarySearch(int[] nums, int target) {
        int l = 0, r = nums.length - 1, mid = -1, ans = -1;
        while (l <= r) {
            mid = l + (r - l) / 2;
            if (nums[mid] <target) {

                l = mid + 1;
            } else {
                ans = mid;
                r = mid - 1;
            }
        }
        return ans;
    }

    public int search(int[] nums, int target) {
        int cnt = 0;
        int loc = binarySearch(nums, target);
        if (loc < 0)
            return cnt;
        for (int i = loc; i < nums.length; i++) {
            if (nums[i] == target) {
                cnt++;
            } else {
                break;
            }
        }
        return cnt;
    }
    public int findString(String[] words, String s) {
        HashMap<String,Integer> map =new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            if (words[i]==null) {
                continue;
            }
            map.put(words[i],i);
        }
        if (map.containsKey(s)) {

            Integer integer = map.get(s);
            return integer;
        }
        return -1 ;

    }
    public static void main(String[] args) {
        Solution_34 sol = new Solution_34();
        int[] nums =new int[]{5,7,7,8,8,10};
        sol.search(nums,8);
        int string = sol.findString(new String[]{"at", "", "", "", "ball", "", "", "car", "", "", "dad", "", ""}, "ta");
        int string1 = sol.findString(new String[]{"at", "", "", "", "ball", "", "", "car", "", "", "dad", "", ""}, "ball");

        System.out.println("==================");
    }
}


