package leetcode.algorithm.demo;

import java.util.Stack;

/**
 * @program: LeetCodeSolution
 * @description:
 * @author: WhyWhatHow
 **/

public class Solution_316 {

    public static void main(String[] args) {
        Solution_316 sol = new Solution_316();
        System.out.println("==================");
//        String bcabc = sol.removeDuplicateLetters("bcabc");
//        String cbacdcbc = sol.removeDuplicateLetters("cbacdcbc");
        String bbcaac = sol.removeDuplicateLetters("bbcaac");
//        String bddbccd = sol.removeDuplicateLetters("bddbccd");
//        String abacb = sol.removeDuplicateLetters("abacb");
//        String rusrbofeggbbkyuyjsrzornpdguwzizqszpbicdquakqws = sol.removeDuplicateLetters("rusrbofeggbbkyuyjsrzornpdguwzizqszpbicdquakqws");
        System.out.println("=================================");
//        System.out.println(sol.removeDuplicateLetters2("abacb"));
//        System.out.println(sol.removeDuplicateLetters2("bbcaac"));
//        String cbaacabcaaccaacababa = sol.removeDuplicateLetters("cbaacabcaaccaacababa");
    }

    //    "rusrbofeggbbkyuyjsrzornpdguwzizqszpbicdquakqws"
    public String removeDuplicateLetters(String s) {
        Stack<Character> stack = new Stack<>();
        int[] nums = new int[26];
        boolean[] vis = new boolean[26];
        char[] chars = s.toCharArray();
        for (char c : chars) {
            nums[c - 'a']++;
        }

        for (char c : chars) {
            nums[c - 'a']--;
            if (vis[c - 'a']) {
                continue;
            }
            while (!stack.empty() && stack.peek() > c) {
                if (nums[stack.peek() - 'a'] == 0) {
                    break;
                }
                Character pop = stack.pop();
                vis[pop - 'a'] = false;
            }
            stack.push(c);
            vis[c - 'a'] = true;
        }
        StringBuilder builder = new StringBuilder();
        while (!stack.empty()) {
            Character pop = stack.pop();
            builder.append(pop);
        }
        return builder.reverse().toString();
    }


}


