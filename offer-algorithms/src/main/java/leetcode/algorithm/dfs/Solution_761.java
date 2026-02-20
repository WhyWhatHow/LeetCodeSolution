package leetcode.algorithm.dfs;

import java.util.ArrayList;

/**
 * @program: LeetCodeSolution
 * @description: #
 * @author: WhyWhatHow
 **/
public class Solution_761 {

    public static void main(String[] args) {
        Solution_761 sol = new Solution_761();//
        System.out.println(sol.makeLargestSpecial(
                "11011000"
        ));
        System.out.println("==================");
    }

    /**
     * 11011000
     * (()(()))
     * 0 的数量与 1 的数量相等。
     * 二进制序列的每一个前缀码中 1 的数量要大于等于 0 的数量。
     * 要求的子串满足条件  ==> cnt_0 ==cnt_1  && prefix_cnt_1 >= prefix_cnt_0, 也就是所括号匹配格式.
     * 对于每一个满足条件的子串s, 我们需要去找到它的子串s.substring(1,s.length-1) 中是否有满足题目要求的子串. 如果有同步更新上去.
     * 题目要求其最后的s 要尽可能大, 我们可以对区间[l,r]range内所有满足题目要求的子串进行排序,按照desc的顺序将子串进行凭借,返回的结果就是[l,r]中符合题意最大的子串.
     *
     * @param s
     * @return
     */
    public String makeLargestSpecial(String s) {
        if (s.length() <= 2) return s;
        int cnt = 0;
        var list = new ArrayList<String>();
        int l = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') cnt++;
            else {
                cnt--;
                if (cnt == 0) {
                    list.add("1" + makeLargestSpecial(s.substring(l + 1, i)) + "0");
                    l = i + 1;
                }
            }
        }
        list.sort((a, b) -> b.compareTo(a));
//        var res = "";
        return String.join("", list);
//        for (String string : list) {
//            res += string;
//        }
//        return res;
    }
}
