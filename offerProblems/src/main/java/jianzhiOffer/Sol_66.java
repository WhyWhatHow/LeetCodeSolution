package jianzhiOffer;

import java.util.Arrays;

/**
 * @program: LeetCodeSolution
 * @description:
 * @author: WhyWhatHow
 * @create: 2020-05-22 08:10
 **/
public class Sol_66 {
    /**
     *          a[0], a[1], a[2], a[3], a[4]
     *  ans[0]   x,
     *  ans[1]  *a[0], x,
     *  ans[2]   a[0],a[0]*a[1],x,
     *  ans[3]   a[0],a[0]*a[1],a[0]*a[1]*a[2],x,
     *  ans[4]   a[0],a[0]*a[1],a[0]*a[1]*a[2],a[0]*a[1]*a[2]*a[3].x,
     * @param a
     * @return
     */
    public int[] constructArr(int[] a) {
        int[] ans = new int[a.length];
        Arrays.fill(ans, 1);
        int temp = 1;
        for (int i = 1; i < ans.length; i++) {
            temp *= a[i - 1];
            ans[i] = temp;
        }
        temp = 1;
        for (int i = ans.length - 1; i >= 1; i--) {
            temp *= a[i];
            ans[i - 1] *= temp;
        }
        return ans;
    }

    public static void main(String[] args) {
        Sol_66 sol = new Sol_66();
        int[] ints = sol.constructArr(new int[]{
                1, 2, 3, 4, 5
        });
        for (int anInt : ints) {
            System.out.println(anInt+",");
        }
        System.out.println("=======");
    }
}
