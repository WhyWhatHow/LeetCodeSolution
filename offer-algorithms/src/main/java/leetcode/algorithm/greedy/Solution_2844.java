package leetcode.algorithm.greedy;

/**
 * @program: LeetCodeSolution
 * @description: #
 * @author: WhyWhatHow
 **/

public class Solution_2844 {

    public static void main(String[] args) {
        Solution_2844 sol = new Solution_2844();
        System.out.println(sol.minimumOperations(new String(
//                "2245047"
//                "1"
//                "15"

                "10"
        )));
        System.out.println("==================");
    }

    /**
     * 0-> x00, 50, 0.
     * 5-> 25,55
     * 1st find 0, 5 ,
     * @param num
     * @return
     */
    public int minimumOperationsBetter(String num) {
        char[] cs = num.toCharArray();
        int n = cs.length;
        boolean find0 = false, find5 = false;
        for (int i = cs.length - 1; i >= 0; i--) {
            char c = cs[i];
            if (find0 && (c == '0' || c == '5')) {
                return n - i - 2; // del c's right  elements but remain '0'
            }
            if (find5 && (c == '2' || c == '7')) {
                return n - i - 2; // del c's right elements but remain '5'
            }
            if (c == '0') find0 = true;
            if (c == '5') find5 = true;
        }
        return find0 ? n - 1 : n;
    }

    /**
     * 25,50,75,00
     *
     * @param num
     * @return
     */
    public int minimumOperations(String num) {
        char[] chars = num.toCharArray();
        int n = num.length();
        if (n == 1) {
            return chars[0] == '0' ? 0 : 1;
        }
        int min = n;
        for (int i = chars.length - 1; i > 0; i--) {
            int len = n - i - 1; // [i,...]
            if (chars[i] == '5' || chars[i] == '0') {
                min = Math.min(min, len + delCount(chars, i, chars[i]));

            }
        }
        return min;
    }

    /**
     * only need consider [0,i]'s len.
     *
     * @param chars
     * @param i
     * @param c
     * @return
     */
    private int delCount(char[] chars, int i, char c) {
        int ans = 0;
        boolean yes = false;
        for (int j = i - 1; j >= 0; j--) {
            if (c == '5' && (chars[j] == '2' || chars[j] == '7')) {
                yes = true;
                break;
            }
            if (c == '0' && (chars[j] == '5' || chars[j] == '0')) {
                yes = true;
                break;
            }
            ans++;
        }
        if (c == '0' && !yes) ans = i;
        if (c == '5' && !yes) ans = i + 1;
        return ans;
    }
}


