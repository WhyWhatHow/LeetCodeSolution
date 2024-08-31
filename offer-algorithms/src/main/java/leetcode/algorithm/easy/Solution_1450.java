package leetcode.algorithm.easy;

/**
 * @program: LeetCodeSolution
 * @description: #
 * @author: WhyWhatHow
 **/

public class Solution_1450 {

    public static void main(String[] args) {
        Solution_1450 sol = new Solution_1450();
        System.out.println("==================");
    }

    public int busyStudent(int[] startTime, int[] endTime, int queryTime) {
        int res = 0 ;
        for (int i = 0; i < startTime.length; i++) {
            if(queryTime>=startTime[i] && queryTime<= endTime[i]) res++;
        }
        return res;
    }

}


