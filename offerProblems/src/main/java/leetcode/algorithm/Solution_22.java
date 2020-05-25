package leetcode.algorithm;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @program: LeetCodeSolution
 * @description:
 * @author: WhyWhatHow
 * @create: 2020-05-07 12:09
 **/
public class Solution_22 {

// 做减法

//    public List<String> generateParenthesis(int n) {
//        List<String> res = new ArrayList<String>();
//        // 特判
//        if (n == 0) {
//            return res;
//        }
//
//        // 执行深度优先遍历，搜索可能的结果
//        dfs("", n, n, res);
//        return res;
//    }

    /**
     * @param curStr 当前递归得到的结果
     * @param left   左括号还有几个可以使用
     * @param right  右括号还有几个可以使用
     * @param res    结果集
     */
    private void dfs(String curStr, int left, int right, List<String> res) {
        // 因为每一次尝试，都使用新的字符串变量，所以无需回溯
        // 在递归终止的时候，直接把它添加到结果集即可，注意与「力扣」第 46 题、第 39 题区分
        if (left == 0 && right == 0) {
            res.add(curStr);
            return;
        }

        // 剪枝（如图，左括号可以使用的个数严格大于右括号可以使用的个数，才剪枝，注意这个细节）
        if (left > right) {
            return;
        }

        if (left > 0) {
            dfs(curStr + "(", left - 1, right, res);
        }

        if (right > 0) {
            dfs(curStr + ")", left, right - 1, res);
        }
    }



    List<String> list = new ArrayList<String>();

    void dfs(int left, int right, String s) {
        if (left == 0 && right == 0) {
            list.add(s);
            return;
        }
        if (left >0 ){
            dfs(left-1,right,s+"(");
        }
        if(right >left){
            dfs(left,right-1,s+")");
        }
    }

    public List<String> generateParenthesis(int n) {
        dfs(n,n,"");
        return list;
    }

    public static void main(String[] args) {
        Solution_22 sol =new Solution_22();
        List<String> list1 = sol.generateParenthesis(3);
        for (String s : list1) {
            System.out.println(s);
        }
    }
}
