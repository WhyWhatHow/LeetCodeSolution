package leetcode.algorithm.easy;

/**
 * @program: LeetCodeSolution
 * @description: #
 * @author: WhyWhatHow
 **/

public class Solution_3200 {

    public static void main(String[] args) {
        Solution_3200 sol = new Solution_3200();
        System.out.println(sol.maxHeightOfTriangle(10, 1));
        System.out.println("==================");
    }

    public int maxHeightOfTriangle(int red, int blue) {
        int res = getHeight(red, blue);
        res = Math.max(res, getHeight(blue, red));
        return res;
    }


    /***
     *  返回第一,和第二个的数量
     * @param first
     * @param second
     * @return
     */
    private int getHeight(int first, int second) {
        int add = 2;
        int res = 0;
        int sc =0 , scc = 0 ;
        int c = 0, cc = 0;
        boolean next = true; // true :first color  ,false : second
        while (true) {
            c += c == 0 ? 1 : 2;
            sc+=c;
            if (sc > first) break;
            next = false;
            res++;

            cc += 2;
            scc+=cc;
            if (scc > second) break;
            next = true;
            res++;
        }
        if (next && sc + 2 <= first) res++;
        else if (!next && scc + 2 <= second) res++;
        return res;

    }
}


