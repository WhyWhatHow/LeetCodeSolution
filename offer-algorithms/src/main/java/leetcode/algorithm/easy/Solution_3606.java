package leetcode.algorithm.easy;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * @program: LeetCodeSolution
 * @description: #
 * @author: WhyWhatHow
 **/

public class Solution_3606 {

    public static void main(String[] args) {
        Solution_3606 sol = new Solution_3606();
        List<String> list = sol.validateCoupons(new String[]
                        {"pBXoMqBU0_aMgc9F8dy6TaSzza3KjSJFjxZa_NuyMjzEBR7fJNwpGHh7lzuoZvQeEUeo6YumHmIOjjchXlzSVa4ItdyDOImQgm", "P8rIIUl35MW8yrqRbO0N_IITptYOxz9tOCbPL6d1aIF_hM2sapaDtUzNpmAZRmJQB1WgjLh8bdYADuSRSU21OzttUkq73qiA66", "aFWkYookQlHYMXzhVGxbnrXIl1810ws3qHtketHSECHqJoktWXVZGc6ZyeOuzA_VL9zFL9znpIHwbkwJF2bOPQqsz3_0PYgETJ"},
                new String[]
                        {"pharmacy", "invalid", "pharmacy"},
                new boolean[]
                        {true, true, true}
        );
        list.forEach(System.out::println);
//        System.out.println("electronics".compareTo("grocery"));
//        System.out.println("grocery".compareTo("pharmacy"));
//        System.out.println("pharmacy".compareTo("restaurant"));
        System.out.println("==================");
    }

    //"electronics"、"grocery"、"pharmacy"、"restaurant"
    public List<String> validateCoupons(String[] code, String[] businessLine, boolean[] isActive) {
        Set<String> set = Set.of("electronics", "grocery", "pharmacy", "restaurant");
        int n = code.length;
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> {
            if (businessLine[a].equals(businessLine[b])) return businessLine[a].compareTo(businessLine[b]);
            else return code[a].compareTo(code[b]);
//            else {
////                return code[a] - code[b];
//                int len = Math.min(code[a].length(), code[b].length());
//                for (int i = 0; i < len; i++) {
//                    if (code[a].charAt(i) != code[b].charAt(i))
//                        return code[a].charAt(i) - code[b].charAt(i);
//                }
//                return code[a].length() - code[b].length();
//            }
        });
        for (int i = 0; i < n; i++) {
            if (!checkCode(code[i]) || !set.contains(businessLine[i]) || !isActive[i]) continue;
            pq.add(i);
        }
        var list = new ArrayList<String>(pq.size());
        while (!pq.isEmpty()) {
            Integer i = pq.poll();
            list.addLast(code[i]);
        }
        return list;
    }

    private boolean checkCode(String s) {
        return !s.isEmpty() && s.matches("^[a-zA-Z0-9_]+$");
    }
}


