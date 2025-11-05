package leetcode.algorithm.window;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * @program: LeetCodeSolution
 * @description: #
 * @author: WhyWhatHow
 **/

public class Solution_3318 {

    public static void main(String[] args) {
        Solution_3318 sol = new Solution_3318();
        System.out.println(sol.findXSum(new int[]{
                        1, 1, 2, 2, 3, 4, 2, 3
                }, 6, 2
        ));
        System.out.println("==================");
    }

    // length = k slide window. and calculate the answer of each sub array.
    public int[] findXSum(int[] nums, int k, int x) {
        int n = nums.length;
        int[] res = new int[n - k + 1];
        int cnt = 0;
        var map = new HashMap<Integer, Integer>(); // k: num, v: cnt
        for (int i = 0; i < nums.length; i++) {
            map.compute(nums[i], (kk, v) -> v == null ? 1 : v + 1);
            if (i >= k - 1) {
                res[cnt++] = getAnswer(map, x);
                map.compute(nums[i - k + 1], (kk, v) -> v - 1); // remove the first one.
            }
        }
        return res;
    }

    private int getAnswer(HashMap<Integer, Integer> map, int x) {
//        var list =
//                map.entrySet().stream().toList();
//        set.stream().sorted()
        ArrayList<Map.Entry<Integer, Integer>> nlist = new ArrayList(map.entrySet());
        Collections.sort(nlist, (a, b) -> {
            if (a.getValue() != b.getValue()) {
                return b.getValue() - a.getValue();
            }
            return b.getKey() - a.getKey();
        });
        int res = 0;
        for (Map.Entry<Integer, Integer> s : nlist) {
            if (x-- >0) {
                res += s.getValue() * s.getKey();
            }
        }
        return res;
    }
}


