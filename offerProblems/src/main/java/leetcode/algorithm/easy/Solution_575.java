package leetcode.algorithm.easy;

import java.util.HashMap;

/**
 * @program: LeetCodeSolution
 * @description:
 * @author: WhyWhatHow
 **/

public class Solution_575 {

    public static void main(String[] args) {
        Solution_575 sol = new Solution_575();

        System.out.println("==================");
    }

    public int distributeCandies(int[] candyType) {
        int canEat = candyType.length /2;
        HashMap<Integer,Integer> map = new HashMap<>() ;
        for(int type : candyType){
            map.put(type, map.getOrDefault(type,0)+1);
        }
        return Math.min(canEat, map.keySet().size());
    }
    

}


