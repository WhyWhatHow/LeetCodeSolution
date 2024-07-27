package leetcode.algorithm.dfs;

/**
 * @program: LeetCodeSolution
 * @description: #
 * @author: WhyWhatHow
 **/

public class Solution_3106 {

    public static void main(String[] args) {
        Solution_3106 sol = new Solution_3106();
        System.out.println(sol.distance('b', 'z'));
        System.out.println(sol.getSmallestString(
                "zbbz", 3
        ));
        System.out.println("==================");
    }

    public String getSmallestStringByDFS(String s, int k) {
        char[] chars = s.toCharArray();
        char[] cs = new char[chars.length];
        dfs(0, cs, chars, k);
        return String.valueOf(cs);
    }

    char c = 'a';

    boolean yes = false;

    private void dfs(int cur, char[] cs, char[] chars, int k) {
        if (k < 0) return;
        if (cur == cs.length) {
            yes = true;
            return;
        }
        if (yes) return;
        for (int i = 0; i < 26; i++) {
            char tmp = (char) (c + i);
            cs[cur] = tmp;
            int val = distance(cs[cur], chars[cur]);
            dfs(cur + 1, cs, chars, k - val);
            if (yes) return;
            cs[cur] = chars[cur];
        }

    }

    /**
     * greedy
     * @param s
     * @param k
     * @return
     */
    public String getSmallestString(String s, int k) {
        char[] cs = s.toCharArray();
        char c = 'a';
        for (int i = 0; i < cs.length; i++) {
            int distance = distance(c, cs[i]);
            if (distance > k) {
                cs[i] -= k;
                break;
            }
            k -= distance;
            cs[i] = 'a';
        }
        return String.valueOf(cs);
    }

    int distance(char a, char b) {
        int res = Math.abs(b - a);
        if (res > 13) {
            res = 26 - res;
        }
        return res;
    }
}


