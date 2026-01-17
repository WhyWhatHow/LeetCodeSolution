package leetcode.algorithm.medium;

/**
 * @program: LeetCodeSolution
 * @description: #
 * @author: WhyWhatHow
 **/
public class Solution_3047 {

    public static void main(String[] args) {
        Solution_3047 sol = new Solution_3047();
        System.out.println(sol.largestSquareArea(

//                new int[][]{{1, 1}, {2, 2}, {1, 2}}, new int[][]{{3, 3}, {4, 4}, {3, 4}})
//                new int[][]{{2,2},{1,3}},
//                new int[][]{{3,4},{5,5}}

                new int[][]{{2, 2}, {2, 3}},
                new int[][]{{4, 3}, {3, 4}}
        ));
        System.out.println("==================");
    }

    public long largestSquareArea(int[][] bl, int[][] tr) {
        int n = bl.length;

        long edge = 0;
        // 枚举所有的交集
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                edge = Math.max(edge, getEdge(i, j, bl, tr));
            }
        }
        return edge == 0 ? -1 : edge * edge;
    }

    // 直接考虑相交的情况. 二维到一维, 只看x轴, 与只看y轴.
    private int getEdge(int i, int j, int[][] bl, int[][] tr) {
        // a
        int asx = bl[i][0], asy = bl[i][1];
        int aex = tr[i][0], aey = tr[i][1];

        // b 矩形
        int bsx = bl[j][0], bsy = bl[j][1]; // bottom left
        int bex = tr[j][0], bey = tr[j][1]; // top right

        // x 轴 , [asx, aex], [bsx,bex]
        int left = Math.max(asx, bsx);
        int right = Math.min(aex, bex);//
        int dx = right - left;
        // y轴   asy, bsy ,
        int down = Math.max(asy, bsy);
        int top = Math.min(aey, bey);
        int dy = top - down;
        return Math.min(dy, dx);
    }
}


