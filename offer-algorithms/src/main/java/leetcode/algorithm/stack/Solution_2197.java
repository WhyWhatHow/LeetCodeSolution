package leetcode.algorithm.stack;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: LeetCodeSolution
 * @description: #
 * @author: WhyWhatHow
 **/

public class Solution_2197 {

    public static void main(String[] args) {
        Solution_2197 sol = new Solution_2197();
        System.out.println(sol.replaceNonCoprimes(new int[]{
//                6, 4, 3, 2, 7, 6, 2
//                31, 97561, 97561, 97561, 97561, 97561, 97561, 97561, 97561
                287, 41, 49, 287, 899, 23, 23, 20677, 5, 825
        }));
        System.out.println("==================");
    }

    /***
     * gcd(x,y) 求 x,y 的最大公约数 . lcm(x,y) 求最小公倍数
     * lcm(x,y ) =x*y /gcd(x,y)
     * gcd(x,y) = gcd(y,x%y) x>y && y!=0;  if y ==0 ,return x;
     * @param nums
     * @return
     */
    public List<Integer> replaceNonCoprimes(int[] nums) {
        var q = new ArrayList<Integer>();
        q.add(nums[0]);

        for (int i = 1; i < nums.length; i++) {
            Integer cur = q.getLast();
            int gcd = gcd(cur, nums[i]);
            // go right
            if (gcd > 1) {
                q.removeLast();
                q.addLast(lcm(cur, nums[i], gcd));
            } else {
                q.addLast(nums[i]);
            }

            // go left
            while (q.size() >= 2) {
                Integer a = q.removeLast();
                Integer b = q.removeLast();
                if (gcd(a, b) > 1) {
                    q.addLast(lcm(a, b));
                } else {
                    q.add(b);
                    q.add(a);
                    break;
                }
            }
        }
        return q;
    }

    int lcm(int x, int y) {
        long t = 1l * x * y;
        return (int) (t / gcd(x, y));
    }

    int lcm(int x, int y, int gcd) {
        long t = 1l * x * y;
        return (int) (t / gcd);
    }

    public int gcd(int x, int y) {
        if (y == 0) {
            return x;
        }
        return gcd(y, x % y);
    }

}


