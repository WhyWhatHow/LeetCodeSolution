package leetcode.algorithm;

/**
 * @program: LeetCodeSolution
 * @description:
 * @author: WhyWhatHow

 **/

public class Solution_11 {

    //    public int maxArea(int[] height) {
//        int res = 0;
//        if (height == null || height.length == 0) {
//            return res;
//        }
////        int temp = -1;
//        int length = height.length/2;
//        for (int i = 0; i < length; i++) {
//            for (int j = height.length-1; j >i; j--) {
//                res = Math.max(res, (j - i) * Math.min(height[i], height[j]));
//            }
//        }
//        return res;
//    }

    // 双指针遍历, 维护一个面积s, s= (right-left)*math.min(h[left],h[right]);
    public int maxArea(int[] height) {
        int res = 0;
        if (height.length == 0 || height == null) {
            return 0;
        }
        int left = 0, right = height.length - 1;
        while (left < right) {
            if (height[left] < height[right]) {
                res=Math.max (res,(right-left)* height[left]);
                left++;
            } else {
                res=Math.max (res,(right-left)* height[right]);
                right--;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution_11 sol = new Solution_11();
        int i = sol.maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7});
        System.out.println(i);
        System.out.println("==================");
    }
}


