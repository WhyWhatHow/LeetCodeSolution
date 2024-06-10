package leetcode.algorithm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program: LeetCodeSolution
 * @description:
 * @author: WhyWhatHow
 * @create: 2020-05-07 12:09
 **/

public class Solution_17 {
    /**
     * 解题思路:
     *  23 为例
     *      2-> a,b,c
     *      a->3(d,e,f), b->3(d,e,f),c->3(d,e,f)
     *  模拟这个过程...
     *  list 存结果集,
     *  map 存 2-9 分别对应的字母
     *  递归解题;
     *  step:
     *      1. 遍历 digits , 得到数字 num
     *          1.1  根据 num  查表(map)获得 字母集
     *          1.2  递归获得 当前字母的所有组合
     *          1.2.1 设置 递归出口
     * @param digits 2-9 的数字
     * @return
     */
    public List<String> letterCombinations(String digits) {
        List<String> list =new ArrayList<>();
        if (digits.length()==0) {
            return list;
        }
        Map<Character,String> map =new HashMap<>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
        solve1(list,map,0,digits,new StringBuilder());
        return list;
    }
    private void solve1(List<String> list, Map<Character, String> map, int index, String digits, StringBuilder stringBuilder) {

        if (digits.length()==index) {
            list.add(stringBuilder.toString());
            return ;
        }else {
            char c = digits.charAt(index);
            String s = map.get(c);
            for (char cc : s.toCharArray()) {
                stringBuilder.append(cc);
                solve1(list,map,index+1, digits,stringBuilder);
                stringBuilder.deleteCharAt(index);
            }
        }

    }

        private void solve(List<String> list, Map<Character, String> map, int index, String digits, StringBuilder stringBuilder) {
        if(index== digits.length()){
            list.add(stringBuilder.toString());
        } else {
            // num
            char c = digits.charAt(index);

            String s = map.get(c);
            char[] chars = s.toCharArray();
            for (int i = 0; i < chars.length; i++) {
                // a-z
                stringBuilder.append(chars[i]);
                solve(list,map,index+1,digits,stringBuilder);
                stringBuilder.deleteCharAt(index);

            }

        }
    }

    public static void main(String[] args) {
        Solution_17 sol = new Solution_17();
        System.out.println("==================");
        List<String> strings = sol.letterCombinations("23");
        strings.forEach(System.out::println);
    }
}


