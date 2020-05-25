package leetcode.interview;

import java.util.HashMap;

/**
 * @program: LeetCodeSolution
 * @description:
 * @author: WhyWhatHow
 * @create: 2020-05-25 12:34
 **/
public class Compass {


    public int compress(char[] chars) {
        if (chars.length == 0) {
            return 0;
        }
        int[] vis = new int[128];
        for (char aChar : chars) {
            vis[aChar]++;
        }
        int cnt = 0;

        StringBuffer buffer = new StringBuffer();
        for (int i = 0; i < vis.length; i++) {
            int vi = vis[i];
            if (vi == 0) continue;
//            String s = Integer.toString(i);
//            String s = Integer.toBinaryString(i);
            char s = Character.toChars(i)[0];
            if (vi == 1) {
                buffer.append(s);
            } else {
                buffer.append(s + ""+vi);
            }
        }
        chars = buffer.toString().toCharArray();
//        System.out.println(buffer.toString());
        return buffer.length();

    }

    public static void main(String[] args) {

        String a = "aaaabbcc";
        Compass sol = new Compass();
        int compress = sol.compress(a.toCharArray());
        System.out.println(compress);
    }
}
