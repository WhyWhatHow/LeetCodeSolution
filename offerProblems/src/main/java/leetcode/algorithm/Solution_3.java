package leetcode.algorithm;

import com.sun.deploy.util.StringUtils;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Stack;


public class Solution_3 {
    /***
     * 求最大无重复字串长度, 求子串:subString(s,e);
     * start  = end  =0 ;
     *          P  W  W  K  E  W
     * round 1 s e
     * round 2 s   e
     * round 3 s1    s2  e
     * round 4        s     e
     * round 5        s1       se
     *
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        char[] chars = s.toCharArray();
        HashMap<Character, Integer> map = new HashMap<>();
//        int cnt =0;
        int max = 0;
        int start = 0, end = 0;
        for (int i = 0; i < chars.length; i++) {
            char aChar = chars[i];
            if (map.containsKey(aChar)) {
                // 更新 start 值
//                abcabcbb
                start = Math.max(start, map.get(aChar) + 1);
            }
            map.put(aChar, i);

            max = Math.max(max, end - start + 1);
            end++;
        }
        return max;

    }

    public int lengthOfLongestSubstring2(String s) {

        int ans = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            end++;

            if (map.containsKey(c)) {
                // update start ;
                start = Math.max(start, map.get(c) + 1);
            }
            map.put(c, i);
            ans = Math.max(ans, end - start);

        }
        return ans;

    }

    public static void main(String[] args) {
        Solution_3 sol = new Solution_3();

        String[] s = new String[]{"au", "", "pwwkew", "bbbbbbbbbbbb", "abcabcbb", "abba"};
        for (String s1 : s) {
            int i = sol.lengthOfLongestSubstring2(s1);
            System.out.println(i);

        }
    }
}
