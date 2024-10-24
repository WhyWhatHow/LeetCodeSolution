package leetcode.algorithm.medium;

import java.util.LinkedList;

/**
 * @program: LeetCodeSolution
 * @description: #
 * @author: WhyWhatHow
 **/

public class Solution_3175 {

    public static void main(String[] args) {
        Solution_3175 sol = new Solution_3175();
        System.out.println("==================");
    }

    /**
     * // if k >=n , return max(skills[i])->i as maxIdx.
     * // else , visit skills, try to find k length,
            *  if you find maxIdx, that would be the ans.
            *  otherwise, you need to count each i's len of the elements that fit the question.
     * @param skills
     * @param k
     * @return
     */
    public int findWinningPlayer(int[] skills, int k) {
        int n = skills.length;
        int maxIdx = 0;
        int max = 0;
        for (int i = 0; i < skills.length; i++) {
            if (max < skills[i]) {
                max = skills[i];
                maxIdx = i;
            }
        }
        if (k >= n) return maxIdx;

        // handle k < n
        int cur = 0;
        int[] cnt = new int[n];// count len
        LinkedList<Integer> q = new LinkedList<>();
        for (int i = 1; i < skills.length; i++) {
            if (skills[i] < skills[cur]) {
                cnt[cur]++;
                q.add(i);
            } else {
                cnt[i]++;
                q.add(cur);
                cur = i;
            }
            if (cnt[cur] == k || cur == maxIdx) {
                break;
            }
        }

        // find maxIdx, so that's the ans.
        return cur;
    }

}


