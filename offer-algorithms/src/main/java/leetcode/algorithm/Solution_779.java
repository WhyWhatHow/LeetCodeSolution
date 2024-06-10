package leetcode.algorithm;

/**
 * @program: LeetCodeSolution
 * @description:
 * @author: WhyWhatHow

 **/

public class Solution_779 {

    static  String[] strings =new String[10];
    static {
        strings[0]="0";

        for(int i = 1; i< strings.length;i++){

            StringBuilder builder= new StringBuilder();
            String s= strings[i-1];
            for (int j = 0; j < s.length(); j++) {
                char c= s.charAt(j);
                if(c=='0')builder.append("01");
                if (c=='1') builder.append("10");
            }
            strings[i]=builder.toString();
        }
    }
    public int kthGrammar(int N, int K) {
        String s = strings[N - 1].charAt(K - 1) + "";
        return Integer.parseInt(s);
    }
    public static void main(String[] args) {
        Solution_779 sol = new Solution_779();
        int i = sol.kthGrammar(3, 1);
        System.out.println(i);
        System.out.println("==================");
    }
}


