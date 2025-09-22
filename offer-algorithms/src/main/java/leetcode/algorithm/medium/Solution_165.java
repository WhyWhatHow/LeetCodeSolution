package leetcode.algorithm.medium;

/**
 * @program: LeetCodeSolution
 * @description: #
 * @author: WhyWhatHow
 **/

public class Solution_165 {

    public static void main(String[] args) {
        Solution_165 sol = new Solution_165();
        System.out.println(Integer.parseInt("00021"));
        System.out.println(sol.compareVersion(
                "1.2", "1.10"
        ));
        System.out.println("==================");
    }

    public int compareVersion(String version1, String version2) {
        String[] vs = version1.split("\\.");
        String[] vss = version2.split("\\.");
//        boolean yes = true; // v1>v2
        int len = Math.min(vs.length, vss.length);
        int i;
        for (i = 0; i < len; i++) {
            int a = Integer.parseInt(vs[i]);
            int b = Integer.parseInt(vss[i]);
            if (a < b) {
                return -1;
            }
            if (a > b) {
                return 1;
            }
        }
        // chcek vs
        while (i < vs.length) {
            if (Integer.parseInt(vs[i]) != 0) {
                return 1;
            }
            i++;
        }

        // check vss
        while (i < vss.length) {
            if (Integer.parseInt(vss[i]) != 0) {
                return -1;
            }
            i++;
        }
        return 0;
    }
}


