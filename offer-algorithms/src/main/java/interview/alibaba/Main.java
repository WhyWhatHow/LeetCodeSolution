package interview.alibaba;

// 本题为考试多行输入输出规范示例，无需提交，不计分。

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Main sol = new Main();
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int n, m;
        int max = 100001;
        while (t > 0) {
            t--;
            m = sc.nextInt();
            n = sc.nextInt();

            int a[] = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }
            System.out.println(sol.solve(a, m));

        }


    }

    private int solve(int[] a, int m) {
        int len = 0;
        int n = a.length;
        while (n > 0) len += n--;
        Pos[] ans = new Pos[len];
        int temp = 0;
        int[] pre = new int[a.length];
        pre[0] = a[0];
        for (int i = 1; i < a.length; i++) {
            pre[i] = pre[i - 1] + a[i];
        }
        //
        int cnt = 0;
        for (int i = 0; i < a.length; i++) {
            for (int j = i; j < a.length; j++) {
                Pos pos = new Pos();
                pos.x = i;
                pos.y = j;
                if (i == j) {
                    pos.val = pre[i];
                } else {
                    pos.val = pre[j] - pre[i];
                }
                ans[cnt++] = pos;
            }
        }
        Arrays.sort(ans, new Comparator<Pos>() {
            @Override
            public int compare(Pos o1, Pos o2) {
                if (o1.val < o2.val) return -1;
                else if (o1.val == o2.val) {
                    int temp = o1.y - o1.x;
                    int tt = o2.y - o2.x;
                    if (temp > tt) return -1;
                    else if (temp == tt) {

                        if (o1.x < o2.x) {
                            return -1;
                        } else if (o1.x == o2.x) {
                            if (o1.y < o2.y) return -1;
                        }
                    }

                }
                return 0;
            }
        });

        for (Pos an : ans) {
            System.out.println(an.x + "," + an.y + "," + an.val);
        }
        int sum = 0;
        int left = a.length, right = a.length;
        for (int i = ans.length - 1; i >= 0; i--) {
            Pos pos = ans[i];
            if (pos.y <= left) {
                sum += pos.val;
                left = pos.x;
                right = pos.y;
                m--;
            }
            if (m == 0)
                break;
        }
        return sum;
    }

}

/**
 * 2
 * 1 3
 * 1 2 3
 * 2 6
 * -1 4 -2 3 -2 3
 */
class Pos {
    int x, y, val;

}
