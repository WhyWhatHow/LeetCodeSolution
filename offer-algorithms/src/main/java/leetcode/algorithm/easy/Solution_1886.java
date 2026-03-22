package leetcode.algorithm.easy;

/**
 * @program: LeetCodeSolution
 * @description: #
 * @author: WhyWhatHow
 **/
public class Solution_1886 {

    public static void main(String[] args) {
        Solution_1886 sol = new Solution_1886();//

        System.out.println("==================");
    }

    public boolean findRotation(int[][] mat, int[][] target) {
        int n = mat.length;

        boolean yes = true;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] != target[i][j]) {
                    yes = false;
                    break;
                }
            }
        }
        if (yes) return yes;
        yes = true;
        // 旋转1次
        //0, 0->0,n-1,  0,n-1-> n-1,n-1
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int x = j;
                int y = n - 1 - i;
                if (mat[i][j] != target[x][y]) {
                    yes = false;
                    break;
                }
            }
        }

        if (yes) return true;
        // 旋转两次,
        // 0,0  -> n-1, n-1 , 0,1 , n-1, n-2,
        // 1,0 -> n-2,n-1,

        yes = true;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int tx = n - 1 - i;
                int ty = n - 1 - j;
                if (mat[i][j] == target[tx][ty]) continue;
                else {
                    yes = false;
                    break;
                }
            }
        }
        if (yes) return true;

        yes = true;
        // 旋转三次 , 0,0 -> n-1,0 , 0,n-1,-> 0,0
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int x = n - 1 - j;
                int y = i;
                if (mat[i][j] != target[x][y]) {
                    return false;
                }
            }
        }
        return yes;

    }

}
