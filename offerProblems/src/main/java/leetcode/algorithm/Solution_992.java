package leetcode.algorithm;

import java.util.HashMap;
import java.util.Stack;


public class Solution_992 {
    /**
     * // TODO: 2020/5/21
     * 求子数组的个数：
     * 子数组条件 ：有k个不同元素
     *
     * @param A
     * @param K
     * @return
     */
    public int subarraysWithKDistinct(int[] A, int K) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int start = 0, end = 0, cnt = 0;
        for (int i = 0; i < A.length; i++) {
            int num = A[i];
            if (map.containsKey(num)) {

            }
        }
        return -1 ;

    }

    public static void main(String[] args) {
        Solution_992 sol = new Solution_992();
    }
}
