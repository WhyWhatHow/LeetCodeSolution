package leetcode.algorithm.tree;

import leetcode.algorithm.dsa.TreeNode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;


public class Solution_501 {
    public static void main(String[] args) {


        Solution_501 sol = new Solution_501();
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(15);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(20);
        root.right.right.right = new TreeNode(20);
//        sol.findMode(root);
        sol.findMode20260301(root);
        String[] s = new String[]{"pwwkew", "bbbbbbbbbbbb", "abcabcbb", "abba"};

    }

    Integer prev = null; // 前一个数据是多少
    int cnt = 0;
    int maxcnt = 0;
    HashSet<Integer> set = new HashSet<>();

    public int[] findMode20260301(TreeNode root) {
        inorder(root);
        int[] rs = new int[set.size()];
        int k = 0;
        for (Integer i : set) {
            rs[k++] = i;
        }
        return rs;

    }

    private void inorder(TreeNode root) {
        if (root == null) return;
        inorder(root.left);

        if (prev == null || prev != root.val) cnt = 1;
        else cnt++;

        if (cnt > maxcnt) {
            set.clear();
            set.add(root.val);
            maxcnt = cnt;
        } else if (cnt == maxcnt) {
            set.add(root.val);
        }

        prev = root.val;

        inorder(root.right);
    }

    //////////////////////////////////// old  solution ///////////////////////
    int max = 0;

    //    int cnt = 0 ;
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


}
