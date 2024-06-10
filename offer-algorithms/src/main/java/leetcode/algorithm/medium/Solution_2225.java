package leetcode.algorithm.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @program: LeetCodeSolution
 * @description:
 * @author: WhyWhatHow
 **/

public class Solution_2225 {

    public static void main(String[] args) {
        Solution_2225 sol = new Solution_2225();

        System.out.println("==================");
    }


    public List<List<Integer>> findWinners(int[][] matches) {
        int[] loses = new int[100005];
        HashSet<Integer> winners = new HashSet<>();
        for (int[] match : matches) {
            loses[match[1]]++;
            if (loses[match[0]] == 0)
                winners.add(match[0]);
        }

        List<Integer> allwinners = winners.parallelStream().filter(winner -> loses[winner] == 0).collect(Collectors.toList());
//        ArrayList<Integer> allwinners = new ArrayList<>();
//        winners.forEach(winner -> {
//            if (loses[winner] == 0) {
//                allwinners.add(winner);
//            }
//        });
        // count loser only lose ones
        ArrayList<Integer> losers = new ArrayList<>();
        for (int i = 0; i < loses.length ; i++) {
            if(loses[i] ==1) losers.add(i);
        }
        allwinners.sort(Integer::compareTo);
        losers.sort(Integer::compareTo);

        return Arrays.asList(allwinners,losers);
//        List<List<Integer>> res = new ArrayList<>();
//        res.add(allwinners);
//        res.add(losers);
//        return res;
    }

}


