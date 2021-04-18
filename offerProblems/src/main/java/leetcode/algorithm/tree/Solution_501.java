package leetcode.algorithm.tree;

import leetcode.algorithm.dsa.TreeNode;

import java.util.*;


public class Solution_501 {

    private int cnt = 0,// ans数组下标
            max = 0;// 数据出现次数

    public int[] findMode(TreeNode root) {
        if (root == null) return new int[]{};
        HashMap<Integer, Integer> map = new HashMap<>();
        inOrder(root, map);
        int[] ans = new int[cnt];

        for (Integer integer : map.keySet()) {
            if (map.get(integer) == max) {
                ans[--cnt] = integer;
            }
        }
        return ans;
    }
//    public int[] findMode2(TreeNode root){
//        if (root == null) return new int[]{};
//
//    }



    void inOrder(TreeNode root, Map<Integer, Integer> map) {
        if (root != null) {
            inOrder(root.left, map);
            map.put(root.val, map.getOrDefault(root.val, 0) + 1);
            Integer integer = map.get(root.val);
            if (max < integer) {
                max = integer;
                cnt = 1;     // 重置,
            } else if (max == integer) {
                cnt++;
            }
            inOrder(root.right, map);
        }
    }


    public static void main(String[] args) {


        Solution_501 sol = new Solution_501();
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(15);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(20);
        sol.findMode(root);
        String[] s = new String[]{"pwwkew", "bbbbbbbbbbbb", "abcabcbb", "abba"};

    }
}
