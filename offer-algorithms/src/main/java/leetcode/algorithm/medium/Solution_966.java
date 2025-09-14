package leetcode.algorithm.medium;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * @program: LeetCodeSolution
 * @description: #
 * @author: WhyWhatHow
 **/

public class Solution_966 {

    public static void main(String[] args) {
        Solution_966 sol = new Solution_966();
        System.out.println(sol.spellchecker(new String[]{
//                "KiTe", "kite", "hare", "Hare"
                "ae", "aa"
        }, new String[]{
//                "kite", "Kite", "KiTe", "Hare", "HARE", "Hear", "hear", "keti", "keet", "keto"
//                "uu"
                "UU"
        }));
        System.out.println("==================");
    }

    Set<Character> cset = Set.of('a', 'e', 'i', 'o', 'u');

    public String[] spellchecker(String[] wordlist, String[] queries) {

        // init  up and lower case map
        HashSet<String> originSet = new HashSet<>(); // 不忽略大小写情况.
        HashMap<String, LinkedHashSet<String>> map = new HashMap<>();// key: 不区分大小写, val : list 按照顺序排列的word
        HashMap<String, LinkedHashSet<String>> aemap = new HashMap<>(); // 元音拼写错误 : 元音替代  key : yellow-> y*ll*w, val: yellow
        for (String s : wordlist) {
            originSet.add(s);

            // up and lower
            String key = s.toLowerCase();
            var list = map.getOrDefault(key, new LinkedHashSet<>());
            list.add(s);
            map.put(key, list);

            // aeiou
            String k = buildAKey(s);
            var set = aemap.getOrDefault(k, new LinkedHashSet<>());
            set.add(s);
            aemap.put(k, set);
        }


        // do query
        String[] ss = new String[queries.length];
        int cnt = 0;
//        checkFirstMap(map, key)
        for (String s : queries) {
            String val = originSet.contains(s) ? s : null;
            if (val == null)
                val = doHandleUpLowerMap(s, map);
            if (val == null) {
                val = doCheckAEMap(buildAKey(s), aemap);
            }
            ss[cnt++] = val == null ? "" : val;
        }
        return ss;
    }

    private String doCheckAEMap(String s, HashMap<String, LinkedHashSet<String>> map) {
        if (map.containsKey(s)) return map.get(s).getFirst();
        return null;
    }

    private String buildAKey(String s) {
        char[] cs = s.toLowerCase().toCharArray();
        for (int i = 0; i < cs.length; i++) {
            if (cset.contains(cs[i])) cs[i] = '*';
        }
        return String.valueOf(cs);
    }
    private String doHandleUpLowerMap(String s, HashMap<String, LinkedHashSet<String>> map) {
        String key = s.toLowerCase();
        if (map.containsKey(key)) {
            return map.get(key).getFirst();
        }
        return null;
    }

    //
//    private boolean check(char[] s, char[] tar) {
//        // 判断改变s的元音字母是否可以转换成目标字母tar
//        boolean yes = true;
//        for (int i = 0; i < s.length; i++) {
//            if (s[i] == tar[i]) continue;
//            else if (cset.contains(s[i]) && cset.contains(tar[i])) {
//                continue;
//            } else {
//                yes = false;
//                break;
//            }
//        }
//        return yes;
//    }



}


