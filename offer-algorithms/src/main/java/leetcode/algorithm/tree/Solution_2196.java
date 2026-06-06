package leetcode.algorithm.tree;

import leetcode.algorithm.dsa.TreeNode;

import java.util.HashMap;
import java.util.TreeSet;

/**
 * @program: LeetCodeSolution
 * @description: #
 * @author: WhyWhatHow
 **/
public class Solution_2196 {

    public static void main(String[] args) {


        Solution_2196 sol = new Solution_2196();//
        System.out.println(sol.createBinaryTree(
                new int[][]{{20, 15, 1}, {20, 17, 0}, {50, 20, 1}, {50, 80, 0}, {80, 19, 1}}
        ));
        System.out.println("==================");
    }

    public TreeNode createBinaryTree(int[][] descriptions) {
        var map = new HashMap<Integer, TreeNode>();
        // findRootNode
        var roots = new TreeSet<Integer>();
        for (int[] ds : descriptions) {
            int p = ds[0], c = ds[1], isleft = ds[2];

            roots.add(p);
//            if (roots.contains(c)) roots.remove(c);
            var pNode = map.getOrDefault(p, new TreeNode(p));
            var cNode = map.getOrDefault(c, new TreeNode(c));
            if (isleft == 1) pNode.left = cNode;
            else pNode.right = cNode;
            map.put(p,pNode);
            map.put(c,cNode);
        }
        for (int[] ds : descriptions) {
            int c = ds[1];
            if (roots.contains(c)) roots.remove(c);
        }
        return map.get(roots.getFirst())      ;
    }

}
