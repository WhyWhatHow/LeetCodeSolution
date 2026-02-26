package leetcode.algorithm.medium;

/**
 * @program: LeetCodeSolution
 * @description: #
 * @author: WhyWhatHow
 **/
public class Solution_1404 {

    public static void main(String[] args) {
        Solution_1404 sol = new Solution_1404();//
        System.out.println(sol.numSteps(
//                "1101"
//                "1"
                "10"
        ));
        System.out.println("==================");
    }

    public int numSteps(String s) {
        char[] ss = s.toCharArray();
        char[] cs = new char[ss.length + 1];
        for (int i = 0; i < ss.length; i++) {
            cs[i + 1] = ss[i];
        }
        cs[0] = '0';
        int n = cs.length;
        int cnt = 0;
        for (int i = n - 1; i > 0; ) {
            //'01'
            if (i == 1 && (cs[i] == '1' && cs[0] == '0')) break;
            if (i == 0 && cs[i] == '1') break;
            if (cs[i] == '1') {
                cnt++;
                for (int j = i; j >= 0; j--) {
                    if (cs[j] == '1') cs[j] = '0';
                    else {
                        cs[j] = '1';
                        break;
                    }
                }
            } else {
                cnt++;
                i--;
            }

        }
        return cnt;
    }

}
