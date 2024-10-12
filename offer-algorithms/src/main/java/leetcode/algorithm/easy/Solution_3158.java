package leetcode.algorithm.easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * @program: LeetCodeSolution
 * @description: #
 * @author: WhyWhatHow
 **/

public class Solution_3158 {

    public static void main(String[] args) {
        Solution_3158 sol = new Solution_3158();
        System.out.println("==================");
    }

    public int duplicateNumbersXOR(int[] nums) {
        Arrays.sort(nums);
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.compute(num, (k, v) -> v == null ? 1 : v + 1);
        }
        List<Integer> list = map.entrySet().stream().filter(o -> o.getValue() == 2).map(o -> o.getKey()).toList();
        if(list.size() ==0) return 0;
        int res = list.get(0);
        for (int i = 1; i < list.size(); i++) {
            res = res ^ list.get(i);
        }
        return res;
    }
}


