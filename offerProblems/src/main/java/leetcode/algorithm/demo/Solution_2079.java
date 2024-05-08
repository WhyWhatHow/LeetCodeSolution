package leetcode.algorithm.demo;

/**
 * @program: LeetCodeSolution
 * @description:
 * @author: WhyWhatHow
 **/

public class Solution_2079 {

    public static void main(String[] args) {
        Solution_2079 sol = new Solution_2079();
        System.out.println(sol.wateringPlants(new int[]{
//                        2, 2, 3, 3
                        7,7,7,7,7,7,7
                },
//                5
                8
        ));
        System.out.println("==================");
    }

    public int wateringPlants(int[] plants, int capacity) {
        int now = capacity;
        int cnt = 0;

        for (int i = 0; i < plants.length; i++) {
            if (now >= plants[i]) {
                now -= plants[i];
                cnt++;
            } else {
                now = capacity;
                cnt += 2 * i ;
                now -= plants[i];
                cnt++;
            }
        }
        return cnt;
    }

}


