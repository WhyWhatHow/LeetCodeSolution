package leetcode.algorithm.medium;

import java.util.ArrayList;

/**
 * @program: LeetCodeSolution
 * @description: #
 * @author: WhyWhatHow
 **/

public class Solution_1493 {

    public static void main(String[] args) {
        Solution_1493 sol = new Solution_1493();
        System.out.println(sol.longestSubarray(new int[]{
//                0, 1, 1, 1, 0, 1, 1, 0, 1
//                1, 1, 0, 0, 1, 1, 1, 0, 1
//                1, 0, 0, 0
                1, 1, 0, 1
        }));
        System.out.println("==================");
    }

    // 统计0出现的位置, 两个相邻的0之间的差值
    // 首尾添加两个哨兵, 标记0.
    //以1,1,0,1 为例.
    // -  0: -1, 1: 2 , 2:4
    // 4-2-1 + 2-1-(-1) = 4-(-1)-2 ;
    // 正常表述, 假设a0为第一次出现0的idx, a1为第二次, a2 为第三次.
    // 也就是在a0,a1,a3,中去掉a1, 即(a0,a1) + (a1,a2) ,
    // 即 a2-1-a1 + a1-1-a0 = a2-a0-2
    public int longestSubarray(int[] nums) {
        ArrayList<Integer> q = new ArrayList<>();
        q.add(-1);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                q.add(i);
            }
        }
        q.add(nums.length);
        if (q.size() == 2) return nums.length - 1;
        int res = 0;
        for (int i = 2; i < q.size(); i++) {
            res = Math.max(res, q.get(i) - q.get(i - 2) - 2);
        }
        return res;
    }

    public int longestSubarrayStupid(int[] nums) {

        ArrayList<int[]> list = new ArrayList<>();// cnt, st,end
        int cnt = 0;
        int st = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                cnt++;
            } else {
                if (cnt == 0) {
                    st = i;
                    continue;
                }
                list.add(new int[]{cnt, st, i});
                st = i;
                cnt = 0;
            }
        }
        if (cnt != 0)
            list.add(new int[]{cnt, st, nums.length});

        if (list.size() == 0) return 0;

        int res = 0;
        if (list.getFirst()[2] == nums.length && list.getFirst()[1] == -1) return list.getFirst()[0] - 1;
        else res = Math.max(list.getFirst()[0], list.getLast()[0]);
        for (int i = 1; i < list.size(); i++) {
            int[] prev = list.get(i - 1);
            int[] cur = list.get(i);
            if (prev[2] == cur[1])
                res = Math.max(prev[0] + cur[0], res);
            else
                res = Math.max(res, Math.max(cur[0], prev[0]));

        }
        return res;
    }
}


