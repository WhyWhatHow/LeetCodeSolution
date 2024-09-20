package leetcode.algorithm.dp;

import java.util.HashMap;
import java.util.List;

/**
 * @program: LeetCodeSolution
 * @description: #
 * @author: WhyWhatHow
 **/

public class Solution_2376 {

    public static void main(String[] args) {
        Solution_2376 sol = new Solution_2376();
        List<Integer> list = List.of(20, 123, 135);
        for (Integer i : list) {
            System.out.println(sol.countSpecialNumbers(i));
        }
        System.out.println("==================");
    }

    public int countSpecialNumbers(int n) {
        String s = String.valueOf(n);
        this.cs = s.toCharArray();
        this.len = s.length();
        map = new HashMap<>();
        return dfs(0, 0, true, false);

    }

    char[] cs;
    int len;
    HashMap<Integer, Integer> map ;

    /***
     * dfs(i,mask): 第i位 及其以后位置的合法方案数亮.
     * @param i 第i位
     * @param mask [0,i] 内填入的 数字.
     * @param limited 限制第i位对应的的数据范围, 最高位是num[i] ,还是 9
     * @param isNum [0,i) 区间内的是否是一个数, 即[0,i) 是否全是0, 如果是, numbered =true, else numbered = false .
     * @return
     */
    int dfs(int i, int mask, boolean limited, boolean isNum) {

        if (i == len)  return isNum ? 1 : 0;

//         memory
        int key = (i << 10) | mask;
        if (map.containsKey(key) && isNum && !limited) {
            return map.get(key);
        }

        // count
        int val = 0;
        if (!isNum) {  // j exist , then skip i
            val += dfs(i + 1, mask, false, false);
        }

        int up = !limited ? 9 : cs[i] - '0';
        int low = isNum ? 0 : 1;
        for (int j = low; j <= up; j++) {
            // check j  used or not
            if ((mask >> j & 1) == 0) { // j not exist
//                mask = mask | (1 << j); // wa , you changed mask, u can not change mask, cause the rest elements need it.
                val += dfs(i + 1,  mask | (1 << j), limited && j == up, true);
            }
        }

        if (!limited && isNum) {
            map.put(key, val);
        }
        return val;
    }


//    HashMap<String, Integer> map;
//
//    int dfs(int i, int mask, boolean limited, boolean isNum) {
//        if (i == len) {
//            return isNum ? 1 : 0;
//        }
//
//        String key = i + "," + mask + "," + limited + "," + isNum;
//        if (!limited && isNum && map.containsKey(key)) {
//            return map.get(key);
//        }
//
//        int res = 0;
//        if (!isNum) {
//            res += dfs(i + 1, mask, false, false);
//        }
//
//        int up = limited ? cs[i] - '0' : 9;
//        for (int d = isNum ? 0 : 1; d <= up; d++) {
//            if ((mask & (1 << d)) == 0) {
//                res += dfs(i + 1, mask | (1 << d), limited && d == up, true);
//            }
//        }
//
//        if (!limited && isNum) {
//            map.put(key, res);
//        }
//
//        return res;
//    }
}


