package leetcode.algorithm.easy;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * @program: LeetCodeSolution
 * @description: #
 * @author: WhyWhatHow
 **/
public class Solution_2515 {

    public static void main(String[] args) {
        Solution_2515 sol = new Solution_2515();//

        System.out.println("==================");
    }

    public int closestTarget(String[] words, String target, int startIndex) {
        int n = words.length;
        int res = n;
        var map = new HashMap<String, ArrayList<Integer>>();
        for(int i = 0 ; i< n; i++){
            map.computeIfAbsent(words[i], j->new ArrayList<>()).add(i);
        }
        if(!map.containsKey(target)) return -1 ;

        var list =  map.get(target);

        for(var i : list){
            // go left
            int left = i<=startIndex? startIndex-i : startIndex + n-i;
            // go right
            int right = i>=startIndex? i-startIndex: i+ n-startIndex;
            res = Math.min(res , Math.min(left, right));
        }
        return res;
    }
}
