package leetcode.algorithm.dp;

/**
 * @program: LeetCodeSolution
 * @description: #
 * @author: WhyWhatHow
 **/

public class Solution_3494 {

    public static void main(String[] args) {
        Solution_3494 sol = new Solution_3494();
        System.out.println(sol.minTime(new int[]{
//                1, 5, 2, 4
                7
        }, new int[]{
//                5, 1, 4, 2
                3, 3, 9, 5, 8, 7
        }));
        System.out.println("==================");
    }

    /**
     * 题目要求 a-> 传递药水后, b要立刻开始工作也就是说, a的结束时间的max(a,up_bfinished_time)
     * 因而: 题目就需要两次遍历, 正向遍历 求得最后一个wizard处理药水所需的时间, 然后逆向遍历减掉每一个wizard制作mana所需的时间即可正确还原.
     * people :  1,  5,  2,  4
     * mana_5:   5, 30, 40, 60
     * mana_1:
     *
     * @param skill
     * @param mana
     * @return
     */
    public long minTime(int[] skill, int[] mana) {
        int n = skill.length;
        long[] bf = new long[n]; // 上一次的结束时间.

        // init 1st mana
        long sum = 0;
        for (int i = 0; i < skill.length; i++) {
            sum += skill[i] * mana[0];
            bf[i] = sum;
        }

        // handle [2,n) mana
        for (int k = 1; k < mana.length; k++) {
            for (int i = 0; i < skill.length - 1; i++) {
                //make sure i-1 has been finished.
                if (i > 0) {
                    bf[i] = Math.max(bf[i - 1], bf[i]);
                }
                // as the min time to start work
                long tmp = skill[i] * mana[k] + bf[i];

                bf[i] = Math.max(tmp, bf[i + 1]);
                sum = bf[i];
            }
            bf[n - 1] = sum = sum + mana[k] * skill[n - 1];
            for (int i = n - 2; i >= 0; i--) {
                bf[i] = bf[i + 1] - skill[i + 1] * mana[k];
            }
            System.out.println("...");
        }
        return bf[n - 1];
    }
}


