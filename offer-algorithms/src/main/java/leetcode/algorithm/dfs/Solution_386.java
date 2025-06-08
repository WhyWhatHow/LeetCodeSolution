package leetcode.algorithm.dfs;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: LeetCodeSolution
 * @description: #
 * @author: WhyWhatHow
 **/

public class Solution_386 {

    public static void main(String[] args) {
        Solution_386 sol = new Solution_386();

        System.out.println("==================");
    }

    public List<Integer> lexicalOrder(int n) {
        List<Integer> res = new ArrayList<>();
        int number = 1;
        for (int i = 0; i < n; i++) {
            res.add(number);
            if (number * 10 <= n) {
                number *= 10;
            } else {
                while (number % 10 == 9 || number + 1 > n) {
                    number /= 10;
                }
                number++;
            }
        }

        return res;
    }


    public List<Integer> lexicalOrderByDfs(int n) {
        var list = new ArrayList<Integer>();
        for (int i = 1; i < 10; i++) {
            dfs(i, n, list);
        }
        return list;
    }

    private void dfs(int i, int n, ArrayList<Integer> list) {
        if (i <= n) list.add(i);
        if (i > n) return;
        for (int j = 0; j < 10; j++) {
            if ((i * 10 + j) <= n) {
                dfs(i * 10 + j, n, list);
            } else break;
        }
    }
}


