package leetcode.algorithm.medium;

/**
 * @program: LeetCodeSolution
 * @description: #
 * @author: WhyWhatHow
 **/

public class Solution_1625 {

    public static void main(String[] args) {
        Solution_1625 sol = new Solution_1625();
        System.out.println();
//        System.out.println(sol.genMinVal(9, "5525".toCharArray()).equals("5050"));
//        sol.set.addAll(List.of("0123", "0098", "1121", "3121", "0000"));
        System.out.println(sol.findLexSmallestString(
//                "5525", 9, 2
//                "74", 5, 1
//                "552568", 9, 2
                "43987654", 7, 3
        ));
        System.out.println("==================");
    }

    //    TreeSet<String> set = new TreeSet<>((a, b) -> {
//        return a.compareTo(b);
//    });
    //    TreeMap<Integer,String> map = new TreeMap<>();
    char zero = '0';

    // 枚举产生的每一个数字, 选择最小的哪一个.
    // op_1 : odd index number plus a .
    // op_2 : s go right with b index .
    // op1, op2 相互独立
    // 对于奇数位 ,最多可以修改次数是9次,
    // 枚举 所有移位的数字, 以及枚举所有数字可能产生的所有结果选择最小的返回. 
    public String findLexSmallestString(String s, int a, int b) {
        int n = s.length();
        String ss = s + s;
        String res = s;
        boolean[] v = new boolean[s.length()];
        for (int i = 0; !v[i]; i = (i + b) % n) {
            // 枚举所有的字符
            v[i] = true;
            int elimit = (b & 1) == 0 ? 0 : 9;
            for (int j = 0; j < 10; j++) { // odd time
                for (int e = 0; e <= elimit; e++) { // even Time

                    char[] os = ss.substring(i, i + n).toCharArray();//
                    // 对os 奇数位 添加数字, 数字0-9,最多添加9次
                    for (int k = 1; k < os.length; k += 2) {
                        os[k] = (char) (((os[k] - zero + j * a) % 10) + zero); //
                        // why ? case we add j*e time a
//                        os[k] = (char) (((os[k] - zero + a) % 10) + zero); //
                    }
                    res = minStr(res, String.valueOf(os));

                    // 对 os 偶数位进行操作, 如果b 为偶数 那么没有操作次数, 如果b为奇数,最多可以有9次的操作次数
                    if (elimit > 0) {
                        for (int k = 0; k < os.length; k += 2) {
                            os[k] = (char) (((os[k] - zero + e*a) % 10) + zero);
                        }
                        res = minStr(res, String.valueOf(os));
                    }
                }
            }
        }
        return res;
    }

    private String minStr(String res, String s) {
        if (res.compareTo(s) < 0) return res;
        return s;
    }


}


