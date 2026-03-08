package leetcode.algorithm.greedy;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: LeetCodeSolution
 * @description:
 * @author: WhyWhatHow
 **/

public class Solution_763 {

    public static void main(String[] args) {
        Solution_763 sol = new Solution_763();
        System.out.println("==================");
        System.out.println(sol.partitionLabels("ababcbacadefegdehijhklij"));
        System.out.println(sol.partitionLabels("eccbbbbdec"));
        ;
    }

    public List<Integer> partitionLabels(String s) {
        char[] cs = s.toCharArray();
        var list = new ArrayList<Integer>();
        int[] map = new int[26]; // 记录最后一个字符出现的下标.
        char c = 'a';
        int n = cs.length;
        for (int i = 0; i < n; i++) {
            map[cs[i] - c] = i;
        }

        int max = 0;
        int l = 0, r = l;
        while (r < n && l < n) {
            max = Math.max(max, map[cs[l] - c]);

            while (r < max && r < n) {
                max = Math.max(max, map[cs[r] - c]);
                r++;
            }
            list.add(r - l + 1);
            l = ++r;


        }

        return list;
    }
    /***
     * 思路: 假设s ="aaaabbbcccab...", 需要做的事, 统计每一个元素最后出现的位置,
     * @param s
     * @return
     */
//    public List<Integer> partitionLabels(String s) {
//        char[] chars = s.toCharArray();
//        int[] arr = new int[chars.length];
//        HashMap<Character, Integer> map = new HashMap<>();
//        List<Integer> res = new ArrayList<>();
//        for (int i = 0; i < chars.length; i++) {
//            map.put(chars[i], i);
//        }
//        for (int i = 0; i < chars.length; i++) {
//            arr[i] = map.get(chars[i]);
//        }
//
//        for (int i = 0; i < arr.length; ) {
//            int left = i, right = arr[left];
//            while (left <= right) {
//                if (right < arr[left]) right = arr[left];
//                left++;
//            }
//            res.add(left - i);
//            i =left++;
//        }
//        return res;
//    }
}


