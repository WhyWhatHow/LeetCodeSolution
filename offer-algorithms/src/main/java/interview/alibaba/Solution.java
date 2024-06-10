package interview.alibaba;

/**
 * @program: LeetCodeSolution
 * @description:
 * @author: WhyWhatHow
 * @create: 2020-05-27 15:47
 **/
public class Solution {
    public static void main(String[] args) {
        Solution sol = new Solution();
        int a =2147483647 ;

        int b =-2147483648;
        int ans = sol.maximum(a, b);
        System.out.println(ans);
//        Scanner scanner = new Scanner(System.in);
//        while (scanner.hasNext()){
//
//        }
    } public int maximum(int a, int b) {
        long aa =(long) a ;
        long bb = (long) b;
        return (int) (((aa+bb)+Math.abs(aa-bb))/2);
    }
}
