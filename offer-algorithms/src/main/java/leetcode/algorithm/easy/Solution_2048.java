package leetcode.algorithm.easy;

/**
 * @program: LeetCodeSolution
 * @description: #
 * @author: WhyWhatHow
 **/
public class Solution_2048 {

    public static void main(String[] args) {
        Solution_2048 sol = new Solution_2048();//
        System.out.println(1 ^ 1);
        System.out.println(1 ^ 1 ^ 1);
        System.out.println("==================");
    }

    public int maxDistance(int[] colors) {
        int res = 0;
        for (int i = 0; i < colors.length; i++) {
            for (int j = colors.length - 1; j > i; j--) {
                if (colors[j] != colors[i]) res = Math.max(j - i, res);
            }
        }
        return res ;
    }


}
