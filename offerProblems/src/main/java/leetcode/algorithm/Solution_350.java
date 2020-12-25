package leetcode.algorithm;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

/**
 * @program: LeetCodeSolution
 * @description:
 * @author: WhyWhatHow
 * @create: 2020-05-07 12:09
 **/

public class Solution_350 {
    /**
     * sol _349
     */
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> map =new HashSet<>();
        for (int i : nums1) {
            map.add(i);
        }
        int[] ans= new int[Math.min(nums1.length,nums2.length)];
        int cnt =0 ;
        for (int i : nums2) {
            if (map.contains(i)) {
                ans[cnt++]=i;
                map.remove(i);
            }
        }
        return Arrays.copyOfRange(ans,0,cnt);
    }
    // 打表解决
    public int[] intersect(int[] nums1, int[] nums2) {
        int len = Math.min(nums1.length,nums2.length);
        int[] ans =new int[len];
        HashMap<Integer,Integer> map =new HashMap<>();
        for (int i : nums1) {
            if (map.containsKey(i)) {
                map.put(i, map.get(i) + 1);
            }else{
                map.putIfAbsent(i, 1);
            }
        }
        int cnt =0 ;
        for (int i : nums2) {
            if (map.containsKey(i)) {
                Integer integer = map.get(i);
                if(integer>0)
                ans[cnt++]=i;
                map.put(i, integer-1);
            }
        }
        return Arrays.copyOfRange(ans, 0,cnt) ;

    }
    public static void main(String[] args) {
        Solution_350 sol = new Solution_350();
        sol.intersection(new int[]{1,2,2,1},new int[]{2,2});
        System.out.println("==================");
    }
}


