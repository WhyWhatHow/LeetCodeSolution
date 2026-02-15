package leetcode.algorithm.easy;

import java.util.Arrays;

/**
 * @program: LeetCodeSolution
 * @description: #
 * @author: WhyWhatHow
 **/
public class Solution_67 {

    public static void main(String[] args) {
        Solution_67 sol = new Solution_67();//

        System.out.println(sol.addBinary(
//                "11",
//                "1"
//                "0",
//                "0"
//                "1111",
//                "1111"
                "101111",
                "10"
        ));
        System.out.println("==================");
    }

    public String addBinary(String a, String b) {
        char[] as = a.toCharArray();
        char[] bs = b.toCharArray();
        char[] rs = new char[Math.max(as.length, bs.length) + 1];
        Arrays.fill(rs, '0');
        int i = as.length - 1;
        int j = bs.length - 1;
        int k = rs.length - 1;
        boolean yes = false;
        char zero = '0';
        while (i >= 0 && j >= 0) {
            if (as[i] == '1' && bs[j] == '1') {

                if (yes) {
                    rs[k] = '1';
                } else {
                    rs[k] = zero;
                }
                yes = true;
            } else if (as[i] == '0' && bs[j] == '0') {
                if (yes) {
                    rs[k] = '1';
                    yes = !yes;
                } else {
                    yes = false;
                    rs[k] = zero;
                }
            } else {
                if (yes) {
                    rs[k] = '0';
                    yes = true;
                } else {
                    yes = false;
                    rs[k] = '1';
                }
            }
            i--;
            j--;
            k--;
        }
        while (i >= 0) {

            if (as[i] == '1') {
                if (yes) {
                    rs[k] = zero;
                } else {
                    rs[k] = as[i];
                }
            } else {
                rs[k] = yes ? '1' : '0';
                yes = false;
            }

            k--;
            i--;
        }

        while (j >= 0) {
            if (bs[j] == '1') {
                if (yes) {
                    rs[k] = '0';
                } else {
                    rs[k] = bs[j];
                }
            } else {
                rs[k] = yes ? '1' : '0';
                yes = false;
            }
            k--;
            j--;
        }
        if (yes) {
            rs[k--] = '1';
        }
        return rs[0] == zero ? String.valueOf(rs, 1, rs.length - 1) : String.valueOf(rs);
    }

}
