package leetcode.algorithm;

/**
 * @program: LeetCodeSolution
 * @description:
 * @author: WhyWhatHow
 * @create: 2020-05-07 12:09
 **/

public class Solution_191 {
    // you need to treat n as an unsigned value
    public int hammingWeight1(int n) {
        Integer temp = new Integer(n);
        String s = temp.toString();
        int len = s.length();
        int cnt = 0;
        for (int i = 0; i < len; i++) {
            if (s.charAt(i) == '1') {
                cnt++;
            }
        }
        return cnt;
    }

    //    public int hammingWeight(int n) {
//        int cnt =0 ;
//        while(n!=0){
//            n&=(n-1);// 可以去掉最后一位 的1 , 然后最后变成0
//            cnt++;
//        }
//        return cnt;
//    }
    public int hammingWeight(int n) {
        int cnt = 0;
        for (int i = 0; i < 32; i++) {
            cnt += (n >> i) & 1;// &1 , 结果 不是0, 就是1 , 判断最后一位是0 或者是1 .
        }
        return cnt;
    }

    public static void main(String[] args) {
        Solution_191 sol = new Solution_191();
        int i = sol.hammingWeight(00000000000000000000000000001011);
        System.out.println(i);
        System.out.println("==================");
    }
}


