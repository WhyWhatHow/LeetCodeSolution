package leetcode.algorithm.array;

import java.util.Arrays;

/**
 * @program: LeetCodeSolution
 * @description:
 * @author: WhyWhatHow
 **/

public class Solution_1535 {

    public static void main(String[] args) {
        Solution_1535 sol = new Solution_1535();
        System.out.println(sol.getWinner(new int[]{
//                2, 1, 3, 5, 4, 6, 7
                        1, 25, 35, 42, 68, 70
                },
                2
        ));
        System.out.println("==================");
    }

    public int getWinner(int[] arr, int k) {
        int max = arr[0];
        int cnt = 0;
        for (int i = 1; i < arr.length; i++) {

            if (max < arr[i]) {
                max = arr[i];
                cnt = 0;
            }
            cnt++;
            if (cnt == k) {
                break;
            }
        }
        return max;
    }

    /**
     * 模拟
     *
     * @param arr
     * @param k
     * @return
     */
    public int getWinnerStupid(int[] arr, int k) {
        int res = -1;
        if (k >= arr.length) {
            return Arrays.stream(arr).max().getAsInt();
        }
        int step = 0;
        int[] end = new int[arr.length];

        // handle arr
        int i = 0, j = 1, cnt = 0;
        int max = -1;
        while (j < arr.length) {
            if (arr[i] > arr[j]) {
                // 加入队尾
                end[step++] = arr[j];
                j++;
                cnt++;
            } else {
                end[step++] = arr[i];
                cnt = 1;
                i = j;
                j++;
            }
            if (cnt == k) {
                res = arr[i];
                break;
            }
        }
        // handle end
//        while ()
//        System.out.println(1);
        return res == -1 ? arr[i] : res;
    }

}


