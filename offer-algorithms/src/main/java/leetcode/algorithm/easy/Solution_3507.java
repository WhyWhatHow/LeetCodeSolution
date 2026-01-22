package leetcode.algorithm.easy;

import java.util.ArrayList;

/**
 * @program: LeetCodeSolution
 * @description: #
 * @author: WhyWhatHow
 **/
public class Solution_3507 {

    public static void main(String[] args) {
        Solution_3507 sol = new Solution_3507();
        System.out.println(sol.minimumPairRemoval(
//                new int[]{1, 2, 2}
                new int[]{5, 2, 3, 1}
        ));
        System.out.println("==================");
    }

    public int minimumPairRemoval(int[] nums) {
        var q = new ArrayList<Integer>();
        for (int i = 0; i < nums.length; i++) {

            q.add(nums[i]);
        }
        int cnt = 0;
        while (!check(q) && q.size() >= 2) {
            int idx = 1;
            int sum = q.get(0) + q.get(1);
            for (int i = 2; i < q.size(); i++) {
                int tmp = q.get(i - 1) + q.get(i);
                if (sum > tmp) {
                    idx = i;
                    sum = tmp;
                }
            }
            q.remove(idx);
            q.set(idx - 1, sum);
            cnt++;
        }
        return cnt;


    }

    // true -> 非递减, false->
    private boolean check(ArrayList<Integer> q) {
        var prev = q.getFirst();
        for (Integer i : q) {
            if (prev > i) return false;
            prev = i;
        }
        return true;
    }


}


