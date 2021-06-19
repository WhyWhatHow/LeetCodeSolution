package jianzhiOffer;

/**
 * @program: LeetCodeSolution
 * @description:
 * @author: WhyWhatHow
 * @create: 2020-05-22 08:10
 **/
public class Sol_60 {

    public double[] dicesProbability(int n) {
        double[] ans = new double[6 * n - 1];
        double base = 0.16667 * n;
        int mid = ans.length / 2;
        double x=0.0d;
        for (int i = 0; i < mid; i++) {

            ans[i] = x;
            ans[ans.length - 1 - i] = x;
        }
        return ans;
    }

    public static void main(String[] args) {
        Sol_60 sol = new Sol_60();
        System.out.println("=======");
    }
}
