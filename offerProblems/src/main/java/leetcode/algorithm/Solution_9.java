package leetcode.algorithm;

/**
 * @program: LeetCodeSolution
 * @description:
 * @author: WhyWhatHow
 * @create: 2020-05-07 12:09
 **/

public class Solution_9 {
    /**
     * 判断回文数，反转后，判断相等，这样就不需要数组长度处理奇数，偶数的情况。
     *
     * @param x
     * @return
     */
    public boolean isPalindrome(int x) {
        String inOrder = x + "";
        String notOrder = new StringBuffer().append(x + "").reverse().toString();
//        System.out.println(inOrder);
//        System.out.println(notOrder);
        return inOrder.equals(notOrder);

    }

    public static void main(String[] args) {
        Solution_9 sol = new Solution_9();
        int[] example = new int[]{124,123,121,-121};
        for (int i : example) {

            System.out.println( sol.isPalindrome(i));         }
        System.out.println("==================");
    }
}


