package leetcode.algorithm.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * @program: LeetCodeSolution
 * @description:
 * @author: WhyWhatHow
 **/

public class Solution_2981 {

    public static void main(String[] args) {
        Solution_2981 sol = new Solution_2981();
        System.out.println(sol.maximumLength("aaaa"));

        System.out.println("==================");
    }


    /**
     * map.put(c,list_position)
     * cnt[c-'a']++;
     * a
     *
     * @param s
     * @return
     */
    public int maximumLength(String s) {

        char[] cs = s.toCharArray();

        ArrayList[] lists = new ArrayList[26];
        Arrays.setAll(lists, i -> new ArrayList<Integer>());

        int cnt = 0;
        for (int i = 0; i < cs.length; i++) {
            cnt++;
            if (i + 1 == cs.length || cs[i] != cs[i + 1]) {
                lists[cs[i] - 'a'].add((cnt));
                cnt = 0;
            }


        }

        int res = -1;
        for (ArrayList<Integer> list : lists) {

            if (list.isEmpty()) {
                continue;
            }
            /// 避免l2,l3  == 0
            list.add(0);
            list.add(0);

            list.sort(Collections.reverseOrder());

            res = Math.max(res, Math.max(list.get(0)-2,
                        Math.max(
                                Math.min(list.get(0)-1,list.get(1)),
                                list.get(2)
                        )));

//            res = Math.max(list.get(0) - 2, Math.min(list.get(0) - 1, list.get(1)));
//            res = Math.max(res, list.get(2));

        }

        return res>=0 ? res : -1;
    }
}


