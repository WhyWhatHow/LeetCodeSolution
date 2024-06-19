package leetcode.algorithm.easy;

/**
 * @program: LeetCodeSolution
 * @description: #
 * @author: WhyWhatHow
 **/

public class Solution_2748 {

    public static void main(String[] args) {
        Solution_2748 sol = new Solution_2748();
        sol.countBeautifulPairs(new int[]{22, 33, 44, 555, 66, 99, 1});
        System.out.println("==================");
    }

    public int countBeautifulPairs(int[] nums) {
        int[] fs = new int[nums.length];
        int[] es = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            fs[i] = getFirstNum(nums[i]);
            es[i] = nums[i] % 10;
        }


        int cnt = 0;
        for (int i = 0; i < fs.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (gcd(fs[i], es[j]) == 1) {
                    cnt++;
                }
            }
        }
        return cnt;
    }


    private int gcd(int a, int b) {
//        if (a < b) {
//            int temp = a;
//            a = b;
//            b = temp;
//        }
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    private int getFirstNum(int num) {
        String s = String.valueOf(num);
        return Integer.valueOf(s.substring(0, 1));
    }
}


