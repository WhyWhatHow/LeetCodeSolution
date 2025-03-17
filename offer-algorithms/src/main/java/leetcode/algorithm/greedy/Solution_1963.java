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
        int ans = 0;
        int c = 0;// '[' 数量
        for (char a : cs) {
            if (a == '[') c++;
            else if (c > 0) c--;
            else {
                ans++;
                c++;
            }
        }
        return ans;
    }

}


