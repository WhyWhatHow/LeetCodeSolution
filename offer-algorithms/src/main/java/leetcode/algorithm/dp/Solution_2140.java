package leetcode.algorithm.dp;

/**
 * @program: LeetCodeSolution
 * @description: #
 * @author: WhyWhatHow
 **/

public class Solution_2140 {

    public static void main(String[] args) {
        Solution_2140 sol = new Solution_2140();
        System.out.println(sol.mostPoints(new int[][]{
                {1, 1}, {2, 2}, {3, 3}, {4, 4}, {5, 5}
//                {12, 46},
//                {78, 19},
//                {63, 15},
//                {79, 62},
//                {13, 10}
        }));
        System.out.println("==================");
    }

    long[] f;// f[i] means [i,n-1] 最大值

    /**
     * 对于i 位置,
     * 选择的话 f[i] = f[i+skip+1] + points_i;
     * 不选择的话 f[i] = f[i+1]
     */
    public long mostPoints(int[][] questions) {
        int n = questions.length;
        f = new long[n];
        dfs(0, questions);
        long res = 0 ;
        for (long l : f) {
            res= Math.max(l,res);
        }
        return res;
    }

    private long dfs(int i, int[][] questions) {
        if(i>=questions.length) return 0 ;
        if (f[i] != 0) return f[i];
        // use i
        long res = dfs(i + questions[i][1]+1, questions) + questions[i][0];
        // not use i  ==> dfs(i+1)
        res = Math.max(res, dfs(i + 1, questions));
        return f[i] = res;
    }


}


