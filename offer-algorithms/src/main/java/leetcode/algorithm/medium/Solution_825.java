package leetcode.algorithm.medium;

/**
 * @program: LeetCodeSolution
 * @description: #
 * @author: WhyWhatHow
 **/

public class Solution_825 {

    public static void main(String[] args) {
        Solution_825 sol = new Solution_825();
        System.out.println(sol.numFriendRequests(new int[]{
//                16, 16
//                16, 16,16,17
//                16, 17, 18
//                54,23,102,90,40,74,112,74,76,21

                73, 106, 39, 6, 26, 15, 30, 100, 71, 35, 46, 112, 6, 60, 110
        }));
        System.out.println("==================");
    }


    /***
     * 不可以现处理 x==y, 这种情况. 比如[6,6] -> 0 而不是2 .
     * @param ages
     * @return
     */
    public int numFriendRequests(int[] ages) {
        int res = 0;
        int[] nums = new int[121];
        for (int age : ages) {
            nums[age]++;
        }
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == 0) continue;
            int left = i / 2 + 7;
//            int cnt = nums[i] - 1;
            int cnt = 0;
            for (int j = left + 1; j <= i; j++) {
                if (nums[j] == 0) continue;
                if (i == j) {
                    cnt += nums[j] - 1;
                } else {
                    cnt += nums[j];
                }
//                System.out.println(i + "::" + j);
            }
            res += cnt * nums[i];
        }

        return res;
    }

}


