package leetcode.algorithm.medium;

import java.util.HashMap;

/**
 * @program: LeetCodeSolution
 * @description:
 * @author: WhyWhatHow
 **/

public class Solution_137 {

    public static void main(String[] args) {
        Solution_137 sol = new Solution_137();

        System.out.println("==================");
    }

    public int singleNumber(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num,0) + 1);
        }
        int res = 0 ;
        for (Integer integer : map.keySet()) {
            if (map.get(integer)==1) {
                res = integer;
                break;
            }
        }
        return res ;
    }
}


