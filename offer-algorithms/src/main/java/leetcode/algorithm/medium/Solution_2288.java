package leetcode.algorithm.medium;

import com.google.inject.internal.util.Strings;

/**
 * @program: LeetCodeSolution
 * @description: #binary Indexed Array
 * @author: WhyWhatHow
 **/

public class Solution_2288 {

    public static void main(String[] args) {
        Solution_2288 sol = new Solution_2288();
        System.out.println("==================");
    }


    public String discountPrices(String sentence, int discount) {
        String[] ss = sentence.split(" ");
        StringBuilder builder = new StringBuilder();
        double plus = 1.00 - 0.01 * discount;
        for (String s : ss) {
            if (s.startsWith("$") && !s.contains("e")  && checkNumber(s.substring(1))) {
                Long val = Long.valueOf(s.substring(1));
                builder.append("$");
                builder.append(String.format("%.2f", val * plus));
            } else
                builder.append(s);
            builder.append(" ");
        }
        // remove last " "
        builder.deleteCharAt(builder.length() - 1);
        return builder.toString();
    }

    boolean checkNumber(String s) {
        try {
            Long.valueOf(s);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}


