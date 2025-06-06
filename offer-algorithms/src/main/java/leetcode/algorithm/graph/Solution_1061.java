package leetcode.algorithm.graph;

/**
 * @program: LeetCodeSolution
 * @description: #
 * @author: WhyWhatHow
 **/

public class Solution_1061 {

    public static void main(String[] args) {
        Solution_1061 sol = new Solution_1061();
        System.out.println(sol.smallestEquivalentString(
//                "hello", "world", "hold"
                "leetcode", "programs", "sourcecode"
        ));

        System.out.println("==================");
    }

    int[] p;  // parent
    int[] ls; // levels

    void init(int n) {
        p = new int[n];
        ls = new int[n];
        for (int i = 0; i < n; i++) {
            p[i] = i;
            ls[i] = 1;
        }
    }

    int find(int idx) {
        if (p[idx] != idx) {
            p[idx] = find(p[idx]);
        }
        return p[idx];
    }

    boolean union(int a, int b) {
        int pa = find(a);
        int pb = find(b);
        if (pa == pb) return false;
        if (pa < pb) {
            p[pb] = pa;
            ls[pa]++;
        } else {
            p[pa] = pb;
            ls[pb]++;
        }
        return true;
    }

    public String smallestEquivalentString(String s1, String s2, String baseStr) {
        int n = s1.length();
        init(26);

        char c = 'a';
        for (int i = 0; i < n; i++) {
            int x = s1.charAt(i) - c;
            int y = s2.charAt(i) - c;
            union(x, y);
        }

        StringBuilder sb = new StringBuilder();
        for (char cc : baseStr.toCharArray()) {
            sb.append((char) (c + find(cc - c)));
        }


        return sb.toString();
    }
}


