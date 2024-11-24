package leetcode.algorithm.window;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

/**
 * @program: LeetCodeSolution
 * @description: #hard
 * @author: WhyWhatHow
 **/

public class Solution_632 {

    public static void main(String[] args) {
        Solution_632 sol = new Solution_632();
        int[][] array = {
//                {4, 10, 15, 24, 26},
//                {0, 9, 12, 20},
//                {5, 18, 22, 30}
                // ///////////////////
                {-89, 1, 69, 89, 90, 98},
                {-43, -36, -24, -14, 49, 61, 66, 69},
                {73, 94, 94, 96},
                {11, 13, 76, 79, 90},
                {-40, -20, 1, 9, 12, 12, 14},
                {-91, -31, 0, 21, 25, 26, 28, 29, 29, 30},
                {23, 88, 89},
                {31, 42, 42, 57},
                {-2, 6, 11, 12, 12, 13, 15},
                {-3, 25, 34, 36, 39},
                {-7, 3, 29, 29, 31, 32, 33},
                {4, 11, 14, 15, 15, 18, 19},
                {-34, 9, 12, 19, 19, 19, 19, 20},
                {-26, 4, 47, 53, 64, 64, 64, 64, 64, 65},
                {-51, -25, 36, 38, 50, 54},
                {17, 25, 38, 38, 38, 38, 40},
                {-30, 12, 15, 19, 19, 20, 22},
                {-14, -13, -10, 68, 69, 69, 72, 74, 75},
                {-39, 42, 70, 70, 70, 71, 72, 72, 73},
                {-67, -34, 6, 26, 28, 28, 28, 28, 29, 30, 31}
        };

        List<List<Integer>> nums = new ArrayList<>();
        for (int[] subArray : array) {
            List<Integer> list = new ArrayList<>();
            for (int num : subArray) {
                list.add(num);
            }
            nums.add(list);
        }

        System.out.println(sol.smallestRange(nums));
        System.out.println("==================");
    }


    public int[] smallestRange(List<List<Integer>> nums) {
        // wa : reason : only check a[0] don't check the whole element, so if you try to use Comparator, you need to handle every part of element.
//        TreeSet<int[]> set = new TreeSet<>((a,b)->{return a[0]-b[0]});//
        TreeSet<int[]> set = new TreeSet<>((a, b) -> {
            if (a[0] != b[0]) return a[0] - b[0];
            else if (a[1] != b[1]) return a[1] - b[1];
            else  return a[2] - b[2];
        });
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.size(); i++) {
            Integer val = nums.get(i).get(0);
            min = Math.min(min, val);
            max = Math.max(max, val);
            set.add(new int[]{val, i, 0});
        }
        int minDistance = max - min;

        while (!set.isEmpty()) {
            int[] a = set.pollFirst();
//            System.out.println(a[0] + " , x:" + a[1] + " ,y:" + a[2]);
            int x = a[1], y = a[2] + 1;
            if (y == nums.get(x).size()) break;
            int val = nums.get(x).get(y);
            set.add(new int[]{val, x, y});

            int dis = set.last()[0] - set.first()[0];
            if (dis < minDistance) {
                minDistance = dis;
                max = set.last()[0];
                min = set.first()[0];
            }

        }

        return new int[]{min, max};
    }

}


