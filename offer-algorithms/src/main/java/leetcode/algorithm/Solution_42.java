package leetcode.algorithm;

import java.util.Stack;

/**
 * @program: LeetCodeSolution
 * @description:
 * @author: WhyWhatHow
 * @create: 2020-05-07 12:09
 **/

public class Solution_42 {

    /**
     * @param height
     * @return
     */
    public int trap1(int[] height) {
        int res = 0;
        Stack<Integer> stack = new Stack<>();
        int cur = 0;
        while (cur < height.length) {
            while (!stack.isEmpty() && height[cur] > height[stack.peek()]) {
                int h = height[stack.peek()];
                stack.pop();
                if (stack.isEmpty()) {
                    break;
                }
                int distance = cur - stack.peek() - 1;
                int min = Math.min(height[stack.peek()], height[cur]);
                res += distance * (min - h);
            }
            stack.push(cur++);
        }
        return res;

    }

    /**
     * 1 列1列的处理.  当前 列 i 存储的水量 = min(i节点左侧柱子最大值, i节点右侧柱子最大值) -i节点柱子的高度
     *
     * @param height
     * @return
     */
    public int trap(int[] height) {
        if (height.length == 0) {
            return 0;
        }
        int res = 0;
        int[] maxLeft = new int[height.length];// i 节点左侧的最大值
        int[] maxRight = new int[height.length];// i 节点右侧的最大值
        maxLeft[0] = height[0];
        for (int i = 1; i < maxLeft.length; i++) {
            maxLeft[i] = Math.max(maxLeft[i - 1], height[i]);
        }
        maxRight[height.length - 1] = height[height.length - 1];
        for (int i = maxRight.length - 2; i >= 0; i--) {
            maxRight[i] = Math.max(height[i], maxRight[i + 1]);
        }
        for (int i = 0; i < height.length; i++) {
            res += Math.min(maxLeft[i], maxRight[i]) - height[i];
        }
        return res;
    }

    /**
     * 不同处:  maxLeft  从数组 ->maxLeft
     * 1 列1列的处理.  当前 列 i 存储的水量 = min(i节点左侧柱子最大值, i节点右侧柱子最大值) -i节点柱子的高度
     *
     * @param height
     * @return
     */
    public int trapMaxLeft(int[] height) {
        if (height.length == 0) {
            return 0;
        }
        int res = 0;
        int maxLeft = 0;// i 节点左侧的最大值
        int[] maxRight = new int[height.length];// i 节点右侧的最大值

        maxRight[height.length - 1] = height[height.length - 1];
        for (int i = maxRight.length - 2; i >= 0; i--) {
            maxRight[i] = Math.max(height[i], maxRight[i + 1]);
        }
        for (int i = 0; i < height.length; i++) {
            maxLeft = Math.max(maxLeft, height[i]);
            res += Math.min(maxLeft, maxRight[i]) - height[i];
        }
        return res;
    }

    public static void main(String[] args) {
        Solution_42 sol = new Solution_42();
        int i = sol.trap2(new int[]{
                0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1
//                4, 2, 0, 3, 2, 5
        });
        System.out.println(i);

        System.out.println("==================");
    }

    /**
     * 2023-09-24
     *
     * @param height
     * @return
     */
    public int trap2(int[] height) {
        int[] maxLeft = new int[height.length];
        int[] maxRight = new int[height.length];
        int res = 0;
        maxLeft[0] = height[0];
        maxRight[height.length - 1] = height[height.length - 1];

        for (int i = 1; i < height.length; i++) {
            maxLeft[i] = Math.max(maxLeft[i - 1], height[i]);
        }
        for (int i = maxRight.length - 2; i >= 0; i--) {
            maxRight[i] = Math.max(maxRight[i + 1], height[i]);
        }
        for (int i = 0; i < height.length; i++) {
            // 位置为i的节点可以接受到的雨水是: 左右两侧最小的哪一个 - height[i]
            int temp = Math.min(maxLeft[i], maxRight[i])-height[i];
            if (temp>0) {
                res+=temp;
            }
        }
        return res;
    }

}
