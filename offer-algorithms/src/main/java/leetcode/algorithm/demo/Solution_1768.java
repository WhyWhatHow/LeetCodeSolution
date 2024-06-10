package leetcode.algorithm.demo;

/**
 * @program: LeetCodeSolution
 * @description: #array #string
 * @author: WhyWhatHow
 **/

public class Solution_1768 {

    public static void main(String[] args) {
        Solution_1768 sol = new Solution_1768();
        System.out.println("==================");
    }
    public String mergeAlternately(String word1, String word2) {
        char[] chars= word1.toCharArray();
        char[] cc = word2.toCharArray();

        StringBuilder sb = new StringBuilder( );
        int i = 0, j = 0 ;
        while (i< chars.length&& j<cc.length){
            sb.append(chars[i++]);
            sb.append(cc[j++]);
        }
        while (i< chars.length)
            sb.append(chars[i++]);
        while (j<cc.length)
            sb.append(cc[j++]);
        return sb.toString();
    }

}


