package leetcode.algorithm.dfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;

/**
 * @program: LeetCodeSolution
 * @description: #
 * @author: WhyWhatHow
 **/

public class Solution_2094 {

    public static void main(String[] args) {
        Solution_2094 sol = new Solution_2094();
        Arrays.stream(sol.
                        findEvenNumbers(new int[]{2, 1, 3, 0})
//                findEvenNumbersForce(new int[]{2, 1, 3, 0})
        ).sequential();

        System.out.println("==================");
    }

    // dfs
    public int[] findEvenNumbers(int[] digits) {
        int[] cs = new int[10];
        for (int i : digits) {
            cs[i]++;
        }
        ArrayList<Integer> q = new ArrayList();
        dfs(0, 0, cs, q);
        return q.stream().mapToInt(i -> i).toArray();
    }

    //dfs(i,k) 从百位->各位的顺序是i, k 表示当前的取值.
    private void dfs(int i, int k, int[] cs, ArrayList<Integer> q) {
        if (i == 3) {
            q.add(k);
            return;
        }
        for (int j = 0; j < cs.length; j++) {
            if (cs[j] == 0) continue;
            if ((i == 0 && j != 0) ||// 百
                    (i == 1) ||
                    (i == 2 && (j & 1) == 0)) { // 个位
                cs[j]--;
                dfs(i + 1, k * 10 + j, cs, q);
                cs[j]++;
            }
        }
    }

    public int[] findEvenNumbersForce(int[] digits) {
        int[] cs = new int[10];
        for (int d : digits) {
            cs[d]++;
        }
        ArrayList<Integer> q = new ArrayList<>();
        for (int i = 100; i < 1000; i += 2) {
            if (hasI(i, cs)) {
                q.add(i);
            }
        }
        return q.stream().mapToInt(i -> i).toArray();
    }

//    HashMap<Integer, Integer> map = new HashMap<>();

    private boolean hasI(int i, int[] cs) {
        int[] a = new int[10];
        while (i > 0) {
            int k = i % 10;
            a[k]++;
            if (a[k] > cs[k]) return false;
            i /= 10;
        }
        return true;
    }

    // mine stupid way
    public int[] findEvenNumbersStupid(int[] digits) {
        Arrays.sort(digits);
        boolean[] vis = new boolean[10]; // last index
        Set<Integer> set = new TreeSet<>();
        for (int i = 0; i < digits.length; i++) {
            if ((digits[i] & 1) == 1) continue;
            if (vis[digits[i]]) continue;
            int val = digits[i];
            vis[val] = true;
            for (int j = 0; j < digits.length; j++) {
                if (i == j) continue;
                val = digits[j] * 10 + digits[i];
                for (int k = 0; k < digits.length; k++) {
                    if (k == i || k == j || digits[k] == 0) continue;
                    set.add(digits[k] * 100 + val);
                }
            }
        }
        int[] ans = new int[set.size()];
        int k = 0;
        for (Integer i : set) {
            ans[k++] = i;
        }
        return ans;
    }
}


