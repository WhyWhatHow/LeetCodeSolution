package leetcode.algorithm.medium;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

/**
 * @program: LeetCodeSolution
 * @description: #
 * @author: WhyWhatHow
 **/

public class Solution_1338 {

    public static void main(String[] args) {
        Solution_1338 sol = new Solution_1338();
        int i = sol.minSetSize(new int[]{
//                100, 100, 3, 7
                9, 77, 63, 22, 92, 9, 14, 54, 8, 38, 18, 19, 38, 68, 58, 19
        });
        System.out.println("==================");
    }


    public int minSetSize(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i : arr) {
            map.compute(i, (k, v) -> v == null ? 1 : v + 1);
        }
        List<Integer> list = map.values().stream().sorted(Comparator.reverseOrder()).toList();
        int n = arr.length / 2;

        int res = 0;
        int sum = 0;
        for (Integer i : list) {
            res++;
            sum += i;
            if (sum >= n) break;
        }
        return res;
    }

}


