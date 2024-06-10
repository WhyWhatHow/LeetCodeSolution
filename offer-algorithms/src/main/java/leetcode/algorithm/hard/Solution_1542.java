package leetcode.algorithm.hard;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: LeetCodeSolution
 * @description:
 * @author: WhyWhatHow
 **/

public class Solution_1542 {

    public static void main(String[] args) {
        Solution_1542 sol = new Solution_1542();
//        System.out.println(1<<3);
        System.out.println(sol.longestAwesome(
//                "112345222"
                "3242415"
        ));
        System.out.println("==================");
    }


    public int longestAwesomeMap(String s) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int cur = 0;  //状态
        int ans = 1;  //记录答案
        map.put(cur, -1);
        for (int c = 0; c < s.length(); c++) {
            int ch = s.charAt(c) - '0';
            //计数
            cur = cur ^ (1 << ch);
            //一个数字出现奇数次，其余出现偶数次
            for (int i = 0; i < 10; i++) {
                int next = cur ^ (1 << i);
                if (map.containsKey(next)) {
                    ans = Math.max(ans, c - map.get(next));
                }
            }
            //所有都出现了偶数次
            if (!map.containsKey(cur)) {
                map.put(cur, c);
            } else {
                ans = Math.max(ans, c - map.get(cur));
            }
        }
        return ans;
    }


    /**
     * 1<<10 ==>1024
     *
     * 如果从 s[i]s[i]s[i] 到 s[j]s[j]s[j] 的子串长度是偶数，要使子串可以重排成回文串，每个数字的出现次数都得是偶数，所以 pre[j]⊕pre[i]=0\textit{pre}[j]\oplus \textit{pre}[i] = 0pre[j]⊕pre[i]=0，即 pre[i]=pre[j]\textit{pre}[i]= \textit{pre}[j]pre[i]=pre[j]。
     * 如果从 s[i]s[i]s[i] 到 s[j]s[j]s[j] 的子串长度是奇数，要使子串可以重排成回文串，必须恰好有一个数字的出现次数是奇数，其余数字的出现次数都是偶数，所以 pre[j]⊕pre[i]=2k\textit{pre}[j]\oplus \textit{pre}[i] = 2^kpre[j]⊕pre[i]=2
     * k
     *  ，即 pre[i]=pre[j]⊕2k (0≤k≤9)\textit{pre}[i]= \textit{pre}[j]\oplus 2^k\ (0\le k\le 9)pre[i]=pre[j]⊕2
     * k
     *   (0≤k≤9)。其中 2k2^k2
     * k
     *   是只有一个 111 的二进制数，对应恰好一个数字出现次数是奇数的情况。
     *
     * @param s
     * @return
     */
    public int longestAwesome(String s) {
        char[] chars = s.toCharArray();
        HashMap<Integer, Integer> map = new HashMap<>();
        int res = 0;
        int cur = 0;
        map.put(cur, -1); //
//        int[] arr = new int[chars.length]; //arr[i] means [0,i]内, 奇数 出现的数据.
        // init arr, count i position nums appear time.
        for (int i = 0; i < chars.length; i++) {
//            arr[i] =
            cur = cur ^ (1 << (chars[i] - '0')); // [0,i] 中每个数字0-9 之间的数量的奇偶数

            // check
            for (int j = 0; j < 10; j++) {
                int temp = cur ^ (1 << j);
                if (map.containsKey(temp)) { // odd
                    res = Math.max(res, i - map.get(temp)); // [j+1, i]
                }
            }

            if (!map.containsKey(cur)) { //
                map.put(cur, i);
            } else { // even
                res = Math.max(res, i - map.get(cur));
            }
        }


        return res;
    }

    /***
     * `1<<digit`: 将1 向左移 digit位, 即 对应的压缩数据的 digit的所在位置.
     * @param s
     * @return
     */
    public int longestAwesomeOffcial(String s) {
        int n = s.length();
        Map<Integer, Integer> prefix = new HashMap<Integer, Integer>();
        prefix.put(0, -1);
        int ans = 0;
        int sequence = 0;
        for (int j = 0; j < n; ++j) {
            int digit = s.charAt(j) - '0';
            sequence ^= (1 << digit); // 不这样做, 应该会超时哦.
            if (prefix.containsKey(sequence)) {
                ans = Math.max(ans, j - prefix.get(sequence));
            } else {
                prefix.put(sequence, j);
            }
            for (int k = 0; k < 10; ++k) {
                if (prefix.containsKey(sequence ^ (1 << k))) {
                    ans = Math.max(ans, j - prefix.get(sequence ^ (1 << k)));
                }
            }
        }
        return ans;
    }
}


