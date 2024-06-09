package leetcode.algorithm.dp;

/**
 * @program: LeetCodeSolution
 * @description:
 * @author: WhyWhatHow
 **/

public class Solution_312 {

    public static void main(String[] args) {
        Solution_312 sol = new Solution_312();
        int i = sol.maxCoins(new int[]{
                3, 1, 5, 8
//                5
//                3, 1, 5
        });
        System.out.println(i);
        System.out.println("==================");
    }

    /**
     * f[i][j]  (i,j)范围内的最大值.   nums[i]*nums[i-1]*nums[i+1]
     * 假设存在k,使得k 为最后一个被结束的点 , 如下, i,j 不属于范围, f[i][j] = nums[i]*nums[k]*nums[j]+ f[i][k] + f[k][j]
     * i,   i+1,... k, ...j-1,   j
     * so
     * if i< j ==> f[i][j] = max(f[i][j], nums[i]*nums[k]*nums[j] +f[i][k] + f[k][j])
     * else :      f[i][j] = 0 ;
     * 下一个问题, 遍历的顺序, 需要保证 f[i][k], f[k][j] 有值, 如何保证.
     * 按长度遍历, len =3 , [l,k,r]  range : len <= n+2
     * 在枚举l(0,?)  l+ len -1 <= n+2
     *  因此 r = l+len-1
     *  `k belong [l+1,r-1] `
     *
     * @param nums
     * @return
     */
    public int maxCoins(int[] nums) {
        int n = nums.length;
        int[][] f = new int[n + 2][n + 2];
        // init
        int[] arr = new int[nums.length + 2];
        arr[0] = arr[n + 1] = 1;
        for (int i = 0; i < nums.length; i++) {
            arr[i + 1] = nums[i];
        }

        // running
        for (int len = 3; len <= n + 2; len++) {
            for (int l = 0; l + len - 1 < n + 2; l++) {
                int r = l + len - 1;
                for (int k = l + 1; k < r; k++) {
                    f[l][r] = Math.max(f[l][r], f[l][k] + arr[l] * arr[r] * arr[k] + f[k][r]);
                }
            }
        }

        return f[0][n + 1];
    }

//    public int maxCoins(int[] nums) {
//        int mid = nums.length / 2;
//        int left = mid , right = mid+1;
//        int res = 0;
//        while (0 <= left && right < nums.length) {
//            // left
//            res = handleLeft(nums, right, left, res);
//            left--;
//            //right
//            res = handleRight(nums, left, right, res);
//            right++;
//        }
//        while (0 <= left) {
//            res = handleLeft(nums, right, left, res);
//            left--;
//        }
//        while (right < nums.length) {
//            res = handleRight(nums, left, right, res);
//            right++;
//        }
//        return res;
//    }

    private int handleLeft(int[] nums, int right, int left, int res) {
        int pr = 1;
        if (right < nums.length) {
            pr = nums[right];
        }
        if (0 < left) {

            res += nums[left - 1] * nums[left] * pr;

        } else {  //left ==0
            res += nums[left] * pr;
        }
        return res;
    }

    private int handleRight(int[] nums, int left, int right, int res) {
        int pl = 1;
        if (0 <= left) {
            pl = nums[left];
        }
        if (right < nums.length - 1) {
            res += pl * nums[right] * nums[right + 1];
        } else {
            if (left < 0) {
                res += nums[right];
            } else {
                res += pl * nums[right];
            }
        }
        return res;
    }
}


