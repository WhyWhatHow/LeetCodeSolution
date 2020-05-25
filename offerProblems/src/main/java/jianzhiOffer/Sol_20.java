package jianzhiOffer;

import java.util.Arrays;

/**
 * @program: LeetCodeSolution
 * @description:
 * @author: WhyWhatHow
 * @create: 2020-05-22 07:33
 **/
public class Sol_20 {

    public String replaceSpace(String s) {
        if (s.length()==0){
            return "";
        }
        String s1 = s.replaceAll(" ", "%20");
        return s1;
    }
    public static void main(String[] args) {
        Sol_20 sol =new Sol_20();
        String we_are_happy_ = sol.replaceSpace("we are happy ");
        System.out.println(we_are_happy_);

    }

}
