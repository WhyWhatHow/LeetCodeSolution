package leetcode.algorithm.easy;

/**
 * @program: LeetCodeSolution
 * @description: #
 * @author: WhyWhatHow
 **/

public class Solution_1317 {

    public static void main(String[] args) {
        Solution_1317 sol = new Solution_1317();
        System.out.println(sol.getNoZeroIntegers(2));
        System.out.println("==================");
    }

    public int[] getNoZeroIntegers(int n) {
        for(int i = 1; i<=n/2; i++){
            if(check(i) && check(n-i)){
                return new int[]{i, n-i};
            }
        }
        return new int[]{};
    }
    boolean check(int x){
        if(String.valueOf(x).contains("0")) return false ;
        return true;
    }
}


