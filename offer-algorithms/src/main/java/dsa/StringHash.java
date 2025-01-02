package dsa;

/**
 * @program: LeetCodeSolution
 * @description: 字符串hash模板类
 * @author: WhyWhatHow
 * @create: 2025-01-02 16:03
 **/
@SuppressWarnings("ALL")
public class StringHash {
    long[] p;  // p[i] = base^i ;
    long[] h;  // h[i] means string s [0,i] 's hash
    int base = 433;
    // int mod = 1000_000_007; // why ? Beacause we already did.(mod = 2^64-1)
    public StringHash(String s) {
        build(s);
    }

    void build(String s) {
        int n = s.length();
        p = new long[n];
        h = new long[n];
        for (int i = 0; i < n; i++) {
            p[i] = i == 0 ? 1 : base * p[i - 1];
            h[i] = i == 0 ? s.charAt(i) : h[i - 1] * base + s.charAt(i);
        }
    }

    // string s [l,r]' hash.
    long query(int l, int r) {
        long ans = h[r];
        if (l > 0) {
            ans -= h[l - 1] * p[r - l + 1];
        }
        return ans;
    }
    public static void main(String[] args) {
        // 测试代码
        String s = "hello";
        StringHash stringHash = new StringHash(s);

        // 查询不同子串的哈希值
        System.out.println("Hash of substring [0, 2]: " + stringHash.query(0, 2)); // "hel"
        System.out.println("Hash of substring [1, 3]: " + stringHash.query(1, 3)); // "ell"
        System.out.println("Hash of substring [2, 4]: " + stringHash.query(2, 4)); // "llo"
        System.out.println("Hash of substring [2, 2]: " + stringHash.query(2, 2)); // "l"
        System.out.println("Hash of substring [3, 3]: " + stringHash.query(3, 3)); // "l"

        // 比较两个子串是否相等
        long hash1 = stringHash.query(0, 2); // "hel"
        long hash2 = stringHash.query(1, 3); // "ell"
        System.out.println("Are 'hel' and 'ell' equal? " + (hash1 == hash2));
    }

}
