package jianzhiOffer;

import java.util.LinkedList;
import java.util.List;

/**
 * @program: LeetCodeSolution
 * @description:
 * @author: WhyWhatHow
 * @create: 2020-05-22 08:10
 **/
public class Sol_34 {
    public static void main(String[] args) {
        Sol_34 sol = new Sol_34();
    }

    List resList = new LinkedList();

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        solve(root, sum, 0);
        return resList;
    }

    private void solve(TreeNode root, int sum, int now) {
        if (root == null) {
            return;
        }
        if (now == sum) {

        }
        now += root.val;
        solve(root.left, sum, now);
        solve(root.right, sum, now);
        now -= root.val;
        solve(root.left, sum, now);
        solve(root.right, sum, now);
    }
}
