package leetcode.nowcoder;

/**
 * @program: LeetCodeSolution
 * @description:
 * @author: WhyWhatHow
 * @create: 2020-05-21 19:24
 **/

import java.util.HashSet;
import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String s = sc.nextLine();
            System.out.println(dealWith(s));

        }
    }

    // 根据输入 s 输出回文串的数量
    private static int dealWith(String s) {
        int[] need = new int[26];

        for (int i = 0; i < s.length(); i++) {
            need[s.charAt(i) - 'a']++;
        }
        int sum = 0;
        int cnt = 0; // 所有的偶数可以凑一个大回文串 即AA
        boolean check = false;
        // odd ,odd
        // even ,even
        HashSet<Integer> set = new HashSet<>();
        for (int i : need) {
            if (i % 2 != 0 && i != 1) {
                set.add(i);
            }
            if (i == 1) {
                cnt++;
            }
        }

        int size = set.size();
        cnt += size;

        return Math.max(cnt, 1);
//            abbaa

    }


}

