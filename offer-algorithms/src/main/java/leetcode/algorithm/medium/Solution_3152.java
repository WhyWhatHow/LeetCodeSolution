package leetcode.algorithm.medium;

/**
 * @program: LeetCodeSolution
 * @description: #
 * @author: WhyWhatHow
 **/

public class Solution_3152 {

    public static void main(String[] args) {
        Solution_3152 sol = new Solution_3152();
        System.out.println(sol.isArraySpecial(new int[]{
                4, 1, 3, 6
        }, new int[][]{
                {0, 2}, {2, 3}
        }));
        System.out.println("==================");
    }


    /**
     * 统计所有符合条件的答案.
     *
     * @param nums
     * @param queries
     * @return
     */
    public boolean[] isArraySpecial(int[] nums, int[][] queries) {
        boolean[] res = new boolean[queries.length];
        boolean[] odds = new boolean[nums.length];
        int[] arr = new int[nums.length];
        int cnt = 0;

        for (int i = 0; i < nums.length; i++) {
            odds[i] = isOdd(nums[i]);
            if (i != 0 && odds[i] == odds[i - 1]) {
                arr[cnt++] = i - 1;
            }
        }
        arr[cnt++] = nums.length - 1;


        for (int i = 0; i < queries.length; i++) {
            int from = queries[i][0], to = queries[i][1];
            if (from == to) res[i] = true;
            res[i] = check(arr, cnt, nums, from, to);
//            else if (list.contains(to)) res[i] = false;
//            else res[i] = check(nums, queries[i]);
        }
        return res;
    }

    /**
     * check nums index from and to is ok.
     */
    private boolean check(int[] arr, int cnt, int[] nums, int from, int to) {
        //(arr[i-1]+1,arr[i]] find first element >= to
        int i = ceilSearch(arr, cnt, to);
        if (i > 0 && from < arr[i - 1] + 1) return false;
        return true;
    }

    private int ceilSearch(int[] arr, int cnt, int target) {
        int l = 0, r = cnt;
        int mid = r / 2;
        int res = -1;
        while (l <= r) {
            mid = l + (r - l) / 2;
            if (arr[mid] >= target) {
                r = mid - 1;
                res = mid;
            } else {
                l = mid + 1;
            }
        }
        return res;
    }


    boolean isOdd(int num) {
        return (num & 1) != 0;
    }

//    private boolean check(int[] nums, int[] query) {
//        int from = query[0], to = query[1];
//        boolean yes = true;
//        for (int i = from + 1; i <= to; i++) {
//            if (isOdd(nums[i - 1]) == isOdd(nums[i])) {
//                yes = false;
//                break;
//            }
//        }
//        return yes;
//    }

}


