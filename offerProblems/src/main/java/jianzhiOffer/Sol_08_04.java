package jianzhiOffer;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: LeetCodeSolution
 * @description:
 * @author: WhyWhatHow
 * @create: 2020-05-22 08:10
 **/
public class Sol_08_04 {

    int pow(int a, int n) {
        int base = a, ans = 1;
        while (n != 0) {
            if ((n & 1) != 0) { // 奇数情况
                ans *= base;
            }
            n >>= 1;
            base *= base;
        }
        return ans;
    }

    double pow(double a, int n) {

        if (n == 0) {
            return 1;
        }
        double ans = 1, base = a;
        while (n != 0) {
            if ((n & 1) == 1) {
                ans *= base;
            }
            n = n >> 1;
            base *= base;

        }
        return ans;
    }



    public static void main(String[] args) {
        Sol_08_04 sol = new Sol_08_04();
        int a = 4, b = 0;
//        System.out.println(a >>> b);
//        List<List<Integer>> subsets = sol.subsets(new int[]{1, 2, 3});
//        for (List<Integer> subset : subsets) {
//            for (Integer integer : subset) {
//                System.out.print(integer+",");
//            }
//            System.out.println();
//        }
//        sol.getPrime(10000);
////        for (int i = 0; i < sol.cnt; i++) {
////            System.out.println(sol.prime[i]);
////        }
//        System.out.println(pow + "," + pow1);

    }

    final static int MAX = 100086;
    int[] prime = new int[MAX];
    boolean vis[] = new boolean[MAX];
    int cnt = 0; //素数的个数

    void getPrime(int n) {
        for (int i = 2; i < n; i++) {
            if (!vis[i]) {
                prime[cnt++] = i;
                for (int j = i * 2; j < n; j += i) {
                    vis[j] = true;
                }
            }
        }
    }
}
