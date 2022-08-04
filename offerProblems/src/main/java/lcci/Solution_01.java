package lcci;

import sun.management.Sensor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * @program: LeetCodeSolution
 * @description: 字符串+数组, 比较简单 注意矩阵旋转, + 字符串旋转判断
 * @author: WhyWhatHow

 **/

public class Solution_01 {
    /**
     * 01.01
     *
     * @param astr
     * @return
     */
    public boolean isUnique(String astr) {
        boolean res = true;
        if (astr == null || astr.length() == 0) {
            return true;
        }
        HashMap<Character, Boolean> map = new HashMap<>();
        char[] chars = astr.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (map.containsKey(chars[i])) {
                res = false;
                break;
            }
            map.put(chars[i], true);
        }
        return res;

    }

    /**
     * 01.02
     *
     * @param s1
     * @param s2
     * @return
     */
    public boolean CheckPermutation(String s1, String s2) {
        if (s1 == null && s2 == null)
            return true;
        if (s1.length() == s2.length() && s2.length() == 0)
            return true;
        if (s1 == null || s2 == null || s1.length() != s2.length()) {
            return false;
        }
        boolean res = true;
        char[] chars = s1.toCharArray();
        char[] chars1 = s2.toCharArray();
        Arrays.sort(chars);
        Arrays.sort(chars1);

        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == chars1[i]) {
                continue;
            } else {
                res = false;
                break;
            }
        }
        return res;
    }

    /**
     * 0103
     *
     * @param S
     * @param length
     * @return
     */
    public String replaceSpaces(String S, int length) {
        StringBuilder stringBuilder = new StringBuilder();
        String space = "%20";
        String[] s = S.split(" ");
        int cnt = 0;
        for (int i = 0; i < s.length; i++) {
            stringBuilder.append(s[i]);
            cnt += s[i].length();
            if (cnt < length) {
                cnt++;
                stringBuilder.append(space);
            }

        }
        while (cnt < length) {
            cnt++;
            stringBuilder.append(space);
        }
        return stringBuilder.toString();
    }

    public boolean canPermutePalindrome(String s) {
        char[] chars = s.toCharArray();
        int[] nums = new int[255];
        for (char aChar : chars) {
            nums[aChar]++;
        }
        int cnt = 0;
        for (int num : nums) {
            if ((num & 1) != 0) {
                cnt++;
            }
        }
        if (cnt > 1)
            return false;
        else
            return true;

    }

    /**
     * 0105
     *
     * @param first
     * @param second
     * @return
     */
    public boolean oneEditAway(String first, String second) {
        int num = first.length() - second.length();
        boolean res = true;
        int i = 0, j = 0;
        int cnt = 0;//
        if (num == 0) {
            // replace op

            while (i < first.length()) {
                if (first.charAt(i) != second.charAt(i)) {
                    cnt++;
                    if (cnt > 1) {
                        res = false;
                        break;
                    }
                }
                i++;
            }
        } else if (num == 1) {
            // del op
            res = delOrAdd(first, second, res, i, j, cnt);

        } else if (num == -1) {
            // add op
            res = delOrAdd(second, first, res, i, j, cnt);
        } else {
            res = false;
        }
        return res;
    }

    private boolean delOrAdd(String first, String second, boolean res, int i, int j, int cnt) {
        while (i < first.length() && j < second.length()) {
            if (first.charAt(i) != second.charAt(j)) {
                i++;
                cnt++;
                if (cnt > 1) {
                    res = false;
                    break;
                }
                continue;
            }
            i++;
            j++;
        }
        return res;
    }

    /**
     * 0106
     *
     * @param S
     * @return
     */
    public String compressString(String S) {
        if (S == null || S.length() == 0)
            return S;
        StringBuilder builder = new StringBuilder();
        char[] chars = S.toCharArray();
        int cnt = 1;
        for (int i = 1; i < chars.length; i++) {
            if (chars[i] == chars[i - 1]) {
                cnt++;
            } else {
                builder.append(chars[i - 1]);
                builder.append(cnt);
                cnt = 1;
            }
        }
        builder.append(chars[chars.length - 1]);
        builder.append(cnt);

        return builder.length() < S.length() ? builder.toString() : S;
    }

    /**
     * 01 08
     */
    public void setZeroes(int[][] matrix) {
        List<Node> list = new ArrayList<Node>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    list.add(new Node(i, j));
                }
            }
        }
        for (Node node : list) {
            for (int i = 0; i < matrix[node.x].length; i++) {
                matrix[node.x][i] = 0;
            }
            for (int i = 0; i < matrix.length; i++) {
                matrix[i][node.y] = 0;
            }
        }
        return;
    }

    private class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    /**
     * x,y 分别代表子串
     * s1 有两部分组成,x和y
     * s2 由 yx 组成
     * s1s1 = xyxy,那么 s2 就是s1s1 的子串
     *
     * @param s1 xy
     * @param s2 yx
     * @return
     */
    public boolean isFlipedString(String s1, String s2) {
        String s = s1 + s1;
        if (s1.length() != s2.length())
            return false;
        if (s1 == null || s1.length() == 0)
            return true;
        return s.indexOf(s2) != -1;
    }
    //// TODO: 2021/6/5 旋转矩阵, 90度, 不用额外空间
    public static void main(String[] args) {
        Solution_01 sol = new Solution_01();
//        boolean leetcode = sol.isUnique("leetcode");
//        System.out.println(leetcode);
//        boolean abc = sol.isUnique("abc");
//        String s = sol.replaceSpaces("Mr John Smith    ", 13);
//        String s = sol.compressString("aabcccccaaa");
        boolean b = sol.oneEditAway("teacher"
                , "taches");
//        System.out.println(s);


        System.out.println("==================");

    }
}


