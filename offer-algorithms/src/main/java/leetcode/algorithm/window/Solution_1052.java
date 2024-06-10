package leetcode.algorithm.window;

/**
 * @program: LeetCodeSolution
 * @description: #slide_window
 * @author: WhyWhatHow
 **/

public class Solution_1052 {

    public static void main(String[] args) {
        Solution_1052 sol = new Solution_1052();

        int i = sol.maxSatisfied(new int[]{
                        1, 0, 1, 2, 1, 1, 7, 5
//                        4, 10, 10
                }, new int[]{
                        0, 1, 0, 1, 0, 1, 0, 1
//                        1, 1, 0
                },
                3
//                2
        );
        System.out.println(i);

        System.out.println("==================");
    }

    int windowSum = 0;
    int right = 0;
    int res = 0;
    int left = 0; //  max_win_sum left
    int max = -1;

    /**
     * 统计每一次 grumpy[i] =1 ,所耗费的时间,
     * @param customers
     * @param grumpy
     * @param minutes
     * @return
     */
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {

        for (int i = 0; i < grumpy.length; i++) {
            if (grumpy[i] == 0) res += customers[i];
            else {
                handleWindow(customers, grumpy, minutes, i);
            }
        }
        if (max != -1) {
            res += max;
//            for (int i = left; i < right; i++) {
//                if (grumpy[i] == 0)
//                    res -= customers[i];
//            }
        }
        return res;


    }

    // handle window
    private void handleWindow(int[] customers, int[] grumpy, int minutes, int start) {
        right = start;
        windowSum = 0;
        while (right < grumpy.length && right < start + minutes) {
            if (grumpy[right] == 1){
                windowSum += customers[right];
            }
            right++;
        }
        if (max < windowSum) {
            max = windowSum;
            left = start;
        }
    }

    // AI
    public int maxSatisfiedBYAI(int[] customers, int[] grumpy, int minutes) {
        int windowSum = 0;
        int maxWinSum = 0;
        int totalSatisfaction = 0;

        for (int i = 0; i < customers.length; i++) {
            // Always add the customer satisfaction when the owner is not grumpy
            if (grumpy[i] == 0) {
                totalSatisfaction += customers[i];
            } else {
                // Only add the grumpy customer satisfaction to the window sum
                windowSum += customers[i];
            }

            // If we have reached the window size, slide the window
            if (i >= minutes) {
                // Subtract the leftmost element of the window if it was a grumpy minute
                if (grumpy[i - minutes] == 1) {
                    windowSum -= customers[i - minutes];
                }
            }

            // Update the max window sum if necessary
            maxWinSum = Math.max(maxWinSum, windowSum);
        }

        // Add the maximum additional satisfaction we could gain from the window
        return totalSatisfaction + maxWinSum;
    }
}


