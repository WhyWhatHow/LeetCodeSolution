package leetcode.algorithm.medium;

import java.util.Arrays;

/**
 * @program: LeetCodeSolution
 * @description: #binary Indexed Array
 * @author: WhyWhatHow
 **/

public class Solution_522 {

    public static void main(String[] args) {
        Solution_522 sol = new Solution_522();
        System.out.println(sol.findLUSlength(new String[]{
//                "aabbcc", "aabbcc", "cb"
//                "aaa", "aaa", "aa"
//                "aabbcc", "aabbcc","b","bc","abcabc"
                "abcabc","abcabc","abcabc","abc","abc","cca"
        }));
        System.out.println("==================");
    }

    public int findLUSlength(String[] strs) {
        Arrays.sort(strs, (a, b) -> b.length() - a.length());
        int n = strs.length;
        int[] nums = new int[n];
        Arrays.fill(nums, -1);
        boolean[] vis = new boolean[n];

        for (int i = 0; i < strs.length; i++) {
            if (vis[i]) continue;
            for (int j = i + 1; j < strs.length; j++) {
                if (strs[i].equals(strs[j])) {
                    vis[i] = true;
                    vis[j] = true;
                    continue;
                }
                if (check(strs[i],strs[j])) {
                    vis[j] = true;
                    continue;
                }
                if (!vis[j] && !vis[i]) {
                    nums[i] = Math.max(nums[i], Math.max(strs[i].length(), strs[j].length()));
                }
            }
            if(!vis[i]){
                nums[i] =strs[i].length();
            }
        }
        if (!vis[n - 1])
            nums[n - 1] = Math.max(nums[n - 1], strs[n - 1].length());

        int res = -1;
        for (int i = 0; i < nums.length; i++) {
            if (!vis[i])
                res = Math.max(res, nums[i]);
        }
        return res;

//        String[] ss = (String[]) map.entrySet().stream().filter(entry -> entry.getValue() == 1).map(Map.Entry::getKey).toArray();


    }

    /**
     * a.length() <=b.length()
     *
     * @param a
     * @param b
     * @return
     */
    boolean check(String a, String b) {
        int i = 0, j = 0;
        int n = a.length();
        int m = b.length();
        while (j < m && i<n) {
            if (a.charAt(i) == b.charAt(j)) {
                j++;
            }  i++;
        }
        return j==m? true : false ;
    }
}


