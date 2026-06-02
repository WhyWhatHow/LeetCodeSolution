package leetcode.algorithm.easy;

import java.util.TreeMap;

/**
 * @program: LeetCodeSolution
 * @description: #
 * @author: WhyWhatHow
 **/
public class Solution_3633 {

    public static void main(String[] args) {


        Solution_3633 sol = new Solution_3633();//
        System.out.println("==================");
    }

    public int earliestFinishTime(int[] landStartTime, int[] landDuration, int[] waterStartTime, int[] waterDuration) {
        var lmap = new TreeMap<Integer, Integer>(); // key: lst, val:lend
        var wmap = new TreeMap<Integer, Integer>(); // key : wst ,val : wend

        int min = Integer.MAX_VALUE;
        // l first , w wait
        for (int i = 0; i < landStartTime.length; i++) {
            int cur = landDuration[i] + landStartTime[i];
            for (int j = 0; j < waterDuration.length; j++) {
                if (waterStartTime[j] <= cur) min = Math.min(min, cur + waterDuration[j]);
                else {
                    min = Math.min(min, waterDuration[j] + waterStartTime[j]);
                }
            }
        }

        // w first , l second
        for (int i = 0; i < waterStartTime.length; i++) {
            int cur = waterDuration[i] + waterStartTime[i];
            for (int j = 0; j < landStartTime.length; j++) {
                if (landStartTime[j] <= cur) min = Math.min(min, cur + landDuration[j]);
                else min = Math.min(min, landStartTime[j] + landDuration[j]);
            }
        }

        return min;
    }

}
