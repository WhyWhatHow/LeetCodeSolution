package jianzhiOffer;

import jdk.nashorn.internal.ir.IfNode;

import java.util.Arrays;

/**
 * @program: LeetCodeSolution
 * @description:
 * @author: WhyWhatHow
 * @create: 2020-05-22 07:33
 **/
public class Sol_20 {

    public String replaceSpace(String s) {
        if (s.length() == 0) {
            return "";
        }
        String s1 = s.replaceAll(" ", "%20");
        return s1;
    }

    public static void main(String[] args) {
        Sol_20 sol = new Sol_20();
        String we_are_happy_ = sol.replaceSpace("we are happy ");
        System.out.println(we_are_happy_);
        boolean e9 = sol.isNumber("12.f");


    }

    public boolean isNumber(String s) {
        boolean res = true;// 标记最终结果
        boolean isNum = false;// 表示小数部分
        char[] chars = s.toCharArray();
//        StringBuilder builder = new StringBuilder();
        // 去掉头部空格
        int start = -1;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == ' ') {
                continue;
            } else {
                start = i;
                break;
            }
        }// 去掉尾部空格
        int end = -1;
        for (int i = chars.length - 1; i >= 0; i--) {
            if (chars[i] == ' ') {
                continue;
            } else {
                end = i+1;
                break;
            }
        }
        if (start == end&& end==-1) {
            res = false;
            return res ;
        }
        // 中间遍历,去掉 其他字符不符合条件的东西, 去掉f就好了,
        for (int i = start; i < end; i++) {
            if (chars[i]=='f'|| chars[i]=='F') {
                res =false ;
                break;
            }
        }
        String temp = s.substring(start, end);
        if (res) {
            try {
                double v = Double.parseDouble(temp);
                res = true;
            } catch (NumberFormatException e) {
                res = false;
            }
        }
        return res;

    }



}
