package leetcode.algorithm.medium;

/**
 * @program: LeetCodeSolution
 * @description: #
 * @author: WhyWhatHow
 **/

public class Solution_1007 {

    public static void main(String[] args) {
        Solution_1007 sol = new Solution_1007();
        System.out.println(sol.minDominoRotations(new int[]{
                3, 6, 3, 3, 4
        }, new int[]{
                3, 5, 1, 2, 3
        }));
        System.out.println("==================");
    }

    public int minDominoRotations(int[] tops, int[] bottoms) {
        int n = tops.length;
        int[][] cs = new int[7][2]; // top_cnt, bottom_cnt;
        for (int i = 0; i < n; i++) {
            cs[tops[i]][0]++;
            cs[bottoms[i]][1]++;
        }
        boolean yes = false;
        int min = n;
        for (int i = 0; i < cs.length; i++) {
            if (cs[i][0] + cs[i][1] < n) continue;
            // top
            int top = doHandle(tops, bottoms, i);
            // bottom
            int bottom = doHandle(bottoms, tops, i);
            top = Math.min(top, bottom);
            if (top < n) {
                yes = true;
                min = top;
            }
        }
        return yes ? min : -1;
    }

    private int doHandle(int[] fs, int[] ss, int target) {
        int cnt = 0;
        for (int i = 0; i < fs.length; i++) {
            if (fs[i] == target) continue;
            else if (ss[i] == target) cnt++;
            else return fs.length + 1; // wrong target
        }
        return cnt;
    }

}


