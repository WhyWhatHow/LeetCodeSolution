package leetcode.algorithm.greedy
        ;

/**
 * @program: LeetCodeSolution
 * @description: #
 * @author: WhyWhatHow
 **/

public class Solution_955 {

    public static void main(String[] args) {
        Solution_955 sol = new Solution_955();
        System.out.println(sol.minDeletionSize(new String[]{"xga", "xfb", "yfa"}));
        System.out.println("==================");
    }

    public int minDeletionSize(String[] strs) {
        int res = 0;
        int n = strs.length;
        int m = strs[0].length();
        boolean[] v = new boolean[n]; // v[i] 表示 i, i+1 是否是 c(i) < c(i+1)
        for (int i = 0; i < m; i++) {
            if (isUnsorted(i, strs, v)) {
                res++;
                continue;
            } else {
                updateVArray(i, strs, v);
            }
            if (checkAllSorted(v)) break;
        }

        return res;

    }

    private boolean checkAllSorted(boolean[] v) {
        for (boolean b : v) {
            if (!b) return false;
        }
        return true;
    }

    // 根据第i列对v数组进行更新,如果严格单调递增,则v[j] 设置为true, 就可以跳过比较.
    private void updateVArray(int i, String[] strs, boolean[] v) {
        int n = strs.length;
        for (int j = 0; j < n - 1; j++) {
            if (v[j]) continue;
            if (strs[j].charAt(i) < strs[j + 1].charAt(i)) v[j] = true;
        }

    }

    // 判断第 i col 是否 是严格单调递增.
    private boolean isUnsorted(int i, String[] strs, boolean[] v) {
        int n = strs.length;
        int m = strs[0].length();
        for (int j = 0; j < n - 1; j++) {
            if (v[j]) continue;
            if (strs[j].charAt(i) > strs[j + 1].charAt(i)) {
                return true;
            }
        }
        return false;
    }


}