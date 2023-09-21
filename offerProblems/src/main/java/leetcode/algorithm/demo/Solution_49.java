package leetcode.algorithm.demo;


import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * @program: LeetCodeSolution
 * @description:
 * @author: WhyWhatHow
 **/

public class Solution_49 {

    public static void main(String[] args) {
        Solution_49 sol = new Solution_49();
        System.out.println("==================");
        List<List<String>> lists = sol.groupAnagrams2(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"});
        lists.forEach(System.out::println);
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List> map = new HashMap<>();
        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String s = String.valueOf(chars);
//            List<String> list  = new LinkedList<>();
//            if (map.containsKey(s)) {
//                list = map.get(s);
//            }
            //    OPTIMIZE [whywhathow] [2023/9/21] [must]  more graceful way to get value in hashmap.
            List list = map.getOrDefault(s, new LinkedList());

            list.add(str);
            map.put(s, list);
        }
        LinkedList linkedList = new LinkedList<>(map.values());
        return linkedList;
    }

    public List<List<String>> groupAnagrams2(String[] strs) {
        HashMap<String, List> map = new HashMap<>();
        for (String str : strs) {
            int[] cnt = new int[26];
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < str.length(); i++) {
                cnt[str.charAt(i) - 'a']++;
            }
            for (int i = 0; i < cnt.length; i++) {
                if (cnt[i] != 0) {
                    sb.append('a'+i);
                    sb.append(cnt[i]);
                }
            }
            String s = sb.toString();
            List list = map.getOrDefault(s, new LinkedList());
            list.add(str);
            map.put(s,list);
        }
        LinkedList linkedList = new LinkedList<>(map.values());
        return linkedList;
    }

}


