package leetcode.algorithm.greedy;

/**
 * @program: LeetCodeSolution
 * @description: #
 * @author: WhyWhatHow
 **/
public class Solution_3800 {

    public static void main(String[] args) {
        Solution_3800 sol = new Solution_3800();
        System.out.println(sol.minimumCost(
                "01000",
                "10111",
                10,
                2,
                2
        ));
        System.out.println("==================");
    }

    /**
     * 1 只有flip 是可以解决问题的情况.
     * 2. flip +Swap
     * 3. flip +swap + cross( hint : cross 不会减少数量,值会让数据尽可能的少)
     */
    public long minimumCost(String s, String t, int flipCost, int swapCost, int crossCost) {

        char[] cs = s.toCharArray();
        char[] ts = t.toCharArray();
        int n = cs.length;
        int c = 0; // cs[i] ==1 &&ts[i] ==0
        int cc = 0; // cs[i] ==0 &&ts[i] ==1
        int fc = 0; // 只考虑flip 的情况
        for (int i = 0; i < cs.length; i++) {
            if (cs[i] != ts[i]) {
                fc++;
            }
            if (cs[i] == '1' && ts[i] == '0') c++;
            if (ts[i] == '1' && cs[i] == '0') cc++;
        }

        if (c > cc) {
            int tmp = c;
            c = cc;
            cc = tmp;
        }

        // 只用flip的情况结果.
        if (fc == 0) return 0; //swapcount = fc/2
        long res = (long) flipCost * fc;

        //flip + swap 实现. swap 可以消灭c 组数据
        res = Math.min(res, (long) c * swapCost + (long) (cc - c) * flipCost);

        // cross 只改变 c 与cc的数量关系,并不会消灭不等数对, 所以我们应该上01,与10的数据量尽可能相等,
        // 即需要移动(c+cc)/2 -c 列 到 c中
        int all = c + cc;
        long avg = (c + cc) / 2;
        long tmp = (avg - c) * crossCost + avg * swapCost + (all % 2) * flipCost;
        res = Math.min(res,tmp);
        // 枚举cross 次数, 从1次到最多c次.
//        for (int i = 1; i <= cc - c; i++) {
//            long sc = c + i;  // swap count
//            long tmp = (long) i * crossCost + sc * swapCost + (cc -i- sc) * flipCost;
//             if(tmp<=0) continue;
//            res = Math.min(tmp, res);
//        }

        return res;
    }
}


