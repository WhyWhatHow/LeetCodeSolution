package leetcode.algorithm.greedy;

/**
 * @program: LeetCodeSolution
 * @description: #
 * @author: WhyWhatHow
 **/

public class Solution_1963 {

    public static void main(String[] args) {
        Solution_1963 sol = new Solution_1963();
//        System.out.println(sol.minSwaps("]]][[["));
        System.out.println(sol.minSwaps("[[[]]]][][]][[]]][[["));
        System.out.println("==================");
    }

    public int minSwaps(String s) {
        char[] cs = s.toCharArray();
        int l = 0, r = cs.length - 1;
        int mid = cs.length / 2;
        int ans = 0;
        int c = 0;// '[' 数量
        for (; l < cs.length; l++) {
            if (cs[l] == '[') c++;
            else if (c > 0) c--;
            else {
                c = 1;
                ans++;
                while (r >= mid) {
                    if (cs[r] == '[') {
                        swap(cs, l, r);
                        r--;
                        break;
                    }
                    r--;
                }
            }

        }
        return ans;
    }

    private void swap(char[] cs, int l, int r) {
        char c = cs[l];
        cs[l] = cs[r];
        cs[r] = c;
    }
}


