package leetcode.algorithm.window
        ;

import java.util.Arrays;
import java.util.List;

/**
 * @program: LeetCodeSolution
 * @description:
 * @author: WhyWhatHow
 **/

public class Solution_2831 {

    public static void main(String[] args) {
        Solution_2831 sol = new Solution_2831();
        System.out.println(sol.longestEqualSubarray(Arrays.asList(1, 1, 2, 2, 1, 1), 2));
        System.out.println("==================");
    }

    /**
     * 维护一个滑动窗口, 并统计窗口内每个元素出现的次数,
     * 如果 窗口内, right- left+1 -max <= k
     * // 数组中众数的求法
     * @param nums
     * @param k
     * @return
     */
    public int longestEqualSubarray(List<Integer> nums, int k) {
        int[] arr = new int[nums.size() + 1];
        int res = 0, max = -1;
        int l = 0, r = 0;
        int n = nums.size();

        for (; r <n; r++) {
            int num = nums.get(r);
            arr[num]++;
            max = Math.max(max,arr[num]);
            while(r-l+1 > k + arr[nums.get(l)]){
                arr[nums.get(l)]--;
                l--;
            }
        }
        return max ;
    }

//    public int longestEqualSubarray(List<Integer> nums, int k) {
//        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
//            if (a[2] != b[2]) {
//                return b[2] - a[2];
//            } else {
//                return a[0] - b[0];
//            }
//        }); // start , end , maxSize
//        int l = 0, r = l + 1, cnt = 1 ;
//        int n = nums.size();
//        while (r < n) {
//            if (nums.get(l) == nums.get(r)) {
//                cnt++;
//            } else {
//                pq.add(new int[]{l, r - 1, cnt});
//                cnt = 1;
//                l = r;
//            }
//            r++;
//        }
//        int[] arr = pq.poll();
//        return deal(nums, k, arr);
//    }
//
//    /**
//     * @param nums
//     * @param k
//     * @param arr  //     * @param direction true  ->  右, false <-左
//     * @return
//     */
//    int deal(List<Integer> nums, int k, int[] arr
////             ,boolean direction
//    ) {
//        int start = arr[0];
//        int end = arr[1];
//        int maxl = 0, maxr = 0;
//        int idx = end;
//        int cnt = 0;
//
//        // ->
//        while (++idx < nums.size() && cnt <= k) {
//            if (nums.get(end) == nums.get(idx)) {
//                maxr++;
//            } else {
//                cnt++;
//            }
//        }
//        // <-
//        int i = start;
//        while (i-- > 0 && cnt <= k) {
//            if (nums.get(start) == nums.get(idx)) {
//                maxl++;
//            } else {
//                cnt++;
//            }
//        }
//        return maxl + maxr + arr[2];
//    }

}


