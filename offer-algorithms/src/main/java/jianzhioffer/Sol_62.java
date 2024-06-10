package jianzhioffer;

/**
 * @program: LeetCodeSolution
 * @description:
 * @author: WhyWhatHow
 * @create: 2020-05-22 08:10
 **/
public class Sol_62 {
    /**
     * 算法是参考的精选答案:
     * 模拟 n=5, m=3 这个过程
     * * 0,1,2,3,4__0,1,2,3,4  第一次选出 2 , 先前移动 m个格子, 即3格 ;**数组下标3,数组长度5**
     * * 34,0,1__3401 -> 第二次选出 0, 先前移动3格 ;**数组下标0, 数组长度4**
     * * 134__134 -> 第三次选出 4, 移动三格; **数组下标 1,数组长度3**
     * * 13__13 -> 选出 1 移动三格; **数组下标1,数组长度2**
     * * 3-> 余数3,**数组下标0,数组长度1**
     *
     * 反推, 参考 答案
     * @param n
     * @param m
     * @return
     */
    public int lastRemaining(int n, int m) {
        int ans = 0;// 表示最后一个元素下标
        for (int i = 2; i <= n; i++) {
            ans = (ans + m) % i;
        }
        return ans;
    }

    /**
     * 模拟,超时, 换成迭代算法
     *
     * @param n
     * @param m
     * @return
     */
    public int lastRemaining1(int n, int m) {
        boolean[] vis = new boolean[n];
        int cnt = 0; // 0-m
        int step = 0;// 0-n

        while (n != 1) {
            if (!vis[step]) {
                cnt++;
            }
            if (cnt == m) {
                vis[step] = true;
                n--;
                cnt = 0;
            }
            if (step == vis.length - 1) {
                step = 0;
                continue;
            }

            step++;
        }
        int res = -1;
        for (int i = 0; i < vis.length; i++) {
            if (!vis[i]) {
                res = i;
                break;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Sol_62 sol = new Sol_62();
        int i = sol.lastRemaining(5, 3);
        System.out.println(i);
        int i1 = sol.lastRemaining(10, 17);
        int i2 = sol.lastRemaining(10, 7);

        System.out.println(i1);
        System.out.println(i2);
        System.out.println("=======");
    }
}
