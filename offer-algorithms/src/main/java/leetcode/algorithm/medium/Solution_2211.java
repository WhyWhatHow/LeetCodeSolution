package leetcode.algorithm.medium;

/**
 * @program: LeetCodeSolution
 * @description: #
 * @author: WhyWhatHow
 **/

public class Solution_2211 {

    public static void main(String[] args) {
        Solution_2211 sol = new Solution_2211();
        System.out.println(sol.countCollisions(
                "RLRSLL"
        ));
        System.out.println("==================");
    }

    public int countCollisions(String directions) {
        char[] cs = directions.toCharArray();
        int n = cs.length;
        int cnt = 0;
        boolean[] vis = new boolean[cs.length]; // 标记当前位置是否有车
        // handle 'S'
        for (int i = 0; i < cs.length; i++) {
            if (cs[i] == 'S') vis[i] = true;
        }
        // handle 'L' ==> go left, means always handle first element .
        for (int i = 0; i < cs.length; i++) {
            if (cs[i] == 'L' && !vis[i]) {
                if (i == 0) {
                    vis[i] = false;
                    continue;
                }  // move to -1
                if (vis[i - 1]) { // handle S
                    vis[i] = true;
                    cnt++;
                } else if (cs[i - 1] == 'R') { // handle R
                    vis[i - 1] = true;
                    vis[i] = true;
                    cnt += 2;
                }
            }
        }

        // handle 'R'
        for (int i = cs.length - 1; i >= 0; i--) {
            if (cs[i] == 'R' &&!vis[i]) {
                if (i == n - 1) {
                    vis[i] = false;
                    continue;
                }
                if (vis[i + 1]) { // handle 'S'
                    vis[i] = true;
                    cnt++;
                }
            }
        }

        return cnt;

    }

}


