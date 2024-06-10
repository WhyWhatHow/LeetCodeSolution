package leetcode.algorithm.demo;

import java.util.HashMap;

/**
 * @program: LeetCodeSolution
 * @description:
 * @author: WhyWhatHow
 **/

public class Solution_287 {

    public static void main(String[] args) {
        Solution_287 sol = new Solution_287();
        System.out.println("==================");
    }
    public int findDuplicate(int[] nums) {
        int ans = 0;
        int i=0, j = i+1;
        while (i<nums.length){
            i++;
        }

        return ans;
    }
        // hashMap : 如何去掉hashmap
    public int findDuplicateNotConstantSpace(int[] nums) {
        HashMap<Integer, Boolean> map  =new HashMap<>();
        for(int num: nums){
            if(map.containsKey(num)){
                return num ;
            }
            map.put(num,true);
        }
        return 0;
    }
    void test(){
        
    }
}


