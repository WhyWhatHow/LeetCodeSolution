package leetcode.algorithm.prefix;

import java.util.HashMap;

/**
 * @program: LeetCodeSolution
 * @description: #
 * @author: WhyWhatHow
 **/

public class Solution_1590 {

    public static void main(String[] args) {
        Solution_1590 sol = new Solution_1590();
        System.out.println(sol.minSubarray(new int[]{
//                        3, 1, 4, 2
                1,2,3
                },

//                6
                7
        ));
        System.out.println("==================");
    }

    // 设 nums 和为 x , 如果满足题意的话, 会存在一个子数组之和, 假定为y ,
    // 那么会有 (x-y)%p == 0 ; ==> x%p == y%p;
    // 也就是说 存在[i,j] range, ps(i,j) == x %p ;
    // x- (ps[i]-ps[j]) =0 ; // j<i
    // ps[j] =ps[i]-x;
    public int minSubarray(int[] nums, int p) {
        int n = nums.length;

        int[] ps = new int[n + 1];
        for (int i = 0; i < nums.length; i++) {
            ps[i + 1] = (ps[i] + nums[i]) % p;
        }
        int tar = ps[n];
        if (tar == 0) return 0;
        int res = n;
        var map = new HashMap<Integer, Integer>(); // key: presum[i] , val: idx .
        for (int i = 0; i < ps.length; i++) {
            // int key = (tar - ps[i]) % p;
            // key = key < 0 ? key + p : key;
            //wrong reason : #line 28
            int key = (ps[i] - tar + p) % p;
//            if (key == ps[i]) {
//                res = Math.min(res, 1);
//            }
            if (map.containsKey(key)) {

                Integer idx = map.get(key);
                res = Math.min(i - idx , res);
            }
            map.put(ps[i], i);
        }
        return res == n ? -1 : res;
    }
}


