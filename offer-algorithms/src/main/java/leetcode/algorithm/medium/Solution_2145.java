package leetcode.algorithm.medium;

/**
 * @program: LeetCodeSolution
 * @description: #
 * @author: WhyWhatHow
 **/

public class Solution_2145 {

    public static void main(String[] args) {
        Solution_2145 sol = new Solution_2145();
        System.out.println(sol.numberOfArrays(new int[]{
                        -11054, -29384, -79640
                }, 21923, 53016
        ));
        System.out.println("==================");
    }

    /**
     * d[i] = h[i+1]-h[i]
     * h[i+1] = d[i] + h[i]
     * h[i+2] = d[i] + d[i+1] + h[i]
     * h[j] = sum(d) {[i,j)} + h[i]
     * 由已知:  h[j] <= upper  && h[j] >=lower
     * sum (d{i,j}) 中 min >=lower ,max <= upper
     * 记 lowerBound 为 h[i] 最小值.  upperBound 为 h[i] 的最大值.
     * lowerBound = lower -min
     * upperBound = upper - max
     * 数量记为 upperBound-lowerBound +1 ;
     * -----------------------------------------------------------------
     * 问题可以转化为[i,j] 范围内的最大差值为 target <=upper-lower 的数量.
     * 那么,如何求target 呢?  slide_window diff[i] + diff[i+1 ] =hidden[i+2] - hidden[i]
     * diff[i]+..+diff[j] = h[j+1] - h[i]
     * 设 f[i]  表示 [0,i+1] range 内 差的最大值.
     * f[i] = max(f[i-1] + d[i], d[i])
     *
     * @param differences
     * @param lower
     * @param upper
     * @return
     */
    public int numberOfArrays(int[] differences, int lower, int upper) {
        long sum = 0;
        long min = 0;
        long max = 0;
        for (int d : differences) {
            sum += d;
            min = Math.min(min, sum);
            max = Math.max(max, sum);
        }
        long loBound = lower - min;
        long upBound = upper - max;
        return (int) Math.max(0, upBound - loBound + 1);
    }


}


