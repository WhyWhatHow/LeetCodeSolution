package leetcode.algorithm.pq;

import java.util.HashMap;
import java.util.TreeSet;


/**
 * @program: LeetCodeSolution
 * @description: #
 * @author: WhyWhatHow
 **/

public class Solution_3321 {

    public static void main(String[] args) {
        Solution_3321 sol = new Solution_3321();
        System.out.println(sol.findXSum(new int[]{
                        1, 1, 2, 2, 3, 4, 2, 3
                }, 6, 2
        ));
        System.out.println("==================");
    }

    HashMap<Integer, Integer> map = new HashMap<>(); // key : num ,val : cnt
    // only store x num element.
    TreeSet<int[]> ls = new TreeSet<>((a, b) -> a[1] != b[1] ? b[1] - a[1] : b[0] - a[0]);// desc int[]: { x, cnt };
    // store right direction element.
    TreeSet<int[]> rs = new TreeSet<>(ls.comparator()); // int[]=={x, cnt};
    long sum = 0;

    /**
     * 对于进入窗口的元素, 从set中删除, cnt++, 加入到set中.
     * 对于离开窗口的元素, 从set中删除, cnt--, 加入到set中.
     * hint : 不能选择先放入rs, 然后在到达第一个window 的rightLimit 时 将前x元素 -> ls. (这样处理会超时)
     * 因此, 需要在add 的时候就决定 元素的取向, 如果 加入窗口的元素> ls.last() ,那么就加入到ls 中, 否则加入到rs中.

     // end::tagname[]
     *
     * @param nums
     * @param k
     * @param x
     * @return
     */
    public long[] findXSum(int[] nums, int k, int x) {
        int n = nums.length;
        long[] ans = new long[n - k + 1];
        for (int i = 0; i < nums.length; i++) {
            // add to window
            remove(nums[i]);
            int v = map.merge(nums[i], 1, Integer::sum);
            add(nums[i]);
            if (i < k - 1) continue;// skip not a window element.

            // hint: 超时,不能选择先加入rs, 最后从rs选择前x个元素送给ls.
//            while (!ls.isEmpty() && rs.isEmpty()) {
//                int[] last = ls.last();
//                int[] first = rs.first();
//                if (ls.comparator().compare(last, first) > 0) {
//                    ls2rs();
//                } else break;
//            }
            while (!rs.isEmpty() && ls.size() < x) {
                rs2ls();
            }

            while (ls.size() > x) {
                ls2rs();
            }

            // calculate sum;
            ans[i - k + 1] = sum;
            // leave window
            remove(nums[i - k + 1]);
            map.merge(nums[i - k + 1], -1, Integer::sum);
            add(nums[i - k + 1]);
        }
        return ans;
    }

    private void ls2rs() {
        int[] a = ls.removeLast();
        sum -= (long) a[0] * a[1];
        rs.add(a);
    }

    private void rs2ls() {
        int[] a = rs.removeFirst();
        sum += (long) a[0] * a[1];
        ls.add(a);
    }

    private void remove(int num) {
        Integer v = map.getOrDefault(num, 0);
        if (v == 0) return;
        int[] a = new int[]{num, v};
        if (ls.contains(a)) {
            ls.remove(a);
            sum -= (long) a[0] * a[1];
        } else rs.remove(a);
    }

    private void add(int num) {
        Integer v = map.getOrDefault(num, 0);
        if (v == 0) return;
        int[] a = {num, v};
        // desc , b-a ,  for this case , a[] > last[]
        if (!ls.isEmpty() && ls.comparator().compare(ls.last(), a) > 0) {
            ls.add(a);
            sum += 1L * a[0] * a[1];
        } else
            rs.add(a);
    }


}