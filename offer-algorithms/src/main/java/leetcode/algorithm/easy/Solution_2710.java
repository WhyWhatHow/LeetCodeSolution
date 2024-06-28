package leetcode.algorithm.easy;

/**
 * @program: LeetCodeSolution
 * @description: #
 * @author: WhyWhatHow
 **/

public class Solution_2710 {

    public static void main(String[] args) {
        Solution_2710 sol = new Solution_2710();
        System.out.println("==================");
    }
    public String removeTrailingZeros(String num) {
        char[] cs=  num.toCharArray();
        int last = cs.length -1;
        while(cs[last] =='0'){
            last--;
        }
        return num.substring(0,last+1);
    }


}


