package leetcode.algorithm.weekly;

import java.util.Set;

/**
 * @program: LeetCodeSolution
 * @description:
 * @author: WhyWhatHow
 * @create: 2025-12-07 10:29
 **/
public class Weekly_480 {
    public static void main(String[] args) {
        Weekly_480 sol = new Weekly_480();
//        System.out.println(sol.reverseWords("cat and mice"));
        System.out.println(sol.minMoves(
//                new int[]{-2, 2}
//                new int[]{1, 2, -5, 2}
                new int[]{5, 1, -4}
        ));
        System.out.println("---------------------");
    }


    public long minMoves(int[] balance) {
        long res = 0;
        int n = balance.length;

        // find min
        boolean yes = true;
        long sum = 0;
        int idx = -1;
        for (int i = 0; i < balance.length; i++) {
            sum += balance[i];
            if (balance[i] < 0) {
                yes = false;
                idx = i;
            }
        }
        if (yes) return 0; // every ele >=0
        if (sum < 0) return -1; // 无解
        int cnt = 1;
        long lcost, rcost;
        while (balance[idx] < 0) {
            int l = (idx - cnt + n) % n;
            int r = (idx + cnt) % n;
            // go left
            int abs = Math.abs(balance[idx]);
            lcost = Math.min(abs, balance[l]);
            res += lcost * cnt;
            balance[idx] += lcost;
            balance[l] -= lcost;
            if (balance[idx] >= 0) break;

            // go right
            abs = Math.abs(balance[idx]);
            rcost = Math.min(abs, balance[r]);
            res += rcost * cnt;
            balance[r] -= rcost;
            balance[idx] += rcost;
            if (balance[idx] >= 0) break;
            cnt++;

        }
        return res;
    }


    public String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();
        String[] ss = s.split(" ");
        sb.append(ss[0]);
        sb.append(" ");
        Set<Character> set = Set.of('a', 'e', 'i', 'o', 'u');
        int cnt = getCount(ss[0], set);
        for (int i = 1; i < ss.length; i++) {
            if (getCount(ss[i], set) == cnt) {
                sb.append(new StringBuffer(ss[i]).reverse().toString());
            } else {
                sb.append(ss[i]);
            }
            if (i != ss.length - 1)
                sb.append(" ");
        }
        return sb.toString();
    }

    private int getCount(String s, Set<Character> set) {
        char[] cs = s.toCharArray();
        int cnt = 0;
        for (char c : cs) {
            if (set.contains(c)) {
                cnt++;
            }
        }
        return cnt;

    }
}

 