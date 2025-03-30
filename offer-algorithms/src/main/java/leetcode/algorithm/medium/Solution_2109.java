package leetcode.algorithm.medium;

/**
 * @program: LeetCodeSolution
 * @description: #
 * @author: WhyWhatHow
 **/

public class Solution_2109 {

    public static void main(String[] args) {
        Solution_2109 sol = new Solution_2109();sol.addSpaces("LeetcodeHelpsMeLearn",new int[]{
                8,13,15
        });
        System.out.println("==================");
    }

    public String addSpaces(String s, int[] spaces) {
        StringBuilder sb = new StringBuilder() ;
        char[] cs  = s.toCharArray() ;
        int k = 0; // spaces.length
        for(int i = 0; i< cs.length;i++){
            if(k <spaces.length && i==spaces[k]){
                sb.append(" ");
                k++;
            }
            sb.append(cs[i]);
        }
        return sb.toString();
    }
}


