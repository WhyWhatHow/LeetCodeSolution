package jianzhiOffer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @program: LeetCodeSolution
 * @description:
 * @author: WhyWhatHow
 * @create: 2020-05-22 08:10
 **/
public class Sol_57_2 {

    public int[][] findContinuousSequence(int target) {
        int mid = (target >> 1) + 1;
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();

        for (int i = 1; i < mid; i++) {
            int temp = i;
            for (int j = i + 1; j <=mid; j++) {
                temp += j;
                if (temp < target) {
                    continue;
                } else if (temp == target) {
                    addToList(res, i, j);
                    break;
                } else {
                    break;
                }
            }
        }
        return transformData(res);
    }

    private int[][] transformData(ArrayList<ArrayList<Integer>> res) {
        int[][] ans = new int[res.size()][];
//        ans = res.toArray(ans);
        int cnt = 0;
        for (ArrayList<Integer> re : res) {
            int i = 0;

            ans[cnt]=new int[re.size()];

            for (Integer integer : re) {
                ans[cnt][i++] = integer;
            }
            cnt++;
        }
        return ans;
    }

    private void addToList(ArrayList<ArrayList<Integer>> res, int i, int j) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int k = i; k <= j; k++) {
            list.add(k);
        }
        res.add(list);
    }


    public static void main(String[] args) {
        Sol_57_2 sol = new Sol_57_2();
        int[][] continuousSequence = sol.findContinuousSequence(15);
        for (int[] ints : continuousSequence) {
            System.out.println();
        }
        System.out.println("=======");
    }


}
