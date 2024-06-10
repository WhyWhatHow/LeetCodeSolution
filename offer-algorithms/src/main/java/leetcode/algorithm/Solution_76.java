package leetcode.algorithm;

public class Solution_76 {
    /**
     * s 的最短字串：
     * 子串中包含t
     *
     * @param s
     * @param t
     * @return
     */
    public String minWindow(String s, String t) {
        if (s == null || s == "" || t == null || t == "" || s.length() < t.length()) {
            return "";
        }
        // 统计所需要的所有的t的字串
        int need[] = new int[128];
        // 滑动窗口中元素的值
        int window[] = new int[128];
        for (int i = 0; i < t.length(); i++) {
            need[t.charAt(i)]++;
        }
        // start 开始位置， end 结束位置
        int start = 0, end = 0;
        // 统计数量
        int count = 0;
        // 子串的长度
        int min = s.length() + 1;
        String res = "";
        while (end < s.length()) {
            //  找到满足条件的字串
            char ch = s.charAt(end);
            window[ch]++;
            if (need[ch] > 0 && need[ch] >= window[ch]) {
                count++;
            }

            while (count == t.length()) {
                // 优化字串位置, 优化start 位置
                char c = s.charAt(start);
                if (need[c] > 0 && need[c] == window[c]) {
                    count--;
                    int temp = end - start + 1;
                    if (temp < min) {
                        min = end - start + 1;
                        res = s.substring(start, end + 1);
                    }
                }
                window[c]--;
                start++;
            }
            end++;
        }
        return res;
//        if (min > s.length()) {
//            return "";
//        }
//        return s.substring(start - 1, start - 1 + min);
    }

    public static void main(String[] args) {
        Solution_76 sol = new Solution_76();
//        String s = "ADOBECODEBANC";
//        String t = "ABC";
        String s = "cabwefgewcwaefgcf";
//
        String t = "cae";
//        String s="a";
//        String t="b";
//        String s1 = sol.minWindow(s, t);
        String s1 = sol.minwindows(s, t);
        System.out.println(s1);
    }

    public String minwindows(String s, String t) {

        int[] need = new int[128];
        int[] window = new int[128];
        int left = 0, right = 0, cnt = 0, min = s.length() + 1;
        for (int i = 0; i < t.length(); i++) {
            need[t.charAt(i)]++;
        }
        String res = "";
        while (right < s.length()) {
            // 找到满足条件的子串
            char ch = s.charAt(right);
            window[ch]++;
            if (need[ch] > 0 && need[ch] >= window[ch]) {
                cnt++;
            }
            while (cnt == t.length()) {
                // 优化子串
                char c = s.charAt(left);
                if (need[c] > 0 && need[c] == window[c]) {
                    cnt--;
                    int temp = right - left + 1;
                    if (temp < min) {
                        min =temp;
                        res = s.substring(left, right + 1);
                    }
                }
                window[c]--;
                left++;
            }
            right++;

        }
        return res;
    }
}

