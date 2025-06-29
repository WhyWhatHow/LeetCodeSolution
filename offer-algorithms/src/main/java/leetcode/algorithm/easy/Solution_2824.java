package leetcode.algorithm.easy;

import java.util.List;

/**
 * @program: LeetCodeSolution
 * @description: #
 * @author: WhyWhatHow
 **/

public class Solution_2824 {

    public static void main(String[] args) {
        Solution_2824 sol = new Solution_2824();

        System.out.println("==================");
    }

    public int countPairs(List<Integer> nums, int target) {
            int res = 0 ;
        for (int i = 0; i < nums.size(); i++) {
            for(int j = i+1; j<nums.size(); j++){
                if(nums.get(i) + nums.get(j)<target) res++ ;
            }
        }
        return res ;
    }

}


