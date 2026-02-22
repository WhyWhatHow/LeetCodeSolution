package leetcode.algorithm.weekly;


import java.util.HashMap;

/**
 * @program: LeetCodeSolution
 * @description:
 * @author: WhyWhatHow
 * @create: 2025-12-07 10:29
 **/
public class Weekly_490 {
    public static void main(String[] args) {
//        System.out.println(MyMath.pow(3, 19));
//        System.out.println(MyMath.pow(6, 19));
//        System.out.println(MyMath.pow(6, 19) > 100000_00000_00000l);
        Weekly_490 sol = new Weekly_490();
        System.out.println(sol.countSequences(
//                new int[]{2, 3, 2},
//                6
//                new int[]{4,6,3},
//                2
//                new int[]{1, 5},
//                1
                new int[]{5, 3, 5},
                3
        ));

//        System.out.println(sol.isDigitorialPermutation(415));
        System.out.println("---------------------");
    }

    // k/f
    record Pair(int i, long k, long fen) {
    }

    // long[][] f
    //f (i,j) 表示[0,i] range  val == j 的方案数.
    // f(n-1, k)
    // f(i,j ) = f( i-1, k/nums[i]) + f(i-1, k*nums[i] ) + f(i-1,j )
    HashMap<Pair, Integer> map = new HashMap<>();


    public int countSequences(int[] nums, long k) {
        long max = 1;
        for (int num : nums) {
            max *= num;
        }
        if (max < k) return 0;
        int n = nums.length;
        map.put(new Pair(0, nums[0], 1), 1);
        map.compute(new Pair(0, 1, nums[0]), (kk, v) -> v == null ? 1 : v + 1);
        map.compute(new Pair(0, 1, 1), (kk, v) -> v == null ? 1 : v + 1);
        int res = dfs(nums, n - 1, k, 1);
        return res;
    }

    private int dfs(int[] nums, int i, long k, long fen) {
        if (i < 0) return 0;
        Pair key = new Pair(i, k, fen);
        if (map.containsKey(key)) return map.get(key);
        var res = 0;
        res += dfs(nums, i - 1, k, fen);
        long gcd = gcd(k*nums[i], fen);
        res += dfs(nums, i - 1, k * nums[i]/gcd, fen/gcd);
        long gg  = gcd(k, fen*nums[i]);
        res += dfs(nums, i - 1, k/gg, fen * nums[i]/gg);
        map.put(key, res);
        return res;
    }
    private long gcd(long a, long b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    public String maximumXor(String s, String t) {
        char[] cs = s.toCharArray();
        char[] ts = t.toCharArray();
        int c = 0, cz = 0;
        for (char tt : ts) {
            if (tt == '1') c++;
            else cz++;
        }
        for (int i = 0; i < cs.length; i++) {
            if (cs[i] == '1') {
                if (cz > 0) {
                    cz--;
                } else {
                    c--;
                    cs[i] = '0';
                }
            } else {
                if (c > 0) {
                    c--;
                    cs[i] = '1';
                } else {
                    cz--;
                    cs[i] = '0';
                }
            }
        }
        return String.valueOf(cs);
    }

    public boolean isDigitorialPermutation(int n) {
        int[] a = new int[10];
        a[0] = 1;
        for (int i = 1; i < a.length; i++) {
            a[i] = a[i - 1] * i;
        }
        int tar = n;
        int sum = 0;
        int[] cs = new int[10];
        while (n > 0) {
            int mod = n % 10;
            sum += a[mod];
            cs[mod]++;
            n /= 10;
        }
        return isSame(cs, sum);
    }

    private boolean isSame(int[] cs, int sum) {
        while (sum > 0) {
            int mod = sum % 10;
            cs[mod]--;
            sum /= 10;
        }
        for (int i = 0; i < cs.length; i++) {
            if (cs[i] < 0 || cs[i] > 0) {
                return false;
            }
        }
        return true;
    }

    public int scoreDifference(int[] nums) {
        int sc = 0, scc = 0;
        int n = nums.length;
        boolean yes = true; // 第一个玩家
        for (int i = 0; i < nums.length; i++) {
            if ((nums[i] & 1) == 1) {
                // 交换身份
                yes = !yes;
            }
            if (i % 6 == 5) yes = !yes;
            if (yes) sc += nums[i];
            else scc += nums[i];
        }
        return sc - scc;

    }
}
 