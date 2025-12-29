package leetcode.algorithm.dfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * @program: LeetCodeSolution
 * @description: #
 * @author: WhyWhatHow
 **/

public class Solution_756 {

    public static void main(String[] args) {
        Solution_756 sol = new Solution_756();
        System.out.println(sol.pyramidTransition(
                "BCD",
                Arrays.stream(new String[]{"BCC", "CDE", "CEA", "FFF"}).toList()
//                "AAAA",
//                Arrays.stream(new String[]{"AAB", "AAC", "BCD", "BBE", "DEF"}).toList())
        ));
        System.out.println("==================");
    }

    public boolean pyramidTransition(String bottom, List<String> allowed) {

        var map = new HashMap<String, List<Character>>();
        for (String s : allowed) {
            String key = s.substring(0, 2);
            List<Character> list = map.getOrDefault(key, new ArrayList<>());
            list.add(s.charAt(2));
            map.put(key, list);
        }

        char[] cs = bottom.toCharArray();

        int n = cs.length;

        return dfs(0, bottom, new StringBuilder(), map);

    }

    private boolean dfs(int pos, String cur, StringBuilder next, HashMap<String, List<Character>> map) {
        if (cur.length() == 1) return true;  // 到达最上层.

        // 当前层构建完毕.
        if (pos == cur.length() - 1) return dfs(0, next.toString(), new StringBuilder(), map);

        // 构建当前层.
        String key = cur.substring(pos, pos + 2);

        if (!map.containsKey(key)) return false;

        List<Character> list = map.get(key);
        for (Character c : list) {
            next.append(c);
            if (dfs(pos + 1, cur, next, map)) {
                return true;
            } else {
                next.deleteCharAt(next.length() - 1);
            }
        }
        return false;

    }


}


