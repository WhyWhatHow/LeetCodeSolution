package leetcode.algorithm.medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @program: LeetCodeSolution
 * @description: #
 * @author: WhyWhatHow
 **/

public class Solution_2610 {

    public static void main(String[] args) {
        Solution_2610 sol = new Solution_2610();
        System.out.println(sol.findMatrix(new int[]{1, 3, 4, 1, 2, 3, 1}));
        System.out.println("==================");
    }

    public List<List<Integer>> findMatrix(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        for (int num : nums) {
            int size = list.size();
            boolean yes = false;
            for (int i = 0; i < size; i++) {
                List<Integer> set = list.get(i);
                if (set.contains(num)) continue;
                set.add(num);
                yes = true;
                break;
            }
            if (!yes) {
                List<Integer> set = new LinkedList<>();
                set.add(num);
                list.add(set);
            }
        }
        return list;
    }


}


