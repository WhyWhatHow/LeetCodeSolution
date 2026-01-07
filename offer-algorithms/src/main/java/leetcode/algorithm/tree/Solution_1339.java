package leetcode.algorithm.tree;

import leetcode.algorithm.dsa.TreeNode;

import java.util.ArrayList;

/**
 * @program: LeetCodeSolution
 * @description: #
 * @author: WhyWhatHow
 **/
public class Solution_1339 {

    public static void main(String[] args) {
        Solution_1339 sol = new Solution_1339();
        System.out.println("==================");
    }

    int mod = 1000_000_007;
    ArrayList<Long> list = new ArrayList<>();
    long ans = 0;

    public int maxProduct(TreeNode root) {
//        int all = getTotal(root);
        getTotal(root);
        long all = list.getLast();
        long res = 0;
        dfs(root, all);
        return (int) (ans % mod);
        // 保存结果做法
//        for (int i = 0; i < list.size() - 1; i++) {
//            long val = list.get(i);
//            res = Math.max(res, val * (all - val) );
//        }
//        return (int) (res%mod);
    }

    private long dfs(TreeNode root, long all) {
        if (root == null) return 0;
        long res = dfs(root.left, all) + dfs(root.right, all) + root.val;
        ans = Math.max(ans, res * (all - res));
        return res;
    }


    private long getTotal(TreeNode root) {
        if (root == null) return 0;
        long res = 0;
        res += getTotal(root.left) + getTotal(root.right);
        res += root.val;
        list.add(res);
        return res;
    }
}


