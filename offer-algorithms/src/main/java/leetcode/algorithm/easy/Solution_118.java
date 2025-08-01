package leetcode.algorithm.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: LeetCodeSolution
 * @description: #
 * @author: WhyWhatHow
 **/

public class Solution_118 {

    public static void main(String[] args) {
        Solution_118 sol = new Solution_118();
        System.out.println(sol.generate(5));
        System.out.println("==================");
    }

    public List<List<Integer>> generate(int numRows) {

        List<List<Integer>> list = new ArrayList<>();
        list.add(List.of(1));
        for (int i = 1; i < numRows; i++) {
            var preList = list.get(i - 1);
            List<Integer> tmp = new ArrayList<>();
            tmp.add(1);
            for (int j = 1; j <= i; j++) {
                if (j == i ) tmp.add(1);
                else {
                    int cur = preList.get(j - 1) + preList.get(j);
                    tmp.add(cur);
                }
            }
            list.add(tmp);
        }

        return list;
    }


}


