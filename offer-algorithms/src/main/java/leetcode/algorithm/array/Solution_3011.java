package leetcode.algorithm.array;

import java.util.HashMap;

/**
 * @program: LeetCodeSolution
 * @description: #
 * @author: WhyWhatHow
 **/

public class Solution_3011 {

    public static void main(String[] args) {
        Solution_3011 sol = new Solution_3011();
        System.out.println(sol.canSortArray(new int[]{
//                75, 34, 30
                8, 4, 2, 30, 15
        }));

        ;
        System.out.println("==================");
    }

    public boolean canSortArray(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], Integer.bitCount(nums[i]));
        }

        for (int i = 1; i < nums.length; i++) {
            int j = i;
            while (j > 0) {
                if (nums[j] < nums[j - 1] && map.get(nums[j]) == map.get(nums[j - 1])) {
                    int temp = nums[j];
                    nums[j] = nums[j - 1];
                    nums[j - 1] = temp;
                }
                j--;
            }
        }

        // check num
        boolean res = true;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < nums[i - 1]) {
                res = false;
                break;
            }
        }

        return res;
    }
    /**
     * wrong ,两个元素相邻, sad!!!
     */
//    public boolean canSortArray(int[] nums) {
//        int[] cnts = new int[nums.length];
//        int[] a = new int[nums.length];
//        for (int i = 0; i < nums.length; i++) {
//            cnts[i] = Integer.bitCount(nums[i]);
//            a[i] = nums[i];
//        }
//
//        Arrays.sort(a);
//        int idx = -1;
//        for (int i = 0; i < nums.length; i++) {
//            boolean changed = false;
//            for (int j = i + 1; j < nums.length; j++) {
//                if (cnts[i] == cnts[j] && nums[i] > nums[j]) {
//                    changed = true;
//                    idx = j;
//                }
//            }
//            if (changed) {
//                int temp = nums[i];
//                nums[i] = nums[idx];
//                nums[idx] = temp;
//            }
//        }
//
//        // check num
//        boolean res = true;
//        for (int i = 0; i < a.length; i++) {
//            if (a[i] != nums[i]) {
//                res = false;
//                break;
//            }
//        }
//        return res;
//    }

//    private int count(int num) {
//    return  Integer.bitCount(num);
//    }


}


