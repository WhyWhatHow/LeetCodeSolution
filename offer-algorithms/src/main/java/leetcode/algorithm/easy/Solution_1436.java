package leetcode.algorithm.easy;

import java.util.HashMap;
import java.util.List;

/**
 * @program: LeetCodeSolution
 * @description: #
 * @author: WhyWhatHow
 **/

public class Solution_1436 {

    public static void main(String[] args) {
        Solution_1436 sol = new Solution_1436();
        System.out.println("==================");
    }

    public String destCity(List<List<String>> paths) {
        HashMap<String, Integer> map = new HashMap<>();
        for (List<String> path : paths) {
            map.compute(path.get(0), (k, v) -> v == null ? 1 : v + 1);
        }
        String res ;
        for (List<String> path : paths) {
            for (String s : path) {
                if (!map.containsKey(s)) {
                    return s;
                }
            }
        }
        return null ;
    }
}


