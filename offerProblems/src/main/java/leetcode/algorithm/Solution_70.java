package leetcode.algorithm;

/**
 * @program: LeetCodeSolution
 * @description:
 * @author: WhyWhatHow
 * @create: 2020-05-07 12:09
 **/

public class Solution_70 {
   static  final int MAX = 1000;
   static  int[] ans = new int[MAX];
   static {
        ans[0]=1;
        ans[1]=2;
        for (int i = 2; i < ans.length; i++) {
            ans[i]=ans[i-1]+ans[i-2];
        }

    }
    public int climbStairs(int n) {
        return ans[n-1];
    }

    public static void main(String[] args) {
        Solution_70 sol = new Solution_70();
        System.out.println("==================");
    }
}


