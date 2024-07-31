package leetcode.algorithm.lcp;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * @program: LeetCodeSolution
 * @description: #
 * @author: WhyWhatHow
 **/

public class Solution_lcp40 {

    public static void main(String[] args) {
        Solution_lcp40 sol = new Solution_lcp40();
        System.out.println(sol.maxmiumScore(new int[]{
//                        1, 2, 8, 9
                        3, 1, 6, 9, 2, 4, 9, 2, 3
                },
//                3
                4
        ));
        System.out.println("==================");
    }

    public int maxmiumScore(int[] cards, int cnt) {
        Arrays.sort(cards);
        int n = cards.length;
        int res = 0;
        LinkedList<Integer> oddlist = new LinkedList<>();
        LinkedList<Integer> evenlist = new LinkedList<>();

        for (int card : cards) {
            if ((card & 1) == 1) oddlist.addFirst(card);
            else evenlist.addFirst(card);
        }

        while (cnt > 0) {
            if ((cnt & 1) == 1) { //odd
                cnt--;
                if (evenlist.size() == 0) return 0;
                res += evenlist.pop();
            } else {
                cnt -= 2;
                int oddSum = 0, evenSum = 0;
                if (oddlist.size() >= 2) {
                    oddSum = oddlist.get(0) + oddlist.get(1);
                }
                if (evenlist.size() >= 2) {
                    evenSum = evenlist.get(0) + evenlist.get(1);
                }
                if (oddSum == 0 && evenSum == 0) return 0;
                if (oddSum >= evenSum) {
                    oddlist.pop();
                    oddlist.pop();
                    res+=oddSum;
                } else {
                    res+=evenSum;
                    evenlist.pop();
                    evenlist.pop();
                }
            }
        }


        return res;
    }

}


