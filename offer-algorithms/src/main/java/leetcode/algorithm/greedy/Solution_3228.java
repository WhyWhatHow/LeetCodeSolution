package leetcode.algorithm.greedy;

/**
 * @program: LeetCodeSolution
 * @description: #
 * @author: WhyWhatHow
 **/

public class Solution_3228 {

    public static void main(String[] args) {
        Solution_3228 sol = new Solution_3228();
        System.out.println(sol.maxOperations(
//                "001110"
//                "0011101"
                "1001101"
//                "10011011001101"
        ));
        System.out.println("==================");
    }

    public int maxOperations(String s) {
        char[] cs = s.toCharArray();
        boolean[] v = new boolean[cs.length];

        for (int i = cs.length - 2; i >= 0; i--) {
            if (v[i + 1]) v[i] = v[i + 1];
            if (cs[i + 1] == '0') v[i] = true;
        }
        int cnt = 0;
        int cnt1 = 0;// 统计1的数量
        int tmp = 0 ;
//        Stack<Character> ss = new Stack<>();
        for (int i = 0; i < cs.length; i++) {
            if (cs[i] == '0' && tmp > 0) {
//                cnt += ss.size();
                cnt += cnt1;
                tmp = 0;
//                ss.clear();
            } else if (cs[i] == '1' && v[i]) {
                cnt1++;
                tmp++;
//                ss.push(cs[i]);
            }
        }
        return cnt;
    }
}


