package leetcode.algorithm.window;

/**
 * @program: LeetCodeSolution
 * @description: #
 * @author: WhyWhatHow
 **/
public class Solution_1888 {

    public static void main(String[] args) {
        Solution_1888 sol = new Solution_1888();//
        System.out.println(sol.minFlips("111000"));
        System.out.println("==================");
    }

    // 将字符串 s 变为s+s , 这样的话,我们就可以用[i,i+n-1] 的范围表示第一中操作中可能出现的每一个字符串样式,
    // 在这个基础上,我们只需要分别统计不同窗口  01010101, 长度, 以及1010101, 两种类型的str 对应差值, 找到最小值即为答案.
    public int minFlips(String s) {
        int n = s.length();
        s += s;
        char[] cs = s.toCharArray();
        int min = n;
        int l = 0, r = 0;
        int a = 0; // 01
        int b = 0; // 10
        while (r < cs.length) {
            while (r < l + n) {
                // count a and b
                if (((r - l) & 1) == 0) { // even
                    if (cs[r] == '0') b++;
                    else a++;
                } else { // odd
                    if (cs[r] == '1') b++; // 01,10
                    else a++;
                }
                r++;
            }
            min = Math.min(min, Math.min(a, b));
            if (cs[l] == '0') {
                b--;
            } else {
                a--;
            }
            // l 移动后,奇偶应该变化
            int t = a;
            a = b;
            b = t;
            l++;
        }

        return min;


    }
}
