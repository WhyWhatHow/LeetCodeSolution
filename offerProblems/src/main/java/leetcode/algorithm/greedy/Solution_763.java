package leetcode.algorithm.greedy;

import java.util.ArrayList;
import java.util.HashMap;
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

    /***
     * 思路: 假设s ="aaaabbbcccab...", 需要做的事, 统计每一个元素最后出现的位置,
     * @param s
     * @return
     */
    public List<Integer> partitionLabels(String s) {
        char[] chars = s.toCharArray();
        int[] arr = new int[chars.length];
        HashMap<Character, Integer> map = new HashMap<>();
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < chars.length; i++) {
            map.put(chars[i], i);
        }
        for (int i = 0; i < chars.length; i++) {
            arr[i] = map.get(chars[i]);
        }

        for (int i = 0; i < arr.length; ) {
            int left = i, right = arr[left];
            while (left <= right) {
                if (right < arr[left]) right = arr[left];
                left++;
            }
            res.add(left - i);
            i =left++;
        }
        return res;
    }
}


