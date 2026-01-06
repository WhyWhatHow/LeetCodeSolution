package leetcode.algorithm.tree;

import leetcode.algorithm.dsa.TreeNode;

import java.util.ArrayDeque;

/**
 * @program: LeetCodeSolution
 * @description: #
 * @author: WhyWhatHow
 **/
public class Solution_1161 {

    public static void main(String[] args) {
        Solution_1161 sol = new Solution_1161();
        System.out.println("==================");
    }

    public int maxLevelSum(TreeNode root) {
        var q = new ArrayDeque<TreeNode>();
        q.add(root);
        int max = Integer.MIN_VALUE;
        int res = -1;
        int cnt = 0 ;
        while (!q.isEmpty()){
            int size =q.size();
            int sum = 0;
            cnt++;
            for(int i =0 ;i<size;i++){
                TreeNode poll = q.poll();
                sum+=poll.val;
                if(poll.left!=null) q.add(poll.left);
                if(poll.right!=null) q.add(poll.right);
            }
            if(max<sum){
                max =sum ;
                res= cnt ;
            }

        }
        return res;
    }
}


