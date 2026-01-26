package leetcode.algorithm.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @program: LeetCodeSolution
 * @description: #
 * @author: WhyWhatHow
 **/
public class Solution_demo {

    public static void main(String[] args) {
        Solution_demo sol = new Solution_demo();
        System.out.println("==================");
    }

    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        Arrays.sort(arr);

        int min = Integer.MAX_VALUE;
        for (int i = 1; i < arr.length; i++) {
            min = Math.min(min, arr[i] - arr[i - 1]);
        }
        var list = new ArrayList<List<Integer>>();

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] - arr[i - 1] == min) {
                list.add(List.of(arr[i - 1], arr[i]));
            }
        }
        return list;
    }


}


