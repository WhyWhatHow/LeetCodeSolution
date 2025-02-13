package leetcode.algorithm.easy;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * @program: LeetCodeSolution
 * @description: #
 * @author: WhyWhatHow
 **/

public class Solution_1742 {

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>(3);
        Solution_1742 sol = new Solution_1742();
        System.out.println(sol.countBalls(1, 10));
        System.out.println("==================");
    }

    public int countBalls(int lowLimit, int highLimit) {
        int max = 0 ;
        HashMap<Integer,Integer> map = new HashMap<Integer, Integer>();
        for(int i = lowLimit; i<= highLimit; i++){
            int key = getNum(i);
            int val = map.compute(key,(k,v)-> {
                return v == null ? 1 : v + 1;
            });
            if(max<val) max = val ;
        }
        return max ;
    }
    int getNum(int x){
        char[] cs = String.valueOf(x).toCharArray();
        int res = 0 ;
        for(char c : cs){
            res+=c-'0';
        }
        return res ;
    }

}
