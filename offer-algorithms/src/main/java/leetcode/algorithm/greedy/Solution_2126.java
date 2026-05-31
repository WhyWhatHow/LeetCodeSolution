package leetcode.algorithm.greedy;

import java.util.Arrays;

/**
 * @program: LeetCodeSolution
 * @description: #
 * @author: WhyWhatHow
 **/
public class Solution_2126 {

    public static void main(String[] args) {


        Solution_2126 sol = new Solution_2126();//
        System.out.println("==================");
    }


    public boolean asteroidsDestroyed(int mass, int[] asteroids) {
        Arrays.sort(asteroids);
        long m = mass ;
        for (int a : asteroids) {
            if (m< a) return false;
            m += a;
        }
        return true;
    }
}
