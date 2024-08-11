package leetcode.algorithm.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program: LeetCodeSolution
 * @description: #
 * @author: WhyWhatHow
 **/

public class Solution_676 {

    public static void main(String[] args) {
        Solution_676 sol = new Solution_676();
        MagicDictionary md = new MagicDictionary();
        md.buildDict(new String[]{
//                "hello", "hallo","leetcode"
                "a", "b", "ab", "abc", "abcabacbababdbadbfaejfoiawfjaojfaojefaowjfoawjfoawj", "abcdefghijawefe", "aefawoifjowajfowafjeoawjfaow", "cba", "cas", "aaewfawi", "babcda", "bcd", "awefj"
        });
        md.search("abc");
        md.search("cba");
//        System.out.println(md.search("hhllo"));
//        System.out.println(md.search("hello"));
//        System.out.println(md.search("hallo"));
        System.out.println("==================");
    }


}


class MagicDictionary {
    Map<Integer, List<String>> map = new HashMap<>();

    public MagicDictionary() {

    }

    public void buildDict(String[] dictionary) {
        for (String s : dictionary) {
            List<String> list = map.getOrDefault(s.length(), new ArrayList<>());
            list.add(s);
            map.put(s.length(), list);
        }
    }

    public boolean search(String searchWord) {
        int len = searchWord.length();
        if (map.containsKey(len)) {

            // check
            List<String> list = map.get(len);
            for (String s : list) {
                if (tryToReplace(s, searchWord)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean tryToReplace(String s, String searchWord) {
        char[] ss = s.toCharArray();
        char[] chars = searchWord.toCharArray();
        int cnt = 0;
        for (int i = 0; i < ss.length; i++) {
            if (ss[i] != chars[i]) cnt++;
            if (cnt > 1) return false;
        }
        return true;
    }

}

/**
 * Your MagicDictionary object will be instantiated and called as such:
 * MagicDictionary obj = new MagicDictionary();
 * obj.buildDict(dictionary);
 * boolean param_2 = obj.search(searchWord);
 */
