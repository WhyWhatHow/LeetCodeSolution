package leetcode.algorithm.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

/**
 * @program: LeetCodeSolution
 * @description:
 * @author: WhyWhatHow
 **/

public class Solution_2982 {

    public static void main(String[] args) {
        Solution_2982 sol = new Solution_2982();
        System.out.println(sol.maximumLength("aaaa"));
        System.out.println("==================");
    }


    /***
     * l1 最长子串,l2 次长子串,l3 第三长子串
     * 1. s= "aaaa" -> res = l1 -2  //
     * 2.相当于在l1中选了两端l2长度的子串,以及l2
     *  1)s = "aaaabaaaa", l1 ==l2,res = l1 -1
     *  2)s ="aaaaba", l1>l2 , res = l2(相当于在l1中选了两端l2长度的子串,以及l2)
     *  res = min(l1-1, l2)
     *  3. 选l3的长度作为最长子串
     *  s= aaabaaba
     *  res = max(l1-2, min (l1-1, l2),l3)
     * @param s
     * @return
     */
    public int maximumLength(String s) {

        char[] chars = s.toCharArray();
        ArrayList[] lists = new ArrayList[26];
        Arrays.setAll(lists, i -> new ArrayList<Integer>());

        // count
        int cnt = 0;
        for (int i = 0; i < chars.length; i++) {
            cnt++;
            if (i + 1 == chars.length || chars[i] != chars[i + 1]) {
                lists[chars[i] - 'a'].add(cnt);
                cnt = 0;
            }

        }

        int res = -1;
        //
        for (ArrayList<Integer> list : lists) {
//            list.sort(Collections.reverseOrder());
            if (list.size() == 0) {
                continue;
            }
            list.sort(Comparator.reverseOrder());
            list.add(0); // l1 =0
            list.add(0);// l2 = 0
            res = Math.max(res, list.get(0) - 2);
            res = Math.max(res, Math.min(list.get(0) - 1, list.get(1)));
//            res = Math.max(res, Math.max(list.get(0) - 2, Math.min(list.get(0) - 1, list.get(1))));
            res = Math.max(res, list.get(2));
        }
        return res > 0 ? res : -1;

    }
}


