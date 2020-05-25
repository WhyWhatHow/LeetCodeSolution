package leetcode.nowcoder;

/**
 * @program: LeetCodeSolution
 * @description:
 * @author: WhyWhatHow
 * @create: 2020-05-21 19:24
 **/

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        System.out.println(dealWith(s));
    }

    // 通过去偶串的个数获取仍是偶串的数据
    private static int dealWith(String s) {
        int length = s.length();
        char[] chars = s.toCharArray();
        int end = length - 1, mid;
        boolean check;
        char first = chars[0];
        String sub = "";
        String subb = "";
        int ans = 0;

        mid = length / 2;
        check = length % 2 == 0;
        while (mid >= 0) {
            end--;
            length--;
            if (check) {
                // 偶数
                sub = s.substring(0, mid - 1);
                subb = s.substring(mid, end);
                if (sub.equals(subb)) {
                    ans = end + 1;
                    break;
                }
            } else {
                sub = s.substring(0, mid);
                subb = s.substring(mid, end + 1);
                if (sub.equals(subb)) {

                    ans = end + 1;
                    break;
                }
            }

            mid = length / 2;
            check = length % 2 == 0;

        }
        return ans;
    }
}

