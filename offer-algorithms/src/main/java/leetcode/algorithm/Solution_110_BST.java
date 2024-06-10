package leetcode.algorithm;

import leetcode.algorithm.dsa.TreeNode;

import java.util.Random;

/**
 * @program: LeetCodeSolution
 * @description:
 * @author: WhyWhatHow

 **/

public class Solution_110_BST {

    public int binarySearch(int[] nums, int x, int left, int right) {
        if (left > right)
            return -1;

        int mid = (left + right) >> 1;
        if (nums[mid] == x) {
            return mid;
        } else if (nums[mid] > x) {
            return binarySearch(nums, x, left, mid - 1);
        } else {
            return binarySearch(nums, x, mid + 1, right);
        }
    }

    public int binarySearchByWhile(int[] nums, int x, int left, int right) {
        int mid = -1 ;
        while (true) {
            mid = (left + right) >> 1;

            if (nums[mid] < x) {
                left = mid + 1;
            }
            else {
                right = mid - 1;
            }
        }
    }


    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length == 0) {
            return null;
        }
        int mid = nums.length >> 1;
        int left = 0, right = nums.length;

        TreeNode root = new TreeNode(nums[mid]);
        TreeNode ll = root, rr = root;
        int lm = 0;
        while (0 <= mid) {
            lm = (left + mid) >> 1;
            ll.left = new TreeNode(nums[lm]);
            ll.right = new TreeNode();
            ll = ll.left;
        }

        return root;
    }
//
//    public TreeNode create(int x, TreeNode root) {
//        if (root == null) {
//            return new TreeNode(x);
//        }
//
//    }

//    public TreeNode solve(int[] nums, int left, int right) {
//
//    }

    public static void main(String[] args) {
        Solution_110_BST sol = new Solution_110_BST();
        Random random = new Random();
        int[] nums = new int[10];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = i;
        }

        for (int i = 0; i < nums.length; i++) {
            int i1 = sol.binarySearchByWhile(nums, nums[i], 0, nums.length - 1);
            System.out.print(nums[i] + " : " + i1 + ";");
        }
        int i1 = sol.binarySearchByWhile(nums, -1, 0, 9);
        System.out.println(i1);
        int i = sol.binarySearchByWhile(nums, 10, 0, 9);
        System.out.println(i);
        System.out.println("==================");
    }
}


