package leetcode.algorithm.greedy;

/**
 * @program: LeetCodeSolution
 * @description:
 * @author: WhyWhatHow
 **/

public class Solution_45 {

    public static void main(String[] args) {
        Solution_45 sol = new Solution_45();
        System.out.println("==================");
        System.out.println(sol.jump(new int[]{
//              2,3,1,1,4
//              2, 0, 3, 1, 4
            7,0,9,6,9,6,1,7,9,0,1,2,9,0,3
        }));
    }

    public int jump(int[] nums) {
        int cnt = 0;
        if (nums.length == 1) return cnt;

        int curCover = 0; // 第cnt步 所可以涵盖的范围
        int nextCover = 0; // 第cnt+1 所可以涵盖的范围
        for (int i = 0; i < nums.length - 1; i++) {
            nextCover = Math.max(nextCover, i + nums[i]);
            if (i == curCover) {
                cnt++;
                curCover = nextCover;
                if (nextCover >= nums.length - 1) break;
            }
        }
        return cnt;
    }
}


