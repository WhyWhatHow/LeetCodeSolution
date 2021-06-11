package jianzhiOffer;

/**
 * @program: LeetCodeSolution
 * @description:
 * @author: WhyWhatHow
 * @create: 2020-05-22 08:10
 **/
public class Sol_29 {

    public int[] spiralOrder(int[][] matrix) {
        if (matrix.length==0) {
            return null;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        if (m == 0 || n == 0) {
            return new int[0];
        }
        int[] ans = new int[m * n];
        int up = 0, down = m - 1, left = 0, right = n - 1;
        int cnt = 0;
        int all = m*n;
        while (cnt < all) {
            for (int i = left; i <=right; i++) {
                ans[cnt++] = matrix[up][i];
            }
            up++;
            if(cnt>=all){
                break;
            }
            for (int i = up; i <=down; i++) {
                ans[cnt++] = matrix[i][right];
            }
            right--;
            if(cnt>=all){
                break;
            }
            for (int i = right; i >=left ; i--) {
                ans[cnt++] = matrix[down][i];
            }
            if(cnt>=all){
                break;
            }
            down--;
            for (int i = down;i>=up;i--){
                ans[cnt++] = matrix[i][left];
            }left++;
            if(cnt>=all){
                break;
            }
        }
        return  ans;
    }

    public static void main(String[] args) {
        Sol_29 sol = new Sol_29();
        System.out.println("=======");
    }
}
