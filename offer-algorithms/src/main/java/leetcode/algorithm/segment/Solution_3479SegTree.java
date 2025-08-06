package leetcode.algorithm.segment;

/**
 * @program: LeetCodeSolution
 * @description: #
 * @author: WhyWhatHow
 **/

public class Solution_3479SegTree {

    public static void main(String[] args) {
        Solution_3479SegTree sol = new Solution_3479SegTree();
        System.out.println(sol.numOfUnplacedFruits(new int[]{
//                4, 2, 5,
                17, 14, 59, 20
        }, new int[]{
//                3, 5, 4,
                41, 6, 7, 33
        }));
        System.out.println("==================");
    }


    public int numOfUnplacedFruits(int[] f, int[] b) {
        SegmentTree tree = new SegmentTree(b);
        int n = f.length;
        for (int i : f) {
            int res = tree.find(1, 0, f.length - 1, i);
            if (res > 0) {
                tree.update(res, -1);
                n--;
            }
        }
        return n;
    }


}

class SegmentTree {
    int[] max;

    SegmentTree(int[] a) {
        int n = a.length;
        max = new int[n * 4];
        build(1, 0, n - 1, a);
    }

    /**
     * @param i 当前node 节点
     * @param l arr 的左边界.
     * @param r arr 右边界
     * @param a
     */
    private void build(int i, int l, int r, int[] a) {
        if (l == r) {
            max[i] = a[l];
            return;
        }
        int mid = l + (r - l) / 2;
        build(2 * i, l, mid, a); // left_subtree
        build(2 * i + 1, mid + 1, r, a); // right_subTree
        maintain(i); // current node
    }

    // 设置 位置i的 结果. i 由 i*2, i*2+1 确定
    private void maintain(int i) {
        max[i] = Math.max(max[i * 2], max[i * 2 + 1]);
    }

    // 注: 子树根节点为其最大值.
    // 对于节点下标为i的子树进行查找.

    /**
     * l, r 用来判断是否找到了叶子节点,即最初的要被修改的位置
     *
     * @param i   当前下标为i 的子树.
     * @param l   arr 的左边界
     * @param r   arr 的右边界.
     * @param tar 目标值.
     * @return
     */
    public int find(int i, int l, int r, int tar) {
        if (max[i] < tar) return -1; //
        if (l == r) return i;  // 找到叶子节点, 标记访问结束,返回即可.
        int mid = l + (r - l) / 2;
        // check left_subtree
        int res = find(i * 2, l, mid, tar);
        if (res < 0)
            res = find(i * 2 + 1, mid + 1, r, tar);
        return res;
    }

    // 更新叶子节点 idx , 以及其parent节点.
    public void update(int idx, int val) {
        max[idx] = val;
        while (idx != 1) {
            idx = idx / 2;
            maintain(idx);
        }
    }
}

