package leetcode.algorithm.demo;

/**
 * @program: LeetCodeSolution
 * @description:
 * @author: WhyWhatHow
 * @create: 2020-05-07 12:09
 **/

public class Solution_374 {

    public int guessNumber(int n) {
        int left = 1, right = n ;
        int mid, val, res = -1;
        while (left <= right) {
            mid = (right - left) / 2 + left;
            val = guess(mid);
            if (val == 0) {
                res = mid;
                break;
            } else if (val == -1) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return res;
    }

    int temp = 6;

    private int guess(int mid) {
        if (mid == temp) {
            return 0;
        } else if (mid < temp) {
            return 1;
        }else {
            return -1;
        }
    }

    public static void main(String[] args) {
        Solution_374 sol = new Solution_374();
        sol.temp= 6;
        int i = sol.guessNumber(10
        );
        System.out.println(i);
        System.out.println("==================");
    }
}


