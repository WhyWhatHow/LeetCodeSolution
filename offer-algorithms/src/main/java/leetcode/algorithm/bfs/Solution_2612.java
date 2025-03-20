package leetcode.algorithm.bfs;

import java.util.*;

/**
 * @program: LeetCodeSolution
 * @description: #hard #bfs
 * @author: WhyWhatHow
 **/

public class Solution_2612 {

    public static void main(String[] args) {
        Solution_2612 sol = new Solution_2612();
        System.out.println(sol.minReverseOperations(
                4, 0,
                new int[]{
                        1, 2
                }, 4
        ));
        System.out.println("==================");
    }

    /**
     * 对于任意的 下标为 i, 设其子数组为[l,r],其中 r-l+1=k;
     * 已知:  对于子数组 [l,r]中的i 元素, 翻转后的位置是 `l+r-i`; // l->r , l+1->r-1, l+2->r-2;
     * 如果确定了l , 对应r 也就确定了 , 即 r = l+k-1;
     * 如何确定l 呢?
     * if 对于index_i 的l取值最小, 只有当 i ==r, 时成立, 即 l = i-k+1 , 由于数组,l>=0
     * 所以 minL = max(0, i-k+1); maxL = min(i, n-k) // n-k 避免构不成子数组.
     * 所以 l 的取值范围是 [minL,maxL] ,确定l ==> 确定r (r = l+k-1)
     * 那么对应的节点 i 所需要的翻转后的位置是 l+r-i
     * l+r-i = l + (l+k-1)-i = 2l+k-1-i;
     * --------------
     * [l,r] 右移一个 [l+1, r+1] ,对应的 i-> l+r+2-i
     * [l,r] 左移一位, [l-1, r-1] , i->l+r-2-i;
     * so 会有两种情况+2, if l+r 为偶数, 那么 用两个维护即可.
     */
    public int[] minReverseOperations(int n, int p, int[] banned, int k) {
        HashSet<Integer> set = new HashSet<>();
        for (int i : banned) {
            set.add(i);
        }
        int[] ans = new int[n];
        Arrays.fill(ans, -1);

        TreeSet<Integer>[] ss = new TreeSet[]{new TreeSet<Integer>(), new TreeSet<>()};
        for (int i = 0; i < n; i++) {
            if (i == p || set.contains(i)) continue;
            ss[i & 1].add(i);
        }

        ans[p] = 0;
        ArrayDeque<Integer> q = new ArrayDeque<>(); //  val =idx
        q.add(p);
        while (!q.isEmpty()) {
            Integer cur = q.poll();

            int minL = Math.max(0, cur - k + 1);
            int maxL = Math.min(cur, n - k);
            // 翻转后的位置
            int min = 2 * minL + k - 1 - cur;
            int max = 2 * maxL + k - 1 - cur;
            var s = ss[min & 1];
            Integer next = s.ceiling(min);
            while (next != null && next <= max) {
                s.remove(next);
                ans[next] = ans[cur] + 1;
                q.add(next);
                next = s.ceiling(min);
            }
        }

        return ans;

    }

    /**
     * 对于任意的 下标为 i, 设其子数组为[l,r],其中 r-l+1=k;
     * 已知:  对于子数组 [l,r]中的i 元素, 翻转后的位置是 `l+r-i`; // l->r , l+1->r-1, l+2->r-2;
     * 如果确定了l , 对应r 也就确定了 , 即 r = l+k-1;
     * 如何确定l 呢?
     * if 对于index_i 的l取值最小, 只有当 i ==r, 时成立, 即 l = i-k+1 , 由于数组,l>=0
     * 所以 minL = max(0, i-k+1); maxL = min(i, n-k) // n-k 避免构不成子数组.
     * 所以 l 的取值范围是 [minL,maxL] ,确定l ==> 确定r (r = l+k-1)
     * 那么对应的节点 i 所需要的翻转后的位置是 l+r-i
     * l+r-i = l + (l+k-1)-i = 2l+k-1-i;
     */
    public int[] minReverseOperationsTLE(int n, int p, int[] banned, int k) {
        HashSet<Integer> set = new HashSet<>();
        for (int i : banned) {
            set.add(i);
        }
        boolean[] vis = new boolean[n];
        vis[p] = true;
        int[] ans = new int[n];
        Arrays.fill(ans, -1);
        ans[p] = 0;
        Queue<Integer> q = new ArrayDeque<>(); //  val =idx
        q.add(p);
        while (!q.isEmpty()) {
            Integer cur = q.poll();
            int minL = Math.max(0, cur - k + 1);
            int maxL = Math.min(cur, n - k);
            for (int l = minL; l <= maxL; l++) {
                if (vis[l] || set.contains(l)) continue;
                int next = 2 * l + k - 1 - cur;
//                if (vis[next] || set.contains(next)) continue;
                vis[next] = true;
                q.add(next);
                ans[next] = ans[cur] + 1;
            }
        }

        return ans;

    }
}


