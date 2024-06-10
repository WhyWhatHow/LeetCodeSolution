package leetcode.algorithm.binarysearch;

import java.util.Arrays;

/**
 * @program: LeetCodeSolution
 * @description:
 * @author: WhyWhatHow
 **/

public class Solution_875 {

    public static void main(String[] args) {
        Solution_875 sol = new Solution_875();
        System.out.println(sol.minEatingSpeed(new int[]{
                        3, 6, 7, 11
                },
                8
        ));
        System.out.println("==================");
    }

    public int minEatingSpeed(int[] piles, int h) {
        if (piles.length == h) {
            return Arrays.stream(piles).max().getAsInt();
        }
        int res = 0;
        long sum = 0;
        for (int pile : piles) {
            sum += pile;
        }
        long target = sum % h == 0 ? sum / h : sum / h + 1;
        Arrays.sort(piles);
        int pos = search(piles, target);
        return piles[res];
    }

    private int search(int[] piles, long target) {
        int left = 0, right = piles.length - 1;
        int res = -1, mid;
        while (left <= right) {
            mid = left + (right - left) / 2;
            if (piles[mid] >= target) {
                res = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return res;
    }

}


