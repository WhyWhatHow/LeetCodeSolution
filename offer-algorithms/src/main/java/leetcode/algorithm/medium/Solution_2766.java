package leetcode.algorithm.medium;

import java.util.HashSet;
import java.util.List;

/**
 * @program: LeetCodeSolution
 * @description: #
 * @author: WhyWhatHow
 **/

public class Solution_2766 {

    public static void main(String[] args) {
        Solution_2766 sol = new Solution_2766();
        System.out.println("==================");
    }

    public List<Integer> relocateMarbles(int[] nums, int[] moveFrom, int[] moveTo) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int n = moveFrom.length;
        for (int i = 0; i < n; i++) {
            set.remove(moveFrom[i]);
            set.add(moveTo[i]);
        }
        List<Integer> list = set.stream().sorted().toList();
        return list;
    }

}


