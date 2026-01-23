package leetcode.algorithm.hard;

import java.util.TreeSet;

/**
 * @program: LeetCodeSolution
 * @description: #
 * @author: WhyWhatHow
 **/
public class Solution_3510 {

    public static void main(String[] args) {
        Solution_3510 sol = new Solution_3510();
        int max = 2_000_000_000;
        System.out.println(max);
        System.out.println(Integer.MAX_VALUE);
        System.out.println(sol.minimumPairRemoval(
//                new int[]{1, 2, 2}
//                new int[]{5, 2, 3, 1}
                new int[]{2, 2, -1, 3, -2, 2, 1, 1, 1, 0, -1}
//                new int[]{-7, -2, -4, 4, 8, -6, 0, 0, 4, 5, 1, -8}
        ));
        System.out.println("==================");
    }

    record Pair(long s, int i) {
    }
    //  前缀构成数对, 即 (i-1,i) 作为初始数对, 由于 每次删除元素后,  左侧不一定是i-1,所以需要向左找到对应的下标 记为left(i)

    // 即对于位置i , 删除后, 需要更新i-2, i-1, del(i), i+1 这几个点的值会发生变化.
    public int minimumPairRemoval(int[] nums) {

        var tset = new TreeSet<Pair>((a, b) -> { // {sum , i}
            if (a.s != b.s) return Long.compare(a.s, b.s);
            else return a.i - b.i;
        });

        // 用于更新值nums的变化 // init updates && set
        long[] a = new long[nums.length];
        var set = new TreeSet<Integer>();
        for (int i = 0; i < nums.length; i++) {
            set.add(i);
            a[i] = nums[i];
        }

        int dec = 0; // 统计逆序对.
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] > nums[i + 1]) dec++;
            tset.add(new Pair(nums[i] + nums[i + 1], i));
        }

        if (dec == 0) return 0;

        int cnt = 0;
        // prev, cur , del(nxt) , nxt2
        while (dec > 0) {
            Pair p = tset.pollFirst();
            var sum = p.s;
            var cur = p.i;
            Integer nxt = set.higher(cur);

            if (nxt == null || !set.contains(nxt)) continue;

            if (a[cur] > a[nxt]) dec--; //

            // handle prev
            Integer prev = set.lower(cur);
            if (prev != null) {

                // 先去掉旧的数据, 因此之前统计的逆序对数如果是的话,也要去掉.
                if (a[prev] > a[cur]) {
                    dec--;
                }
                // 对于新数据进行处理, 如果 依旧是逆序对,那么 dec++
                if (a[prev] > sum) dec++;

                tset.remove(new Pair(a[prev] + a[cur], prev));
                tset.add(new Pair(a[prev] + sum, prev));
            }

            // handle nxtt
            Integer nxtt = set.higher(nxt);
            if (nxtt != null) {
                // 先去掉旧数据,在处理新数据.
                if (a[nxt] > a[nxtt]) dec--;
                if (sum > a[nxtt]) dec++;

                tset.remove(new Pair(a[nxt] + a[nxtt], nxt));
                tset.add(new Pair(sum + a[nxtt], cur));
            }

            a[cur] = sum;
            // update
            set.remove(nxt);
            cnt++;

        }
        return cnt;
    }


}


