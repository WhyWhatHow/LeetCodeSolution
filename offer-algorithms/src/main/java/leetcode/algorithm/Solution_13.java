package leetcode.algorithm;

import java.util.HashMap;

/**
 * @program: LeetCodeSolution
 * @description:
 * @author: WhyWhatHow

 **/

public class Solution_13 {
    public int romanToInt(String s) {
        HashMap<String, Integer> map = new HashMap<>();
        int[] vals = new int[]{1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] keys = new String[]{"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        for (int i = 0; i < keys.length; i++) {
            map.put(keys[i], vals[i]);
        }
        int res = 0;
        int len = s.length();
        for (int i = 0; i < len; i++) {
            if (i + 1 < len && (map.get(s.substring(i, i + 2)) != null)) {
                res += map.get(s.substring(i, i +2));
                i++;
            }else{
                res += map.get(s.substring(i,i+1));
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution_13 sol = new Solution_13();
        int mcmxciv = sol.romanToInt("MCMXCIV");

        System.out.println(mcmxciv);
        System.out.println("==================");
    }
}


