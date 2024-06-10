package leetcode.algorithm.easy;

/**
 * @program: LeetCodeSolution
 * @description:
 * @author: WhyWhatHow
 **/

public class Solution_1103 {

    public static void main(String[] args) {
        Solution_1103 sol = new Solution_1103();
        sol.distributeCandies(
//                7, 4
//                10, 3
                100,3
//                70, 4
//                1000000000, 3
        );
//        int[] ints = sol.distributeCandies(1000000000, 3);
        System.out.println("==================");
    }

    /**
     * 1,2,3
     * 4,5,6
     * 7,8,9
     * 本质是1,..n的求和,
     * 1. 枚举n使得 s= (1+n)n/2 >= candies 即可.,-> 二分
     * 2.
     *
     * @param candies    [1,10^9]
     * @param num_people [1,1000]
     * @return
     */
    public int[] distributeCandies(int candies, int num_people) {
        if (num_people == 1) return new int[]{candies};
        int n = 1;
        int all = 2 * candies;

        while (n * n + n < all) {
            n++;
        }

        // calculate level
        int level = n / num_people;
        int mod = n % num_people;
        if (mod > 0) level++;
        int[] ans = new int[num_people];

        // handle one line
        if (level == 1 && mod == 0) {
            for (int i = 0; i < ans.length; i++) {
                if (candies - i - 1 > 0) {
                    ans[i] = i + 1;
                    candies -= ans[i];
                } else {
                    ans[i] = candies;
                }
            }
            return ans;
        }

        // level- 1
        for (int i = 0; i < num_people; i++) {
            if (level >= 1)
                ans[i] += (level - 1) * (i + 1);
            if (level >= 2)
                ans[i] += (level - 2) * (level - 1) / 2 * num_people;
        }

        int sum = 0;


        // level
        if (mod > 0) {
            for (int i = 0; i < mod - 1; i++) {
                ans[i] += i + 1;
                if (level >= 1) {
                    ans[i] += (level - 1) * num_people;
                }
            }
            for (int an : ans) {
                sum += an;
            }
            ans[mod - 1] += candies - sum;
        } else {
            for (int an : ans) {
                sum += an;
            }
            for (int i = 0; i < num_people; i++) {
                int temp = (level-1)*num_people +i+1;
                if(sum+temp<candies) {
                    ans[i] += temp;
                    sum+=temp;
                }else {
                    ans[i]+=candies-sum;
                    break;
                }
            }
        }

        return ans;
    }


}


