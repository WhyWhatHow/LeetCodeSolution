package leetcode.algorithm.greedy;

import java.util.HashMap;

/**
 * @program: LeetCodeSolution
 * @description:
 * @author: WhyWhatHow
 **/

public class Solution_2244 {

    public static void main(String[] args) {
        Solution_2244 sol = new Solution_2244();

        System.out.println(sol.minimumRounds(new int[]{
//                2, 2, 3, 3, 2, 4, 4, 4, 4, 4
//                2, 3, 3
//                2, 2, 2, 2, 2, 2, 2
                69, 65, 62, 64, 70, 68, 69, 67, 60, 65, 69, 62, 65, 65, 61, 66, 68, 61, 65, 63, 60, 66, 68, 66, 67, 65, 63, 65, 70, 69, 70, 62, 68, 70, 60, 68, 65, 61, 64, 65, 63, 62, 62, 62, 67, 62, 62, 61, 66, 69
        }));
        ;
        System.out.println("==================");
    }


    // 2,3 个相同的任务
    public int minimumRounds(int[] tasks) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int task : tasks) {
            map.put(task, map.getOrDefault(task, 0) + 1);
        }
//        int[] nums = new int[]{-1, -1, 1, 1, 2, 2};
        int res = 0;
        boolean failed = false;
        for (Integer k : map.keySet()) {
            Integer val = map.get(k);
            if (val == 1) {
                failed = true;
                break;
            }

            int temp = val % 3;
            switch (temp) {
                case 0:
                    res += val / 3;
                    break;
                default:
                    res += val / 3 + 1;
                    break;
//                case 1:
//                    res += val / 3 + 1;
//                    val = 0;
//                    break;
//                case 2:
//                    res += val / 3 + 1;
//                    val = 0;
//                    break;
            }

//            val = 0;

        }
        return failed ? -1 : res;
    }
}



