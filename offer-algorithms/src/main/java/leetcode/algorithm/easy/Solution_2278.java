package leetcode.algorithm.easy;

/**
 * @program: LeetCodeSolution
 * @description: #
 * @author: WhyWhatHow
 **/

public class Solution_2278 {

    public static void main(String[] args) {
        Solution_2278 sol = new Solution_2278();
        System.out.println(sol.percentageLetter("foobar", 'o'));
        System.out.println("==================");
    }
    public int percentageLetter(String s, char letter) {
        int cnt = 0 ;
        char[] cs=  s.toCharArray();
        for(char c : cs){
            if(c == letter) cnt++ ;
        }
        return (int)Math.floor(cnt*100/cs.length);
    }

}


