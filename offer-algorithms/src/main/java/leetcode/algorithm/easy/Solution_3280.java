package leetcode.algorithm.easy;

/**
 * @program: LeetCodeSolution
 * @description: #
 * @author: WhyWhatHow
 **/

public class Solution_3280 {

    public static void main(String[] args) {
        Solution_3280 sol = new Solution_3280();
        System.out.println(sol.convertDateToBinary("2080-02-29"));;
        System.out.println("==================");
    }
    public String convertDateToBinary(String date) {
        String[] ss = date.split("-");
        StringBuilder sb = new StringBuilder();
        int cnt =0 ;

        for (String s : ss) {
            sb.append(Integer.toBinaryString(Integer.valueOf(s)));
           if(cnt<ss.length-1){
            sb.append("-");
           }
           cnt++ ;
        }
        return sb.toString();
    }

}


