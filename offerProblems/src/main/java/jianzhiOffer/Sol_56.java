package jianzhiOffer;

import java.util.HashMap;

/**
 * @program: LeetCodeSolution
 * @description:
 * @author: WhyWhatHow
 * @create: 2020-05-22 08:10
 **/
public class Sol_56 {

    public int singleNumber(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        int res = -1;
        for (int num : nums) {
            if (map.get(num)==1) {
                res =num;
                break;
            }
        }
        return res ;
    }

    public static void main(String[] args) {
        Sol_56 sol = new Sol_56();

        System.out.println("=======");
    }
}
