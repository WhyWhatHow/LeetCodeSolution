package leetcode.algorithm.greedy;

/**
 * @program: LeetCodeSolution
 * @description: #
 * @author: WhyWhatHow
 **/
public class Solution_1536 {

    public static void main(String[] args) {
        Solution_1536 sol = new Solution_1536();//
        System.out.println(sol.minSwaps(
//                new int[][]{{1, 0, 0, 0, 0, 0}, {0, 0, 0, 1, 0, 0}, {0, 0, 0, 1, 0, 0}, {0, 1, 0, 0, 0, 0}, {0, 0, 1, 0, 0, 0}, {0, 0, 0, 0, 0, 1}}
                new int[][]{{0, 0, 1}, {1, 1, 0}, {1, 0, 0}}
        ));
        System.out.println("==================");
    }

    // 题目要求,
    // row_0, 需要n-2个0,
    // row_1, 需要n-3个0
    //..
    // row_n-2,需要n-2个0
    // row_n-1,需要 0个0
    // 贪心, 假设当前是第i行 ,所需要的0的数量是n-1-i个, 贪心的思路是找到第一个>=n-1-i的位置后,交换返回结果即可.
    // 也就是说, 遍历每一行,找到符合每一行目标的第一个值, 依次交换后得到的就是我们要的答案.

    public int minSwaps(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        // init es
        int[] es = new int[n]; // es[i] means in rows[i] , [m-1,0] have es[i] number of 0.
        for (int i = 0; i < grid.length; i++) {
            int cnt = 0;
            for (int j = m - 1; j >= 0; j--) {
                if (grid[i][j] == 0) cnt++;
                else break;
            }
            es[i] = cnt;
        }

        int res = 0;
        // 枚举每一行需要的值 ,找到第一个然后交换得到后返回
        for (int i = 0; i < n - 1; i++) { // n-1, 0
            int tar = n - i - 1;
            if (es[i] >= tar) continue;

            int idx = -1;
            for (int j = i + 1; j < n; j++) {
                if (es[j] >= tar) {
                    idx = j;
                    break;
                }
            }
            if (idx == -1) return -1; // 没有目标值.

            //swap
            for (int k = idx; k > i; k--) {
                int t = es[k];
                es[k] = es[k - 1];
                es[k - 1] = t;
                res++;
            }
        }
        return res;


    }


}
