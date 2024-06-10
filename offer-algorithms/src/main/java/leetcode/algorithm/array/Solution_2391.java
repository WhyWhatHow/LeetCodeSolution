package leetcode.algorithm.array;

/**
 * @program: LeetCodeSolution
 * @description:
 * @author: WhyWhatHow
 **/

public class Solution_2391 {

    public static void main(String[] args) {
        var sol = new Solution_2391();
        String s = new String("abcdefg");

        System.out.println(s.contains("f"));
//        System.out.println(s.contains(c));

        System.out.println("==================");
        System.out.println(sol.garbageCollection(new String[]{
//                "G", "P", "GP", "GG"
                "MMM","PGM","GP"
        }, new int[]{
//                2, 4, 3
                3,10
        }));
        ;
    }

    /***
     * 思路:
     * 1.找到 GPM 最后出现的位置, 然后,
     * 2. 计算 GPM 分别到这个位置的所需要的 travel 时间.
     * 3. 因为是三辆垃圾车,运行是互斥的.所以, 直接统计 garbage 的长度即可.
     * @param garbage
     * @param travel
     * @return
     */
    public int garbageCollection(String[] garbage, int[] travel) {
        int sum = 0;
        sum += handlelastPosition(travel, garbage, "G");
        sum += handlelastPosition(travel, garbage, "P");
        sum += handlelastPosition(travel, garbage, "M");
        StringBuilder builder = new StringBuilder();
        for (String s : garbage) {
            builder.append(s);
        }
        sum += builder.length();
        return sum;
    }

    private int handlelastPosition(int[] travel, String[] garbage, String s) {
        int loc = -1;
        // get location
        for (int i = garbage.length - 1; i >= 0; i--) {
            if (garbage[i].contains(s)) {
                loc = i;
                break;
            }
        }
        int res = 0;
        // count val
        for (int i = 0; i < loc; i++) {
            res += travel[i];
        }
        return res;
    }
}



