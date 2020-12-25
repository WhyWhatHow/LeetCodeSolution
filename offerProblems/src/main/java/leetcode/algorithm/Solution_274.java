package leetcode.algorithm;

import java.util.Arrays;

/**
 * @program: LeetCodeSolution
 * @description:
 * @author: WhyWhatHow
 * @create: 2020-05-07 12:09
 **/

public class Solution_274 {

    /**
     * h指数: 表示 h篇文章 中,每篇文章的引用次数>=h
     * @param citations
     * @return 文章数,
     */
    public int hIndex(int[] citations) {
        int ans = 0;
        Arrays.sort(citations);
        int index = 0;
        for (int c : citations) {
            // 当前文章的应用数
            // c: 文章的饮用数量
            // length-index, 表示文章数
            if (c >= citations.length - index) {
                return   citations.length-index;
            }else index++;
        }
        return 0;
    }

    public static void main(String[] args) {
        Solution_274 sol = new Solution_274();
        int i = sol.hIndex(new int[]{3, 0, 6, 1, 5});
        System.out.println("==================");
    }
}


