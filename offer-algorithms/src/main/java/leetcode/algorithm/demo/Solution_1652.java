package leetcode.algorithm.demo;

import java.util.Arrays;

/**
 * @program: LeetCodeSolution
 * @description:
 * @author: WhyWhatHow
 **/

public class Solution_1652 {

    public static void main(String[] args) {
        Solution_1652 sol = new Solution_1652();
        System.out.printf("", sol.decrypt(new int[]{
//                        5, 7, 1, 4
                        2, 4, 9, 3
                },
//                3
                -2
        ));
        System.out.println("==================");
    }

    public int[] decrypt(int[] code, int k) {
        if (k == 0) {
            Arrays.fill(code, 0);
            return code;
        }
        int[] res = new int[code.length];
        int n = code.length;
        int cnt, temp;
        if (k > 0) {
            for (int i = 0; i < n; i++) {
                cnt = 0;
                temp = 0;
                int j = i + 1;
                while (cnt < k) {
                    cnt++;
                    if (j == n) {
                        j = 0;
                    }
                    temp += code[j++];
                }
                res[i] = temp;
            }
        }
        if (k < 0) {
            k = -k;
            for (int i = n - 1; i >= 0; i--) {
                cnt = 0;
                temp = 0;
                int j = i - 1;
                while (cnt < k) {
                    cnt++;
                    if (j < 0) {
                        j = n - 1;
                    }
                    temp += code[j--];
                }
                res[i] = temp;
            }
        }

        return res;


    }

}


