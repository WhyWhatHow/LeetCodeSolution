package leetcode.algorithm.greedy;

/**
 * @program: LeetCodeSolution
 * @description: #hard
 * @author: WhyWhatHow
 **/

public class Solution_2663 {

    public static void main(String[] args) {
        Solution_2663 sol = new Solution_2663();
        System.out.println(sol.smallestBeautifulString(
//                "abcz", 26
//                "ced",6
                "dc", 4
        ));
        System.out.println("==================");
    }

    /**
     * 貌似只有最后aa, 或者是aba 这种情况. 所以遍历应该就可以.
     *
     * @param s
     * @param k
     * @return
     */
    public String smallestBeautifulString(String s, int k) {
        char maxC = (char) ('a' + k );
        char[] arr = s.toCharArray();
        boolean yes = false;
        int idx = -1; // have answer position

        // have answer or not
        for (int i = arr.length - 1; i >= 0; i--) {
            char c = arr[i];
            //abcz
            while ((++c) < maxC) {
                if (!check(arr, i, c)) {
                    yes = true;
                    arr[i] = c;
                    idx = i;
                    break;
                }
            }
            if (yes) {
                break;
            }
        }

        // create min answer
        if (yes) {
            char origin = 'a';
            for (int i = idx + 1; i < arr.length; i++) {
                arr[i] = origin;
                while (check(arr, i, arr[i])) {
                    arr[i]++;
                }
            }
        }

        return yes ? String.valueOf(arr) : "";
    }

    /**
     * cs[ i-1,i]  子串长度为2 是否是回文 是返回true .
     * cs[i-2,i] 子串长度为3  是否是回文判断即可. 是 返回true
     * 都不是返回 false
     *
     * @param cs
     * @param i
     * @param c  changed char
     * @return
     */
    private boolean check(char[] cs, int i, char c) {
        boolean check = true;
        if (i > 0 && c == cs[i - 1]) check = true;
        else if (i > 1 && c == cs[i - 2]) check = true;
        else check = false;
        return check;
    }


}


