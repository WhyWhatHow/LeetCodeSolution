package leetcode.algorithm.medium;

/**
 * @program: LeetCodeSolution
 * @description: #
 * @author: WhyWhatHow
 **/

public class Solution_2483 {

    public static void main(String[] args) {
        Solution_2483 sol = new Solution_2483();
        System.out.println(sol.bestClosingTime("YYNY"));

        System.out.println("==================");
    }

    public int bestClosingTime(String customers) {
        char[] cs = customers.toCharArray();
        int n = cs.length;
        int ally = 0, alln = 0;
        int[] cy = new int[n];
        int[] cn = new int[n]; //

        // init index == 0
        if (cs[0] == 'Y') {
            cy[0] = 1;
            ally++;
        } else cn[0] = 1;

        for (int i = 1; i < cs.length; i++) {
            cy[i] = cy[i - 1];
            cn[i] = cn[i - 1];
            if (cs[i] == 'Y') {
                cy[i]++;
                ally++;
            } else {
                cn[i]++;
            }
        }
//        alln = n - ally;
        int res = 0;
        int min = ally  ; // before 0 hour , the cost is ally count
        for (int i = 0; i < n; i++) {
            // calculate  cost
            int tmp = ally - cy[i] + cn[i];
//            System.out.println(i + ": " + tmp);
            if (min > tmp) {
                min = tmp;
                res = i + 1;
            }
        }
        return res;
    }

}


